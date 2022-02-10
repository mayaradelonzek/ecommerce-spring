package com.projeto.ecommerce.api;

import com.projeto.ecommerce.domain.Produto;
import com.projeto.ecommerce.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    public ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/")
    public List<Produto> buscarTodos() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable("id") Long id) {
        return produtoService.findById(id);
    }

    @PostMapping
    public Produto salvar(@RequestBody @Valid Produto fornecedor) {
        return produtoService.salvar(fornecedor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id) {
        produtoService.delete(id);
    }
}
