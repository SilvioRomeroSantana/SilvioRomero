package srsantana.crud.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srsantana.crud.model.Pessoa;
import srsantana.crud.repository.PessoaRepository;

@Service
@Transactional
public class PessoaService implements IPessoaService{

	@Autowired
	PessoaRepository repository;
	
	@Override
	public List<Pessoa> GetAll() {
		return (List<Pessoa>) repository.findAll();
	}

	@Override
	public Pessoa GetById(long id) {
		return repository.findById(id).get();
	}

	@Override
	public Pessoa SavePessoa(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	@Override
	public void DeletePessoa(long id) {
		repository.deleteById(id);
	}

}
