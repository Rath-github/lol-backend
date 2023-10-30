package com.ufpr.lol.controller;

import com.ufpr.lol.modal.PedidoModal;
import com.ufpr.lol.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/criar")
    public ResponseEntity<String> criarPedido(@RequestBody PedidoModal pedido) {
        pedidoService.criarPedido(pedido);
        return ResponseEntity.ok("Pedido criado com sucesso!");
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PedidoModal>> listarPedidos() {
        List<PedidoModal> pedidos = pedidoService.listarTodosPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoModal> buscarPedidoPorId(@PathVariable Long id) {
        PedidoModal pedido = pedidoService.buscarPedidoPorId(id);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarPedido(@PathVariable Long id, @RequestBody PedidoModal pedido) {
        PedidoModal pedidoExistente = pedidoService.buscarPedidoPorId(id);
        if (pedidoExistente != null) {
            pedido.setId(id);
            pedidoService.atualizarPedido(pedido);
            return ResponseEntity.ok("Pedido atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirPedido(@PathVariable Long id) {
        PedidoModal pedidoExistente = pedidoService.buscarPedidoPorId(id);
        if (pedidoExistente != null) {
            pedidoService.excluirPedido(id);
            return ResponseEntity.ok("Pedido excluído com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}