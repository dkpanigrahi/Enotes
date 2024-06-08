package com.deepak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepak.entity.Notes;
import com.deepak.entity.User;
import com.deepak.repository.NotesRepository;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NotesRepository noteRepository;
	
	@Override
	public Notes saveNotes(Notes notes) {
		
		return noteRepository.save(notes);
	}

	@Override
	public Notes getNotesById(int id) {
		
		return noteRepository.findById(id).get();
	}

	@Override
	public List<Notes> getNotesByUser(User user) {
		
		return noteRepository.findByUser(user);
	}

	@Override
	public Notes updateNotes(Notes notes) {
		
		return noteRepository.save(notes);
	}

	@Override
	public boolean deleteNotes(int id) {
		
		Notes note = noteRepository.findById(id).get();
		
		if(note != null) {
			noteRepository.delete(note);
			return true;
		}
		
		return false;
	}

}
