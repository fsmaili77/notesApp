package com.gestionnaire.notes.dao;

import com.gestionnaire.notes.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Integer> {
}
