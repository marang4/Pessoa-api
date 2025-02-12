package br.com.senac.pessoa.pessoa_webservice_api.Repositorios;

import br.com.senac.pessoa.pessoa_webservice_api.Entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}