angular.module('crudApp').controller('sharedController', sharedController);

sharedController.$inject = ['$scope', 'ngPessoaService', '$location'];

function sharedController ($scope, ngPessoaService, $location){
	
	$scope.PORT = "8081";
	//array com funcoes de validação do formulario
	$scope.validationFunctions = [];
	//numero de campos obrigatorios do form
	NUMBER_OF_FIELDS = 8;
	//Verifica se o usuario já tentou salvar uma pessoa
	var isFirstTentative = false;
	//Carregando ID pela url
	var possibleId = window.location.href.split("/").slice(-1)[0];
	//Verificando se eh um numero
	var isNumber = !isNaN(possibleId);
	//Variavel de controle para tipo de form (add ou details)
	
	//Se for details, carrego a pessoa, se não, inicio a pessoa com {}
	if(isNumber)
		ngPessoaService.getById({id: possibleId}, function() {}).$promise.then(function(pessoa){
			$scope.pessoa = pessoa;
		});
	else
		$scope.pessoa = {};
			
	//Chamado pelo botal clear, limpa o form
	$scope.clearFormRegister = function (){
		return $scope.pessoa = {};
	}
	
	//Funcao que retorna variavel de controle do tipo do form
	$scope.isAdd = function (){
		return !isNumber;
	}
	
	$scope.getTentativeType = function (){
		return isFirstTentative;
	}
	
	//Valida form, verifica se o objeto pessoa possui todos os campos preenchidos
	$scope.areAllFieldsFilled = function() {
		if($scope.pessoa !== undefined)	
			return  Object.values($scope.pessoa).filter(p => p !== "").length === NUMBER_OF_FIELDS;
	};

	//valida se o campo number é um numero ou esta vazio
	$scope.isNumberValid = function() {
		return $scope.pessoa !== undefined && ($scope.pessoa.number === undefined || !isNaN($scope.pessoa.number));
	};
	
	//Adiciono funcoes no array de funcoes de validacao
	$scope.validationFunctions.push($scope.isNumberValid);
	$scope.validationFunctions.push($scope.areAllFieldsFilled);
		
	//Verifica validade do form através das funcoes de validacao
	$scope.verifyValidityForm = function() {
		return $scope.validationFunctions.reduce((accumulator, currentValue) => accumulator() && currentValue());
	};
		
	$scope.savePessoa = function() {
		if($scope.verifyValidityForm())
		{
			try{		
				//Salva pessoa
				ngPessoaService.save($scope.pessoa, function() {});
			}finally{
				//Redireciona para home
				window.location.assign("http://localhost:"+$scope.PORT+"/pessoa");
			}
		}
		//Usada apenas para mostrar mensagem de erro apos a primeira tentativa de salvar pessoa
		else
			isFirstTentative = true;
	};
		
}