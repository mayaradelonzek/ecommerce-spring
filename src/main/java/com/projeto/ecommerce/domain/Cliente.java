package com.projeto.ecommerce.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cliente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cliente_Id")
    protected Long id;

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

    public Cliente(Contato contato, Endereco endereco, Long id, String nome, String cpf) {
        super(contato, endereco);
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        isValid();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
