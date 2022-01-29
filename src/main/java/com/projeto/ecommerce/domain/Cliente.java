package com.projeto.ecommerce.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cliente extends Pessoa {

    @NotNull(message = "Nome é obrigatório")
    @NotEmpty(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome precisa ter no máximo 100 caracteres")
    private String nome;

    @NotNull(message = "CPF é obrigatório")
    @NotEmpty(message = "CPF é obrigatório")
    @Size(max = 20, message = "CPF precisa ter no máximo 20 caracteres")
    private String cpf;

    @Deprecated
    public Cliente() {
    }

    public Cliente(Long id, Contato contato, Endereco endereco, String nome, String cpf) {
        super(id, contato, endereco);
        this.nome = nome;
        this.cpf = cpf;
        isValid();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
