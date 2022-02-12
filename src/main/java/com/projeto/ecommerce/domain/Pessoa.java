package com.projeto.ecommerce.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Pessoa extends Entidade {

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

    public Pessoa(Contato contato, Endereco endereco) {
        this.contato = contato;
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
