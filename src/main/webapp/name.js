$(document).ready(function() {

    $.ajax({
        url : "/car",
        type: "get",
        data : {"id" : getIdFromUrl},
        success: function(data) {
            for(var i = 0; i < data.length; i++) {
                var id = data[i].id;
                var color = data[i].color;
                var year = data[i].year;
                var brand = data[i].brand;
                var garageId = data[i].garageId;

                console.log("id: " + id + " - brand: " + brand
                    + " - year: " + year + " - color: " + color
                    + " - garageId: " + garageId);

                var htmlString = "Brand: " + brand +
                        " - Year: " + year +
                        " - Color: " + color + "<br>";

                $("#cars").append(htmlString);
            }

        }
    })

    $.ajax({
        url : "/car",
        type : "post",
        data : {}
    })

    function getIdFromUrl() {
        var id = window.location.search.substring(4);
        console.log("id: " + id);
        return id;

    }

});
