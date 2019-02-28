angular.module('crudApp').factory('ngPessoaService', ngPessoaService);

ngPessoaService.$inject=['$resource'];

//Servico para acessar o Back-end
function ngPessoaService ($resource){
	return $resource ('/rest/pessoas', {},{
	    save:{
	        url:'/rest/pessoas/save',
	        method:'POST'
	    },
	    getAll:{
	        url:'/rest/pessoas',
	        method:'GET'
	    },
	    getById:{
	        url:'/rest/pessoas/:id',
	        method:'GET'
	    },
	    delete:{
	        url:'/rest/pessoas/remove/:id',
	        method:'DELETE'
	    }
    });
    
}