package com.ufpr.lol.repository;

import com.ufpr.lol.modal.PedidoModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModal, Long> {
}
