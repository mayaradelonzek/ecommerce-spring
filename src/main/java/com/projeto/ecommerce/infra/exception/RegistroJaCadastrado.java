package com.projeto.ecommerce.infra.exception;

public class RegistroJaCadastrado extends ExcecaoDeNegocio {
    public RegistroJaCadastrado(String mensagem) {
        super(mensagem);
    }
}
