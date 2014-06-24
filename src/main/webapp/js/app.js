var app = angular.module("geektic", ['ngRoute']);

app.controller('MainCtrl', function($scope, $http) {
//    $http.get('/api/hello').success(function(helloMessage) {
//        $scope.helloMessage = helloMessage;
//    });
	
	  $http.get('/api/geek/').success(function(geeks) {
		  $scope.geeks = geeks;
	  });
	  
	  $http.get('/api/interet/').success(function(interets) {
		  $scope.interets = interets;
	  });
	
});