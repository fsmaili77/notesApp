package com.gestionnaire.notes.controler;

import com.gestionnaire.notes.dao.NotesDao;
import com.gestionnaire.notes.entities.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class NotesControler {

    @Autowired
    private NotesDao notesDao;

    @GetMapping(value = "/Notes")
    public List<Notes>getNotes() {
        List<Notes> notes = notesDao.findAll();
        return notes;
    }
    @GetMapping(value = "/Notes/{id}")
    public Optional<Notes>getNotesById(@PathVariable Integer id) {
        return notesDao.findById(id);
    }
    @PostMapping(value = "/Notes")
    public ResponseEntity<Void>addNotes(@RequestBody Notes notes) {
        Notes newNote = notesDao.save(notes);
        if (newNote == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newNote.getIdNote()).toUri();
        return ResponseEntity.created(location).build();
    }
    /*@PostMapping(path="/Notes")
    public Notes addNotes(@RequestBody Notes notes) throws Exception {
        if (notes == null) {
            throw new Exception("Name not found.");
        }
        return notesDao.save(notes);
    }*/

    @DeleteMapping(value = "/Notes/{id}")
    public ResponseEntity<Void>deleteNotes(@PathVariable int id) {
        Optional<Notes> notes = notesDao.findById(id);
        if (notes != null) notesDao.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/Notes")
    public void updateNotes(@RequestBody Notes notes) {
        notesDao.save(notes);
    }
}
