package com.projeto.ecommerce.service.dto;

import java.util.List;

public class PedidoDTO {
    private Long fornecedor;
    private Long cliente;
    private Double valorFrete;
    private List<ItensDTO> itens;

    public Long getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Long fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public List<ItensDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItensDTO> itens) {
        this.itens = itens;
    }
}
