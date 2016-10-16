var app = angular.module('clienteModule',[]);
app.controller('clienteControl',function($scope,$http) {
	
	urlcliente = 'http://127.0.0.1:8080/AplicacaoHotel/rs/cliente';
	urlsexo = 'http://127.0.0.1:8080/AplicacaoHotel/rs/sexo';
	urlLogradouro = 'http://127.0.0.1:8080/AplicacaoHotel/rs/logradouro';
	
	
	$scope.pesquisarLogradouro = function() {
		$http.get(urlLogradouro).success(function (logradouros) {
			$scope.logradouros = logradouros;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.pesquisarSexo = function(){
		$http.get(urlsexo).success(function(sexos){
			$scope.sexos = sexos;
		}).error(function(erro){
			alert(erro);
		});
	}
	
	$scope.salvar = function() {
		if($scope.cliente.codigo == ''){
			$http.post(urlcliente,$scope.cliente).success(function(cliente){
				$scope.clientes.push($scope.cliente);
				$scope.novo();
			}).error(function (erro){
				alert(erro);
			});
		}else{
			$http.put(urlcliente,$scope.cliente).success(function(cliente) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.pesquisar = function() {
		$http.get(urlcliente).success(function (clientes) {
			$scope.clientes = clientes;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if($scope.cliente.codigo == ''){
			alert('selecione um cliente');
		}else{
			urlExcluir = urlcliente+'/'+$scope.cliente.codigo;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro){
				alert(erro);
			});
		}
		 		
	}
	
	$scope.novo = function () { 
		$scope.cliente = {};
	}; 	
	
	$scope.seleciona = function (cliente) {
		$scope.cliente = cliente; 
	};	
	
	$scope.selecionaLogradouro = function (logradouro) {
		$scope.cliente.endereco = logradouro; 
	};
	
	$scope.pesquisar();
	$scope.pesquisarSexo();
	$scope.pesquisarLogradouro();

	
});