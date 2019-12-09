package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import projpoo1.GestionAchatCommande.Achat;
import projpoo1.GestionAchatCommande.Commande;
import projpoo1.GestionPersonnes.Fournisseur;

public class TestFournisseur {

	private Fournisseur op;

	private final String onom = "ruppin";
	private final String oprenom = "teddy";
	private final String oadresse = "248 rue des ecoles";
	private final String oville = "le bourget du lac";
	private final String ocodepostal = "73370";
	private final String onfournisseur = "654321";
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

	private final String setnfournisseur = "";

	@Before
	public void init() {
		op = new Fournisseur(onom, oprenom, oadresse, oville, ocodepostal, onfournisseur, oestclient, oestfournisseur);
		
		lat.add(achat1);
		lat.add(achat2);
		lat.add(achat3);
		
		lct.add(commande1);
		lct.add(commande2);
		lct.add(commande3);
	}

	@Test
	public void testFournisseur() {
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
		assertEquals(onfournisseur, op.getNfournisseur());
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
	public void testPaie() {
		assertNotNull(op);
	}

	@Test
	public void testLivre() {
		assertEquals(olivre, op.livre());
	}

	@Test
	public void testCommande() {
		op.commande(lct);
		assertEquals(lct, op.getListeCommandes());
	}


/*
	@Test
	public void testTesteUniciteNumFournisseur() {
		fail("Not yet implemented");
	}*/
	
	
////////////////////////		NUMERO FOURNISSEUR         //////////////////////////////

	
	@Test
	public void testGetNfournisseur() {
		assertEquals(onfournisseur, op.getNfournisseur());
		this.testSetNfournisseur();	
	}

	@Test
	public void testSetNfournisseur() {
		op.setNfournisseur(setnfournisseur);
		assertEquals("", op.getNfournisseur());	
	}

}
