package com.projeto.ecommerce.service;

import com.projeto.ecommerce.domain.Pedido;
import com.projeto.ecommerce.infra.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    public PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    //TODO VALIDAR EXISTENCIA ANTES DE SALVAR
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }
}
