package com.gestionnaire.notes.dao;

import com.gestionnaire.notes.entities.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesDao extends JpaRepository<Notes, Integer> {
}
