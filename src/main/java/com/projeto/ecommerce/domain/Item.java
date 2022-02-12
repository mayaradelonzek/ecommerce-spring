package com.projeto.ecommerce.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Item extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Item_Id")
    private Long id;

    @Valid
    @ManyToOne
    @JoinColumn(name = "Produto_Id")
    @NotNull(message = "Produto é obrigatório")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "Pedido_Id")
    private Pedido pedido;

    @NotNull(message = "Quantidade é obrigatório")
    private Integer quantidade;

    private Double valorTotalItem;

    @Deprecated
    public Item() {
    }

    public Item(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        isValid();
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getValorTotalItem() {
        return produto.getValorUnitario() * quantidade;
    }

    void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
