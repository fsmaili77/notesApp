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

        /*String [] listSujets = {"Français", "Anglais", "Math", "SVT", "Histoire et Geographie",
            "Technologie", "Arts Plastiques", "Education Musicale",
            "Education phisique et sportive", "Vie Scolaire", "Math"};
        int count = countOccurances(listSujets, "Math");
        System.out.println(count);*/

        System.out.println("//////////////////////////////////////////////");

        Notes notes = new Notes();
        //System.out.println(notes);

        /*Notes notes1 = new Notes();
        System.out.println();*/

        /*Etudiant etudiant = new Etudiant();
        System.out.println(etudiant);*/
        Matiere francais = new Matiere(5, "Français");
        Matiere anglais = new Matiere(6, "Anglais");


       // e1.addNoteToList(new Notes(8, 17, 14));
       // System.out.println(e1.getNotesList());
        //System.out.println(e1.getNotesListSize());


       // System.out.println(e2.getNotesListSize());

        Etudiant e1 = new Etudiant(8, "Bill", "John", df.parse("2002-12-03"), "john@gmail.com");
        e1.addNoteToList(new Notes(5, 9, 16));
        e1.addNoteToList(new Notes(6, 19, 20));
        System.out.println("***********************************************");
        System.out.println("Etudiant : "+e1.getNom()+ " " + e1.getPrenom());

        System.out.println("Matière : "+francais.getNomMatiere());
        System.out.println(e1.getNotesList().get(0));
        System.out.println("Matière : "+anglais.getNomMatiere());
        System.out.println(e1.getNotesList().get(1));


        Etudiant e2 = new Etudiant(16, "Jean", "Jack", df.parse("1999-02-01"), "jean@gmail.com");
        e2.addNoteToList(new Notes(6, 15, 16));
        e2.addNoteToList(new Notes(7, 14, 19));
        System.out.println("***********************************************");
        System.out.println("Etudiant : "+e2.getNom()+ " " + e2.getPrenom());
        System.out.println("Matière : "+francais.getNomMatiere());
        System.out.println(e2.getNotesList().get(0));
        System.out.println("Matière : "+anglais.getNomMatiere());
        System.out.println(e2.getNotesList().get(1));

    }

}
