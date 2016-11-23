var app = angular.module('consumoModule',['simple-autocomplete']);
app.controller('consumoControl',function($scope,$http) {
	
	$scope.selectedData = [];
	$scope.datas = [
		{title: 'Coca', valor: 2},
		{title: 'Guarana', valor: 4},
		{title: 'Sprite', valor: 7}
	];	

	$scope.onSelect = function(selection) {
		console.log(selection);	
		if($scope.consumo == undefined){
			$scope.consumo = {itensConsumo:[]};
		}			
		$scope.consumo.itensConsumo.push({produto:selection,quantidade: null});
		$scope.$broadcast('simple-autocomplete:clearInput');
		$scope.searchTerm = '';
	};

	$scope.clearInput = function() {
		$scope.$broadcast('simple-autocomplete:clearInput');
	};
	
	$scope.getTotal = function(){
		var total = 0;
		for(var i = 0; i < $scope.consumo.itensConsumo.length; i++){
			var item = $scope.consumo.itensConsumo[i];
			total += (item.produto.valor * item.quantidade);
		}
		return total;
	}
	
	urlConsumo = 'http://127.0.0.1:8080/AplicacaoHotel/rs/consumo';
	
	$scope.salvar = function() {
		if($scope.consumo.codigo == undefined || $scope.consumo.codigo == ''){
			$http.post(urlConsumo,$scope.consumo).success(function(consumo){
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Consumo salvo com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}else{
			$http.put(urlConsumo,$scope.consumo).success(function(consumo) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Consumo atualizado com sucesso');
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
		$http.get(urlConsumo).success(function (produtos) {
			$scope.produtos = produtos;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if($scope.consumo.codigo == undefined || $scope.consumo.codigo == ''){
			$scope.mensagens.push('Selecione um consumo');
		}else{
			urlExcluir = urlConsumo+'/'+$scope.consumo.codigo;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Consumo excluído com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		 		
	}
	
	$scope.novo = function () { 
		$scope.consumo = {};
		$scope.mensagens = [];
	}; 	
	
	$scope.seleciona = function (consumo) {
		$scope.consumo = consumo;
        $('#myTab a:first').tab('show')
	};	
	
	$scope.pesquisar();
	
});