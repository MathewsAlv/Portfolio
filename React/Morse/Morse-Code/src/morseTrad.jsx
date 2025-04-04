import { useState, useRef } from "react";
import "./morseTrad.css";


const morseCode = {
    A: ".-", B: "-...", C: "-.-.", D: "-..", E: ".",
    F: "..-.", G: "--.", H: "....", I: "..", J: ".---",
    K: "-.-", L: ".-..", M: "--", N: "-.", O: "---",
    P: ".--.", Q: "--.-", R: ".-.", S: "...", T: "-",
    U: "..-", V: "...-", W: ".--", X: "-..-", Y: "-.--",
    Z: "--..", "1": ".----", "2": "..---", "3": "...--",
    "4": "....-", "5": ".....", "6": "-....", "7": "--...",
    "8": "---..", "9": "----.", "0": "-----", " ": "/"
};


const translateToMorse = (text) => {
    return text
        .toUpperCase()
        .split("")
        .map((char) => morseCode[char] || "")
        .join(" ");
};

const translateFromMorse = (morse) => {
    const reversedMorseCode = Object.fromEntries(
        Object.entries(morseCode).map(([key, value]) => [value, key])
    );
    return morse
        .split(" ")
        .map((code) => reversedMorseCode[code] || "")
        .join("");
};

export default function MorseTrad(){
    const [text, setText] = useState("");
    const [morse, setMorse] = useState("");

    const handleTextChange = (e) => {
        setText(e.target.value);
        setMorse(translateToMorse(e.target.value));
    };

const audioContextRef = useRef(null);
const oscillatorRef = useRef([]);
const timeoutsRef = useRef([]);

const playBeep = (duration, frequency = 600) => {
    if (!audioContextRef.current || audioContextRef.current.state === "closed") {
        audioContextRef.current = new (window.AudioContext || window.webkitAudioContext)();
    }

    const context = audioContextRef.current;
    const oscillator = context.createOscillator();
    const gain = context.createGain();
    
    oscillator.type = "sine";
    oscillator.frequency.setValueAtTime(frequency, context.currentTime);
    oscillator.connect(gain);
    gain.connect(context.destination); 
    
    oscillator.start();
    oscillatorRef.current.push(oscillator);

    const timeout = setTimeout(() => {
        oscillator.stop();
        oscillatorRef.current = oscillatorRef.current.filter(osc => osc !== oscillator);
    }, duration);

    timeoutsRef.current.push(timeout);
};

const [isPlaying, setIsPlaying] = useState(false);

const playMorse = (morseText) => {
    if (isPlaying) return;
    setIsPlaying(true);

    let index = 0;

    const playNext = () => {
        if (index >= morseText.length) {
            setIsPlaying(false);
            return;
        }

        const char = morseText[index];
        index++;

        let timeout;
        if (char === ".") {
            playBeep(150, 700); // dot: sonido corto
            timeout = setTimeout(playNext, 200);
        } else if (char === "-") {
            playBeep(400, 500); // dash: sonido largo
            timeout = setTimeout(playNext, 500);
        } else {
            timeout = setTimeout(playNext, 300);
        }

        timeoutsRef.current.push(timeout);
    };

    playNext();
};

const stopMorsePlayback = () => {

    oscillatorRef.current.forEach(osc => osc.stop());
    oscillatorRef.current = [];
    
    timeoutsRef.current.forEach(timeout => clearTimeout(timeout));
    timeoutsRef.current = [];

    if (audioContextRef.current) {
        audioContextRef.current.close().then(() => {
            audioContextRef.current = null;
        });
    }

    setIsPlaying(false);
};
    

const handleMorseChange = (e) => {
    const morseText = e.target.value;
    setMorse(morseText);
    setText(translateFromMorse(morseText));
};



    return (
        <div className="main-div">
            <h1 className="main-title-text">Traductor Codigo Morse</h1>
            <div className="text-areas">
                <textarea 
                className="main-text-area-normal" 
                placeholder="Escribe aqui"
                value={text}
                onChange={handleTextChange}
                />

                <textarea 
                className="main-text-area-morse" 
                placeholder="Codigo Morse."
                value={morse}
                onChange={handleMorseChange}
                />

                <button
                className="morse-button"
                onClick={() => playMorse(morse)} >
                    Reproducir Morse
                </button>

                <button
                className="morse-button-stop"
                onClick={stopMorsePlayback}>
                    Detener sonido
                </button>

            </div>
            
        </div>
    );
}

