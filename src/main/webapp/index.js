$(document).ready(function() {

    $.ajax({
        url : "/garage",
        type : "get",
        success : function (data) {

            console.log(data);
            for(var i = 0; i < data.length; i++) {
                var id = data[i].id;
                var name = data[i].name;
                var city = data[i].city;
                var capacity = data[i].maxCapacity;
                console.log("id: " + id + " - name: " + name
                    + " - city: " + city + " - capacity: " + capacity);

                var htmlString = "<td>" + id + "</td>" +
                        "<td>" + name + "</td>" +
                        "<td>" + city + "</td>" +
                        "<td>" + capacity + "</td>" +
                        "<td><a href=\"cars.html?id=\"" + id + ">Show cars</a></td>" + "</tr>";

                $("#garage").append(htmlString);


            }

        }
    })

});
