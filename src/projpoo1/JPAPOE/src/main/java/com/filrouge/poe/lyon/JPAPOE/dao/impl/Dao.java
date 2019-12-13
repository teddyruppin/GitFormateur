package com.filrouge.poe.lyon.JPAPOE.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Dao {
	
	private static EntityManagerFactory factory = null;
	
	public void init() {
		factory = Persistence.createEntityManagerFactory("bddFILROUGE");
	}
	
	public void close() {
		if (factory != null) {
			factory.close();
		}
	}
	
	// creer un EM et ouvrir une transaction
	public EntityManager newEntityManager() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		return (em);
	}
	
	// ferme un EM et defaire la trassaction si necessaire
	public void closeEntityManager (EntityManager em) {
		if ( em != null) {
			EntityTransaction t = em.getTransaction();
			if (t.isActive()) {
				try {
					t.rollback();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			em.close();
		}
	}
}
