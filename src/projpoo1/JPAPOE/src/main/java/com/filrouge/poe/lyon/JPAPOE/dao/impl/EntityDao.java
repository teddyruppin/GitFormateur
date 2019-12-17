package com.filrouge.poe.lyon.JPAPOE.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public abstract class EntityDao<T> {

	private Dao dao = null;

	public EntityDao(Dao dao) {
		super();
		this.dao = dao;
	}

	public T add(T p) {
		EntityManager em = null;
		try {
			em = dao.newEntityManager();
			em.persist(p); // INSERT
			em.getTransaction().commit();
			return (p);
		} finally {
			dao.closeEntityManager(em);
		}
	}

	public void update(T p) {
		EntityManager em = null;
		try {
			em = dao.newEntityManager();
			em.merge(p); // UPDATE
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.closeEntityManager(em);
		}
	}

	public void remove(Class<T> eclasse, Object pk) {
		EntityManager em = null;
		try {
			em = dao.newEntityManager();
			T p = em.find(eclasse, pk); // on doit faire un find avant dans la meme transaction
			em.remove(p); // suppression physique
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.closeEntityManager(em);
		}
	}

	public T find(Class<T> eclass, Object pk) {
		EntityManager em = null;
		try {
			em = dao.newEntityManager();
			return em.find(eclass, pk);
		} finally {
			dao.closeEntityManager(em);
		}
	}
	
	public List<T> AllFind(Class<T> eclass) {
		EntityManager em = null;
		try {
			em = dao.newEntityManager();
			String query = "SELECT q FROM " + eclass.getSimpleName() 
					+ " q ";
			TypedQuery<T> q = em.createQuery(query, eclass);
			return q.getResultList();	
		} finally {
			dao.closeEntityManager(em);
		}
	}
	/*
	public List<T> FindClientByName1(String query,String param,Class<T> eclass){
		EntityManager em = null;
		try {
			em = dao.newEntityManager();
			
			TypedQuery<T> q = em.createNamedQuery(query,eclass);
			q.setParameter("param1", param);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	
	public List<T> requeteNamed(Class<T> eclass, String requete) {
		EntityManager em = null;
		try {
			em = dao.newEntityManager();
			TypedQuery<T> q = em.createNamedQuery(requete,eclass);
			return q.getResultList();	
		} finally {
			dao.closeEntityManager(em);
		}
	}
	
	public List<T> requeteNamed(Class<T> eclass, String requete, Object...objet) {
		EntityManager em = null;
		try {
			em = dao.newEntityManager();
			TypedQuery<T> q = em.createNamedQuery(requete,eclass);
			int i = 1; // sql commence toujours à 1
			for (Object p : objet) {
				q.setParameter(i, p);
				i++;
			}
			return q.getResultList();	
		} finally {
			dao.closeEntityManager(em);
		}
	}
	
	
}
