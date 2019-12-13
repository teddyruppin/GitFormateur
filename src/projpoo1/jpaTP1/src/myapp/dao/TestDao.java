package myapp.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import myapp.model.Person;

public class TestDao {
	
	static Dao dao;
	
	@BeforeClass
	public static void beforeAll() {
		dao = new Dao();
		dao.init();
	}

	@AfterClass
	public static void afterAll() {
		dao.close();
	}
	
	
	@Test
	public void testVide() {
		assertNotNull(dao);
	}
	
	@Test
	public void testPerson() {
		Person p = new Person();
		p.setFirstname("toto");
		p.setBirthDay(new Date());
		System.out.println(p);
	}

}
