package com.filrouge.poe.lyon.JPAPOE.service.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.Dao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.VoitureDao;
import com.filrouge.poe.lyon.JPAPOE.model.Voiture;
import com.filrouge.poe.lyon.JPAPOE.service.IVoitureService;

public class VoitureService implements IVoitureService {

	private IDao<Voiture, Integer> voituredao;

	public VoitureService(Dao dao) {
		super();
		this.voituredao = new VoitureDao(dao);
	}

	@Override
	public List<Voiture> listVoiture() {
		return this.voituredao.all();
	}

	@Override
	public void ajouterVoiture(Voiture v) {
		this.voituredao.ajouter(v);

	}

	@Override
	public void modifierVoiture(Voiture v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerVoiture(Voiture v) {
		this.voituredao.supprimer(v);

	}

	@Override
	public Voiture findVoiture(Integer i) {
		return this.voituredao.find(i);
	}

	@Override
	public List<Voiture> requetenamed(String requete) {
		return this.voituredao.requetenamed(requete);
	}

	@Override
	public List<Voiture> requetenamed(String requete, Object... tab) {
		return this.voituredao.requetenamed(requete, tab);
	}

}
