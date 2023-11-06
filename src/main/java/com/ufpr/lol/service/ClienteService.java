package com.ufpr.lol.service;

import com.ufpr.lol.utils.GerarSenhas;
import com.ufpr.lol.modal.ClienteModal;
import com.ufpr.lol.repository.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ClienteService {
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private clienteRepository clienteRepository;

    public ClienteModal criarCliente(ClienteModal cliente) {
        try {
            logger.info("Tentando criar um novo cliente: {}", cliente.getNome());

            // Valide a entrada do cliente aqui se necessário.

            // Gere uma senha aleatória para o cliente
            String senhaAleatoria = GerarSenhas.generateRandomPassword();
            cliente.setSenha(senhaAleatoria);

            ClienteModal novoCliente = clienteRepository.save(cliente);
            logger.info("Novo cliente criado com sucesso: ID {}", novoCliente.getId());
            return novoCliente;
        } catch (Exception ex) {
            logger.error("Erro ao criar cliente", ex);
            throw new RuntimeException("Erro ao criar cliente", ex);
        }
    }

    public ClienteModal buscarClientePorEmail(String email) {
        try {
            logger.info("Tentando buscar cliente por email: {}", email);

            // Valide a entrada do email se necessário.

            ClienteModal cliente = clienteRepository.findByEmail(email);
            if (cliente != null) {
                logger.info("Cliente encontrado: ID {}", cliente.getId());
            } else {
                logger.info("Cliente não encontrado para o email: {}", email);
            }
            return cliente;
        } catch (Exception ex) {
            logger.error("Erro ao buscar cliente por email", ex);
            throw new RuntimeException("Erro ao buscar cliente por email", ex);
        }
    }

    public void atualizarCliente(ClienteModal cliente) {
        try {
            logger.info("Tentando atualizar cliente: ID {}", cliente.getId());

            // Implemente a lógica de atualização do cliente aqui.

            logger.info("Cliente atualizado com sucesso: ID {}", cliente.getId());
        } catch (Exception ex) {
            logger.error("Erro ao atualizar cliente", ex);
            throw new RuntimeException("Erro ao atualizar cliente", ex);
        }
    }
}
