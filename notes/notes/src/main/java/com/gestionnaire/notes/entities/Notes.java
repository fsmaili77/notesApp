package com.gestionnaire.notes.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @SequenceGenerator(name = "notes_generator", sequenceName = "notes_sequence", initialValue = 9)
    @Column(name = "noteId")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_etudiantId", referencedColumnName = "etudiantId")
   // @JsonBackReference
    private Etudiant etudiant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_matiereId", referencedColumnName = "matiereId")
    //@JsonBackReference
    private Matiere matiere;

    private double noteEcrit;
    private double noteOral;
    private double noteMoyenne;

    public Notes() {
    }

    public Notes(int id, int noteEcrit, int noteOral, double noteMoyenne, Matiere matiere) {
        this.id = id;
        this.noteEcrit = noteEcrit;
        this.noteOral = noteOral;
        this.noteMoyenne = noteMoyenne;
        this.matiere = matiere;
    }

    public int getIdNote() {
        return id;
    }

    public void setIdNote(int idNote) {
        this.id = idNote;
    }

    public double getNoteEcrit() {
        return noteEcrit;
    }

    public void setNoteEcrit(int noteEcrit) {
        this.noteEcrit = noteEcrit;
    }

    public  double getNoteOral() {
        return noteOral;
    }

    public void setNoteOral(int noteOral) {
        this.noteOral = noteOral;
    }

    public double getNoteMoyenne() {
        return (noteEcrit + noteOral)/2;
    }

    public void setNoteMoyenne(double noteMoyenne) {
        this.noteMoyenne = noteMoyenne;
    }

    @JsonIgnore
    public Matiere getMatiere() {
        return matiere;
    }

    public String getNomMatiere() {
        return matiere.getNomMatiere();
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }


    @Override
    public String toString() {
        return
            " noteEcrit=" + noteEcrit +'\n' +
            " noteOral=" + noteOral +'\n' +
            " noteMoyenne=" + noteMoyenne + '\n'
            ;
    }
    public double afficherNoteMoyenne(){
        return ((double) noteEcrit + noteOral)/2;
    }


}
