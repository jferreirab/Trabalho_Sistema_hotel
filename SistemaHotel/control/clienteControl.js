var app = angular.module('clienteModule',[]);
app.controller('clienteControl',function($scope,$http) {
	
	urlcliente = 'http://127.0.0.1:8080/AplicacaoHotel/rs/cliente';
	urlsexo = 'http://127.0.0.1:8080/AplicacaoHotel/rs/sexo';
	urlLogradouro = 'http://127.0.0.1:8080/AplicacaoHotel/rs/logradouro';
	urlBuscaLogradDesc='/desc';
	
		
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
		if($scope.cliente.codigo == undefined || $scope.cliente.codigo == ''){
			$http.post(urlcliente,$scope.cliente).success(function(cliente){
				$scope.clientes.push($scope.cliente);
				$scope.novo();
				$scope.mensagens.push('Cliente salva com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}else{
			$http.put(urlcliente,$scope.cliente).success(function(cliente) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Cliente atualizada com sucesso');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
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
		$http.get(urlcliente).success(function (clientes) {
			$scope.clientes = clientes;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if($scope.cliente.codigo == undefined || $scope.cliente.codigo == ''){
			$scope.mensagens.push('selecione um cliente');
		}else{
			urlExcluir = urlcliente+'/'+$scope.cliente.codigo;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Cliente excluída com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		 		
	}
	
	$scope.pesquisaEndereco = '';
	$scope.showModal = false;
	//$scope.showModal1 = true;
	
	$scope.pesquisaEnderecoDescricao = function() {
		/*if($scope.pesquisaEndereco == ''){
			
		}else{*/
			$scope.mensagens_model = [];
			if($scope.pesquisaEndereco == '' ){
				urlpesquisa = urlLogradouro; 
			}else{
			urlpesquisa = urlLogradouro + urlBuscaLogradDesc +'/'+$scope.pesquisaEndereco;
			}
			$http.get(urlpesquisa).success(function(logradouros) {
				$scope.logradouros = logradouros;
				if($scope.logradouros.length == 0){
					$scope.mensagens_model.push('Endereço não Encontrado!');
				}
			}).error(function (erro){
				//alert(erro);
				$scope.montaMensagemErroModel(erro.parameterViolations);
			});
		//}
		 		
	}
	
	$scope.montaMensagemErroModel = function(listaErro) {
		$scope.mensagens_model = [];
		$scope.mensagens_model.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens_model.push(value.message);
		});
	}
	 
	
	$scope.novo = function () { 
		$scope.cliente = {};
		$scope.mensagens = [];
		$scope.mensagens_model = [];
		$scope.mensagensDanger = [];
	}; 	
	
	$scope.seleciona = function (cliente) {
		$scope.cliente = cliente; 
		$scope.mensagens = [];
		$('#myTab a:first').tab('show')
	};	
	
	$scope.selecionaLogradouro = function (logradouro) {
		if($scope.cliente == undefined ){
			$scope.cliente={};
		}
			
		$scope.cliente.endereco = logradouro; 
		
	};
	
	$scope.pesquisar();
	$scope.pesquisarSexo();
	//$scope.pesquisarLogradouro();

	
});

