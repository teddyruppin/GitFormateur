package com.filrouge.poe.lyon.JPAPOE.service;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.model.User;

public interface IUserService {

	List<User> listUser();
	void ajouterUser(User c);
	void modifierUser(User c);
	void supprimerUser(User c);
	User findUser(Integer i);
	
	List<User> requetenamed(String requete);
	List<User> requetenamed(String requete, Object...tab);
}
