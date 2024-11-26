package br.com.maikonspo.center_fitness_project.controller;

import br.com.maikonspo.center_fitness_project.model.PessoaModel;
import br.com.maikonspo.center_fitness_project.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cfitness")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPessoas(@PathVariable UUID id) {
        return repository.findById(id)
                .map(pessoa -> ResponseEntity.ok((Object) pessoa)) // Força a tipagem para evitar warnings
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Pessoa não encontrada para o ID fornecido."));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Object> postPessoa(@RequestBody PessoaModel pessoa){
        PessoaModel pessoSalva = repository.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoSalva);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> pessoaList(){
        List<PessoaModel> pessoasLista = repository.findAll();

        if (pessoasLista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("A lista permanece vazia.");
        }

        return ResponseEntity.ok(pessoasLista);
    }

}
