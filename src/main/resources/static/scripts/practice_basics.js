var count = 0;
function changeColor(e) {
    if (e.getAttribute("fill") !== "red") {
        e.setAttribute("fill", "red");
        count++;
        var numerator = document.getElementById("numerator");
        numerator.innerHTML = count;
    }
}

function clearAll(e) {
    e.setAttributeAll("fill", "yellow")
    count = 0;
}

var n = null

function showHideFraction() {
    if(n === null) {
        document.getElementById("numerator").style.color = "red";
        document.getElementById("denominator").style.color = "red";
        n = true
        document.getElementById("show_hide").innerHTML = "Schowaj ułamek";
    } else {
        document.getElementById("numerator").style.color = "#ddd";
        document.getElementById("denominator").style.color = "#ddd";
        n = null
        document.getElementById("show_hide").innerHTML = "Pokaż ułamek";
    }
}




        // function changeColor(e) {
        //     var list = ["green", "yellow", "red"];
        //     var i = list.indexOf(e.getAttribute("fill"));
        //     e.setAttribute("fill", list[(i + 1) % 3]);
        // }


