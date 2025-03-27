import { useState, useEffect } from "react";
import "./Tempo.css";

const Tempo = () => {
    const [hours, setHours] = useState(0);
    const [minutes, setMinutes] = useState(0);
    const [seconds, setSeconds] = useState(0);
    const [timeLeft, setTimeLeft] = useState(null);
    const [isRunning, setIsRunning] = useState(false);
    const [isPaused, setIsPaused] = useState(false);

    const alarmSound = new Audio("./sounds/scream.mp3");

  useEffect(() => {
    if (!isRunning || isPaused || timeLeft <= 0) return;

    const timer = setInterval(() => {
      setTimeLeft((prev) => prev - 1);
    }, 1000);

    return () => clearInterval(timer);
  }, [timeLeft, isRunning, isPaused]);


  useEffect(() => {
    if (timeLeft === 0) {
      alarmSound.play();

    }
  }, [timeLeft]);



    const startTimer = () => {
        const totalSeconds = hours * 3600 + minutes * 60 + seconds;
        if (totalSeconds > 0) {
            setTimeLeft(totalSeconds);
            setIsRunning(true);
            setIsPaused(false);
        }
    };

    const pauseTimer = () => {
      setIsPaused(true);
    };

    const resumeTimer = () => {
      setIsPaused(false);
    };

    const resetTimer = () => {
      setIsRunning(false);
      setIsPaused(false);
      setTimeLeft(null);
      setHours(0);
      setMinutes(0);
      setSeconds(0);
      alarmSound.pause();
      
    }

    const formatTime = () => {
        if (timeLeft === null) return "00:00:00";
        const h = String(Math.floor(timeLeft / 3600)).padStart(2, "0");
        const m = String(Math.floor((timeLeft % 3600) / 60)).padStart(2, "0");
        const s = String(timeLeft % 60).padStart(2, "0");
        return `${h}:${m}:${s}`;
    }

  return (
    <div className="main-div-tempo">
      <h1 className="main-text-tempo">T<a href="https://www.youtube.com/watch?v=NVzDrqOmYiY" className="main-text-tempo-anchor">e</a>mpo</h1>
      {!isRunning ? (
      <div className="hours-stuff">
        <span className="text-letter-h">H</span>
          <input
            type="number"
            min="0"
            value={hours}
            onChange={(e) => setHours(Number(e.target.value))}
            className="text-input-h"
          />

          <span className="text-letter-m">M</span>
          <input
            type="number"
            min="0"
            max="59"
            value={minutes}
            onChange={(e) => setMinutes(Number(e.target.value))}
            className="text-input-m"
          />

          <span className="text-letter-s">S</span>
          <input
            type="number"
            min="0"
            max="59"
            value={seconds}
            onChange={(e) => setSeconds(Number(e.target.value))}
            className="text-input-s"
          />
            <button
              onClick={startTimer}
              className="text-startButton"
            >
              Iniciar
            </button>
      </div>
        
    
    ) : (
      <div className="time-format-div">
        <p className="time-format-time">{formatTime()}</p>

        <div className="time-format-buttons">
          {timeLeft > 0 && (
              isPaused ? (
                <button onClick={resumeTimer} className="time-format-button">
                  Reanudar
                </button>
              ) : (
                <button onClick={pauseTimer} className="time-format-button">
                  Pausar
                </button>
              )
            )}
          

          <button onClick={resetTimer} className="reset-button">
            Reset
          </button>
        </div>
      </div>
      )}
    </div>
  );
};


export default Tempo;
