console.log("Conectado");

function eliminarCookies(){
    var cookies = document.querySelector(".cookies");
    cookies.remove();
}

function sumarLike(elemento){
    var numLikes = parseInt( elemento.closest(".likes").querySelector(".like").innerHTML );
    numLikes++;
    elemento.closest(".likes").querySelector(".like").innerHTML = numLikes;
}