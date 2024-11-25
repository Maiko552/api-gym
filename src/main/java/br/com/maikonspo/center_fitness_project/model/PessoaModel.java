package br.com.maikonspo.center_fitness_project.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "pessoas")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long ID;

    @NotBlank
    @Column(length = 255, nullable = false)
    private String name;

    @NotBlank
    @Column(length = 255, nullable = false)
    private String lastName;

    private String email;

    private String fotoURL;


}
