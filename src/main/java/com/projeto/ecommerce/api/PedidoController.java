package com.projeto.ecommerce.api;

import com.projeto.ecommerce.domain.Pedido;
import com.projeto.ecommerce.service.PedidoService;
import com.projeto.ecommerce.service.dto.PedidoDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    public PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/")
    public List<Pedido> buscarTodos() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable("id") Long id) {
        return pedidoService.findById(id);
    }

    @PostMapping
    public Pedido salvar(@RequestBody @Valid PedidoDTO pedido) {
        return pedidoService.salvar(pedido);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id) {
        pedidoService.delete(id);
    }
}
