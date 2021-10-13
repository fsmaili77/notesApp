package com.gestionnaire.notes.dao;

import com.gestionnaire.notes.entities.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesDao extends JpaRepository<Notes, Integer> {
    Notes findNoteById(Integer id);

    void deleteNoteById(Integer id);

    List<Notes> findAllByEtudiant_Id(int id_etudiant);
}
