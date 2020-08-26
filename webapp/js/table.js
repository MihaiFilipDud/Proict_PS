

function listSchedule(){

        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/getSchedule',
            dataType: 'json',
            success: function(data){
                
                var str = '';
                for ( var i = 0, len = data.length; i < len; ++i) {
                    var flight = data[i];
                    str = str + "<tr>" +
                          "<td>" + flight.code + "</td>" +
                          "<td>" + flight.airport + "</td>" +
                          "<td>" + flight.destination + "</td>" +
                          "<td>" + flight.arrival + "</td>" +
                          "<td>" + flight.departure + "</td>" +
                          "<td>" + flight.status + "</td>" +
                          "<td>" + flight.plane.id + "</td>" +
                          "<td>" + flight.plane.model + "</td>" +
                          "<td>" + flight.plane.company + "</td>" +
                          "</tr>";
                    $("#table_body").html(str);
                    console.log("Schedule generated");
            }

                
            },
            error: function(){
                console.log("Error");
            }

        });
}

function listPlanes(){
      
        var company = sessionStorage.getItem('company');
        console.log(company);
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/getPlanes?company='+company,
            dataType: 'json',
            success: function(data){
                
                    var str = '';
                    for ( var i = 0, len = data.length; i < len; ++i) {
                      var plane = data[i];
                      str = str + "<tr>" +
                          "<td>" + plane.id + "</td>" +
                          "<td>" + plane.model + "</td>" +
                          "<td>" + plane.company + "</td>" +
                          "</tr>";
                      $("#table_body").html(str);
                    }  
                    console.log("Planes generated");
                    console.log(data.code);
            

                
            },
            error: function(){
                console.log("Error");
            }

        });
}




