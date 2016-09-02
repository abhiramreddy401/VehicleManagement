'use strict';

App.factory('UserService', ['$http', '$q', function($http, $q){

	return {
		
		    createUser: function(user){
					return $http.post('http://localhost:8681/VehicleManagement/user/', user)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating user');
										return $q.reject(errResponse);
									}
							);
		    },
	};

}]);
