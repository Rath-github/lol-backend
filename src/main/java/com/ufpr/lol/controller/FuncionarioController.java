package com.ufpr.lol.controller;

import com.ufpr.lol.modal.FuncionarioModal;
import com.ufpr.lol.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    // Criação de um funcionário
    @PostMapping("/criar")
    public ResponseEntity<String> criarFuncionario(@RequestBody FuncionarioModal funcionario) {
        funcionarioService.criarFuncionario(funcionario);
        return ResponseEntity.ok("Funcionário criado com sucesso!");
    }

    // Recuperação de todos os funcionários
    @GetMapping("/todos")
    public ResponseEntity<List<FuncionarioModal>> listarFuncionarios() {
        List<FuncionarioModal> funcionarios = funcionarioService.listarTodosFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    // Recuperação de um funcionário por ID
    @GetMapping("reco/{id}")
    public ResponseEntity<FuncionarioModal> buscarFuncionarioPorId(@PathVariable UUID id) {
        FuncionarioModal funcionario = funcionarioService.buscarFuncionarioPorId(id);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Atualização de um funcionário
    @PutMapping("update/{id}")
    public ResponseEntity<String> atualizarFuncionario(@PathVariable UUID id, @RequestBody FuncionarioModal funcionario) {
        FuncionarioModal funcionarioExistente = funcionarioService.buscarFuncionarioPorId(id);
        if (funcionarioExistente != null) {
            funcionario.setId(id); // Garante que o ID não seja alterado
            funcionarioService.atualizarFuncionario(funcionario);
            return ResponseEntity.ok("Funcionário atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Exclusão de um funcionário por ID
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> excluirFuncionario(@PathVariable UUID id) {
        FuncionarioModal funcionarioExistente = funcionarioService.buscarFuncionarioPorId(id);
        if (funcionarioExistente != null) {
            funcionarioService.excluirFuncionario(id);
            return ResponseEntity.ok("Funcionário excluído com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}