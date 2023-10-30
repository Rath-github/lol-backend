package com.ufpr.lol.controller;

import com.ufpr.lol.modal.RoupaModal;
import com.ufpr.lol.service.RoupaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/roupas")
public class RoupaController {
    @Autowired
    private RoupaService roupaService;

    @PostMapping("/criar")
    public ResponseEntity<String> criarRoupa(@RequestBody RoupaModal roupa) {
        roupaService.criarRoupa(roupa);
        return ResponseEntity.ok("Roupa criada com sucesso!");
    }

    @GetMapping("/todas")
    public ResponseEntity<List<RoupaModal>> listarRoupas() {
        List<RoupaModal> roupas = roupaService.listarTodasRoupas();
        return ResponseEntity.ok(roupas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<RoupaModal>> buscarRoupaPorId(@PathVariable UUID id) {
        Optional<RoupaModal> roupa = roupaService.buscarRoupaPorId(id);
        if (roupa != null) {
            return ResponseEntity.ok(roupa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarRoupa(@PathVariable UUID id, @RequestBody RoupaModal roupa) {
        Optional<RoupaModal> roupaExistente = roupaService.buscarRoupaPorId(id);
        if (roupaExistente != null) {
            roupa.setId(id);
            roupaService.atualizarRoupa(roupa);
            return ResponseEntity.ok("Roupa atualizada com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirRoupa(@PathVariable UUID id) {
        Optional<RoupaModal> roupaExistente = roupaService.buscarRoupaPorId(id);
        if (roupaExistente != null) {
            roupaService.excluirRoupa(id);
            return ResponseEntity.ok("Roupa excluída com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}