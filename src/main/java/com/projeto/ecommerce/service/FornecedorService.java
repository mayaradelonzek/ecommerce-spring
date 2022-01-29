package com.projeto.ecommerce.service;

import com.projeto.ecommerce.domain.Fornecedor;
import com.projeto.ecommerce.infra.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void salvar(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }
}
