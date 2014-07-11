var app = angular.module("geektic", [ 'ngRoute', 'ui.gravatar',
		'checklist-model' ]);

app.config(function($routeProvider){
	$routeProvider.when('/', {
        templateUrl: 'views/home.html',
        controller: 'MainCtrl',
        reloadOnSearch: false
      }).when('/genre/:genre/interet/:interet', {
    	  templateUrl: 'views/home.html',
          controller: 'MainCtrl',
          reloadOnSearch: false
      }).when('/profil/:id', {
        templateUrl: 'views/profil.html',
        controller: 'ProfilCtrl'
      })

})

app.controller('MainCtrl', function($scope, $http, $routeParams, $location) {

	$http.get('/api/interet/').success(function(interets) {
		$scope.interets = interets;
	});

	// valeurs cochées par défaut
	$scope.interetSel = [];
	//$scope.interetSel.push(parseInt($routeParams.interet));
	angular.forEach($routeParams.interet,function(interet){
		$scope.interetSel.push(parseInt(interet));	
	});
	
	$scope.interetParam = $routeParams.interet;

	// fonction recherche
	$scope.search = function() {
		$location.search('genre', $scope.genre);
		$location.search('interet', $scope.interetSel);		
		$http.get(
				'api/geek/genre/' + $scope.genre + '/interets/'
						+ $scope.interetSel).then(function(response) {
			$scope.geeks = response.data;
		});
	};

	//$scope.genre = 'FEMME';
	$scope.genre = $routeParams.genre;
	$scope.chx_genre = function(genre) {
		$scope.genre = genre;
	};
	
	$scope.search();

});

app.controller('ProfilCtrl', function($scope, $http, $routeParams) {

	$http.get('/api/geek/id/'+$routeParams.id).success(function(geek) {
		$scope.geek = geek;
	});
	
	  $scope.back = function() { 
		    window.history.back();
	  };

});

