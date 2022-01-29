package com.projeto.ecommerce.service;

import com.projeto.ecommerce.domain.Cliente;
import com.projeto.ecommerce.infra.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> buscar(String nome) {
        if (nome == null) {
            return List.of();
        }
        return clienteRepository.buscar(nome);
    }

    //TODO VALIDAR EXISTENCIA ANTES DE SALVAR
    public void salvar(Cliente cliente) {
        clienteRepository.save(cliente);
    }






}
