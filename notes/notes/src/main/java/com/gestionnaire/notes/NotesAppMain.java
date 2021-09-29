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

        String [] listSujets = {"Français", "Anglais", "Math", "SVT", "Histoire et Geographie",
            "Technologie", "Arts Plastiques", "Education Musicale",
            "Education phisique et sportive", "Vie Scolaire", "Math"};
        int count = countOccurances(listSujets, "Math");
        System.out.println(count);

        }
        public static int countOccurances(
            String [] listSujets, String searchMatiere
            ) {
            int count = 0;
            for (String matiere : listSujets) {
                if (matiere == searchMatiere){
                    count++;
                }
            }
            return count;
        }
}
