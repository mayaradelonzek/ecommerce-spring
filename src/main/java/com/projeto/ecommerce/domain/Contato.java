package com.projeto.ecommerce.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Contato {

    @NotNull(message = "E-mail é obrigatório")
    @NotEmpty(message = "E-mail é obrigatório")
    @Size(max = 100, message = "E-mail precisa ter no máximo 100 caracteres")
    private String email;

    @NotNull(message = "Telefone é obrigatório")
    @NotEmpty(message = "Telefone é obrigatório")
    @Size(max = 20, message = "Telefone precisa ter no máximo 20 caracteres")
    private String telefone;

    @Deprecated
    protected Contato() {}

    public Contato(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
