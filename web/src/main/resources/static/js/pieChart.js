/**
 * Created by SDOAX36 on 4/11/2015.
 */

$(document).ready(function() {

    var pieDataActive = [
        {
            //value: document.getElementsByName("audiActive").value,
            value:8,
            color: "#FF0000"
        },
        {
            //value: document.getElementsByName("volkswageActive").value,
            value:9,
            color: "#0000FF"
        },
        {
            //value: document.getElementsByName("seatActive").value,
            value: 10,
            color: "#FF9980"
        },
        {
            //value: document.getElementsByName("skodaActive").value,
            value:8,
            color: "#009900"
        }

    ];
    var pieDataFree = [
        {
            value: $("#audiFree").text(),
            color: "#FF0000"
        },
        {
            value: $("#volkswagenFree").text(),
            color: "#0000FF"
        },
        {
            value: $("#seatFree").text(),
            color: "#FF9980"
        },
        {
            value: $("#skodaFree").text(),
            color: "#009900"
        }

    ];
    var pieDataOrders = [
        {
            value: document.getElementsByName("audiOrders").value,
            color: "#FF0000"
        },
        {
            value: document.getElementsByName("volkswagenOrders").value,
            color: "#0000FF"
        },
        {
            value: document.getElementsByName("seatOrders").value,
            color: "#FF9980"
        },
        {
            value: document.getElementsByName("skodaOrders").value,
            color: "#009900"
        }

    ];


    new Chart(document.getElementById("pieActive").getContext("2d")).Pie(pieDataActive);
    new Chart(document.getElementById("pieFree").getContext("2d")).Pie(pieDataFree);
    new Chart(document.getElementById("pieOrders").getContext("2d")).Pie(pieDataOrders);


});