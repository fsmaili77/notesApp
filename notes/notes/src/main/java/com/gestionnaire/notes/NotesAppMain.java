package com.gestionnaire.notes;

import com.gestionnaire.notes.entities.Etudiant;
import com.gestionnaire.notes.entities.Matiere;
import com.gestionnaire.notes.entities.Notes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotesAppMain {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        /*String [] listSujets = {"Français", "Anglais", "Math", "SVT", "Histoire et Geographie",
            "Technologie", "Arts Plastiques", "Education Musicale",
            "Education phisique et sportive", "Vie Scolaire", "Math"};



        System.out.println("//////////////////////////////////////////////");

        Notes notes = new Notes();
        //System.out.println(notes);

        Notes notes1 = new Notes();
        System.out.println();

        Etudiant etudiant = new Etudiant();
        System.out.println(etudiant);
        Matiere francais = new Matiere(5, "Français");
        Matiere anglais = new Matiere(6, "Anglais");



       // e1.addNoteToList(new Notes(8, 17, 14));
       // System.out.println(e1.getNotesList());
        //System.out.println(e1.getNotesListSize());


       // System.out.println(e2.getNotesListSize());

        Etudiant e1 = new Etudiant(8, "Bill", "John", "2002-12-03", "john@gmail.com", new Notes(1, 15, 16, "ang" ));
        e1.addNoteToList(new Notes(5, 9, 16));
        e1.addNoteToList(new Notes(6, 19, 20));
        System.out.println("***********************************************");
        System.out.println("Etudiant : "+e1.getNom()+ " " + e1.getPrenom());

        System.out.println("Matière : "+francais.getNomMatiere());
        System.out.println(e1.getNotesList().get(0));
        System.out.println("Matière : "+anglais.getNomMatiere());
        System.out.println(e1.getNotesList().get(1));


        Etudiant e2 = new Etudiant(16, "Jean", "Jack", "1999-02-01", "jean@gmail.com");
        e2.addNoteToList(new Notes(6, 15, 16));
        e2.addNoteToList(new Notes(7, 14, 19));
        System.out.println("***********************************************");
        System.out.println("Etudiant : "+e2.getNom()+ " " + e2.getPrenom());
        System.out.println("Matière : "+francais.getNomMatiere());
        System.out.println(e2.getNotesList().get(0));
        System.out.println("Matière : "+anglais.getNomMatiere());
        System.out.println(e2.getNotesList().get(1));*/

        Matiere francais = new Matiere(1, "Francais");
        Matiere anglais = new Matiere(2, "Anglais");


        Notes notes = new Notes(1, 12, 16, new Matiere(1, "Francais"));
        Notes notes1 = new Notes(1, 11, 13, new Matiere(2, "Anglais"));

        Etudiant e1 = new Etudiant(1, "Pogba", "Paul", "12-06-1999", "pogba@free.fr", new ArrayList<>());
        Etudiant e2 = new Etudiant(2, "Kante", "Ngolo", "12-06-1998", "kante@free.fr", new ArrayList<>());

        e1.addNoteToList(notes);
        e1.addNoteToList(notes1);


        System.out.println(e1);
        System.out.println(e2);


    }

}
