package com.gestionnaire.notes.dao;

import com.gestionnaire.notes.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseDao extends JpaRepository<Classe, Integer> {
}
