package com.gestionnaire.notes.controler;

import com.gestionnaire.notes.dao.EtudiantDao;
import com.gestionnaire.notes.entities.Etudiant;
import com.gestionnaire.notes.entities.Notes;
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

    //Moyenne générale d'un étudiant
    @GetMapping(value = "/Etudiants/{id}/moy")
    public double getMoyForEtudiant(@PathVariable Integer id) {
        Etudiant e = etudiantDao.findById(id).get();
        List<Notes> notes = e.getNotesList();
        double sum = 0;
        for (Notes n : notes){ sum = sum+n.afficherNoteMoyenne();}
        double resultat = sum/notes.size();

        return resultat;
    }

    //Moyenne générale de tous les étudiants (Moyenne de la classe)
    @GetMapping(value = "/Etudiants/moy")
    public double getMoyGenerale() {
        List<Etudiant> ets = etudiantDao.findAll();
        double sum = 0;
        for (Etudiant e: ets){
           sum = sum + getMoyForEtudiant(e.getIdEtudiant());
            // sum = getMoyForEtudiant(e.getIdEtudiant());
        }
        double res = sum/ets.size();
        return res;

        //return ( this.getMoyForEtudiant(1)+this.getMoyForEtudiant(2))/2;
    }
/*
    //moyenne generale pour deux étudiants
    @GetMapping(value = "/Etudiants/moy")
    public double getMoyGeneraleForEtudiants() {

        return ( this.getMoyForEtudiant(1)+this.getMoyForEtudiant(2))/2;
    }*/

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
    /*@PostMapping(path="/Etudiants")
    public Notes addEtudiants(@RequestBody Etudiant etudiant) throws Exception {
        if (etudiant == null) {
            throw new Exception("Name not found.");
        }
        return etudiantDao.save(etudiant);
    }*/

    /*public Notes notes(@RequestBody Etudiant etudiant) {
        return new Notes(counter.incrementAndGet(), String.format(template, etudiant.getName()));
    }*/

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
