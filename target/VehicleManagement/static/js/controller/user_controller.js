'use strict';

App.controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
          var self = this;
          self.user={userId:'',name:'',password:'',repassword:'',address:'',email:'',phone:''};
              
           
          self.createUser = function(user){
              UserService.createUser(user)
		              .then(
				              function(errResponse){
					               console.error('Error while creating User.');
				              }	
                  );
          };

          self.submit = function() {
                  console.log('Saving New User', self.user);    
                  self.createUser(self.user);
              self.reset();
          };
          self.reset = function(){
        	  self.user={userId:'',name:'',password:'',repassword:'',address:'',email:'',phone:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);


