
    document.querySelectorAll(".cdownside").forEach(function(likespower){
        likespower.children[1].addEventListener("click", function(){

            var contador = parseInt(likespower.children[0].children[0].innerHTML);

            likespower.children[0].children[0].innerHTML = contador + 1;

            contador +=1;
        });
    });