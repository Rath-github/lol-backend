package com.ufpr.lol.controller;

import com.ufpr.lol.modal.ClienteModal;
import com.ufpr.lol.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class clienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/criar")
    public ResponseEntity<String> criarCliente(@RequestBody ClienteModal cliente) {
        clienteService.criarCliente(cliente);
        return ResponseEntity.ok("Cliente criado com sucesso!");
    }
}
