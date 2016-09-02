<html>
<head>
<title>John Rentals Signup</title>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<link href="<c:url value="/static/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="static/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="static/resources/js/jquery.validate.min.js" />"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <script>
	

	$().ready(function() {
	$("#signupForm").validate();
	$("#user_id").change(function() {

		var userName = $("#uid").val();
		$.ajax({url: "/VehicleManagement/getUserId?data="+userName, success: function(result){
   	        if(userName == result)
			{
			this.value = result;
			$("#userexist").hide();
			}
			else
			{
					$("#userexist").html("User Name Already Exists");
					$("#userexist").show();
			}
   	    }});
	});

	$("#signup" ).click(function() {

          var formData = $("#f_name").val()+"@@"+$("#l_name").val()+"@@"+$("#user_id").val()+"@@"+$("#password").val()+"@@"+$('input[name=re_password]').val()+"@@"+$("#mail_id").val()+"@@"+$("#phone_number").val()+"@@"+$("#address").val(); 
  		  $.post( "/VehicleManagement/registerUser?data="+formData, function( data ) {
  	  		if(data == "Success")
			{
				$("#message").html("Renter Registered Successfully !");
				$("#message").show();
			}else
			{
				$("#message").html(data);
				$("#message").show();
			}

	      	  
      	});	

		});


	$("#cancelbtn").click(function(){
		window.history.back();
		});
	});

	
</script>
	
</head>
<body ng-app="myApp" class="ng-cloak">
 <div class="panel-heading"><span class="lead">User Registration Form </span></div>
    <!--Form  start-->
    <div id="form_name" align="center" ng-controller="UserController as ctrl">
    
<form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
		<div class="row">
              <div class="form-group col-md-12">
                  <label class="col-md-2 control-lable" for="file">Name</label>
                  <div class="col-md-7">
                      <input type="text" ng-model="ctrl.user.name" name="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                      <div class="has-error" ng-show="myForm.$dirty">
                          <span ng-show="myForm.uname.$error.required">This is a required field</span>
                          <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                          <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                      </div>
                  </div>
              </div>
          </div>
          <div class="row">
              <div class="form-group col-md-12">
                  <label class="col-md-2 control-lable" for="file">User Id</label>
                  <div class="col-md-7">
                      <input type="text" ng-model="ctrl.user.userId" ng-change="idChange()" id="userId" name="userId" class="form-control input-sm" placeholder="Enter your user id" required ng-minlength="3"/>
                      <div class="has-error" ng-show="myForm.$dirty">
                          <span ng-show="myForm.userId.$error.required">This is a required field</span>
                          <span ng-show="myForm.userId.$error.minlength">Minimum length required is 3</span>
                          <span ng-show="myForm.userId.$invalid">This field is invalid </span>
                      </div>
                  </div>
              </div>
          </div>
          <div class="row">
              <div class="form-group col-md-12">
                  <label class="col-md-2 control-lable" for="file">Password</label>
                  <div class="col-md-7">
                      <input type="text" ng-model="ctrl.user.password" name="pwd" class="form-control input-sm" placeholder="Enter the password" required ng-minlength="3"/>
                      <div class="has-error" ng-show="myForm.$dirty">
                          <span ng-show="myForm.pwd.$error.required">This is a required field</span>
                          <span ng-show="myForm.pwd.$error.minlength">Minimum length required is 3</span>
                          <span ng-show="myForm.pwd.$invalid">This field is invalid </span>
                      </div>
                  </div>
              </div>
          </div>
            
           <div class="row">
              <div class="form-group col-md-12">
                  <label class="col-md-2 control-lable" for="file">Re enter Password</label>
                  <div class="col-md-7">
                      <input type="text" ng-model="ctrl.user.repassword" name="repwd" pw-check="ctrl.user.password"
                      class="form-control input-sm" placeholder="Re Enter the password" required ng-minlength="3"/>
                      <div class="has-error" ng-show="myForm.$dirty">
                          <span ng-show="myForm.repwd.$error.required">This is a required field</span>
                          <span ng-show="myForm.repwd.$error.pwmatch">Passwords should match </span>
                      </div>
                  </div>
              </div>
          </div>
          <div class="row">
              <div class="form-group col-md-12">
                  <label class="col-md-2 control-lable" for="file">Address</label>
                  <div class="col-md-7">
                      <input type="text" ng-model="ctrl.user.address" class="form-control input-sm" placeholder="Enter your Address." required/>
                      <div class="has-error" ng-show="myForm.$dirty">
                          <span ng-show="myForm.address.$error.required">This is a required field</span>
                          <span ng-show="myForm.address.$invalid">This field is invalid </span>
                      </div>
                  </div>
              </div>
          </div>

          <div class="row">
              <div class="form-group col-md-12">
                  <label class="col-md-2 control-lable" for="file">Email</label>
                  <div class="col-md-7">
                      <input type="email" ng-model="ctrl.user.email" name="email" class="email form-control input-sm" placeholder="Enter your Email" required/>
                      <div class="has-error" ng-show="myForm.$dirty">
                          <span ng-show="myForm.email.$error.required">This is a required field</span>
                          <span ng-show="myForm.email.$invalid">This field is invalid </span>
                      </div>
                  </div>
              </div>
          </div>

		 <div class="row">
             <div class="form-group col-md-12">
               <label class="col-md-2 control-lable" for="file">Phone</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.user.phone" name="phone" class="form-control input-sm" ng-minlength="10" ng-maxlength="10"  
						placeholder="Enter your Phone number" ng-required="true">
					 <div class="has-error" ng-show="myForm.$dirty">
						<span ng-show="myForm.phone.$error.required || myForm.phone.$error.number">
							Valid phone number is required </span>
						<span ng-show="((myForm.phone.$error.minlength || myForm.phone.$error.maxlength) && 
                         		myForm.phone.$dirty) ">phone number should be 10 digits </span>
                  	 </div>
				</div>
			</div>
          </div>
          
          <div class="row">
              <div class="form-actions floatRight">
                  <input type="submit" value="register" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                  <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
              </div>
          </div>
      </form>
	
    </div>
    <!--form ends-->

 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/user_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>


</body>
</html>
	