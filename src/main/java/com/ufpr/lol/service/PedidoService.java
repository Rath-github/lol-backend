package com.ufpr.lol.service;

import com.ufpr.lol.modal.PedidoModal;
import com.ufpr.lol.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoModal criarPedido(PedidoModal pedido) {
        return pedidoRepository.save(pedido);
    }

    public PedidoModal buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public void excluirPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    public void atualizarPedido(PedidoModal pedido) {
        pedidoRepository.save(pedido);
    }

    public List<PedidoModal> listarTodosPedidos() {
        return pedidoRepository.findAll();
    }
}