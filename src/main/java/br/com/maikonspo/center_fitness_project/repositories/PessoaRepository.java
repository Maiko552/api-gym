package br.com.maikonspo.center_fitness_project.repositories;

import br.com.maikonspo.center_fitness_project.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, UUID> {

    // Busca pelo nome ou sobrenome com LIKE
    @Query("SELECT p FROM PessoaModel p WHERE p.nome LIKE %:nome% OR p.sobrenome LIKE %:nome%")
    List<PessoaModel> findByNameOrLastNameContaining(@Param("nome") String name);

}
