package com.gestionnaire.notes.dao;

import com.gestionnaire.notes.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatiereDao extends JpaRepository<Matiere, Integer> {
    Optional<Object> findMatiereById(Integer id);

    void deleteMatiereById(Integer id);
}
