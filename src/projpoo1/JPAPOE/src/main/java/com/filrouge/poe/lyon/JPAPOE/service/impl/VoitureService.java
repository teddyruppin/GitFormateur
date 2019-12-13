package com.filrouge.poe.lyon.JPAPOE.service.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IVoitureDao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.Dao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.VoitureDao;
import com.filrouge.poe.lyon.JPAPOE.model.Voiture;
import com.filrouge.poe.lyon.JPAPOE.service.IVoitureService;

public class VoitureService implements IVoitureService {
	
	private IVoitureDao voituredao;
	
	public VoitureService(Dao dao) {
		super();
		this.voituredao = new VoitureDao(dao);
	}

	public List<Voiture> listVoiture() {
		return this.voituredao.listVoiture();
	}

	public void ajouterVoiture(Voiture v) {
		this.voituredao.ajouterVoiture(v);
	}

	public void modifierVoiture(Voiture v) {
	}

	public void supprimerVoiture(Voiture v) {
		this.voituredao.supprimerVoiture(v);
	}

	public Voiture findVoiture(Integer i) {
		return this.voituredao.findVoiture(i);	}

}
