package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.NoteDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface NoteService {
    @Transactional
    void addNote(NoteDto noteDto, Long userId);

    @Transactional
    void deleteNoteById(Long noteId);

    @Transactional
    void updateNoteById(NoteDto noteDto);

    //need to understand what is happening here
    @Transactional
    List<NoteDto> getAllNotesByUserID(Long userId);

    //also need clarity on what's happening here
    @Transactional
    Optional<NoteDto> getNoteById(Long noteId);
}
