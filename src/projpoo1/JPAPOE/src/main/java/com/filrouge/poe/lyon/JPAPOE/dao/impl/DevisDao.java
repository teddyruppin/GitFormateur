package com.filrouge.poe.lyon.JPAPOE.dao.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.model.Devis;

public class DevisDao extends EntityDao<Devis> implements IDao<Devis, Integer> {

	public DevisDao(Dao dao) {
		super(dao);
	}

	@Override
	public List<Devis> all() {
		return this.AllFind(Devis.class);
	}

	@Override
	public void ajouter(Devis d) {
		this.add(d);		
	}

	@Override
	public void modifier(Devis d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(Devis d) {
		this.remove(Devis.class, d.getId());
		
	}

	@Override
	public Devis find(Integer i) {
		return this.find(Devis.class, i);
	}

	@Override
	public List<Devis> requetenamed(String requete) {
		// TODO Auto-generated method stub
		return this.requeteNamed(Devis.class,requete);	}

	@Override
	public List<Devis> requetenamed(String requete, Object... tab) {
		// TODO Auto-generated method stub
		return this.requeteNamed(Devis.class,requete, tab);
	}

	@Override
	public List<Devis> methodeRetourne(Devis o) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
