package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import projpoo1.Programme;
import projpoo1.GestionPersonnes.Client;
import projpoo1.GestionPersonnes.Fournisseur;
import projpoo1.GestionPersonnes.Personne;
import projpoo1.GestionPersonnes.Salarie;

public class TestControle {

	@Test
	public void testVerifDate() {
		try {
			assertTrue(Programme.verifDate("10/12/2019") instanceof Date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testVerifNumeroClient() {
		List<Personne> lp = new ArrayList<Personne>();
		Personne p = new Client("", "", "", "", "", "001", true, true);

		lp.add(p);
		try {
			Client.testeUniciteNumClient("002", lp);
		} catch (Exception e) {
			assertThat(e.getMessage(), is("\"Num�ro Client existe d�j� : 002"));
		}
		try {
			Client.testeUniciteNumClient("001", lp);
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Num�ro Client existe d�j� : 001"));
		}
	}

	@Test
	public void testVerifNumeroSecuriteSocial() {
		List<Personne> lp = new ArrayList<Personne>();
		Personne p = new Salarie("", "", "", "", "", "0123456789123", "");
		lp.add(p);
		try {
			Salarie.testeUniciteSecu("000", lp);
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Num�ro s�curit� existe d�j� : 002"));
		}
		try {
			Salarie.testeUniciteSecu("0123456789123", lp);
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Num�ro s�curit� existe d�j� : 0123456789123"));
		}
	}

	@Test
	public void testVerifNumeroFournisseur() {
		List<Personne> lp = new ArrayList<Personne>();
		Personne p = new Fournisseur("", "", "", "", "", "123456", true, true);
		lp.add(p);
		try {
			Fournisseur.testeUniciteNumFournisseur("df123", lp);
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Num�ro Fournisseur existe d�j� : df123"));
		}
		try {
			Salarie.testeUniciteSecu("123456", lp);
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Num�ro Fournisseur existe d�j� : 123456"));
		}
	}

	/*
	 * 
	 * Pour le moment impossible a verifier, je dois dedoubler mes methodes.
	 * 
	 * @Test public void testVerifCodePostal() { try {
	 * assertTrue(Programme.verifCodePostal("73370")); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 * 
	 * @Test public void testVerifSalaire() { fail("Not yet implemented"); }
	 */

}
