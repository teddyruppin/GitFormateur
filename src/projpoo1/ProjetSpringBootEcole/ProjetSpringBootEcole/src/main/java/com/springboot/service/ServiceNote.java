package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bean.Note;
import com.springboot.dao.DaoNote;

@Service
public class ServiceNote implements IServiceNote {
	@Autowired
	DaoNote daonote;
	
	@Transactional(readOnly = true)
	@Override
	public List<Note> rechercheNote() {
		return daonote.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Note rechercheNoteId(int id) {
		return daonote.findById(id).get();
	}

	@Transactional
	@Override
	public void creerNote(Note pnote) {
		daonote.save(pnote);
	}

	@Transactional
	@Override
	public void modifierNote(Note pnote) {
		daonote.save(pnote);
	}

	@Transactional
	@Override
	public void supprimerNote(Note pnote) {
		daonote.deleteById(pnote.getId());;
	}

}
