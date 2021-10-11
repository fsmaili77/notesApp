package com.gestionnaire.notes;

import com.gestionnaire.notes.entities.Notes;
import org.junit.jupiter.api.Test;

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



}
