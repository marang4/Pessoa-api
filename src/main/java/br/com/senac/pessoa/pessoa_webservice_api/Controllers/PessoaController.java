package br.com.senac.pessoa.pessoa_webservice_api.Controllers;

import br.com.senac.pessoa.pessoa_webservice_api.Entidades.Pessoa;
import br.com.senac.pessoa.pessoa_webservice_api.Repositorios.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("pessoa")
public class PessoaController {


    @Autowired
    private PessoaRepository pessoaRepository;


    @PostMapping("/criar")
    public ResponseEntity<Pessoa> criarCliente(@RequestBody Pessoa pessoa){
        Pessoa retorno =   pessoaRepository.save(pessoa);
        if (retorno != null) {
            return ResponseEntity.ok().body(retorno);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        List<Pessoa> clientesRetorno = pessoaRepository.findAll();

        return ResponseEntity.ok().body(clientesRetorno);
    }


    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pessoa> atualizarCliente(@RequestBody Pessoa pessoa, @PathVariable Long id){
        Optional<Pessoa> retorno =  pessoaRepository.findById(id).map(record -> {
            record.setNome(pessoa.getNome());

            return pessoaRepository.save(record);
        });
        if (retorno.isPresent()){
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        pessoaRepository.deleteById(id);

        return ResponseEntity.ok().body(null);

    }

}
