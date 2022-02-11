"use strict";

let x, y;
let r=1.5;


document.getElementById("checkButton").onclick = function () {
    if (validateX() && validateY() && validateR()) {
        send();
    }
};



function createNotification(message) {
    let outputContainer = document.getElementById("outputContainer");
    outputContainer.textContent="";
    let noti = document.createElement("h5");
    noti.innerHTML = "<span class='notification'>"+message+"</span>";
    outputContainer.appendChild(noti);
}

function validateX() {
    if (isNumeric(x)) return true;
    else createNotification("X is not chose");
}

function selectR(param) {
    r = param;
    drawGraph();
}

function selectY(param) {
    y = param;
}

function validateX() {
    x = document.querySelector("#X-input").value.replace(",", ".");
    if (x === undefined) {
        createNotification("X is not valid");
        return false;
    } else if (!isNumeric(x)) {
        createNotification("X is not numeric");
        return false;
    } else if (!((x > -5) && (x < 5))) {
        createNotification("X is out of range");
        return false;
    } else {
        x = x / 2;
        return true;
    }

}

function validateY() {
    if (isNumeric(y)) return true;
    else {
        createNotification("Y is not chose");
        return false;
    }
}
function validateR() {
    if (isNumeric(r)) return true;
    else {
        createNotification("R is not chose");
        return false;
    }
}

function isNumeric(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}