var modal = null

function pop() {
    if(modal === null) {
        document.getElementById("briefly_box").style.display = "block";
        modal = true
    } else {
        document.getElementById("briefly_box").style.display = "none";
        modal = null
    }
}