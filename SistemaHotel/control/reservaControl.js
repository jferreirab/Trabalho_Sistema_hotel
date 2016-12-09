var app = angular.module('reservaModule',['simple-autocomplete']);
app.controller('reservaControl',function($scope,$http) {
	
	urlcliente = 'http://127.0.0.1:8080/AplicacaoHotel/rs/cliente';
	urlReserva = 'http://127.0.0.1:8080/AplicacaoHotel/rs/reserva';
	urlSituacaoReserva = 'http://127.0.0.1:8080/AplicacaoHotel/rs/situacaoReserva';
	urlQuarto = 'http://127.0.0.1:8080/AplicacaoHotel/rs/quarto';
	urlProduto = 'http://127.0.0.1:8080/AplicacaoHotel/rs/produto';
	 urlConsumo = 'http://127.0.0.1:8080/AplicacaoHotel/rs/consumo';
	
	
	$scope.pesquisarCliente = function(){
		$http.get(urlcliente).success(function(clientes){
			$scope.clientes = clientes;
		}).error(function(erro){
			alert(erro);
		});
	}
	
	$scope.pesquisarSituacaoReserva = function(){
		$http.get(urlSituacaoReserva).success(function(situacaoReservas){
			$scope.situacaoReservas = situacaoReservas;
		}).error(function(erro){
			alert(erro);
		});
	}
		
	$scope.salvar = function() {
		if(($scope.reserva.dataEntrada == undefined || $scope.reserva.dataEntrada == null) ||(
				$scope.reserva.dataSaida == undefined || $scope.reserva.dataSaida == null) ){
			alert('Data de entrada ou Saída não foi informada!');
		}
		else{
			if($scope.reserva.codigo == undefined || $scope.reserva.codigo == ''){
				$http.post(urlReserva,$scope.reserva).success(function(reserva){
					//$scope.reservas.push($scope.reserva);					
					$scope.pesquisar();
					$scope.novo();
					$scope.mensagens.push('Reserva salva com sucesso');					
				}).error(function (erro){
					$scope.montaMensagemErro(erro.parameterViolations);
				});
			}else{
				$http.put(urlReserva,$scope.reserva).success(function(reserva) {
					$scope.pesquisar();
					$scope.novo();
					$scope.mensagens.push('Reserva atualizada com sucesso');
				}).error(function (erro) {
					$scope.montaMensagemErro(erro.parameterViolations);
				});
			}
		}
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagensDanger = [];
		$scope.mensagensDanger.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagensDanger.push(value.message);
		});
	}
	
	$scope.pesquisar = function() {
		$http.get(urlReserva).success(function (reservas) {
			for(i=0 ; i < reservas.length ; i++){
			    reservas[i].dataSaida = new Date(reservas[i].dataSaida);
			    reservas[i].dataEntrada = new Date(reservas[i].dataEntrada);
			}
			$scope.reservas = reservas;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if($scope.reserva.codigo == undefined || $scope.reserva.codigo == ''){
			$scope.mensagens.push('selecione uma Reserva');
		}else{
			urlExcluir = urlReserva+'/'+$scope.reserva.codigo;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Reserva excluída com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		 		
	}
	
 
	
	$scope.novo = function () { 
		$scope.reserva = {};
		$scope.mensagens = [];
		$scope.mensagensDanger = [];
		$scope.mensagens_model = [];
		$scope.produto = {};
	}; 	
	
	$scope.seleciona = function (reserva) {
		$scope.reserva = reserva; 
		$scope.reserva.dataSaida = new Date($scope.reserva.dataSaida);
		$scope.reserva.dataEntrada = new Date($scope.reserva.dataEntrada);
		$scope.mensagens = [];
		$('#myTab a:first').tab('show')
	};	
	
	$scope.pesquisaQuarto = function() {
		
			$scope.mensagens_model = [];
			
				//urlpesquisa = urlLogradouro; 
			
			//urlpesquisa = urlLogradouro + urlBuscaLogradDesc +'/'+$scope.pesquisaEndereco;
			
			$http.get(urlQuarto).success(function(quartos) {
				$scope.quartos = quartos;
				if($scope.quartos.length == 0){
					$scope.mensagens_model.push('Quartos não Encontrado!');
				}
			}).error(function (erro){
				
				$scope.montaMensagemErroModel(erro.parameterViolations);
			});
				 		
	}
	
	$scope.montaMensagemErroModel = function(listaErro) {
		$scope.mensagens_model = [];
		$scope.mensagens_model.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens_model.push(value.message);
		});
	}
	
	$scope.selecionaQuarto = function (quarto) {
		if($scope.reserva == undefined ){
			$scope.reserva={};
		}
			
		$scope.reserva.quarto = quarto; 
		$scope.reserva.valorDiaria = quarto.valorDiaria;
		$scope.getTotalReserva();
		
	};
	
	//consumo
	$scope.pesquisarProdutos = function() {
		$http.get(urlProduto).success(function (produtos) {
			$scope.produtos = produtos;
		}).error(function (erro) {
			alert(erro);
		});
	}

	$scope.onSelect = function(selection) {
		console.log(selection);	
		if($scope.reserva == undefined || $scope.reserva.consumo == undefined  || $scope.reserva.consumo.itemConsumo == undefined){
			if ($scope.reserva==undefined){
				$scope.reserva= {};
			}
			var descricao;
			if ($scope.reserva.consumo==undefined){
				$scope.reserva.consumo= {};
			}
			else{
				if($scope.reserva.consumo.descricao != undefined){
					descricao = $scope.reserva.consumo.descricao;
				}
			}
			
			$scope.reserva.consumo = {itemConsumo:[]};
			if (descricao != undefined){
				$scope.reserva.consumo.descricao = descricao;
			}
		}
		
		$scope.reserva.consumo.itemConsumo.push({produto:selection,quantidade: null,valorTotal: null, valorUnitario: null});
		$scope.$broadcast('simple-autocomplete:clearInput');
		$scope.searchTerm = '';
	};

	$scope.clearInput = function() {
		$scope.$broadcast('simple-autocomplete:clearInput');
	};
	
	$scope.getTotal = function(){
		var total = 0;
		if ($scope.reserva != undefined && $scope.reserva.consumo != undefined && $scope.reserva.consumo.itemConsumo != undefined){
			for(var i = 0; i < $scope.reserva.consumo.itemConsumo.length; i++){
				var item = $scope.reserva.consumo.itemConsumo[i];
				total += (item.produto.valor * item.quantidade);
			//	$scope.reserva.consumo.itemConsumo[i].quandidade = 
				item.valorTotal = (item.produto.valor * item.quantidade);
				item.valorUnitario = item.produto.valor;
				
			}
			$scope.reserva.consumo.valorTotal = total;
		}
		//return total;
		$scope.getTotalReserva();
	}
   	
     /////////////////
	$scope.getTotalReserva = function(){
		if($scope.reserva != undefined ){
			if($scope.reserva.dataEntrada != undefined && $scope.reserva.dataSaida != undefined){
				 date1 = new Date($scope.reserva.dataEntrada);
				 date2 = new Date($scope.reserva.dataSaida);
				 var diferenca = Math.abs(date1 - date2); //diferença em milésimos e positivo
				 var dia = 1000*60*60*24; // milésimos de segundo correspondente a um dia
				 var total = Math.round(diferenca/dia); //valor total de dias arredondado
				 
				 if(total > 0 ){
					 if($scope.reserva.valorDiaria != undefined){
						 var valorRserva = $scope.reserva.valorDiaria * total;
						 if($scope.reserva.consumo != undefined && $scope.reserva.consumo.valorTotal != undefined && $scope.reserva.consumo.valorTotal > 0  ){
							 $scope.reserva.valorTotalReserva = $scope.reserva.consumo.valorTotal + valorRserva;
						 }
						 else{
							 $scope.reserva.valorTotalReserva = valorRserva;
						 }
					 }
				 }
			}
		}
		 
	 ///////////////////
	}
	
	
	/*$scope.pesquisarConsumo = function() {
		$http.get(urlConsumo).success(function (consumos) {
			$scope.consumos = consumos;
		}).error(function (erro) {
			alert(erro);
		});
	}*/
		
	
	$scope.novoConsumo = function () { 
		$scope.consumo = {};
		$scope.mensagens = [];
	}; 	
	
	$scope.selecionaConsumo = function (consumo) {
		$scope.consumo = consumo;
        $('#myTab a:first').tab('show')
	};	
	
	
	//final consumo
	
	$scope.pesquisar();
	$scope.pesquisarCliente();
	$scope.pesquisarSituacaoReserva();
	$scope.pesquisarProdutos();
	/*$scope.pesquisarConsumo();*/

	
});

