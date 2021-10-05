package com.gestionnaire.notes;

//import com.gestionnaire.notes.entities.Classe;
import com.gestionnaire.notes.entities.Etudiant;
import com.gestionnaire.notes.entities.Matiere;
import com.gestionnaire.notes.entities.Notes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Configuration

@SpringBootApplication
public class NotesApplication {

	public static void main(String[] args) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

       /* Matiere francais = new Matiere(5, "Français");
        Matiere anglais = new Matiere(6, "Anglais");

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
        System.out.println("/////////////////////////////////////////////////////////////////");*/

		SpringApplication.run(NotesApplication.class, args);

		/*Notes notes2 = new Notes(6, 16, 15);
        Notes notes1 = new Notes(7, 16, 10);
		Etudiant etudiant1 = new Etudiant(15, "K", "N", df.parse("1999-12-15"), "kante@gmail.com");
		Matiere matiere = new Matiere(12, "Francais");
		//Classe classe = new Classe(22, "TroisiemeA", "1ère Trimestre");
        System.out.println(notes1.toString());
        System.out.println(notes2.toString());
		System.out.println(etudiant1.toString());
        System.out.println(etudiant1);
        System.out.println(matiere.getNomMatiere());*/

		//System.out.println(matiere.toString());
		//System.out.println(classe.toString());


	}




}
