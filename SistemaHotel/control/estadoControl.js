var app = angular.module('estadoModule',[]);
app.controller('estadoControl',function($scope,$http) {
	
	urlUf = 'http://127.0.0.1:8080/AplicacaoHotel/rs/estado';
	
	$scope.salvar = function() {
		if($scope.estado.codigo == undefined || $scope.estado.codigo == ''){
			$http.post(urlUf,$scope.estado).success(function(estado){
				$scope.estados.push($scope.estado);
				$scope.novo();
				$scope.mensagens.push('Estado salva com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}else{
			$http.put(urlUf,$scope.estado).success(function(estado) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Estado atualizada com sucesso');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}
	
	$scope.pesquisar = function() {
		$http.get(urlUf).success(function (estados) {
			$scope.estados = estados;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if($scope.estado.codigo == undefined || $scope.estado.codigo == ''){
			$scope.mensagens.push('selecione uma estado');
		}else{
			urlExcluir = urlUf+'/'+$scope.estado.codigo;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Estado excluída com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		 		
	}
	
	$scope.novo = function () { 
		$scope.estado = {};
		$scope.mensagens = [];
	}; 	
	
	$scope.seleciona = function (estado) {
		$scope.estado = estado; 
	};	
	
	$scope.pesquisar();
	

	
});