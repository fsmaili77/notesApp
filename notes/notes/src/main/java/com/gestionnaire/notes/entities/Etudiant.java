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
    private int id;
    private String nom;
    private String prenom;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateNaissance;
    private String email;

    @OneToMany(mappedBy = "etudiant", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonManagedReference
    private List<Notes> notesList = new ArrayList<>();

    public Etudiant() {
    }

    public Etudiant(int id, String nom, String prenom, String dateNaissance, String email, List<Notes> notesList) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.notesList = notesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
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

    @Override
    public String toString() {
        return "Etudiant{" +
            "id=" + id +
            ", nom='" + nom + '\'' +
            ", prenom='" + prenom + '\'' +
            ", dateNaissance='" + dateNaissance + '\'' +
            ", email='" + email + '\'' +
            ", notesList=" + notesList +
            '}';
    }
    /*public Etudiant() {
    }

    public Etudiant(int id, String nom, String prenom, Date dateNaissance, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
    }

    public int getIdEtudiant() {
        return id;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.id = idEtudiant;
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

    *//*@Override
    public String toString() {
        return "Etudiant{" +
                "idEtudiant=" + idEtudiant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", email='" + email + '\'' +
                ", notesList=" + notesList +
                '}';
    }*//* //Moyenne générale d'un étudiant
    @GetMapping(value = "/Etudiants/{id}/moy")
    public double getMoyForEtudiant(@PathVariable Integer id) {
        Etudiant e = etudiantService.findEtudiantById(id);
        List<Notes> notes = e.getNotesList();
        double sum = 0;
        for (Notes n : notes){ sum = sum+n.afficherNoteMoyenne();}
        double resultat = sum/notes.size();

        return resultat;
    }

    //Moyenne générale de tous les étudiants (Moyenne de la classe)
    @GetMapping(value = "/Etudiants/moy")
    public double getMoyGenerale() {
        List<Etudiant> ets = etudiantService.findAllEtudiants();
        double sum = 0;
        for (Etudiant e: ets){
            sum = sum + getMoyForEtudiant(e.getId());
            // sum = getMoyForEtudiant(e.getIdEtudiant());
        }
        double res = sum/ets.size();
        return res;

    @Override
    public String toString() {
        return "Etudiant:" +'\n' +
            "idEtudiant=" + id + '\n' +
            "Nom=" + nom + '\n' +
            "Prenom='" + prenom + '\n' +
            "Date de naissance=" + dateNaissance + '\n' +
            "Email=" + email + '\n'
            ;
    }*/

    public void addNoteToList(Notes notesL){
        notesList.add(notesL);
    }
    /*public int getNotesListSize(){
        return notesList.size();
    }*/

}
