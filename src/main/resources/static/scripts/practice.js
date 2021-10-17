var modalPractice = null

function practice() {
    if(modalPractice === null) {
        document.getElementById("practice_box").style.display = "block";
        modalPractice = true
    } else {
        document.getElementById("practice_box").style.display = "none";
        modalPractice = null
    }
}