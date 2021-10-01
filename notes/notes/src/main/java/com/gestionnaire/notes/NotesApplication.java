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
		SpringApplication.run(NotesApplication.class, args);

		Notes notes = new Notes(6, 16, 15);
        Notes notes1 = new Notes(7, 16, 10);
		Etudiant etudiant1 = new Etudiant(15, "K", "N", df.parse("1999-12-15"), "kante@gmail.com");
		Matiere matiere = new Matiere(12, "Francais");
		//Classe classe = new Classe(22, "TroisiemeA", "1ère Trimestre");
        System.out.println(notes.toString());
        System.out.println(notes1.toString());
		System.out.println(etudiant1.toString());
        System.out.println();
        System.out.println(notes.afficherNoteMoyenne());

		//System.out.println(matiere.toString());
		//System.out.println(classe.toString());


	}




}
