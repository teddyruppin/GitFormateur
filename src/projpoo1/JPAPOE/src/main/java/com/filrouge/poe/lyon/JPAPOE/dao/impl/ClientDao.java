package com.filrouge.poe.lyon.JPAPOE.dao.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.model.Client;
import com.filrouge.poe.lyon.JPAPOE.model.Devis;

public class ClientDao extends EntityDao<Client> implements IDao<Client, Integer> {

	public ClientDao(Dao dao) {
		super(dao);
	}

	public List<Client> all() {
		return this.AllFind(Client.class);
	}

	public void ajouter(Client c) {
		this.add(c);
	}

	public void modifier(Client c) {

	}

	public void supprimer(Client c) {
		this.remove(Client.class, c.getId());
	}

	public Client find(Integer i) {
		return this.find(Client.class, i);
	}
	/*
	@Override
	public List<Client> FindClientByName(String n) {
		return this.FindClientByName1("ByFirstName",n,Client.class);
	}*/

	@Override
	public List<Client> requetenamed(String requete) {
		// TODO Auto-generated method stub
		return this.requeteNamed(Client.class,requete);
	}

	@Override
	public List<Client> requetenamed(String requete, Object... tab) {
		// TODO Auto-generated method stub
		return this.requeteNamed(Client.class,requete, tab);
	}

	@Override
	public List<Devis> methodeRetourne(Client c) {
		return c.getListeDevis();
	}

}
