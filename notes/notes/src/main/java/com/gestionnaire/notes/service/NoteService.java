package com.gestionnaire.notes.service;

import com.gestionnaire.notes.dao.NotesDao;
import com.gestionnaire.notes.entities.Notes;
import com.gestionnaire.notes.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NoteService {
    private final NotesDao notesDao;

    @Autowired
    public NoteService(NotesDao notesDao) {
        this.notesDao = notesDao;
    }
    public Notes addNote(Notes notes) {
        return notesDao.save(notes);
    }
    public List<Notes> findAllNotes() {
        return notesDao.findAll();
    }
    public Notes updateNote(Notes notes) {
        return notesDao.save(notes);
    }
    public Notes findNoteById(Integer id) {
        return notesDao.findNoteById(id);
    }
    public void deleteNote(Integer id) {
        notesDao.deleteNoteById(id);
    }
}
