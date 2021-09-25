package com.gestionnaire.notes.controler;

import com.gestionnaire.notes.dao.NotesDao;
import org.springframework.beans.factory.annotation.Autowired;

public class NotesControler {

    @Autowired
    private NotesDao notesDao;
}
