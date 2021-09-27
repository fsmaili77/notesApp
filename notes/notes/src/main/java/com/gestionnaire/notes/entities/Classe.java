package com.gestionnaire.notes.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Classe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classes_generator")
    @SequenceGenerator(name = "classes_generator", sequenceName = "classes_sequence", initialValue = 3)
    @Column(name = "classesId")
    private int idClasse;

    @ManyToOne
    @JoinColumn(name = "fk_matiereId", referencedColumnName = "matiereId")
    @JsonBackReference
    private Matiere matiere;


    private String nomClasse;
    private String periode;

    public Classe() {
    }

    public Classe(int idClasse, String nomClasse, String periode) {
        this.idClasse = idClasse;
        this.nomClasse = nomClasse;
        this.periode = periode;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "idClasse=" + idClasse +
                ", nomClasse='" + nomClasse + '\'' +
                ", periode='" + periode + '\'' +
                '}';
    }
}
