package com.projeto.ecommerce.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Pessoa extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Valid
//    @Embedded antigamente precisava
    @NotNull(message = "Contato é obrigatório")
    protected Contato contato;

    @Valid
    @NotNull(message = "Endereco é obrigatório")
    protected Endereco endereco;

    @Deprecated
    public Pessoa() {
    }

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
