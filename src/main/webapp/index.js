$(document).ready(function() {

    $.ajax({
        url : "/garage",
        type : "get",
        success : function (data) {
            var htmlString = "<table><tr>" +
                "<th>Id</th>" +
                "<th>Name</th>" +
                "<th>City</th>" +
                "<th>Capacity</th>" +
                "<th>Cars</th></tr>";

            data.forEach(function (garage) {

                htmlString += "<tr><td>" + garage.id + "</td>" +
                    "<td>" + garage.name + "</td>" +
                    "<td>" + garage.city + "</td>" +
                    "<td>" + garage.maxCapacity + "</td>" +
                    "<td><a href='name.jsp?id=" + garage.id + "'>Show cars</a></td></tr>";
            });
            htmlString += "</table>";
            $("#garage").append(htmlString);


            /*for(var i = 0; i < data.length; i++) {
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
                        "<td><a href='name.jsp?id=" + id + "'>Show cars</a></td></tr><br>";

                $("#garage").append(htmlString);
            }
             */

        }
    })

});
