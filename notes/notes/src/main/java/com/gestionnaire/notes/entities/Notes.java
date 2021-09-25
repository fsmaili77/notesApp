package com.gestionnaire.notes.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Notes implements Serializable {

    @Id
    private int idNote;
    private int noteEcrit;
    private int noteOral;
    private double noteMoyenne;

    public Notes() {
    }

    public Notes(int idNote, int noteEcrit, int noteOral, double noteMoyenne) {
        this.idNote = idNote;
        this.noteEcrit = noteEcrit;
        this.noteOral = noteOral;
        this.noteMoyenne = noteMoyenne;
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public int getNoteEcrit() {
        return noteEcrit;
    }

    public void setNoteEcrit(int noteEcrit) {
        this.noteEcrit = noteEcrit;
    }

    public int getNoteOral() {
        return noteOral;
    }

    public void setNoteOral(int noteOral) {
        this.noteOral = noteOral;
    }

    public double getNoteMoyenne() {
        return noteMoyenne;
    }

    public void setNoteMoyenne(double noteMoyenne) {
        this.noteMoyenne = noteMoyenne;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "idNote=" + idNote +
                ", noteEcrit=" + noteEcrit +
                ", noteOral=" + noteOral +
                ", noteMoyenne=" + noteMoyenne +
                '}';
    }
}
