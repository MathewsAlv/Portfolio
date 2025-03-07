var donateButton = document.getElementById("donateb");

donateButton.addEventListener("click", function(){
    this.remove();
})


function showalert(elemento) {
    var selection = elemento.options[elemento.selectedIndex];
    var pettype = selection.textContent;
    alert("You are looking for " + pettype);
}


document.querySelectorAll(".bcontainer").forEach(function(likespower){
    likespower.children[1].addEventListener("click", function(){

        var contador = parseInt(likespower.children[0].children[0].innerHTML);

        likespower.children[0].children[0].innerHTML = contador + 1;

        contador +=1;
    });
});


