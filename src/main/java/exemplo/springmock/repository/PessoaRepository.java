package exemplo.springmock.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import exemplo.springmock.entity.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
