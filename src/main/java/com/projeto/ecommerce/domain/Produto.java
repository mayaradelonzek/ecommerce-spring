package com.projeto.ecommerce.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produto extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Produto_Id")
    private Long id;

    @NotNull(message = "Nome é obrigatório")
    @NotEmpty(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome precisa ter no máximo 100 caracteres")
    private String nome;

    @Size(max = 500, message = "Descrição precisa ter no máximo 500 caracteres")
    private String descricao;

    private Double valorUnitario;

    @Deprecated
    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, Double valorUnitario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        isValid();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }
}
