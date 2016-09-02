/*
 * function related to login 
 */

$(document).ready(function(){
	
	/*
	 *  Login
	 */
	
    $("#loginbtn").click(function(){
   
   	});
    
    /*
     *  forget link
     */

    $("#forgetlink").click(function(){
    	window.location.href="/VehicleManagement/forget";

    });
    
    /*
     *  send credentials
     */
    
    $("#sendbtn").click(function(){
        
    });

/*
 * signup
 */
    $("#registerbtn").click(function(){
    	
    	window.location.href="/VehicleManagement/register";
    });

   
    
    	
   });



//------------------------------------------------------form submissions here---------------------------------------------//





$.validator.setDefaults({
	submitHandler: function() {
	$.get("/VehicleManagement/login?userid="+$("#userid").val()+'&password='+$("#password").val()+'&time='+new Date(),function(data){
	
      if(data=="User")
      {
    	  window.location.href="/VehicleManagement/mainPage";
      }
      else if (data=="Admin")
      {
    
    	  window.location.href="/VehicleManagement/mainPage";
      }
      else 
      {
    	  $("#message").html("Invalid Credentials !");
		  $("#message").show();
      }
    	
    	
    });
	}
	
	
	
	  

});


$().ready(function() {
	// validate the comment form when it is submitted
$("#login-form").validate();

});





//------------------------------------------------------form submissions here---------------------------------------------//








