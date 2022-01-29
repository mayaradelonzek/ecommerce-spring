package com.projeto.ecommerce.domain;

import com.projeto.ecommerce.infra.exception.DominioInvalido;
import org.apache.commons.lang3.RandomStringUtils;
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

    @Test
    public void deveValidarClienteComInfosInvalidas() {
        Long id = 1L;
        String nome = RandomStringUtils.randomAlphabetic(101);;
        String cpf = RandomStringUtils.randomAlphabetic(21);;
        String email = RandomStringUtils.randomAlphabetic(101);
        String telefone = RandomStringUtils.randomAlphabetic(21);
        String rua = RandomStringUtils.randomAlphabetic(101);
        String numero = RandomStringUtils.randomAlphabetic(7);
        String bairro = RandomStringUtils.randomAlphabetic(51);
        String complemento = RandomStringUtils.randomAlphabetic(121);
        String cep = RandomStringUtils.randomAlphabetic(11);
        String cidade = RandomStringUtils.randomAlphabetic(51);
        String estado = RandomStringUtils.randomAlphabetic(3);

        Contato contato = new Contato(email, telefone);
        Endereco endereco = new Endereco(rua, numero, bairro, complemento, cep, cidade, estado);

        try {
            new Cliente(id, contato, endereco, nome, cpf);
            fail("Teste deveria ter quebrado");
        } catch (DominioInvalido ex) {
              Assertions.assertFalse(ex.getMessage().isEmpty());
//            Assertions.assertEquals("[endereco.cep : Cep precisa ter no máximo 10 caracteres, " +
//                    "endereco.bairro : Bairro precisa ter no máximo 50 caracteres, " +
//                    "endereco.numero : Número precisa ter no máximo 6 caracteres, " +
//                    "cpf : CPF precisa ter no máximo 20 caracteres, " +
//                    "contato.telefone : Telefone precisa ter no máximo 20 caracteres, " +
//                    "endereco.rua : Rua precisa ter no máximo 100 caracteres, " +
//                    "nome : Nome precisa ter no máximo 100 caracteres, " +
//                    "contato.email : E-mail precisa ter no máximo 100 caracteres, " +
//                    "endereco.cidade : Cidade precisa ter no máximo 50 caracteres, " +
//                    "endereco.estado : Estado precisa ter no máximo 2 caracteres, " +
//                    "endereco.complemento : Complemento precisa ter no máximo 120 caracteres]",
//                    ex.getMessage());
        }
    }
}