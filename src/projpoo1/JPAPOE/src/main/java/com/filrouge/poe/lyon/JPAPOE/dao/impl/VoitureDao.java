package com.filrouge.poe.lyon.JPAPOE.dao.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.model.Devis;
import com.filrouge.poe.lyon.JPAPOE.model.Voiture;

public class VoitureDao extends EntityDao<Voiture> implements IDao<Voiture, Integer> {

	public VoitureDao(Dao dao) {
		super(dao);
	}

	public List<Voiture> all() {
		return this.AllFind(Voiture.class);
	}

	public void ajouter(Voiture v) {
		this.add(v);
	}

	public void modifier(Voiture v) {
		// TODO Auto-generated method stub
	}

	public void supprimer(Voiture v) {
		this.remove(Voiture.class, v.getId());
	}

	public Voiture find(Integer i) {
		return this.find(Voiture.class, i);
	}

	@Override
	public List<Voiture> requetenamed(String requete) {
		// TODO Auto-generated method stub
		return this.requeteNamed(Voiture.class, requete);
	}

	@Override
	public List<Voiture> requetenamed(String requete, Object... tab) {
		// TODO Auto-generated method stub
		return this.requeteNamed(Voiture.class, requete, tab);
	}

	@Override
	public List<Devis> methodeRetourne(Voiture o) {
		// TODO Auto-generated method stub
		return null;
	}
}
