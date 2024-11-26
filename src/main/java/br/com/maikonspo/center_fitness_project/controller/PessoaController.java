package br.com.maikonspo.center_fitness_project.controller;

import br.com.maikonspo.center_fitness_project.model.PessoaModel;
import br.com.maikonspo.center_fitness_project.repositories.PessoaRepository;
import br.com.maikonspo.center_fitness_project.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.UUID;

@RestController
@RequestMapping("/cfitness")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPessoas(@PathVariable UUID id) {
        return repository.findById(id)
                .map(pessoa -> ResponseEntity.ok((Object) pessoa)) // Força a tipagem para evitar warnings
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Pessoa não encontrada para o ID fornecido."));
    }
    @GetMapping("/lista")
    public ResponseEntity<?> pessoaList() {
        List<PessoaModel> pessoasLista = repository.findAll();

        if (pessoasLista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("A lista permanece vazia.");
        }

        return ResponseEntity.ok(pessoasLista);
    }
    @GetMapping("/searchnome")
    public ResponseEntity<?> buscarPessoa(@RequestParam String nome) {
        List<PessoaModel> pessoas = repository.findByNameOrLastNameContaining(nome);

        if (pessoas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma pessoa encontrada com o nome fornecido.");
        }

        return ResponseEntity.ok(pessoas);
    }


    @PostMapping("/cadastro")
    public ResponseEntity<Object> postPessoa(@RequestBody PessoaModel pessoa) {
        PessoaModel pessoSalva = repository.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoSalva);
    }

    @PostMapping("/desativar")
    public ResponseEntity<String> desativarPessoa(@RequestParam String nome) {
        try {
            pessoaService.markAsAbsentByName(nome);
            return ResponseEntity.ok("Pessoa(s) desativada(s) com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }

    }
}
