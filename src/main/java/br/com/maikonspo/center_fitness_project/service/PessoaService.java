package br.com.maikonspo.center_fitness_project.service;

import br.com.maikonspo.center_fitness_project.model.PessoaModel;
import br.com.maikonspo.center_fitness_project.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class PessoaService {

    @Autowired
    private  PessoaRepository repository;

    @Transactional
    public void markAsAbsentByName(String nome) {
        List<PessoaModel> pessoas = repository.findByNameOrLastNameContaining(nome);

        if (pessoas.isEmpty()) {
            throw new RuntimeException("Nenhuma pessoa encontrada com o nome fornecido.");
        }

        if (pessoas.size() > 1) {
            throw new RuntimeException("Vários registros encontrados. Refine a busca.");
        }

        for (PessoaModel pessoa : pessoas) {
            pessoa.setPresent(false);
            repository.save(pessoa);
        }
    }

    @Transactional
    public List<String> monthValidation() {
        LocalDate umMesAntes = LocalDate.now().minusMonths(1);
        List<Object[]> pessoasPagamentoVencido = repository.findByPagoBefore(umMesAntes);

        List<String> nomesVencidos = new ArrayList<>();


        for (Object[] result : pessoasPagamentoVencido) {
            String nome = (String) result[0];
            LocalDate pago = (LocalDate) result[1];

            nomesVencidos.add("Nome: " + nome + ", Pago: " + pago);
        }

        return nomesVencidos;
    }


}
