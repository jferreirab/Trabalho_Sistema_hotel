var app = angular.module('produtoModule',[]);
app.controller('produtoControl',function($scope,$http) {
	
	urlProduto = 'http://127.0.0.1:8080/AplicacaoHotel/rs/produto';
	
	$scope.salvar = function() {
		if($scope.produto.codigo == undefined || $scope.produto.codigo == ''){
			$http.post(urlProduto,$scope.produto).success(function(produto){
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Produto salvo com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}else{
			$http.put(urlProduto,$scope.produto).success(function(produto) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Produto atualizado com sucesso');
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
		$http.get(urlProduto).success(function (produtos) {
			$scope.produtos = produtos;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if($scope.produto.codigo == undefined || $scope.produto.codigo == ''){
			$scope.mensagens.push('selecione um produto');
		}else{
			urlExcluir = urlProduto+'/'+$scope.produto.codigo;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Produto excluído com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		 		
	}
	
	$scope.novo = function () { 
		$scope.produto = {};
		$scope.mensagens = [];
	}; 	
	
	$scope.seleciona = function (produto) {
		$scope.produto = produto;
        $('#myTab a:first').tab('show')
	};	
	
	$scope.pesquisar();
	
});