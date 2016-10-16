var app = angular.module('estadoModule',[]);
app.controller('estadoControl',function($scope,$http) {
	
	urlUf = 'http://127.0.0.1:8080/AplicacaoHotel/rs/estado';
	
	$scope.salvar = function() {
		if($scope.estado.codigo == ''){
			$http.post(urlUf,$scope.estado).success(function(estado){
				$scope.estados.push($scope.estado);
				$scope.novo();
			}).error(function (erro){
				alert(erro);
			});
		}else{
			$http.put(urlUf,$scope.estado).success(function(estado) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.pesquisar = function() {
		$http.get(urlUf).success(function (estados) {
			$scope.estados = estados;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if($scope.estado.codigo == ''){
			alert('selecione uma estado');
		}else{
			urlExcluir = urlUf+'/'+$scope.estado.codigo;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro){
				alert(erro);
			});
		}
		 		
	}
	
	$scope.novo = function () { 
		$scope.estado = {};
	}; 	
	
	$scope.seleciona = function (estado) {
		$scope.estado = estado; 
	};	
	
	$scope.pesquisar();
	

	
});