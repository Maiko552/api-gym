package br.com.maikonspo.center_fitness_project.repositories;

import br.com.maikonspo.center_fitness_project.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, UUID> {
}
