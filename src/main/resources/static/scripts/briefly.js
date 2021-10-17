var modalBriefly = null

function briefly() {
    if(modalBriefly === null) {
        document.getElementById("briefly_box").style.display = "block";
        modalBriefly = true
    } else {
        document.getElementById("briefly_box").style.display = "none";
        modalBriefly = null
    }
}