//Carga de posiciones con angular
var myApp = angular.module('myApp',[]);

function MyCtrl($scope, $http, $templateCache) {
    $scope.items = [ ];
     $scope.add = function(item) {
        $scope.items.push(item);
    };
     
    
     $scope.value = Math.round( (Math.random() * 10));
     
      // se lanza cada  cada cierto  tiempo .
	  setInterval(function () {
		 
		  $scope.method = 'JSONP';
		  $scope.url = 'http://angularjs.org/greet.php?callback=JSON_CALLBACK&name=Super%20Hero';
		  
		  $http({method: $scope.method, url: 'http://angularjs.org/greet.php?callback=JSON_CALLBACK&name=Super%20Hero'}).
	      success(function(data, status) {
	        $scope.status = status;
	        $scope.data = data;
	      }).
	      error(function(data, status) {
	        $scope.data = data || "Respuesta fallida";
	        $scope.status = status;
	    }); 
		  
		  
	    $scope.value1 = Math.round( (Math.random() * 10));
		$scope.value2 = Math.round( (Math.random() * 10));
		$scope.value3 = Math.round( (Math.random() * 10));
		$scope.value4 = Math.round( (Math.random() * 10));
		$scope.value5 = Math.round( (Math.random() * 10));
		
	    //Ejemplo de valores
		$scope.items = [
			{name:'Desarrollo de video Games', cal:$scope.value1},
			{name:'SIIN Version 2.0', cal:$scope.value2},
			{name:'Evaluacion de Proyectos', cal:$scope.value3},
			{name:'Sistema de pase de lista', cal:$scope.value4},
			{name:'Pagina modulos Turisticos para Ixmi', cal:$scope.value5}
		  ]
	
		$scope.predicate = '-cal';
	
		// El método $apply sirve para notificar de cambios realizados asíncronamente.
	    $scope.$apply();
	    
	  }, 3000);
     
     
}

myApp.directive('fadey', function() {
    return {
        restrict: 'A',
        link: function(scope, elm, attrs) {
            var duration = parseInt(attrs.fadey);
            if (isNaN(duration)) {
                duration = 800;
            }
            elm = jQuery(elm);
            elm.hide();
            elm.fadeIn(duration)

            scope.destroy = function(complete) {
                elm.fadeOut(duration, function() {
                    if (complete) {
                        complete.apply(scope);
                    }
                });
            };
        }
    };
});
