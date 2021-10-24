package com.gestionnaire.notes.controler;

import com.gestionnaire.notes.NotesApplication;
import com.gestionnaire.notes.dao.EtudiantDao;
import com.gestionnaire.notes.entities.Etudiant;
import com.gestionnaire.notes.entities.Matiere;
import com.gestionnaire.notes.entities.Notes;
import com.gestionnaire.notes.service.EtudiantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class EtudiantControlerTest {

    @Autowired
    private EtudiantControler etudiantControler;

    @Autowired
    private EtudiantDao etudiantDao;
    @Autowired
    private EtudiantService etudiantService;


    @Test
    @Transactional
    public void itShouldAddEtudiant() {

        Matiere matiere1 = new Matiere(25, "Histoire");
        Matiere matiere2 = new Matiere(25, "Math");

        Notes notes1 = new Notes(6, 16, 14, 15, matiere1);
        Notes notes2 = new Notes(7, 10, 12, 11, matiere2);
        Etudiant etudiant1 = new Etudiant(1, "Pavard", "Benjamin", "05-10-1999", "pavard@yahoo.fr", Arrays.asList(notes1, notes2));
        //newEtudiant.addNoteToList(newNotes);
        System.out.println();

        Notes notes3 = new Notes(6, 12, 14, 13, matiere1);
        Notes notes4 = new Notes(7, 11, 14, 12.5, matiere2);
        Etudiant etudiant2 = new Etudiant(2, "Pogba", "Paul", "01-04-1996", "pogba@gmail.fr", Arrays.asList(notes3, notes4));
        System.out.println();
        //etudiant1.addNoteToList(notes1);
        System.out.println();
        System.out.println(etudiant1);
        System.out.println(etudiant2);
        System.out.println();

        Etudiant newEtudiant = new Etudiant(1, "Pavard", "Benjamin", "05-10-1999", "pavard@yahoo.fr", Arrays.asList(notes1, notes2));

        Etudiant et = etudiantDao.save(newEtudiant);
        Optional<Etudiant> etFromDB = etudiantControler.getEtudiantsById(et.getId());
        assertTrue(etFromDB.isPresent());
        assertThat(et).isSameAs(etFromDB.get());
        //Etudiant etudiant = etudiantDao.save(newEtudiant);

        //System.out.println(etudiant.getNotesList().toString());
       // Etudiant newEtudiant = etudiantService.addEtudiant(etudiant);


        //Optional<Etudiant> etFromDB = etudiantControler.getEtudiantById(etudiant.getId());
        //Etudiant et = etudiantDao.save(newEtudiant);
        //Optional<Etudiant> etFromDB = etudiantControler.getEtudiantById(et.getId());
    }

    @Test
    void getAllEtudiants() {
    }

    @Test
    public void shouldCheckIfExistsEtudiantById() {
        Optional<Etudiant> etBDD = etudiantControler.getEtudiantsById(1);
        assertEquals(1, etBDD.get());
    }

    @Test
    void shouldAddEtudiant() {
        List<Etudiant> expectedList = new ArrayList<Etudiant>();
        expectedList.add(etudiantControler.getEtudiantsById(2).get());
        Notes notes = new Notes();
        notes.setNoteOral(12);
        notes.setNoteEcrit(16);
        notes.setNoteMoyenne(14);
        List<Etudiant> resultList = etudiantControler.requestEtudiant(notes);
        assertThat(resultList).isEqualTo(expectedList);
    }

    @Test
    void getMoyForEtudiant() {
    }

    @Test
    void getMoyGenerale() {
    }

    @Test
    void getMoyenneGeneraleClasse() {
    }

    @Test
    void getAllMoyenneForEtudiant() {
    }

    @Test
    void getMoyenneOfClasseForMatiere() {
    }
}