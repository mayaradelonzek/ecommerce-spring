package com.projeto.ecommerce.domain;

import com.projeto.ecommerce.infra.exception.DominioInvalido;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    @Test
    public void deveCriarUmFornecedorValido() {
        Long id = 1L;
        String nomeFantasia = "José";
        String cnpj = "36941367032";
        Contato contato = new Contato("teste@teste.com", "3378-0000");
        Endereco endereco = new Endereco("Rua x", "20", "Bairro x", "Complemento y", "9000000", "Porto Alegre", "RS");

        var fornecedor = new Fornecedor(id, contato, endereco, nomeFantasia, cnpj);

        Assertions.assertEquals(fornecedor.getId(), id);
        Assertions.assertEquals(fornecedor.getNomeFantasia(), nomeFantasia);
        Assertions.assertEquals(fornecedor.getCnpj(), cnpj);
        Assertions.assertEquals(fornecedor.getContato(), contato);
        Assertions.assertEquals(fornecedor.getEndereco(), endereco);
    }

    @Test
    public void deveValidarFornecedorComCamposEmBranco() {
        Long id = null;
        String nomeFantasia = "";
        String cnpj = "";
        Contato contato = null;
        Endereco endereco = null;

        try {
            new Fornecedor(id, contato, endereco, nomeFantasia, cnpj);
            fail("Teste deveria ter quebrado");
        } catch (DominioInvalido ex) {
            String mensagemEsperada = "[nomeFantasia : Nome fantasia é obrigatório, contato : Contato é obrigatório, endereco : Endereco é obrigatório, cnpj : CNPJ é obrigatório]";
            Assertions.assertEquals(mensagemEsperada, ex.getMessage());
        }
    }

    @Test
    public void deveValidarFornecedorComCamposDeContatoEEnderecoEmBranco() {
        Long id = null;
        String nomeFantasia = "";
        String cnpj = "";
        Contato contato = new Contato(null, null);
        Endereco endereco = new Endereco(null, null, null, null, null, null, null);

        try {
            new Cliente(id, contato, endereco, nomeFantasia, cnpj);
            fail("Teste deveria ter quebrado");
        } catch (DominioInvalido ex) {
            Assertions.assertFalse(ex.getMessage().isEmpty());
        }
    }

    @Test
    public void deveValidarClienteComInfosInvalidas() {
        Long id = 1L;
        String nomeFantasia = RandomStringUtils.randomAlphabetic(101);;
        String cnpj = RandomStringUtils.randomAlphabetic(21);;
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
            new Fornecedor(id, contato, endereco, nomeFantasia, cnpj);
            fail("Teste deveria ter quebrado");
        } catch (DominioInvalido ex) {
            Assertions.assertFalse(ex.getMessage().isEmpty());
        }
    }

}