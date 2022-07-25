package exemplo.springmock.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import exemplo.springmock.entity.Pessoa;
import exemplo.springmock.repository.PessoaRepository;
import exemplo.springmock.service.PessoaService;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {
	@InjectMocks
	PessoaService service;

	@Mock
	PessoaRepository repository;

	@Test
	void testeDeletarPessoaNaoEncontrada() {
		Optional<Pessoa> optionalPessoa = Optional.empty();
		
		when(repository.findById(any())).thenReturn( optionalPessoa );
		
		assertThrows(EntityNotFoundException.class, ()->{service.deleteById(1l);});
		
		verify(repository, times(1)).findById(1l);
	}
	
	@Test
	void testeDeletarPessoaEncontrada() {
		Optional<Pessoa> optionalPessoa = Optional.of( new Pessoa("José", "Silva") );
		
		when(repository.findById(any())).thenReturn(optionalPessoa);
		
		assertDoesNotThrow( ()->{ service.deleteById(1l);} );
		
		verify(repository, times(1)).findById(1l);
	}

	@Test
	void testeEncontrarTodos() {
		Optional<Pessoa> optionalPessoa = Optional.of( new Pessoa("José", "Silva") );
		
		when(repository.findById(any())).thenReturn(optionalPessoa);
		
		assertThrows( ()->{ service.findAll();} );
		
		verify(repository, times(1)).findAll();
	}

	@Test
	void testeDeletarTodos() {
		Optional<Pessoa> optionalPessoa = Optional.of( new Pessoa("José", "Silva") );
		
		when(repository.findById(any())).thenReturn(optionalPessoa);
		
		doNothing().when(repository).deleteAll();
		
		service.deleteAll();
		
		verify(repository, times(1)).deleteAll();
	}

	@Test
	void salvar() {
		Optional<Pessoa> optionalPessoa = Optional.of( new Pessoa("José", "Silva") );
		
		when(repository.findById(any())).thenReturn(optionalPessoa);
		
		assertThrows( ()->{ service.save(optionalPessoa);} );
		
		verify(repository, times(1)).save(optionalPessoa);
	}
}
