package com.gestionnaire.notes.service;

import com.gestionnaire.notes.dao.MatiereDao;
import com.gestionnaire.notes.entities.Matiere;
import com.gestionnaire.notes.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MatiereService {

    private final MatiereDao matiereDao;

    @Autowired
    public MatiereService(MatiereDao matiereDao) {
        this.matiereDao = matiereDao;
    }
    public Matiere addMatiere(Matiere matiere) {
        return matiereDao.save(matiere);
    }
    public List<Matiere> findAllMatieres() {
        return matiereDao.findAll();
    }
    public Matiere updateMatiere(Matiere matiere) {
        return matiereDao.save(matiere);
    }
    public Object findMatiereById(Integer id){
        return matiereDao.findMatiereById(id).orElseThrow(() -> new UserNotFoundException("Matiere by id "+id+" not found"));
    }
    public void deleteMatiere(Integer id) {
        matiereDao.deleteMatiereById(id);
    }
}
