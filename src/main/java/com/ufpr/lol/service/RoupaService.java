package com.ufpr.lol.service;

import com.ufpr.lol.modal.RoupaModal;
import com.ufpr.lol.repository.RoupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoupaService {
    @Autowired
    private RoupaRepository roupaRepository;

    public RoupaModal criarRoupa(RoupaModal roupa) {
        return roupaRepository.save(roupa);
    }

    public Optional<RoupaModal> buscarRoupaPorId(UUID id) {
        return roupaRepository.findById(id);
    }

    public void excluirRoupa(UUID id) {
        roupaRepository.deleteById(id);
    }

    public void atualizarRoupa(RoupaModal roupa) {
        roupaRepository.save(roupa);
    }

    public List<RoupaModal> listarTodasRoupas() {
        return roupaRepository.findAll();
    }
}