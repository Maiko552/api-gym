package br.com.maikonspo.center_fitness_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "pessoas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID")
    private UUID id;

    @NotBlank
    @Column(length = 255, nullable = false, name = "nome")
    private String name;

    @NotBlank
    @Column(name = "sobrenome", length = 255, nullable = false)
    private String lastName;

    private String email;

    @Column(name = "ativo")
    private boolean isPresent = true;

    @Column(name = "foto_url")
    private String fotoURL;


}
