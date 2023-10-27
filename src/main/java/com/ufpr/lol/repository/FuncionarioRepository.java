package com.ufpr.lol.repository;

import com.ufpr.lol.modal.FuncionarioModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModal, Long> {
    FuncionarioModal findByEmail(String email);

    void deleteById(UUID id);

    FuncionarioModal findById(UUID id);
}
