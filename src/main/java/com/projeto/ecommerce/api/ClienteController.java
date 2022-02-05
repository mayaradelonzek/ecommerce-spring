package com.projeto.ecommerce.api;

import com.projeto.ecommerce.domain.Cliente;
import com.projeto.ecommerce.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

//    @GetMapping(params = {"filtro"})
//    public List<Cliente> buscar(@RequestParam("filtro") String nome) {
//        return clienteService.buscar(nome);
//    }
//
//    @GetMapping
//    public Cliente buscarPorNome(@RequestParam("nome")  String nome) {
//        return clienteService.buscarPorNome(nome);
//    }

    @GetMapping("/")
    public List<Cliente> buscarTodos() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscarPorId(@PathVariable("id") Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public Cliente salvar(@RequestBody @Valid Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id) {
        clienteService.delete(id);
    }


}
