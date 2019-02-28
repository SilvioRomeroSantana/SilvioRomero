package srsantana.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import srsantana.crud.model.Pessoa;
import srsantana.crud.services.PessoaService;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/rest")
public class PessoaController {

	@Autowired
	PessoaService service;
	
	//Salvando uma pessoa
	@PostMapping(value = "/pessoas/save")
	public Pessoa save (@RequestBody Pessoa pessoa) {
		service.SavePessoa(pessoa);
		return pessoa;
	}
	
	//Pegando todas as pessoas da base de dados
	@GetMapping(value = "/pessoas")
	public List<Pessoa> list () {
		return service.GetAll();
	}
	
	//Pegando 1 pessoa da base de dados
	@GetMapping(value = "/pessoas/{id}")
	public Pessoa getById (@PathVariable long id) {
		return service.GetById(id);
	}
		
	//Deletando 1 pessoa da base de dados
	@DeleteMapping(value = "/pessoas/remove/{id}")
	public void removeFromId (@PathVariable long id) {
		service.DeletePessoa(id);
	}
	
}
