package com.filrouge.poe.lyon.JPAPOE.dao.impl;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.dao.IDao;
import com.filrouge.poe.lyon.JPAPOE.model.Devis;
import com.filrouge.poe.lyon.JPAPOE.model.User;

public class UserDao extends EntityDao<User> implements IDao<User, Integer> {

	public UserDao(Dao dao) {
		super(dao);
	}

	@Override
	public List<User> all() {
		return this.AllFind(User.class);
	}

	@Override
	public void ajouter(User o) {
		this.add(o);	
	}

	@Override
	public void modifier(User o) {		
	}

	@Override
	public void supprimer(User o) {
		this.remove(User.class, o.getId());		
	}

	@Override
	public User find(Integer i) {
		return this.find(User.class, i);
	}

	@Override
	public List<User> requetenamed(String requete) {
		// TODO Auto-generated method stub
		return this.requeteNamed(User.class,requete);
	}

	@Override
	public List<User> requetenamed(String requete, Object... tab) {
		// TODO Auto-generated method stub
		return this.requeteNamed(User.class,requete, tab);
	}

	@Override
	public List<Devis> methodeRetourne(User o) {
		// TODO Auto-generated method stub
		return null;
	}

}
