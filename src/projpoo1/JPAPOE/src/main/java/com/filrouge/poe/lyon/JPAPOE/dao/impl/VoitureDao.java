package com.filrouge.poe.lyon.JPAPOE.dao.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IVoitureDao;
import com.filrouge.poe.lyon.JPAPOE.model.Voiture;

public class VoitureDao extends EntityDao<Voiture> implements IVoitureDao {

	public VoitureDao(Dao dao) {
		super(dao);
	}

	public List<Voiture> listVoiture() {
		return this.AllFind(Voiture.class);
	}

	public void ajouterVoiture(Voiture v) {
		this.add(v);
	}

	public void modifierVoiture(Voiture v) {
		// TODO Auto-generated method stub
	}

	public void supprimerVoiture(Voiture v) {
		this.remove(Voiture.class, v.getId());
	}

	public Voiture findVoiture(Integer i) {
		return this.find(Voiture.class, i);	}

}
