package srsantana.crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	 //Roteamento Pelo Back-End
	 //Para o caminho /pessoa, o arquivo pessoa.html sera chamado
	 @RequestMapping("/pessoa")
	 public String home() {
	  return "pessoa";
	 }
	 
	 @RequestMapping("/pessoa/save")
	 public String save() {
	  return "save";
	 }
	 
	 @RequestMapping("/pessoa/{id}")
	 public String getId() {
	  return "save";
	 }
	 
}