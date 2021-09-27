package com.gestionnaire.notes.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Matiere implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matieres_generator")
    @SequenceGenerator(name = "matieres_generator", sequenceName = "matieres_sequence", initialValue = 2)
    @Column(name = "matiereId")
    private int idMatiere;

    @ManyToOne
    @JoinColumn(name = "fk_noteId", referencedColumnName = "noteId")
    @JsonBackReference
    private Notes notes;

    private String nomMatiere;

    public Matiere() {
    }

    public Matiere(int idMatiere, String nomMatiere) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "idMatiere=" + idMatiere +
                ", nomMatiere='" + nomMatiere + '\'' +
                '}';
    }
}
