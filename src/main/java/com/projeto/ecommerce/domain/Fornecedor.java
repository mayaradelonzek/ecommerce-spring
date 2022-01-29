package com.projeto.ecommerce.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Fornecedor extends Pessoa {

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

    public Fornecedor(Long id, Contato contato, Endereco endereco, String nomeFantasia, String cnpj) {
        super(id, contato, endereco);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        isValid();
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }
}
