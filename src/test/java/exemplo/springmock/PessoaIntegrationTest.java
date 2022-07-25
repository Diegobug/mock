package exemplo.springmock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import exemplo.springmock.controller.PessoaController;
import exemplo.springmock.entity.Pessoa;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PessoaIntegrationTest {

	@Autowired
	PessoaController controller;

	@Test
	public void testCreateReadDelete() {
		Pessoa pessoa = new Pessoa("Joao", "Silva");

		Pessoa pessoaCriada = this.controller.create(pessoa);

		Iterable<Pessoa> todasPessoas = this.controller.read();

		Pessoa primeiraPessoa = todasPessoas.iterator().next();

		assertEquals(pessoa.getPrimeiroNome(), pessoaCriada.getPrimeiroNome());
		assertEquals(pessoa.getSobrenome(), pessoaCriada.getSobrenome());

		assertEquals(primeiraPessoa, pessoa);
	}

}
