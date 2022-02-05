package com.projeto.ecommerce.service;

import com.projeto.ecommerce.domain.Fornecedor;
import com.projeto.ecommerce.infra.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    private FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public List<Fornecedor> buscar(String nome) {
        if (nome == null) {
            return List.of();
        }
        return fornecedorRepository.buscar(nome);
    }

    //TODO VALIDAR EXISTENCIA ANTES DE SALVAR
    public Fornecedor salvar(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> findById(Long id) {
        return fornecedorRepository.findById(id);
    }

    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
