//package com.projeto.ecommerce.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.Valid;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//
//@Entity
//public class Item {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Valid
//    @NotNull(message = "Produto é obrigatório")
//    @NotEmpty(message = "Produto é obrigatório")
//    private Produto produto;
//
//    @NotNull(message = "Quantidade é obrigatório")
//    @NotEmpty(message = "Quantidade é obrigatório")
//    private Integer quantidade;
//
//    private Double valorTotalItem;
//
//    @Deprecated
//    public Item() {
//    }
//
//    public Item(Long id, Produto produto, Integer quantidade, Double valorTotalItem) {
//        this.id = id;
//        this.produto = produto;
//        this.quantidade = quantidade;
//        this.valorTotalItem = getValorTotalItem();
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public Produto getProduto() {
//        return produto;
//    }
//
//    public Integer getQuantidade() {
//        return quantidade;
//    }
//
//    public Double getValorTotalItem() {
//        return valorTotalItem = produto.getValorUnitario() * quantidade;
//    }
//}
