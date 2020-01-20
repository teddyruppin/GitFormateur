package spring004web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import spring004web.bean.Classes;

@Repository
public class ClassesDao implements IClasseDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Classes> rechercherClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	public void creerClasses(Classes cClasses) {
		// TODO Auto-generated method stub

	}

	public void supprimerClasses(Classes cClasses) {
		// TODO Auto-generated method stub

	}

	public void modifierClasses(Classes cClasses) {
		// TODO Auto-generated method stub

	}

}
