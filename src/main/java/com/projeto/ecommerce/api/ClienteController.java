package com.projeto.ecommerce.api;

import com.projeto.ecommerce.domain.Cliente;
import com.projeto.ecommerce.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> buscar(@RequestParam(name = "nome") String nome) {
        return clienteService.buscar(nome);
    }

    @PostMapping
    public void criar(@RequestBody @Valid Cliente cliente) {
        clienteService.salvar(cliente);
    }
}
