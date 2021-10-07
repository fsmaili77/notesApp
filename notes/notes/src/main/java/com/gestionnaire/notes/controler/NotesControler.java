package com.gestionnaire.notes.controler;

import com.gestionnaire.notes.entities.Notes;
import com.gestionnaire.notes.service.NoteService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/note")
public class NotesControler {

    @Autowired
    private final NoteService noteService;

    public NotesControler(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Notes>> getAllNotes(){
        List<Notes> notes = noteService.findAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Notes> getNoteById(@PathVariable("id") Integer id) {
        Notes notes = noteService.findNoteById(id);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Notes> addEtudiant(@RequestBody Notes notes) {
        Notes newNote = noteService.addNote(notes);
        return new ResponseEntity<>(newNote, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Notes> updateNote(@RequestBody Notes notes) {
        Notes updateNote = noteService.updateNote(notes);
        return new ResponseEntity<>(updateNote, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable("id") Integer id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


   /* @GetMapping(value = "/Notes")
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
    *//*@PostMapping(path="/Notes")
    public Notes addNotes(@RequestBody Notes notes) throws Exception {
        if (notes == null) {
            throw new Exception("Name not found.");
        }
        return notesDao.save(notes);
    }*//*

    @DeleteMapping(value = "/Notes/{id}")
    public ResponseEntity<Void>deleteNotes(@PathVariable int id) {
        Optional<Notes> notes = notesDao.findById(id);
        if (notes != null) notesDao.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/Notes")
    public void updateNotes(@RequestBody Notes notes) {
        notesDao.save(notes);
    }*/


}

