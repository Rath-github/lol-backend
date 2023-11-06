package com.ufpr.lol.repository;

import com.ufpr.lol.modal.ClienteModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clienteRepository extends JpaRepository<ClienteModal, Long> {
    ClienteModal findByEmail(String email);
}
