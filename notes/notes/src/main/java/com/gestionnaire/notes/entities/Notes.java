package com.gestionnaire.notes.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Notes")
public class Notes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notes_generator")
    @SequenceGenerator(name = "notes_generator", sequenceName = "notes_sequence", initialValue = 5)
    @Column(name = "noteId")
    private int idNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_etudiantId", referencedColumnName = "etudiantId")
   // @JsonBackReference
    private Etudiant etudiant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_matiereId", referencedColumnName = "matiereId")
    @JsonBackReference
    private Matiere matiere;

    private int noteEcrit;
    private int noteOral;
    private double noteMoyenne;

    public Notes() {
    }

    public Notes(int idNote, int noteEcrit, int noteOral) {
        this.idNote = idNote;
        this.noteEcrit = noteEcrit;
        this.noteOral = noteOral;
        //this.noteMoyenne = noteMoyenne;
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

    /*public double getNoteMoyenne() {
        return noteMoyenne;
    }

    public void setNoteMoyenne(double noteMoyenne) {
        this.noteMoyenne = noteMoyenne;
    }*/

    @Override
    public String toString() {
        return "Notes{" +
                "idNote=" + idNote +
                ", noteEcrit=" + noteEcrit +
                ", noteOral=" + noteOral +
                ", noteMoyenne=" + afficherNoteMoyenne() +
                '}';
    }
    public double afficherNoteMoyenne(){
        return ((double) noteEcrit + noteOral)/2;
    }


}
