<html>
<head>
<title>John Rentals Login Page</title>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
 <link href="<c:url value="/static/resources/css/style.css" />" rel="stylesheet">
 <script src="<c:url value="/static/resources/js/jquery.min.js" />"></script>
 <script src="<c:url value="/static/resources/js/jquery.validate.min.js" />"></script>
 <script src="<c:url value="/static/resources/js/login.js" />"></script>
 
<script>
 $(document).ready(function(){
	 $("#userlogin").click(function(){
  	  window.location.href="/VehicleManagement/UserLogin";
    	});

		 $("#adminlogin").click(function(){
	      window.location.href="/VehicleManagement/AdminLogin";
		});
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
		<div id="form_name" align="center">
		      <form class="cmxform" id="login-form">
				<fieldset>
					<legend>Login</legend>
					<p>
					      <input type="button" value="User"  id="userlogin"/><br/> <br/>
			       		  <input type="button" value="Admin" id="adminlogin"/>
					</p>
				</fieldset>
			</form>
		</div>




</body>
</html>