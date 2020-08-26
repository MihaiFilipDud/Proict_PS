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
    $("#report_button").click(function(e)    {
        var sel = document.getElementById('report_type');

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/getReport?type=' + sel.value,
            dataType: 'text',
            success: function(data){
                console.log("Succes");
                console.log( sel.value );
                window.confirm("Report generated successfully");
            },
            error: function(){
                console.log("Error");
                window.confirm("Report couldn't be generated");
            }

        });
    });

    $("#flight_schedule_button").click(function(e)    {
       
        window.location.href = "table.html";
    });


    $("#update").click(function(e)    {
        var code = $("#flight_code").val().trim();
        var status = $("#flight_status").val().trim();

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/updateFlight?code=' + code + '&status=' + status, 
            dataType: 'text',
            success: function(data){
                console.log(data);
                window.confirm(data);

            },
            error: function(){
                console.log("Error login");
                window.confirm("Flight status couldn be updated");
            }

        });
    });


});


function getCredentials(){
  var name = sessionStorage.getItem('name');
  var airport = sessionStorage.getItem('airport');
  console.log(name + airport);
  var str = "<h1>"+name+", "+airport+"</h1>";
  $("#credentials").html(str);
}
