package com.projeto.ecommerce.api;

import com.projeto.ecommerce.domain.Fornecedor;
import com.projeto.ecommerce.service.FornecedorService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping
    public List<Fornecedor> buscar(@RequestParam(name = "nome") String nome) {
        return fornecedorService.buscar(nome);
    }

    @PostMapping
    public void criar(@RequestBody @Valid Fornecedor fornecedor) {
        fornecedorService.salvar(fornecedor);
    }
}
