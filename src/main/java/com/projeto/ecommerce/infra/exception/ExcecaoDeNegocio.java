package com.projeto.ecommerce.infra.exception;

public abstract class ExcecaoDeNegocio extends RuntimeException {
    public ExcecaoDeNegocio(String mensagem) {
        super(mensagem);
    }
}
