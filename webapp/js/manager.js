var name = sessionStorage.getItem('name');
var company = sessionStorage.getItem('company');

$('.form').find('input, textarea').on('keyup blur focus', function (e) {
  
  var $this = $(this),
      label = $this.prev('label');

	  if (e.type === 'keyup') {
			if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
    	if( $this.val() === '' ) {
    		label.removeClass('active highlight'); 
			} else {
		    label.removeClass('highlight');   
			}   
    } else if (e.type === 'focus') {
      
      if( $this.val() === '' ) {
    		label.removeClass('highlight'); 
			} 
      else if( $this.val() !== '' ) {
		    label.addClass('highlight');
			}
    }

});

$('.tab a').on('click', function (e) {
  
  e.preventDefault();
  
  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');
  
  target = $(this).attr('href');

  $('.tab-content > div').not(target).hide();
  
  $(target).fadeIn(600);
  
});

$('.tab a').on('onload', function (e) {
  
  e.preventDefault();
  
  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');
  
  target = $(this).attr('href');

  $('.tab-content > div').not(target).hide();
  
  $(target).fadeIn(600);
  
});

$(document).ready(function()    {
    $("#plane_button").click(function(e)    {
        var id = $("#id").val().trim();
        var model = $("#model").val().trim();
        //var company = $("#company").val().trim();

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/addPlane?id=' + id + '&model=' + model + '&company=' + company,
            dataType: 'json',
            success: function(data){
                console.log("Succes");
                window.confirm("Plane added successfully");
            },
            error: function(){
                console.log("Error");
                window.confirm("Plane couldn't be added");
            }

        });
    });

    $("#flight_button").click(function(e)    {
        var code = $("#code").val().trim();
        var airport = $("#airport").val().trim();
        var destination = $("#destination").val().trim();
        var arrival = $("#arrival").val().trim();
        var departure = $("#departure").val().trim();
        var status = $("#status").val().trim();
        var plane_code = $("#plane_code").val().trim();

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/addFlight?code=' + code + '&airport=' + airport + '&destination=' + destination + '&arrival=' + arrival + '&departure=' + departure + '&status=' + status + '&plane=' + plane_code, 
            dataType: 'json',
            success: function(data){
                console.log("Succes");
                window.confirm("Flight added successfully");

            },
            error: function(){
                console.log("Error ");
                window.confirm("Flight couldn't be added");
            }

        });
    });


    $("#planes_button").click(function(e)    {
         console.log("Succes");
         window.location.href = "table_planes.html";
    });

    $("#remove_plane_button").click(function(e)    {
        var id = $("#remove_plane_id").val().trim();

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/removePlane?id=' + id,
            dataType: 'text',
            success: function(data){
                console.log("Succes");
                window.confirm(data);
            },
            error: function(){
                console.log("Error");
                
            }

        });
    });

    $("#remove_flight_button").click(function(e)    {
        var code = $("#remove_flight_code").val().trim();

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/removeFlight?code=' + code,
            dataType: 'text',
            success: function(data){
                console.log("Succes");
                window.confirm(data);
            },
            error: function(){
                console.log("Error");
                
            }

        });
    });


});

function getCredentials(){
  
  console.log(name + company);
  var str = "<h1>"+name+", "+company+"</h1>";
  $("#credentials").html(str);
}

