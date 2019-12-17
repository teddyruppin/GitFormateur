package com.filrouge.poe.lyon.JPAPOE.service.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.Dao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.DevisDao;
import com.filrouge.poe.lyon.JPAPOE.model.Devis;
import com.filrouge.poe.lyon.JPAPOE.service.IDevisService;

public class DevisService extends DevisDao implements IDevisService {

	private IDao<Devis, Integer> devisdao;

	public DevisService(Dao dao) {
		super(dao);
		this.devisdao = new DevisDao(dao);
	}

	@Override
	public List<Devis> listDevis() {
		return this.devisdao.all();
	}

	@Override
	public void ajouterDevis(Devis d) {
		this.devisdao.ajouter(d);
	}

	@Override
	public void modifierDevis(Devis d) {
	}

	@Override
	public void supprimerDevis(Devis d) {
		this.devisdao.supprimer(d);
	}

	@Override
	public Devis findDevis(Integer i) {
		// TODO Auto-generated method stub
		return this.devisdao.find(i);
	}

	@Override
	public List<Devis> requetenamed(String requete) {
		// TODO Auto-generated method stub
		return this.devisdao.requetenamed(requete);
	}

	@Override
	public List<Devis> requetenamed(String requete, Object... tab) {
		// TODO Auto-generated method stub
		return this.devisdao.requetenamed(requete, tab);
	}

}
