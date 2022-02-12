package com.projeto.ecommerce.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Fornecedor extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Fornecedor_Id")
    protected Long id;

    @NotNull(message = "Nome fantasia é obrigatório")
    @NotEmpty(message = "Nome fantasia é obrigatório")
    @Size(max = 100, message = "Nome fantasia precisa ter no máximo 100 caracteres")
    private String nomeFantasia;

    @NotNull(message = "CNPJ é obrigatório")
    @NotEmpty(message = "CNPJ é obrigatório")
    @Size(max = 20, message = "CNPJ precisa ter no máximo 20 caracteres")
    private String cnpj;

    @Deprecated
    public Fornecedor() {
    }

    public Fornecedor(Contato contato, Endereco endereco, Long id, String nomeFantasia, String cnpj) {
        super(contato, endereco);
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        isValid();
    }

    public Long getId() {
        return id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }
}
