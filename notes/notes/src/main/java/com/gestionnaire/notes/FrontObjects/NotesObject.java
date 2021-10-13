package com.gestionnaire.notes.FrontObjects;

import com.gestionnaire.notes.entities.Etudiant;
import com.gestionnaire.notes.entities.Notes;

import java.util.List;
import java.util.Optional;

public class NotesObject {
    private Optional<Etudiant> etudiant;
    private List<Notes> globalList;
    // moyenne de toutes les moyennes
    private double moyennGlobale;

    public NotesObject() {
    }

    public NotesObject(Optional<Etudiant> etudiant, List<Notes> globalList, double moyennGlobale) {
        this.setEtudiant(etudiant);
        this.setNotesList(globalList);
        this.setMoyennGlobale(moyennGlobale);
    }

    public Optional<Etudiant> getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Optional<Etudiant> etudiant) {
        this.etudiant = etudiant;
    }

    public List<Notes> getNotesList() {
        return globalList;
    }

    public void setNotesList(List<Notes> notesList) {
        this.globalList = notesList;
    }

    public double getMoyennGlobale() {
        return moyennGlobale;
    }

    public void setMoyennGlobale(double moyennGlobale) {
        this.moyennGlobale = moyennGlobale;
    }
}
