package exemplo.springmock;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import exemplo.springmock.controller.PessoaController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AplicacaoTests {

	@Autowired
	PessoaController controller;

	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}
}
