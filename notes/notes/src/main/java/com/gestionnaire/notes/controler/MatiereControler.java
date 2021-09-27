package com.gestionnaire.notes.controler;

import com.gestionnaire.notes.dao.MatiereDao;
import com.gestionnaire.notes.entities.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class MatiereControler {

    @Autowired
    private MatiereDao matiereDao;

    @GetMapping(value = "/Matieres")
    public List<Matiere>getMatieres() {
        return matiereDao.findAll();
    }

    @GetMapping(value = "/Matieres/{id}")
    public Optional<Matiere>getMatieresById(@PathVariable Integer id) {
        return matiereDao.findById(id);
    }
    @PostMapping(value = "/Matieres")
    public ResponseEntity<Void>addMatieres(@RequestBody Matiere matiere) {
        Matiere newMatiere = matiereDao.save(matiere);
        if (newMatiere == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newMatiere.getIdMatiere()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping(value = "/Matieres/{id}")
    public ResponseEntity<Void>deleteMatieres(@PathVariable int id) {
        Optional<Matiere> matiere = matiereDao.findById(id);
        if (matiere != null) matiereDao.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/Matieres")
    public void updateMatieres(@RequestBody Matiere matiere) {
        matiereDao.save(matiere);
    }
}
