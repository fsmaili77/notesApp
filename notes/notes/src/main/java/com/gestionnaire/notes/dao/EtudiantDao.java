package com.gestionnaire.notes.dao;

import com.gestionnaire.notes.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantDao extends JpaRepository<Etudiant, Integer> {
}
