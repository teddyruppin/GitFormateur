package myapp.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {
	
	private EntityManagerFactory factory = null;
	
	public void init() {
		factory = Persistence.createEntityManagerFactory("mybase");
	}
	
	public void close() {
		if (factory != null) {
			factory.close();
		}
	}

}
