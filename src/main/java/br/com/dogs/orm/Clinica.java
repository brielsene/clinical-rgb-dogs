package br.com.dogs.orm;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "clinica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Embedded
    private Endereco Endereco;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "fk_clinica"),
                inverseJoinColumns = @JoinColumn(name = "fk_dog")
    )
    private Set<Dog>dogs;
}
