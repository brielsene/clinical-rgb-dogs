package br.com.dogs.orm;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String estado;
    private String cidade;
    private String rua;
    private String numero;
}
