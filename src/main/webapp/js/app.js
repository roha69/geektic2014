var app = angular.module("geektic", [ 'ngRoute', 'ui.gravatar',
		'checklist-model' ]);

app.config(function($routeProvider){
	$routeProvider.when('/', {
        templateUrl: 'views/home.html',
        controller: 'MainCtrl'
      }).when('/profil/:id', {
        templateUrl: 'views/profil.html',
        controller: 'ProfilCtrl'
      })

})

app.controller('MainCtrl', function($scope, $http) {

	$http.get('/api/geek/').success(function(geeks) {
		$scope.geeks = geeks;
	});

	$http.get('/api/interet/').success(function(interets) {
		$scope.interets = interets;
	});

	// valeurs cochées par défaut
	$scope.interetSel = [ 2, 4 ];

	// fonction recherche
	$scope.search = function() {
		$http.get(
				'api/geek/genre/' + $scope.genre + '/interets/'
						+ $scope.interetSel).then(function(response) {
			$scope.geeks = response.data;
		});
	};

	$scope.genre = 'HOMME';
	$scope.chx_genre = function(genre) {
		$scope.genre = genre;
	};

});



app.controller('ProfilCtrl', function($scope, $http, $routeParams) {

	$http.get('/api/geek/id/'+$routeParams.id).success(function(geek) {
		$scope.geek = geek;
	});

});

