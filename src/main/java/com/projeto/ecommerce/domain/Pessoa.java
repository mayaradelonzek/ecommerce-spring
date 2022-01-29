package com.projeto.ecommerce.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Pessoa extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Valid
    @NotNull(message = "Contato é obrigatório")
    protected Contato contato;

    @Valid
    @NotNull(message = "Endereco é obrigatório")
    protected Endereco endereco;

    public Pessoa(Long id, Contato contato, Endereco endereco) {
        this.id = id;
        this.contato = contato;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public Contato getContato() {
        return contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
