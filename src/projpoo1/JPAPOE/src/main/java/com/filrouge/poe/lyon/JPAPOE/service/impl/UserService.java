package com.filrouge.poe.lyon.JPAPOE.service.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.Dao;
import com.filrouge.poe.lyon.JPAPOE.dao.impl.UserDao;
import com.filrouge.poe.lyon.JPAPOE.model.User;
import com.filrouge.poe.lyon.JPAPOE.service.IUserService;

public class UserService implements IUserService {

	private IDao<User, Integer> userservice;
	
	public UserService(Dao dao) {
		super();
		this.userservice = new UserDao(dao);
	}

	@Override
	public List<User> listUser() {
		return this.userservice.all();
	}

	@Override
	public void ajouterUser(User c) {
		this.userservice.ajouter(c);		
	}

	@Override
	public void modifierUser(User c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerUser(User c) {
		this.userservice.supprimer(c);
		
	}

	@Override
	public User findUser(Integer i) {
		// TODO Auto-generated method stub
		return this.userservice.find(i);
	}

	@Override
	public List<User> requetenamed(String requete) {
		// TODO Auto-generated method stub
		return this.userservice.requetenamed(requete);
	}

	@Override
	public List<User> requetenamed(String requete, Object... tab) {
		// TODO Auto-generated method stub
		return this.userservice.requetenamed(requete, tab);	
	}

}


