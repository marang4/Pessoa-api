package br.com.senac.pessoa.pessoa_webservice_api.services;

import br.com.senac.pessoa.pessoa_webservice_api.Entidades.Pessoa;
import br.com.senac.pessoa.pessoa_webservice_api.Repositorios.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepositorio;

    /*public PessoaService(PessoaRepository pessoaRepositorio) {
        this.pessoaRepositorio = pessoaRepositorio;
    }*/


    public Pessoa criarPessoa(Pessoa pessoa) {
        try {

           Pessoa pessoaResult =  pessoaRepositorio.save(pessoa);
           return pessoaResult;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }

    }
}
