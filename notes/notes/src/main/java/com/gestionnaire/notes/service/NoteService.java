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
    /*public double testGetMoyForEtudiant(List<Notes> notes) {
        double sum = 0;
        for (Notes n : notes){ sum = sum+n.getNoteMoyenne();}
        double resultat = sum/notes.size();

        return resultat;
    }*/
    //Moyenne par étudiant
    public double getMoyenneGeneraleEtudiant(List<Notes> notes) {
        double sum = 0;
//        for (Notes n : notes) {
//            sum = sum+n.getNoteMoyenne();
//        }
        for (int i = 0; i < notes.size(); i++) {
            sum += notes.get(i).getNoteMoyenne();
        }
        double resultat = sum / notes.size();

        double resultatFinal = Math.round(resultat);
        return resultat;
    }
    public double getMoyenneGeneraleClasse(List<Notes> notes) {
        double sum = 0;
//        for (Notes n : notes) {
//            sum = sum+n.getNoteMoyenne();
//        }
        for (int i = 0; i < notes.size(); i++) {
            sum += notes.get(i).getNoteMoyenne();
        }
        double resultat = sum / notes.size();

        double resultatFinal = Math.round(resultat);
        return resultat;
    }
}
