package com.gestionnaire.notes.dao;

import com.gestionnaire.notes.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface EtudiantDao extends JpaRepository<Etudiant, Integer> {

    void deleteEtudiantById(Integer id);

    Optional<Etudiant> findEtudiantById(Integer id);
}
