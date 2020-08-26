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
    $("#request_login").click(function(e)    {
        var username = $("#username").val().trim();
        var password = $("#password").val().trim();

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/tryLogin?username=' + username + '&password=' + password,
            dataType: 'json',
            success: function(data){
                  console.log("Succes");
                  var bool = 0;
                 for (var key in data) {
                   if (data.hasOwnProperty(key)) {
                      if (/company/.test(key)) {
                        console.log('match!', data[key]); // do stuff here!
                        //window.alert("Manager logged in successfully");
                        bool = 1;
                      }
                    }
                  }

                  sessionStorage.setItem("name", data.name);
                  var x = sessionStorage.getItem("name");
                  console.log(x);
                  if (bool == 1){
                        
                        window.location.href = "manager.html";
                        
                        sessionStorage.setItem('company', data.company);
                        
                       
                      }
                      else{
                        //window.alert("Controller logged in successfully");
                        sessionStorage.setItem('airport', data.airport);
                        window.location.href = "controller.html";

                      }
                  
            },
            error: function(){
                console.log("Error login");
                window.alert("The username or password is incorrect");
            }

        });
    });

    $("#man_button").click(function(e)    {
        var name = $("#man_name").val().trim();
        var dob = $("#man_dob").val().trim();
        var company = $("#man_company").val().trim();
        var username = $("#man_username").val().trim();
        var password = $("#man_password").val().trim();

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/registerManager?name=' + name + '&dob=' + dob + '&company=' + company + '&username=' + username + '&password=' + password, 
            dataType: 'json',
            success: function(data){
                console.log("Succes");
                window.confirm("Registration successfull");

            },
            error: function(){
                console.log("Error login");
            }

        });
    });


    $("#con_button").click(function(e)    {
        var name = $("#con_name").val().trim();
        var dob = $("#con_dob").val().trim();
        var airport = $("#con_airport").val().trim();
        var username = $("#con_username").val().trim();
        var password = $("#con_password").val().trim();

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/registerController?name=' + name + '&dob=' + dob + '&airport=' + airport + '&username=' + username + '&password=' + password, 
            dataType: 'json',
            success: function(data){
                console.log("Succes");
                window.confirm("Registration successfull");

            },
            error: function(){
                console.log("Error login");
            }

        });
    });


});

