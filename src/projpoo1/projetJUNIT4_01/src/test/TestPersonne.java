package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import projetJUNIT4_01.classes.Personne;

public class TestPersonne {
	
	private Personne op;
	private final String onom = "MARTIN";
	private final String oprenom = "Jean";
	private final Date odate = new Date();
	private final String setnom = "";
	private final String setprenom = "";

	// les variables sont mises en final pour ne pas pouvoir les toucher dans le code.
	
	@Before
	public void init() {
		op = new Personne(onom, oprenom, odate);
	}

	@Test
	public void testPersonne() {
		// On veut savoir si le constructeur a bien fonctionné
		assertNotNull(op);
		// assertNotNull --> OK
		// assertNull(op); donne une failure
	}

	@Test
	public void testGetNom() {
		assertEquals(onom , op.getNom());
		this.testSetNom();
	}

	@Test
	public void testSetNom() {
		op.setNom(setnom);
		assertEquals(setnom, op.getNom());
	}

	@Test
	public void testGetPrenom() {
		assertEquals(oprenom , op.getPrenom());
		this.testSetPrenom();
	}

	@Test
	public void testSetPrenom() {
		op.setPrenom(setprenom);
		assertEquals(setprenom, op.getPrenom());
	}

	@Test
	public void testGetDateDaissance() {
		assertEquals(odate, op.getDateDaissance());
	}

	@Test
	public void testGetAge() {
		assertEquals(new Integer(0), op.getAge());
		// assertEquals(null, op.getAge()); si jamais this.age est initialise a null
	}

}
