package com.projeto.ecommerce.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Endereco {

    @NotNull(message = "Rua é obrigatório")
    @NotEmpty(message = "Rua é obrigatório")
    @Size(max = 100, message = "Rua precisa ter no máximo 100 caracteres")
    private String rua;

    @Size(max = 6, message = "Número precisa ter no máximo 6 caracteres")
    private String numero;

    @NotNull(message = "Bairro é obrigatório")
    @NotEmpty(message = "Bairro é obrigatório")
    @Size(max = 50, message = "Bairro precisa ter no máximo 50 caracteres")
    private String bairro;

    @Size(max = 120, message = "Complemento precisa ter no máximo 120 caracteres")
    private String complemento;

    @NotNull(message = "Cep é obrigatório")
    @NotEmpty(message = "Cep é obrigatório")
    @Size(max = 10, message = "Cep precisa ter no máximo 10 caracteres")
    private String cep;

    @NotNull(message = "Cidade é obrigatório")
    @NotEmpty(message = "Cidade é obrigatório")
    @Size(max = 50, message = "Cidade precisa ter no máximo 50 caracteres")
    private String cidade;

    @NotNull(message = "Estado é obrigatório")
    @NotEmpty(message = "Estado é obrigatório")
    @Size(max = 2, message = "Estado precisa ter no máximo 2 caracteres")
    private String estado;

    @Deprecated
    protected Endereco() {}

    public Endereco(String rua, String numero, String bairro, String complemento, String cep, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        //TODO isValid();
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
