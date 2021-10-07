package com.gestionnaire.notes.controler;

import com.gestionnaire.notes.entities.Matiere;
import com.gestionnaire.notes.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("matiere")
public class MatiereControler {

    @Autowired
    private final MatiereService matiereService;

    public MatiereControler(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Matiere>> getAllMatieres(){
        List<Matiere> matieres = matiereService.findAllMatieres();
        return new ResponseEntity<>(matieres, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Matiere> getMatiereById(@PathVariable("id") Integer id) {
        Matiere matiere = (Matiere) matiereService.findMatiereById(id);
        return new ResponseEntity<>(matiere, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Matiere> addMatiere(@RequestBody Matiere matiere) {
        Matiere newMatiere = matiereService.addMatiere(matiere);
        return new ResponseEntity<>(newMatiere, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Matiere> updateMatiere(@RequestBody Matiere matiere) {
        Matiere updateMatiere = matiereService.updateMatiere(matiere);
        return new ResponseEntity<>(updateMatiere, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMatiere(@PathVariable("id") Integer id) {
        matiereService.deleteMatiere(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    /*@Autowired
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
    }*/
}
