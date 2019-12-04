package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import projpoo1.GestionCommande.Achat;
import projpoo1.GestionCommande.Commande;
import projpoo1.GestionPersonnes.Client;


public class TestClient {
	
	private Client op;
	
	private final String onom = "ruppin";
	private final String oprenom = "teddy";
	private final String oadresse = "248 rue des ecoles";
	private final String oville = "le bourget du lac";
	private final String ocodepostal = "73370";
	private final String onclient = "123456";
	private final Boolean oestclient = true;
	private final Boolean oestfournisseur = true;
	private final Boolean olivre = true;

	
	private final Achat achat1 = new Achat("bidule", 1, new Date());
	private final Achat achat2 = new Achat("machin", 2, new Date());
	private final Achat achat3 = new Achat("chose", 3, new Date());
	private final List<Achat> lat = new ArrayList<Achat>();
	
	
	private final Commande commande1 = new Commande("bidule", 1, new Date());
	private final Commande commande2 = new Commande("machin", 2, new Date());
	private final Commande commande3 = new Commande("chose", 3, new Date());
	private final List<Commande> lct = new ArrayList<Commande>();
	
	private final String setnclient = "";
	
	@Before
	public void init() {
		op = new Client(onom, oprenom, oadresse, oville, ocodepostal, onclient, oestclient, oestfournisseur);
		
		lat.add(achat1);
		lat.add(achat2);
		lat.add(achat3);
		
		lct.add(commande1);
		lct.add(commande2);
		lct.add(commande3);
		
	}
	
	
	@Test
	public void testClient() {
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
		assertEquals(onclient, op.getNclient());
		assertEquals(oestclient, op.estClient());
		assertEquals(oestfournisseur, op.estFournisseur());
		}

	
////////////////////////		METHODES         //////////////////////////////

 
	@Test
	public void testEstClient() {
		assertEquals(oestclient, op.estClient());
	}

	@Test
	public void testEstFournisseur() {
		assertEquals(oestfournisseur, op.estFournisseur());
	}
	
	
	@Test
	public void testAchete() {
		op.achete(lat);
		assertEquals(lat,op.getListeAchat());
	}
	
	@Test
	public void testCommande() {
		op.commande(lct);
		assertEquals(lct, op.getListeCommandes());
	}
	
	@Test
	public void testPaie() {
		assertNotNull(op);
	}
	

	@Test
	public void testLivre() {
		assertEquals(olivre, op.livre());
	}

/*

		@Test
	public void testTesteUniciteNumClient() {
		fail("Not yet implemented");
	}
	
*/

////////////////////////		NUMERO CLIENT         //////////////////////////////

	@Test
	public void testGetNclient() {
		assertEquals(onclient, op.getNclient());
		this.testSetNclient();
	}

	@Test
	public void testSetNclient() {
		op.setNclient(setnclient);
		assertEquals("", op.getNclient());
	}

}
