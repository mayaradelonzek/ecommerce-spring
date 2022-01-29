package com.projeto.ecommerce.domain;

import com.projeto.ecommerce.infra.exception.DominioInvalido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    public void deveCriarUmClienteValido() {
        Long id = 1L;
        String nome = "Pedro";
        String cpf = "36941367032";
        Contato contato = new Contato("teste@teste.com", "3378-0000");
        Endereco endereco = new Endereco("Rua x", "20", "Bairro x", "Complemento y", "9000000", "Porto Alegre", "RS");

        var cliente = new Cliente(id, contato, endereco, nome, cpf);

        Assertions.assertEquals(cliente.getId(), id);
        Assertions.assertEquals(cliente.getNome(), nome);
        Assertions.assertEquals(cliente.getCpf(), cpf);
        Assertions.assertEquals(cliente.getContato(), contato);
        Assertions.assertEquals(cliente.getEndereco(), endereco);
    }

    @Test
    public void deveValidarClienteComCamposEmBranco() {
        Long id = null;
        String nome = "";
        String cpf = "";
        Contato contato = null;
        Endereco endereco = null;

        try {
            new Cliente(id, contato, endereco, nome, cpf);
            fail("Teste deveria ter quebrado");
        } catch (DominioInvalido ex) {
            String mensagemEsperada = "[nome : Nome é obrigatório, contato : Contato é obrigatório, cpf : CPF é obrigatório, endereco : Endereco é obrigatório]";
            Assertions.assertEquals(mensagemEsperada, ex.getMessage());
        }
    }

    @Test
    public void deveValidarClienteComCamposDeContatoEEnderecoEmBranco() {
        Long id = null;
        String nome = "";
        String cpf = "";
        Contato contato = new Contato(null, null);
        Endereco endereco = new Endereco(null, null, null, null, null, null, null);

        try {
            new Cliente(id, contato, endereco, nome, cpf);
            fail("Teste deveria ter quebrado");
        } catch (DominioInvalido ex) {
            Assertions.assertFalse(ex.getMessage().isEmpty());
        }
    }

    //TODO TERMINAR ESSE TESTE
//    public void deveValidarClienteComInfosInvalidas() {

//        String generatedString = RandomStringUtils.randomAlphabetic(10);
//        try {
//            Long id = null;
//            String nome = null;
//            String cpf = "";
//            Contato contato = null;
//            Endereco endereco = null;
//        }
//    }

}