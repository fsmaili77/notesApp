package com.gestionnaire.notes;

import com.gestionnaire.notes.dao.EtudiantDao;
import com.gestionnaire.notes.entities.Etudiant;
import com.gestionnaire.notes.entities.Notes;
import com.gestionnaire.notes.service.EtudiantService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
class MoyenneEtudiant {


	@Test
    void getNoteMoyenne() {

        // ARRANGE
        Notes notes = new Notes();
        notes.setNoteOral(16);
        notes.setNoteEcrit(15);

        // ACT
        double noteMoyenneEtudiant = notes.getNoteMoyenne();

        // ASSERT
        assertEquals(15.5, noteMoyenneEtudiant );
    }

    @Test
    void getNoteMoyenneGenerale() {
        // ARRANGE
        Notes notes = new Notes();
        Notes notes1 = new Notes();
        List<Notes> no = new ArrayList<Notes>();

        Etudiant e = new Etudiant();

        notes.setNoteEcrit(19);
        notes.setNoteOral(8);//13.5
        notes1.setNoteEcrit(19);
        notes1.setNoteOral(18);//18.5

        no.add(notes);
        no.add(notes1);
        //System.out.println(no);

        double sum = 0;
        for (Notes n : no){
            sum += n.getNoteMoyenne();
           // System.out.println(no);
        }
        // ACT
        double noteMoyenneGeneraleEtudiant = sum/ no.size();
        // ASSERT
         assertEquals(16, noteMoyenneGeneraleEtudiant );
    }



}
