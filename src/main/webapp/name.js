$(document).ready(function() {

    $.ajax({
        url : "/car",
        type: "get",
        data : {"id" : getIdFromUrl},
        success: function(data) {

            var htmlString = "<table id='table'><tr>" +
                "<th>Id</th>" +
                "<th>Brand</th>" +
                "<th>Year</th>" +
                "<th>Color</th>" +
                "<th>GarageId</th></tr>";

            var htmlString;

            data.forEach(function (car) {
                htmlString += "<tr><td>" + car.id + "</td>" +
                    "<td>" + car.brand + "</td>" +
                    "<td>" + car.year + "</td>" +
                    "<td>" + car.color + "</td>" +
                    "<td>" + car.garageId + "</td></tr>";
            });
            htmlString += "</table>";
            $("#cars").append(htmlString);
        }
    });

    $("#add").click(function () {
        var brand = $("#brand").val();
        var year = $("#year").val();
        var color = $("#color").val();
        var id = getIdFromUrl;
        console.log("brand" + brand, "year" + year,
            "color" + color, "garageId" + id);
        $.ajax({
            url : "/car",
            type : "post",
            data : {"brand" : brand, "year" : year,
                "color" : color, "garageId" : id},

            success: function(data) {
                var id = data.id;
                var color = data.color;
                var year = data.year;
                var brand = data.brand;
                var garageId = data.garageId;

                console.log("id: " + id + " - brand: " + brand
                    + " - year: " + year + " - color: " + color
                    + " - garageId: " + garageId);

                var newLine = "<tr><td>" + data.id + "</td>" +
                    "<td>" + data.brand + "</td>" +
                    "<td>" + data.year + "</td>" +
                    "<td>" + data.color + "</td>" +
                    "<td>" + data.garageId + "</td></tr>";

                $("#table").append(newLine);

            }

        })
    });

    function getIdFromUrl() {
        var id = window.location.search.substring(4);
        console.log("id: " + id);
        return id;

    }

});
