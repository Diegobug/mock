package exemplo.springmock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import exemplo.springmock.entity.Pessoa;
import exemplo.springmock.service.PessoaService;

@RestController
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	@PostMapping("/pessoa")
	public Pessoa create(@RequestBody Pessoa pessoa) {
		return pessoaService.save(pessoa);
	}

	@GetMapping("/pessoa")
	public Iterable<Pessoa> read() {
		return pessoaService.findAll();
	}

	@PutMapping("/pessoa")
	public Pessoa update(@RequestBody Pessoa pessoa) {
		return pessoaService.save(pessoa);
	}

	@DeleteMapping("/pessoa/{id}")
	public void delete(@PathVariable Long id) {
		pessoaService.deleteById(id);
	}

}
