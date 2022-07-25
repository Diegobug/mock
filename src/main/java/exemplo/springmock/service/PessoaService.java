package exemplo.springmock.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exemplo.springmock.entity.Pessoa;
import exemplo.springmock.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository repository;

	public Pessoa save(Pessoa pessoa) {
		if (pessoa.getId() == null) {
			pessoa = repository.save(pessoa);
			return pessoa;
		} else {
			Optional<Pessoa> pessoaOptional = repository.findById(pessoa.getId());

			if (pessoaOptional.isPresent()) {

				Pessoa novaPessoa = pessoaOptional.get();
				novaPessoa.setPrimeiroNome(pessoa.getPrimeiroNome());
				novaPessoa.setSobrenome(pessoa.getSobrenome());

				novaPessoa = repository.save(novaPessoa);

				return novaPessoa;
			} else {
				throw new EntityNotFoundException("Não existe pessoa com esse id.");
			}
		}
	}

	public List<Pessoa> findAll() {
		List<Pessoa> resultado = (List<Pessoa>) repository.findAll();

		if (resultado.size() > 0) {
			return resultado;
		} else {
			return new ArrayList<Pessoa>();
		}
	}

	public void deleteById(Long id) {
		Optional<Pessoa> pessoa = repository.findById(id);

		if (pessoa.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Não existe pessoa com esse id.");
		}
	}

	void deleteAll() {
		repository.deleteAll();
	}
}
