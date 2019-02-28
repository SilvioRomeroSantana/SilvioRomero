package srsantana.crud.services;
import srsantana.crud.model.Pessoa;
import java.util.List;


public interface IPessoaService {
	public List<Pessoa> GetAll ();
	
	public Pessoa GetById (long id);
	
	public Pessoa SavePessoa (Pessoa pessoa);
	
	public void DeletePessoa (long id);
}
