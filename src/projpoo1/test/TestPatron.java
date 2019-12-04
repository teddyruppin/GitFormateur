package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import projpoo1.GestionPersonnes.Patron;

public class TestPatron {
	
	private Patron op;
	private final String onom = "ruppin";
	private final String oprenom = "teddy";
	private final String oadresse = "248 rue des ecoles";
	private final String oville = "le bourget du lac";
	private final String ocodepostal = "73370";
	private final String onsecu = "0123456789123";
	private final String osalaire = "1234,25€";

	
	
	@Before
	public void init() {
		op = new Patron(onom, oprenom, oadresse, oville, ocodepostal, onsecu, osalaire);
	}
	
	@Test
	public void testPatron() {
		assertNotNull(op);
	}

	
////////////////////////		TOSTRING         //////////////////////////////

	
	@Test
	public void testToString() {
		assertEquals(onom, op.getNom());
		assertEquals(oprenom, op.getPrenom());
		assertEquals(oadresse, op.getAdresse());
		assertEquals(oville, op.getVille());
		assertEquals(ocodepostal, op.getCodepostal());
		assertEquals(onsecu, op.getNsecu());
		assertEquals(osalaire, op.getSalaire());
	}

	
////////////////////////		METHODES         //////////////////////////////


	@Test
	public void testEmbauche() {
		assertNotNull(op);
	}

	@Test
	public void testLicencie() {
		assertNotNull(op);
	}

	@Test
	public void testPaieSalarie() {
		assertNotNull(op);
	}

}
