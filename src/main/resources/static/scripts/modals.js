var modalBriefly = null

function brieflyBox() {
    if(modalBriefly === null) {
        document.getElementById("briefly_box").style.display = "block";
        modalBriefly = true
    } else {
        document.getElementById("briefly_box").style.display = "none";
        modalBriefly = null
    }
}

var modalPractice = null

function practiceBox() {
    if(modalPractice === null) {
        document.getElementById("practice_box").style.display = "block";
        modalPractice = true
    } else {
        document.getElementById("practice_box").style.display = "none";
        modalPractice = null
    }
}