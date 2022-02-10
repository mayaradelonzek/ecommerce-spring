package com.projeto.ecommerce.api;

import com.projeto.ecommerce.domain.Fornecedor;
import com.projeto.ecommerce.service.FornecedorService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

//    @GetMapping
//    public List<Fornecedor> buscar(@RequestParam(name = "nome") String nome) {
//        return fornecedorService.buscar(nome);
//    }

    @GetMapping("/")
    public List<Fornecedor> buscarTodos() {
        return fornecedorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Fornecedor> buscarPorId(@PathVariable("id") Long id) {
        return fornecedorService.findById(id);
    }

    @PostMapping
    public Fornecedor salvar(@RequestBody @Valid Fornecedor fornecedor) {
        return fornecedorService.salvar(fornecedor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id) {
        fornecedorService.delete(id);
    }
}
