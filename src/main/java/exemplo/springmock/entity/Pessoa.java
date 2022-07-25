package exemplo.springmock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String primeiroNome;
	
	private String sobrenome;

	public Pessoa(String primeiroNome, String sobrenome) {
		this.primeiroNome = primeiroNome;
		this.sobrenome = sobrenome;
	}
}
