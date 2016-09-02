
<html>
<head>
<title>John Rentals Register Vehicle</title>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<link href="<c:url value="static/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="static/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="static/resources/js/jquery.validate.min.js" />"></script>

<script>

$(document).ready(function(){

	 $("#home").click(function(){
	    	window.location.href="/VehicleManagement/AdminHomePage";
	       	});
    $("#reg1").click(function(){

		if($("#make1").val()=="")
		 {

		  $("#make1msg").html("Field Should no be blank");
		  $("#make1msg").show();
		  $("#model1msg").hide();
		  $("#year1msg").hide();
		  $("#plateno1msg").hide();
		  
		   return false;
		 }else if($("#model1").val()=="")
		 {
			 $("#make1msg").html("Field Should no be blank");
			  $("#make1msg").hide();
			  $("#model1msg").show();
			  $("#year1msg").hide();
			  $("#plateno1msg").hide();
			    return false;
		 }else if($("#year1").val()=="")
		 {
			 $("#year1msg").html("Field Should no be blank");
			  $("#make1msg").hide();
			  $("#model1msg").hide();
			  $("#year1msg").show();
			  $("#plateno1msg").hide();
			  
			return false;
		 }else if($("#plateno1").val()=="")
		 {
			 $("#plateno1msg").html("Field Should no be blank");
			  $("#make1msg").hide();
			  $("#model1msg").hide();
			  $("#year1msg").hide();
			  $("#plateno1msg").show();
			 	 
				return false;
		 }else{


			  $("#make1msg").hide();
			  $("#model1msg").hide();
			  $("#year1msg").hide();
			  $("#plateno1msg").hide();


		var data = $("#make1").val()+"@"+$("#model1").val()+"@"+$("#year1").val()+"@"+$("#plateno1").val();
    	
    	 $.ajax({url: "/VehicleManagement/vehicleregister?data="+data, success: function(result){
    	    if(result == "Success")
			{
    	    	$("#signupForm")[0].reset();
				$("#message1").html("Vehicle Registered Successfully !");
				$("#message1").show();
			}else
			{
				$("#message1").html(result);
				$("#message1").show();
			}
    	    
    	    }});
		 }
   
       	});
    
    $("#cancel1").click(function(){
    	window.history.back();
    	
   	});

});

</script>

</head>
<body>

<div id="menubar">
<div style="float:left">Welcome : ${username} </div>
<div style="float:left"> &nbsp;&nbsp; UserId :${userid}  </div>
<div style="float:right">Status : ${status}  &nbsp;&nbsp; <a href="/VehicleManagement/logout">Logout</a></div>
</div>


<div style="float: left" id="HomeBtn" >
   		<input class="submit" type="button" id="home" value="Admin Home">

</div>


<div id="form_name" align="center">

<div>
   <p style="color: blue;">
     Please register New Vehicles.
   </p>
</div>
<form class="cmxform" id="signupForm" method="get" action="">
		<fieldset>
		<div>
			<legend><h2> Vehicle Registration </h2></legend>
			<br/>
			<div id="vechicle1">
			<p>
				<div id="message1" style="display:none">
				</div>
			</p>
			<p>
				<input id="make1" name="make" type="text" placeholder="Make" required>
				<div  id="make1msg" name="make1msg" style="display:none;color:red;"></div>
				
			</p>
			<p>
				<input id="model1" name="model" type="text" placeholder="Model" required>
				<div  id="model1msg" name="model1msg" style="display:none;color:red;"></div>
				
			</p>
			<p>
				<input id="year1" name="year1" type="text" placeholder="Year" required minlength="4">
				<div  id="year1msg" name="year1msg" style="display:none;color:red;"></div>
				
			</p>
			<p>
				<input id="plateno1" name="plateno" type="text" placeholder="Plate number" required>
				<div  id="plateno1msg" name="plateno1msg" style="display:none;color:red;"></div>
				
			</p>
			<p>
				<input class="submit" type="button" id="reg1" value="Submit">
				<input class="submit" type="button" id ="cancel1" value="Back">
			</p>
			
			</div>
			
			
		</fieldset>
		
		
	</form>
	
    </div>
    <!--form ends-->

</body>

</html>
	