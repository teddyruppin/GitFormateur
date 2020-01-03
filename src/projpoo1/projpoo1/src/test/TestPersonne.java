package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import projpoo1.GestionPersonnes.Personne;

public class TestPersonne {
	
	
	private Personne op;
	
	private final String onom = "ruppin";
	private final String oprenom = "teddy";
	private final String oadresse = "248 rue des ecoles";
	private final String oville = "le bourget du lac";
	private final String ocodepostal = "73370";
	
	private final String setnom = "";
	private final String setprenom = "";
	private final String setadresse = "";
	private final String setville = "";
	private final String setcodepostal = "";
	
	@Before
	public void init() {
		op = new Personne(onom, oprenom, oadresse, oville, ocodepostal);
	}

	@Test
	public void testPersonne() {
		assertNotNull(op);
		}

	
////////////////////////	  TOSTRING         //////////////////////////////

	
	@Test
	public void testToString() {
		assertEquals(onom, op.getNom());
		assertEquals(oprenom, op.getPrenom());
		assertEquals(oadresse, op.getAdresse());
		assertEquals(oville, op.getVille());
		assertEquals(ocodepostal, op.getCodepostal());		
	}
	

////////////////////////      NOM         //////////////////////////////


	@Test
	public void testGetNom() {
		assertEquals(onom, op.getNom());
		this.testSetNom();
	}

	@Test
	public void testSetNom() {
		op.setNom(setnom);
		assertEquals("", op.getNom());
	}
	
////////////////////////      PRENOM         //////////////////////////////	

	@Test
	public void testGetPrenom() {
		assertEquals(oprenom, op.getPrenom());
		this.testSetPrenom();
	}

	@Test
	public void testSetPrenom() {
		op.setPrenom(setprenom);
		assertEquals(setprenom, op.getPrenom());	
	}
	
////////////////////////      ADRESSE         //////////////////////////////


	@Test
	public void testGetAdresse() {
		assertEquals(oadresse, op.getAdresse());
		this.testSetAdresse();
		}

	@Test
	public void testSetAdresse() {
		op.setAdresse(setadresse);
		assertEquals(setadresse, op.getAdresse());	
		}
	
	
////////////////////////	  VILLE         //////////////////////////////


	@Test
	public void testGetVille() {
		assertEquals(oville, op.getVille());
		this.testSetAdresse();
		}

	@Test
	public void testSetVille() {
		op.setVille(setville);
		assertEquals(setville, op.getVille());		}
	
	
////////////////////////	   CODE POSTAL         //////////////////////////////


	@Test
	public void testGetCodepostal() {
		assertEquals(ocodepostal, op.getCodepostal());
		this.testSetCodepostal();	
		}

	@Test
	public void testSetCodepostal() {
		op.setCodepostal(setcodepostal);
		assertEquals(setcodepostal, op.getCodepostal());		}

}
