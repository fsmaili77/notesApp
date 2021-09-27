package com.gestionnaire.notes;

import com.gestionnaire.notes.entities.Etudiant;
import com.gestionnaire.notes.entities.Matiere;
import com.gestionnaire.notes.entities.Notes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesAppMain {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Matiere francais = new Matiere(1, "Français");

        Etudiant etudiant = new Etudiant(2, "jean", "bill", df.parse("2000-11-22"), "jean@gmail.com");
        System.out.println(francais.toString());

        System.out.println(etudiant.toString());
        Notes notes = new Notes(22, 12, 14, 13);
        System.out.println(notes.toString());
    }
}
