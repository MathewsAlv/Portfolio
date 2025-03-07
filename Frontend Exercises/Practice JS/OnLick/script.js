
var definitionb = document.getElementById("leftnavb");

definitionb.addEventListener("click", function(){
    this.remove(definitionb);
});


var loginbotton = document.getElementById("loginb");

loginbotton.addEventListener("click", function(){
    this.innerText = "Cerrar Sesión"
});

var botonlikecat = document.getElementById("catb");
var contadorcat = 0;

botonlikecat.addEventListener("click", function(){
    contadorcat++;
    this.innerText="Me gusta "+contadorcat;
    alert("Gato Atigrado was liked")
})

var botonlikedog = document.getElementById("dogb");
var contadordog = 0;

botonlikedog.addEventListener("click", function(){
    contadordog++;
    this.innerText="Me gusta "+contadordog;
    alert("Golden Retriever was liked")
})