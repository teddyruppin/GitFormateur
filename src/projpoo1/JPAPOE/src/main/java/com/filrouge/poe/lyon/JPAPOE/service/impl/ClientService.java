package com.filrouge.poe.lyon.JPAPOE.service.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.ClientDao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.Dao;
import com.filrouge.poe.lyon.JPAPOE.model.Client;
import com.filrouge.poe.lyon.JPAPOE.service.IClientService;

public class ClientService implements IClientService {
	
	private IDao<Client, Integer> clientdao;
	
	public ClientService(Dao dao) {
		super();
		this.clientdao = new ClientDao(dao);
	}

	public List<Client> listClient() {
		return this.clientdao.all();
	}

	public void ajouterClient(Client c) {
		this.clientdao.ajouter(c);
	}

	public void modifierClient(Client c) {
	}

	public void supprimerClient(Client c) {
		this.clientdao.supprimer(c);
	}

	public Client findClient(Integer i) {
		return this.clientdao.find(i);
	}

	@Override
	public List<Client> findClientByName(String n) {
		return  this.clientdao.FindClientByName(n);
	}

}
