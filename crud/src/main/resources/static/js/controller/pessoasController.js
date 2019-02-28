angular.module('crudApp').controller('pessoasController', pessoasController);

pessoasController.$inject = ['$scope', 'ngPessoaService'];

function pessoasController ($scope, ngPessoaService) {
		
	//Carrego pessoas oo back end
	$scope.pessoas = ngPessoaService.query();
	
	//Deleto pessoa e recarrego lista
	$scope.deletePessoa = function(id) {
		ngPessoaService.delete({id:id}, function() {
			$scope.pessoas = ngPessoaService.query();
		});
	};
	
	//Usado para ordenar tabela por suas colunas
	$scope.orderBy = function(texto) {
		$scope.orderKey = texto;
		$scope.reverse = !$scope.reverse;
	};		
}