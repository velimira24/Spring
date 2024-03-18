package ru.geekbrains.springhw6.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.springhw6.model.Note;
import ru.geekbrains.springhw6.repository.NoteRepo;
import ru.geekbrains.springhw6.service.NoteService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepo noteRepo;

    @Override
    public Note createNote(Note note) {
        return noteRepo.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepo.findById(id).orElseThrow(null);
    }

    @Override
    public Note updateNote(Note note) {
        Note noteByID = getNoteById(note.getId());

        noteByID.setTitle(note.getTitle());
        noteByID.setContent(note.getContent());

        return noteRepo.save(noteByID);
    }

    @Override
    public void deleteNote(Long id) {
        Note noteById = getNoteById(id);
        noteRepo.delete(noteById);
    }
}
