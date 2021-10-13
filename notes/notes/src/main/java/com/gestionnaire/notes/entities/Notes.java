package com.gestionnaire.notes.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestionnaire.notes.FrontObjects.NotesObject;

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
        return "Notes{" +
            "etudiant=" + etudiant +
            ", matiere=" + matiere +
            ", noteEcrit=" + noteEcrit +
            ", noteOral=" + noteOral +
            ", noteMoyenne=" + noteMoyenne +
            '}';
    }

    public double afficherNoteMoyenne(){
        return ((double) noteEcrit + noteOral)/2;
    }

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

        return resultat;
    }

    //Moyenne par classe
    public double getMoyenneGeneraleClasse(List<NotesObject> notesObjects) {
        double sumMoyenneClasse = 0;
        int sumnoteListSizeTotal = 0;
        for (int iObject = 0; iObject < notesObjects.size(); iObject++) {
            sumnoteListSizeTotal += notesObjects.get(iObject).getNotesList().size();
            for (int i = 0; i < notesObjects.get(iObject).getNotesList().size(); i++) {
                sumMoyenneClasse += notesObjects.get(iObject).getNotesList().get(i).getNoteMoyenne();
            }
        }
        double resultat = sumMoyenneClasse / sumnoteListSizeTotal;

        return resultat;
    }
}
