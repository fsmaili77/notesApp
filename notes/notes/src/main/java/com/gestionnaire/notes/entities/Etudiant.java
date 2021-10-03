package com.gestionnaire.notes.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Etudiant")
public class Etudiant implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etudiant_generator")
    @SequenceGenerator(name = "etudiant_generator", sequenceName = "etudiant_sequence", initialValue = 9)
    @Column(name = "etudiantId")
    private int idEtudiant;
    private String nom;
    private String prenom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private String email;

    @OneToMany(mappedBy = "etudiant", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonManagedReference
    private List<Notes> notesList = new ArrayList<>();

    public Etudiant() {
    }

    public Etudiant(int idEtudiant, String nom, String prenom, Date dateNaissance, String email) {
        this.idEtudiant = idEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Notes> getNotesList() {
        return notesList;
    }

    public void setNotesList(List<Notes> notesList) {
        this.notesList = notesList;
    }

    /*@Override
    public String toString() {
        return "Etudiant{" +
                "idEtudiant=" + idEtudiant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", email='" + email + '\'' +
                ", notesList=" + notesList +
                '}';
    }*/

    @Override
    public String toString() {
        return "Etudiant:" +'\n' +
            "idEtudiant=" + idEtudiant + '\n' +
            "Nom=" + nom + '\n' +
            "Prenom='" + prenom + '\n' +
            "Date de naissance=" + dateNaissance + '\n' +
            "Email=" + email + '\n'
            ;
    }

    public void addNoteToList(Notes notesL){
        notesList.add(notesL);
    }
    public int getNotesListSize(){
        return notesList.size();
    }

}
