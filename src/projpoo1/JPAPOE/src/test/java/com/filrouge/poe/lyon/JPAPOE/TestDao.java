package com.filrouge.poe.lyon.JPAPOE;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.filrouge.poe.lyon.JPAPOE.dao.impl.Dao;
import com.filrouge.poe.lyon.JPAPOE.model.Client;
import com.filrouge.poe.lyon.JPAPOE.model.Voiture;
import com.filrouge.poe.lyon.JPAPOE.service.IClientService;
import com.filrouge.poe.lyon.JPAPOE.service.IVoitureService;
import com.filrouge.poe.lyon.JPAPOE.service.impl.ClientService;
import com.filrouge.poe.lyon.JPAPOE.service.impl.VoitureService;

public class TestDao {
	
	private static Dao dao;
	

	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new Dao();
		dao.init();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao.close();
	}
	
	
/////////////////////		CLIENT		/////////////////////////	

	//@Test
	public void testfindClient() {
		IClientService clientservice = new ClientService(dao);
		System.out.println(clientservice.findClient(1));
	}
	
	//@Test
	public void testfinAllClient() {
		IClientService clientservice = new ClientService(dao);
		System.out.println(clientservice.listClient());
	}
	
	@Test
	public void testfinClientByName() {
		IClientService clientservice = new ClientService(dao);
		System.out.println(clientservice.findClientByName("t%"));
	}
	
	//@Test
	public void testajoutClient() {
		IClientService clientservice = new ClientService(dao);
		Client c = new Client();
		c.setName("test");
		c.setFirstname("test");
		c.setAdresse("rue test");
		c.setCodepostal("73370");
		c.setVille("testville");
		c.setPortable("0611111111");
		c.setTel("0411111111");
		clientservice.ajouterClient(c);
		System.out.println(clientservice.listClient());
	}
	
	//@Test
	public void testsupprimeClient() {
		IClientService clientservice = new ClientService(dao);
		Client c = clientservice.findClient(2);
		clientservice.supprimerClient(c);
		System.out.println(clientservice.listClient());
	}
	
	
/////////////////////		VOITURE		/////////////////////////	

	
	//@Test
	public void testfindVoiture() {
		IVoitureService voitureservice = new VoitureService(dao);
		System.out.println(voitureservice.findVoiture(1));
	}
	
	//@Test
	public void testfindAllVoiture() {
		IVoitureService voitureservice = new VoitureService(dao);
		System.out.println(voitureservice.listVoiture());
	}
	
	//@Test
	public void testajoutVoiture() {
		IVoitureService voitureservice = new VoitureService(dao);
		Voiture v = new Voiture();
		v.setModele("BMW");
		v.setQte(1);
		v.setPrix(2000);
		v.setDate(new Date());
		voitureservice.ajouterVoiture(v);
		System.out.println(voitureservice.listVoiture());
	}
	
	//@Test
	public void testsupprimeVoiture() {
		IVoitureService voitureservice = new VoitureService(dao);
		Voiture c = voitureservice.findVoiture(3);
		voitureservice.supprimerVoiture(c);
		System.out.println(voitureservice.listVoiture());
	}

}