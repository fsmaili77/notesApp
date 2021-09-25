package com.gestionnaire.notes.controler;

import com.gestionnaire.notes.dao.ClasseDao;
import com.gestionnaire.notes.entities.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class ClasseControler {

    @Autowired
    private ClasseDao classeDao;

    @GetMapping(value = "Classes")
    public List<Classe>getClasses() {
        return classeDao.findAll();
    }
    @GetMapping(value = "Classes/{id}")
    public Optional<Classe>getClassesById(@PathVariable Integer id) {
        return classeDao.findById(id);
    }
    @PostMapping(value = "Classes")
    public ResponseEntity<Void>addClasses(@RequestBody Classe classe) {
        Classe newClasse = classeDao.save(classe);
        if (newClasse == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newClasse.getIdClasse()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping(value = "/Classes/{id}")
    public ResponseEntity<Void>deleteClasses(@PathVariable int id) {
        Optional<Classe> classe = classeDao.findById(id);
        if (classe != null) classeDao.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public void updateClasses(@RequestBody Classe classe){
        classeDao.save(classe);
    }
}
