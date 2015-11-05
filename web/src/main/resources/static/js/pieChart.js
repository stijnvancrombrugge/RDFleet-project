/**
 * Created by SDOAX36 on 4/11/2015.
 */

$(document).load(function() {

    var pieDataActive = [
        {
            value: document.getElementById("audiActive").innerHTML,
            //value:8,
            color: "#FF0000"
        },
        {
            value: document.getElementById("volkswageActive").innerHTML,
            //value:9,
            color: "#0000FF"
        },
        {
            value: document.getElementById("seatActive").innerHTML,
           // value: 10,
            color: "#FF9980"
        },
        {
            value: document.getElementById("skodaActive").innerHTML,
            //value:8,
            color: "#009900"
        }

    ];
    var pieDataFree = [
        {
            value: $("#audiFree").html(),
            color: "#FF0000"
        },
        {
            value: $("#volkswagenFree").html(),
            color: "#0000FF"
        },
        {
            value: $("#seatFree").html(),
            color: "#FF9980"
        },
        {
            value: $("#skodaFree").html(),
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