package com.projeto.ecommerce.service;

import com.projeto.ecommerce.domain.*;
import com.projeto.ecommerce.infra.repository.PedidoRepository;
import com.projeto.ecommerce.service.dto.ItensDTO;
import com.projeto.ecommerce.service.dto.PedidoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;
    private FornecedorService fornecedorService;
    private ClienteService clienteService;
    private ProdutoService produtoService;

    public PedidoService(PedidoRepository pedidoRepository, FornecedorService fornecedorService, ClienteService clienteService, ProdutoService produtoService) {
        this.pedidoRepository = pedidoRepository;
        this.fornecedorService = fornecedorService;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    //TODO VALIDAR EXISTENCIA ANTES DE SALVAR
    public Pedido salvar(PedidoDTO novoPedido) {
        Fornecedor fornecedor = fornecedorService.buscarPorId(novoPedido.getFornecedor());
        Cliente cliente = clienteService.buscarPorId(novoPedido.getCliente());
        Double valorFrete = novoPedido.getValorFrete();
        Pedido pedido = new Pedido(null, fornecedor, cliente, null, valorFrete);

        for (ItensDTO itemDto: novoPedido.getItens()) {
            Produto produto = produtoService.buscarPorId(itemDto.getProduto());
            Item item = new Item(produto, itemDto.getQuantidade());
            pedido.adicionarItem(item);
        }
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id) {
        return pedidoRepository.getById(id);
    }

    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }
}
