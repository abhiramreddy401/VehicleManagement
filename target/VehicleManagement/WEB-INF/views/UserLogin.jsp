
<html>
<head>
<title>John Rentals User Login Page</title>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
 <link href="<c:url value="/static/resources/css/style.css" />" rel="stylesheet">
 <script src="<c:url value="/static/resources/js/jquery.min.js" />"></script>
 <script src="<c:url value="/static/resources/js/jquery.validate.min.js" />"></script>

    <script>
	$.validator.setDefaults({
		submitHandler: function() {
			alert("submitted!");
		}
	});
 
  </script>
<script src="<c:url value="/static/resources/js/login.js" />"></script>
</head>
 
 
<body>
<div id="emptyDiv"></div>
<div id="description"></div>
<!--container start-->
	<div>
      <h2 class="form_title">Welcome To John Rentals</h2>
      </div>
		<div id="form_name" align="center">
		
		      <form class="cmxform" id="login-form" method="post">
				<fieldset>
					<legend>User-Login</legend>
					<br/>
					<div id="message" style="display:none;" ></div>
					<p>
						<input id="userid" type="text" name="userid" placeholder="User-id" required>
						 
					</p>
					<p>
						<input id="password" type="password"  name="password"  placeholder="Password" required >
						
					</p>
					<p><a href="#" id="forgetlink">Forgot Password?</a></p>
					<p>
					      <input type="submit" value="Login"  id="loginbtn"/>
			       		  <input type="button" value="SignUp" id="registerbtn"/>
					</p>
				</fieldset>
			</form>
			
		    </div>




</body>
</html>