package com.projeto.ecommerce.service;

import com.projeto.ecommerce.domain.Cliente;
import com.projeto.ecommerce.infra.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

//    public List<Cliente> buscar(String nome) {
//        if (nome == null) {
//            return List.of();
//        }
//        return clienteRepository.buscar(nome);
//    }

//    public Cliente buscarPorNome (String nome) {
//        return clienteRepository.buscarPorNome(nome);
//    }

    //TODO VALIDAR EXISTENCIA ANTES DE SALVAR
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }






}
