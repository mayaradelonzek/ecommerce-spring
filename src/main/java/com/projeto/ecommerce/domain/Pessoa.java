package com.projeto.ecommerce.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @NotNull(message = "Contato é obrigatório")
    protected Contato contato;

    @NotNull(message = "Endereco é obrigatório")
    protected Endereco endereco;

    public Pessoa(int id, Contato contato, Endereco endereco) {
        this.id = id;
        this.contato = contato;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public Contato getContato() {
        return contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
