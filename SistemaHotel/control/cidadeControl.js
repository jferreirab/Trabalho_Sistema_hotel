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
		if($scope.cidade.codigo == undefined || $scope.cidade.codigo == ''){
			$http.post(urlCidade,$scope.cidade).success(function(cidade){
				$scope.cidades.push($scope.cidade);
				$scope.novo();
				$scope.mensagens.push('Cidade salva com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}else{
			$http.put(urlCidade,$scope.cidade).success(function(cidade) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Cidade atualizada com sucesso');
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
		$http.get(urlCidade).success(function (cidades) {
			$scope.cidades = cidades;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if($scope.cidade.codigo == undefined || $scope.cidade.codigo == ''){
			$scope.mensagens.push('Selecione uma Cidade');
		}else{
			urlExcluir = urlCidade+'/'+$scope.cidade.codigo;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Cidade excluída com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		 		
	}
	
	$scope.novo = function () { 
		$scope.cidade = {};
		$scope.mensagens = [];
	}; 	
	
	$scope.seleciona = function (cidade) {
		$scope.cidade = cidade; 
		$('#myTab a:first').tab('show')
	};	
	
	$scope.pesquisar();
	$scope.pesquisarEstado();

	
});