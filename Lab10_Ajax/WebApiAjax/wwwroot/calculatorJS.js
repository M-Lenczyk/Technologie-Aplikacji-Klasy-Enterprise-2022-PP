//JAVASCRIPT VANILLA CALL API CALCULATOR

var x;
var y;
var expr;//address

const resultFormatExpr = 'json';
const myRequest = new XMLHttpRequest();
var response;//load

document.getElementById("calcJS").addEventListener("click", getResults);

function getResults() {

    x = document.getElementById("x").value;
    y = document.getElementById("y").value;
    expr = `/math?x=${x}&y=${y}`;

    myRequest.open("GET", expr);
    myRequest.responseType = resultFormatExpr;
    myRequest.send();
    myRequest.onload = function () {
        response = myRequest.response;
        document.getElementById("sum").textContent = response.sum;
        document.getElementById("difference").textContent = response.difference;
        document.getElementById("product").textContent = response.product;
        document.getElementById("quotient").textContent = response.quotient;
    }

}
