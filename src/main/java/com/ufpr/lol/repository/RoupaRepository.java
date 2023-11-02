package com.ufpr.lol.repository;

import com.ufpr.lol.modal.RoupaModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoupaRepository extends JpaRepository<RoupaModal, Long> {
    Optional<RoupaModal> findById(UUID id);

    public List<RoupaModal> selectAll();

    void deleteById(UUID id);
}