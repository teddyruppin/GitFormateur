package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import projpoo1.GestionAchatCommande.Achat;
import projpoo1.GestionPersonnes.Salarie;

public class TestSalarie {

	private Salarie op;
	private final String onom = "ruppin";
	private final String oprenom = "teddy";
	private final String oadresse = "248 rue des ecoles";
	private final String oville = "le bourget du lac";
	private final String ocodepostal = "73370";
	private final String onsecu = "0123456789123";
	private final String osalaire = "1234,25�";
	private final Boolean oestclient = true;
	//private final Boolean oachete = true;
	
	
	private final Achat achat1 = new Achat("bidule", 1, new Date());
	private final Achat achat2 = new Achat("machin", 2, new Date());
	private final Achat achat3 = new Achat("chose", 3, new Date());
	private final List<Achat> lat = new ArrayList<Achat>();


	private final String setnsecu = "";
	private final String setsalaire = "";

	@Before
	public void init() {
		op = new Salarie(onom, oprenom, oadresse, oville, ocodepostal, onsecu, osalaire);
		lat.add(achat1);
		lat.add(achat2);
		lat.add(achat3);
	}

	@Test
	public void testSalarie() {
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
	public void testPaie() {
		assertNotNull(op);
	}
	
	@Test
	public void testEstClient() {
		assertEquals(oestclient, op.estClient());
	}
	
	
	@Test
	public void testAchete() {
		op.achete(lat);
		assertEquals(lat,op.getListeAchat() );
	}
/*
 * 
	@Test
	public void testTesteUniciteSecu() {
		fail("Not yet implemented");
	}*/

////////////////////////		NUMERO DE SECU         //////////////////////////////

	@Test
	public void testGetNsecu() {
		assertEquals(onsecu, op.getNsecu());
		this.testSetNsecu();
	}

	@Test
	public void testSetNsecu() {
		op.setNsecu(setnsecu);
		assertEquals("", op.getNsecu());
	}

////////////////////////		SALAIRE         //////////////////////////////

	@Test
	public void testGetSalaire() {
		assertEquals(osalaire, op.getSalaire());
		this.testSetSalaire();
	}

	@Test
	public void testSetSalaire() {
		op.setSalaire(setsalaire);
		assertEquals(setsalaire, op.getSalaire());
	}

}
