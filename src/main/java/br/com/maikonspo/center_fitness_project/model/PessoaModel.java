package br.com.maikonspo.center_fitness_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private String nome;

    @NotBlank
    @Column(name = "sobrenome", length = 255, nullable = false)
    private String sobrenome;

    private String email;

    @Column(name = "is_present")
    private boolean isPresent = true;

    @Column(name = "pago")
    private LocalDate pago;

    @Column(name = "foto_url")
    private String fotoURL;


    public String getPago() {
        if (pago != null){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return pago.format(formatter);
        }
        return "";
    }
}
