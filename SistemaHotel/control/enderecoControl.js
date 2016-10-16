var app = angular.module('enderecoModule',[]);
app.controller('enderecoControl',function($scope,$http) {
	
	urlLogradouro = 'http://127.0.0.1:8080/AplicacaoHotel/rs/logradouro';
	urlCidade = 'http://127.0.0.1:8080/AplicacaoHotel/rs/cidade';
	urlTipoLogradouro = 'http://127.0.0.1:8080/AplicacaoHotel/rs/tipoLogradouro';
	
	$scope.pesquisarTipoLogradouro = function(){
		$http.get(urlTipoLogradouro).success(function(tipoLogradouros){
			$scope.tipoLogradouros = tipoLogradouros;
		}).error(function(erro){
			alert(erro);
		});
	}
	$scope.pesquisarCidade = function(){
		$http.get(urlCidade).success(function(cidades){
			$scope.cidades = cidades;
		}).error(function(erro){
			alert(erro);
		});
	}
	
	$scope.salvar = function() {
		if($scope.logradouro.codigo == ''){
			$http.post(urlLogradouro,$scope.logradouro).success(function(logradouro){
				$scope.logradouros.push($scope.logradouro);
				$scope.novo();
			}).error(function (erro){
				alert(erro);
			});
		}else{
			$http.put(urlLogradouro,$scope.logradouro).success(function(logradouro) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.pesquisar = function() {
		$http.get(urlLogradouro).success(function (logradouros) {
			$scope.logradouros = logradouros;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if($scope.logradouro.codigo == ''){
			alert('selecione um logradouro');
		}else{
			urlExcluir = urlLogradouro+'/'+$scope.logradouro.codigo;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro){
				alert(erro);
			});
		}
		 		
	}
	
	$scope.novo = function () { 
		$scope.logradouro = {};
	}; 	
	
	$scope.seleciona = function (logradouro) {
		$scope.logradouro = logradouro; 
	};	
	
	$scope.pesquisar();
	$scope.pesquisarCidade();
	$scope.pesquisarTipoLogradouro();

	
});