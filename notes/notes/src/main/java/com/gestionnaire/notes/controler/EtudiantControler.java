package com.gestionnaire.notes.controler;

import com.gestionnaire.notes.dao.EtudiantDao;
import com.gestionnaire.notes.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class EtudiantControler {

    @Autowired
    private EtudiantDao etudiantDao;

    @GetMapping(value = "/Etudiants")
    public List<Etudiant>getEtudiants() {
        return etudiantDao.findAll();
    }
    @GetMapping(value = "/Etudiants/{id}")
    public Optional<Etudiant>getEtudiantsById(@PathVariable Integer id) {
        return etudiantDao.findById(id);
    }
    @PostMapping(value = "/Etudiants")
    public ResponseEntity<Void>addEtudiants(@RequestBody Etudiant etudiant) {
        Etudiant newEtudiant = etudiantDao.save(etudiant);
        if (newEtudiant == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newEtudiant.getIdEtudiant()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping(value = "/Etudiants/{id}")
    public ResponseEntity<Void>deleteEtudiants(@PathVariable int id) {
        Optional<Etudiant> etudiant = etudiantDao.findById(id);
        if (etudiant != null) etudiantDao.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/Etudiants")
    public void updateEtudiants(@RequestBody Etudiant etudiant) {
        etudiantDao.save(etudiant);
    }
}
