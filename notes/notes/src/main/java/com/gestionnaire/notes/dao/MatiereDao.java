package com.gestionnaire.notes.dao;

import com.gestionnaire.notes.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereDao extends JpaRepository<Matiere, Integer> {
}
