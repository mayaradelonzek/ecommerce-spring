package com.projeto.ecommerce.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pedido_Id")
    private Long id;

    @NotNull(message = "Data da compra é obrigatório")
    @NotEmpty(message = "Data da compra é obrigatório")
    private LocalDateTime dataCompra;

    @Valid
    @ManyToOne
    @JoinColumn(name = "Pessoa_Id", updatable = false, insertable = false)
    @NotNull(message = "Fornecedor é obrigatório")
    private Fornecedor fornecedor;

    @Valid
    @ManyToOne
    @JoinColumn(name = "Pessoa_Id", updatable = false, insertable = false)
    @NotNull(message = "Cliente é obrigatório")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<Item> itens = new ArrayList<>();

    private Double valorFrete;

    private Double valorTotal;

    public Pedido(Long id, LocalDateTime dataCompra, Fornecedor fornecedor, Cliente cliente, Item item, Double valorFrete) {
        this.id = id;
        this.dataCompra = dataCompra;
        this.fornecedor = fornecedor;
        this.cliente = cliente;
        this.valorFrete = valorFrete;
        adicionarItem(item);
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public List<Item> getItens() {
        return itens;
    }

    public Double getValorTotal() {
        return getValorTotalItens() + getValorFrete();
    }

    public Double getValorTotalItens() {
        double valorTotal = 0;
        for (Item item : itens) {
            valorTotal += item.getValorTotalItem();
        }
        return valorTotal;
    }

    public void adicionarItem(Item item) {
        if (item == null) {
            return;
        }
        this.itens.add(item);
    }
}
