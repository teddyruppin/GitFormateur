package myapp.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import myapp.model.Personne;

public class TestDao {

	private Personne prs;
	//private static long id = 1L;
	//private static String nom = "test";
	//private static Date date = new Date();
	//private static long version = ;
	
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
	
	@Before
	public void init () {
		prs = new Personne("test", new Date());
	}

	@Before
	public void setUp() {
// pour plus tard
	}

	@After
	public void tearDown() {
// pour plus tard
	}

	@Test
	public void testVide() {
	}
	
	@Test
	public void testAddPersonne() {
		dao.addPerson(prs);
	}
}
