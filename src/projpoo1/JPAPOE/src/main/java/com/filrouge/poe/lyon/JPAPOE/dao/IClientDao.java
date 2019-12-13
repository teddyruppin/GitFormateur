package com.filrouge.poe.lyon.JPAPOE.dao;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.model.Client;

public interface IClientDao {
	
	List<Client> listClient();
	void ajouterClient(Client c);
	void modifierClient(Client c);
	void supprimerClient(Client c);
	Client findClient(Integer i);
}
