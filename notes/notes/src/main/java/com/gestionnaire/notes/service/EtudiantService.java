package com.gestionnaire.notes.service;


import com.gestionnaire.notes.dao.EtudiantDao;
import com.gestionnaire.notes.entities.Etudiant;
import com.gestionnaire.notes.entities.Notes;
import com.gestionnaire.notes.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EtudiantService {
    private final EtudiantDao etudiantDao;

    @Autowired
    public EtudiantService(EtudiantDao etudiantDao) {
        this.etudiantDao = etudiantDao;
    }

    public Etudiant addEtudiant(Etudiant etudiant){
        return etudiantDao.save(etudiant);
    }

    public List<Etudiant> findAllEtudiants() {
        return etudiantDao.findAll();
    }

    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantDao.save(etudiant);
    }
    public Etudiant findEtudiantById(Integer id){
        return etudiantDao.findEtudiantById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEtudiant(Integer id) {
        etudiantDao.deleteEtudiantById(id);
    }


    public double getMoyForEtudiant(Integer id) {
        Etudiant e = this.findEtudiantById(id);
        List<Notes> notes = e.getNotesList();
        double sum = 0;
        for (Notes n : notes){ sum = sum+n.getNoteMoyenne();}
        double resultat = sum/notes.size();

        return resultat;
    }
    public double getMoyGenerale() {
        List<Etudiant> ets = this.findAllEtudiants();
        double sum = 0;
        for (Etudiant e: ets){
            sum = sum + getMoyForEtudiant(e.getId());
            // sum = getMoyForEtudiant(e.getIdEtudiant());
        }
        double res = sum/ets.size();
        return res;

    }

}
