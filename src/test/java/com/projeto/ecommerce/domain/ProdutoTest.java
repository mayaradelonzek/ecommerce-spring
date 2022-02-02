package com.projeto.ecommerce.domain;

import com.projeto.ecommerce.infra.exception.DominioInvalido;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    public void deveCriarUmProdutoComsucesso() {
        Long id = 1L;
        String nome = "Caneta";
        String descricao = "Caneta preta";
        Double valorUnitario = 2.99;

        var produto = new Produto(id, nome, descricao, valorUnitario);

        Assertions.assertEquals(produto.getId(), id);
        Assertions.assertEquals(produto.getNome(), nome);
        Assertions.assertEquals(produto.getDescricao(), descricao);
        Assertions.assertEquals(produto.getValorUnitario(), valorUnitario);
    }

    @Test
    public void deveValidarProdutoComCamposEmBranco() {
        Long id = 1L;
        String nome = "";
        String descricao = "";
        Double valorUnitario = 2.99;

        try {
            new Produto(id, nome, descricao, valorUnitario);
            fail("Teste deveria ter quebrado");
        } catch (DominioInvalido e) {
            String mensagemEsperada = "[nome : Nome é obrigatório]";
            Assertions.assertEquals(mensagemEsperada, e.getMessage());
        }
    }

    @Test
    public void deveValidarProdutoComInfosInvalidas() {
        Long id = 1L;
        String nome = RandomStringUtils.randomAlphabetic(101);
        String descricao = RandomStringUtils.randomAlphabetic(501);
        Double valorUnitario = 2.99;

        try {
            new Produto(id, nome, descricao, valorUnitario);
            fail("Teste deveria ter quebrado");
        } catch (DominioInvalido ex) {
            Assertions.assertFalse(ex.getMessage().isEmpty());
        }
    }
}