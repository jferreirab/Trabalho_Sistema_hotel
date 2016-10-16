var app = angular.module('cidadeModule',[]);
app.controller('cidadeControl',function($scope,$http) {
	
	urlCidade = 'http://127.0.0.1:8080/AplicacaoHotel/rs/cidade';
	urlUf = 'http://127.0.0.1:8080/AplicacaoHotel/rs/estado';
	
	
	$scope.pesquisarEstado = function(){
		$http.get(urlUf).success(function(estados){
			$scope.estados = estados;
		}).error(function(erro){
			alert(erro);
		});
	}
	
	$scope.salvar = function() {
		if($scope.cidade.codigo == ''){
			$http.post(urlCidade,$scope.cidade).success(function(cidade){
				$scope.cidades.push($scope.cidade);
				$scope.novo();
			}).error(function (erro){
				alert(erro);
			});
		}else{
			$http.put(urlCidade,$scope.cidade).success(function(cidade) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.pesquisar = function() {
		$http.get(urlCidade).success(function (cidades) {
			$scope.cidades = cidades;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if($scope.cidade.codigo == ''){
			alert('selecione uma cidade');
		}else{
			urlExcluir = urlCidade+'/'+$scope.cidade.codigo;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro){
				alert(erro);
			});
		}
		 		
	}
	
	$scope.novo = function () { 
		$scope.cidade = {};
	}; 	
	
	$scope.seleciona = function (cidade) {
		$scope.cidade = cidade; 
	};	
	
	$scope.pesquisar();
	$scope.pesquisarEstado();

	
});