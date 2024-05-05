var user = sessionStorage.getItem("username")
document.addEventListener("DOMContentLoaded", function (){
    var nameElement = document.querySelector(".name");
    nameElement.textContent = "Hello" + user;
});

