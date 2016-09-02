
<html>
<head>
<title>John Rentals Admin Login Page</title>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
 <link href="<c:url value="/static/resources/css/style.css" />" rel="stylesheet">
 <script src="<c:url value="/static/resources/js/jquery.min.js" />"></script>
 <script src="<c:url value="/static/resources/js/jquery.validate.min.js" />"></script>

    <script>

    $(document).ready(function(){
    $("#lgbtn").click(function(){ 
        $.ajax({url: "/VehicleManagement/AdminLoginPage?userid="+$("#userid").val()+'&password='+$("#password").val()+'&time='+new Date(), success: function(data){
 	    if(data=="Success")
      {
    	 // alert("User Login Success");
    	  window.location.href="/VehicleManagement/AdminHomePage";
      }
      else 
      {
    	    $("#message").html("Invalid Credentials!");
			$("#message").show();
      }
   	    }
   	    });
    });

    $("#forgetlink").click(function(){
    	window.location.href="/VehicleManagement/forget";

    });
    
    });


    
	$.validator.setDefaults({
		submitHandler: function() {
			alert("submitted!");
		}
	});
    
    
  </script>

</head>
 
 
<body>
<div id="emptyDiv"></div>
<div id="description"></div>
<!--container start-->
	<div>
      <h2 class="form_title">Welcome To John Rentals</h2>
      </div>
		<div id="form_name" align="center"></br>
		<div id="message" style="display:none;" ></div>
		      <form class="cmxform" id="login-form" method="post">
				<fieldset>
					<legend>Admin-Login</legend>
					<br/>
					<p>
						<input id="userid" type="text" name="userid" placeholder="User-id" required>
						 
					</p>
					<p>
						<input id="password" type="password"  name="password"  placeholder="Password" required >
						
					</p>
					<p><a href="#" id="forgetlink">Forgot Password?</a></p>
					<p>
					      <input type="button" value="Login"  id="lgbtn"/>
					</p>
				</fieldset>
			</form>
			
		    </div>




</body>
</html>