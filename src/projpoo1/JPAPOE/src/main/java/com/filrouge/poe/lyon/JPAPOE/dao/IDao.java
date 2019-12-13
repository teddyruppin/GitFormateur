package com.filrouge.poe.lyon.JPAPOE.dao;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.model.Client;

public interface IDao<T,P> {

	List<T> all();
	void ajouter(T o);
	void modifier(T o);
	void supprimer(T o);
	T find(P o);
	List<Client> FindClientByName(String n);
}
