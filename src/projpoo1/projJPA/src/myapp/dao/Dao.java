package myapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import myapp.model.Personne;

public class Dao {
	private EntityManagerFactory factory = null;

	public void init() {
		factory = Persistence.createEntityManagerFactory("myBase");
	}

	public void close() {
		if (factory != null) {
			factory.close();
		}
	}
	
	
	public Personne addPerson(Personne p) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			em.getTransaction().begin();
			// utilisation de l’EntityManager
			em.persist(p);
			em.getTransaction().commit();
			System.err.println("addPerson witdh id=" + p.getId());
			return (p);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public Personne findPerson(long id) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			em.getTransaction().begin();
			// utilisation de l’EntityManager
			Personne p = em.find(Personne.class, id);
			return p;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
}
