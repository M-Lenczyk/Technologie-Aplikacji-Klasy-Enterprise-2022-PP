//JQUERY CALL API CALCULATOR
$(document).ready(function () {
    $("#calcJQUERY").click(function () {
        var x = $('#x').val();
        var y = $('#y').val();
        $.ajax(
            {
                type: "GET", data: { x, y }, url: '/math', success: response => {
                    document.getElementById("sum").textContent = response.sum;
                    document.getElementById("difference").textContent = response.difference;
                    document.getElementById("product").textContent = response.product;
                    document.getElementById("quotient").textContent = response.quotient;
                }
            });
    });
});