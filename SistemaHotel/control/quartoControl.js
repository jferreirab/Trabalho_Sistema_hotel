var app = angular.module('quartoModule',[]);
app.controller('quartoControl',function($scope,$http) {
	
	urlQuarto = 'http://127.0.0.1:8080/AplicacaoHotel/rs/quarto';
    urlTipoQuarto = 'http://127.0.0.1:8080/AplicacaoHotel/rs/tipoQuarto';
	
	$scope.pesquisarTipoQuarto = function(){
		$http.get(urlTipoQuarto).success(function(tiposQuartos){
			$scope.tiposQuartos = tiposQuartos;
		}).error(function(erro){
			alert(erro);
		});
	}
    
    
	$scope.salvar = function() {
		if($scope.quarto.codigo == undefined || $scope.quarto.codigo == ''){
			$http.post(urlQuarto,$scope.quarto).success(function(quarto){
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Quarto salvo com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}else{
			$http.put(urlQuarto,$scope.quarto).success(function(quarto) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Quarto atualizado com sucesso');
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
		$http.get(urlQuarto).success(function (quartos) {
			$scope.quartos = quartos;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if($scope.quarto.codigo == undefined || $scope.quarto.codigo == ''){
			$scope.mensagens.push('selecione um quarto');
		}else{
			urlExcluir = urlQuarto+'/'+$scope.quarto.codigo;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Quarto excluído com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		 		
	}
	
	$scope.novo = function () { 
		$scope.quarto = {};
		$scope.mensagens = [];
	}; 	
	
	$scope.seleciona = function (quarto) {
		$scope.quarto = quarto;
        $('#myTab a:first').tab('show')
	};	
	
	$scope.pesquisar();
    $scope.pesquisarTipoQuarto();
	

	
});