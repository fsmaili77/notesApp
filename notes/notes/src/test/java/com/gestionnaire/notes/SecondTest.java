package com.gestionnaire.notes;

import com.gestionnaire.notes.dao.EtudiantDao;
import com.gestionnaire.notes.entities.Etudiant;
import com.gestionnaire.notes.entities.Notes;
import com.gestionnaire.notes.service.EtudiantService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
class SecondTest {


	@Test
	void getNoteMoyenneGenerale() {
        //given
        Notes notes = new Notes();
        Etudiant e = new Etudiant();
        EtudiantDao etudiantDao;
       // EtudiantService etudiantService = ;
       // etudiantService.findAllEtudiants();


        notes.setNoteMoyenne(16.5);
        notes.setNoteMoyenne(18);
        notes.setNoteMoyenne(19.5);
        e.addNoteToList(notes);
        e.getNotesList();
        List<Notes> notesList = e.getNotesList();

        //when
       // double noteMoyenneEtudiant = etudiantService.getMoyGenerale();

       //then
       // assertEquals(15.5, noteMoyenneEtudiant );
	}



}
