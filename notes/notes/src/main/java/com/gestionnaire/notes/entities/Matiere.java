package com.gestionnaire.notes.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Matiere")
public class Matiere implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matieres_generator")
    @SequenceGenerator(name = "matieres_generator", sequenceName = "matieres_sequence", initialValue = 2)
    @Column(name = "matiereId")
    private int id;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_noteId", referencedColumnName = "noteId")
    @JsonBackReference
    private Notes notes;*/

    private String nomMatiere;

    public Matiere() {
    }

    public Matiere(int idMatiere, String nomMatiere) {
        this.id = id;
        this.nomMatiere = nomMatiere;
    }

    public int getIdMatiere() {
        return id;
    }

    public void setIdMatiere(int idMatiere) {
        this.id = idMatiere;
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
                "idMatiere=" + id +
                ", nomMatiere='" + nomMatiere + '\'' +
                '}';
    }
}
