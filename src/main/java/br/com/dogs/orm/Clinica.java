package br.com.dogs.orm;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@Entity
@Table(name = "clinica")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Embedded
    private Endereco endereco;

    @ManyToMany()
    @Fetch(FetchMode.JOIN)
    @JoinTable(joinColumns = @JoinColumn(name = "fk_clinica"),
                inverseJoinColumns = @JoinColumn(name = "fk_dog")
    )
    private Set<Dog>dogs;

    public Clinica(String nome, Endereco endereco){
        this.nome = nome;
        this.endereco = endereco;
    }
}
