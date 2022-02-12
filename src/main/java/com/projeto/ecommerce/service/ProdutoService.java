package com.projeto.ecommerce.service;

import com.projeto.ecommerce.domain.Produto;
import com.projeto.ecommerce.infra.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    public ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> buscar(String nome) {
        if (nome == null) {
            return List.of();
        }
        return produtoRepository.buscar(nome);
    }

    //TODO VALIDAR EXISTENCIA ANTES DE SALVAR
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.getById(id);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
