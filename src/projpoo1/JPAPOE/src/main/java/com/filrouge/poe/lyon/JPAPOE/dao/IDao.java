package com.filrouge.poe.lyon.JPAPOE.dao;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.model.Devis;


public interface IDao<T,P> {

	List<T> all();
	void ajouter(T o);
	void modifier(T o);
	void supprimer(T o);
	T find(P o);
	//List<Client> FindClientByName(String n);
	List<T> requetenamed(String requete);
	List<T> requetenamed(String requete, Object...tab);
	
	List<Devis> methodeRetourne(T o);
	
	
}
