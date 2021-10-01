package com.gestionnaire.notes.dao;

import com.gestionnaire.notes.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereDao extends JpaRepository<Matiere, Integer> {
}
