package com.ufpr.lol.service;

import com.ufpr.lol.modal.FuncionarioModal;
import com.ufpr.lol.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioModal criarFuncionario(FuncionarioModal funcionario) {
        // Implemente a lógica para criptografar a senha antes de salvar no banco
        funcionario.setSenha(criptografarSenha(funcionario.getSenha()));
        return funcionarioRepository.save(funcionario);
    }

    public FuncionarioModal buscarFuncionarioPorEmail(String email) {
        return funcionarioRepository.findByEmail(email);
    }

    private String criptografarSenha(String senha) {
        // Implemente a criptografia da senha (SHA-256 + SALT) aqui
        return senha; // Este é um exemplo simples, substitua pela lógica real de criptografia.
    }

    public FuncionarioModal buscarFuncionarioPorId(UUID id) {
        return funcionarioRepository.findById(id);
    }

    public void excluirFuncionario(UUID id) {
        funcionarioRepository.deleteById(id);
    }

    public void atualizarFuncionario(FuncionarioModal funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public List<FuncionarioModal> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }
}
