package com.gestionnaire.notes.FrontObjects;

import com.gestionnaire.notes.entities.Notes;

import java.util.List;

public class MoyenneMatiereClasse {
    private String nomMatiere;
    private double moyenne;

    public MoyenneMatiereClasse() {
    }

    public MoyenneMatiereClasse(String nomMatiere, List<Notes> notes) {
        this.nomMatiere = nomMatiere;
        this.setMoyenne(notes);
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(List<Notes> notes) {
        for (int i = 0; i < notes.size(); i++) {
            this.moyenne += notes.get(i).getNoteMoyenne();
        }
        this.moyenne = this.moyenne/notes.size();
    }
}
