package com.gestionnaire.notes.controler;

import com.gestionnaire.notes.dao.EtudiantDao;
import org.springframework.beans.factory.annotation.Autowired;

public class EtudiantControler {

    @Autowired
    private EtudiantDao etudiantDao;
}
