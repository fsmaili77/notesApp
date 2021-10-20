package com.gestionnaire.notes.controler;

import com.gestionnaire.notes.FrontObjects.MoyenneMatiereClasse;
import com.gestionnaire.notes.FrontObjects.NotesObject;
import com.gestionnaire.notes.dao.EtudiantDao;
import com.gestionnaire.notes.dao.NotesDao;
import com.gestionnaire.notes.entities.Etudiant;
import com.gestionnaire.notes.entities.Notes;
import com.gestionnaire.notes.service.EtudiantService;
import com.gestionnaire.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/etudiant")
public class EtudiantControler {
    @Autowired
    private final EtudiantService etudiantService;
    @Autowired
    private final NoteService noteService;

    @Autowired
    private EtudiantDao etudiantDao;
    @Autowired
    private NotesDao notesDao;

    public EtudiantControler(EtudiantService etudiantService, NoteService noteService) {
        this.etudiantService = etudiantService;
        this.noteService = noteService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Etudiant>> getAllEtudiants(){
        List<Etudiant> etudiants = etudiantService.findAllEtudiants();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable("id") Integer id) {
        Etudiant etudiant = etudiantService.findEtudiantById(id);
        return new ResponseEntity<>(etudiant, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant){
        Etudiant newEtudiant = etudiantService.addEtudiant(etudiant);
        return new ResponseEntity<>(newEtudiant, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant){
        Etudiant updateEtudiant = etudiantService.updateEtudiant(etudiant);
        return new ResponseEntity<>(updateEtudiant, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEtudiant(@PathVariable("id") Integer id){
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Moyenne générale d'un étudiant
    @GetMapping(value = "/Etudiants/{id}/moy")
    public double getMoyForEtudiant(@PathVariable Integer id) {
        return etudiantService.getMoyForEtudiant(id);
    }

    //Moyenne générale de tous les étudiants (Moyenne de la classe)
    @GetMapping(value = "/Etudiants/moy")
    public double getMoyGenerale() {
        List<Etudiant> ets = etudiantService.findAllEtudiants();
        double sum = 0;
        for (Etudiant e: ets){
            sum = sum + getMoyForEtudiant(e.getId());
            // sum = getMoyForEtudiant(e.getIdEtudiant());
        }
        double res = sum/ets.size();
        return res;

    }
    @GetMapping(value = "/Etudiant/moyenneGeneraleClasse")
    public double getMoyenneGeneraleClasse() {
        List<Etudiant> ets = etudiantService.findAllEtudiants();
        double sum = 0;
        for (Etudiant e: ets){
            sum = sum + getMoyForEtudiant(e.getId());
            // sum = getMoyForEtudiant(e.getIdEtudiant());
        }
        double res = sum/ets.size();
        return res;
    }
    //get d'un étudiants avec ses moyennes et la moyenne globale
    @GetMapping(value = "/Etudiant/allMoyenne/{id_etudiant}")
    public NotesObject getAllMoyenneForEtudiant(@PathVariable int id_etudiant) {
        Optional<Etudiant> etudiant = etudiantDao.findById(id_etudiant);
        List<Notes> notes = notesDao.findAllByEtudiant_Id(id_etudiant);
        double moyenneGlobale = noteService.getMoyenneGeneraleEtudiant(notes);

        return new NotesObject(etudiant, notes, moyenneGlobale);
    }

    @GetMapping(value = "/classe/allMoyenne/{nom_matiere}")
    public MoyenneMatiereClasse getMoyenneOfClasseForMatiere(@PathVariable String nom_matiere) {
        System.out.println(nom_matiere);
        List<Notes> notesList = notesDao.findAllByMatiere_NomMatiere(nom_matiere);
        return new MoyenneMatiereClasse( nom_matiere, notesList);
    }
}
