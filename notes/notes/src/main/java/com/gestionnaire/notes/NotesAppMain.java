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
        System.out.println(notes);

        /*Notes notes1 = new Notes();
        System.out.println();*/

        /*Etudiant etudiant = new Etudiant();
        System.out.println(etudiant);*/

        Etudiant e1 = new Etudiant(8, "Bill", "John", df.parse("1999-02-01"), "john@gmail.com");
        System.out.println(e1);
        e1.addNoteToList(new Notes(5, 9, 16));
        e1.addNoteToList(new Notes(6, 19, 20));
        e1.addNoteToList(new Notes(8, 17, 14));
        System.out.println(e1.getNotesList());
        System.out.println(e1.getNotesListSize());

        Etudiant e2 = new Etudiant(16, "Jean", "Jack", df.parse("1999-02-01"), "jean@gmail.com");
        System.out.println(e2);
        e2.addNoteToList(new Notes(6, 15, 16));
        e2.addNoteToList(new Notes(7, 12, 19));
        e2.addNoteToList(new Notes(6, 10, 11));
        e2.addNoteToList(new Notes(6, 15, 16));
        e2.addNoteToList(new Notes(7, 12, 19));
        e2.addNoteToList(new Notes(6, 10, 11));
        System.out.println(e2.getNotesList());
        System.out.println(e2.getNotesListSize());


    }
        /*public static int countOccurances(
            String [] listSujets, String searchMatiere
            ) {
            int count = 0;
            for (String matiere : listSujets) {
                if (matiere == searchMatiere){
                    count++;
                }
            }
            return count;
        }*/


}
