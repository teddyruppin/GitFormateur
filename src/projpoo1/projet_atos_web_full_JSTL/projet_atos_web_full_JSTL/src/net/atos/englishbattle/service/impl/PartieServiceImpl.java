package net.atos.englishbattle.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import net.atos.englishbattle.business.Joueur;
import net.atos.englishbattle.business.Partie;
import net.atos.englishbattle.business.Verbe;
import net.atos.englishbattle.dao.PartieDao;
import net.atos.englishbattle.dao.impl.PartieDaoImpl;
import net.atos.englishbattle.service.PartieService;
import net.atos.englishbattle.service.VerbeService;

public class PartieServiceImpl implements PartieService {

	private VerbeService verbeService = new VerbeServiceImpl();
	private PartieDao partieDao = new PartieDaoImpl(); 
	
	@Override
	public Partie ajouterPartie(Joueur joueur) {

		// Un des rôles des services est de créer des objets métier
		Partie partie = new Partie();
		partie.setJoueur(joueur);
		
		List<Verbe> verbes = verbeService.recupererVerbes();
		// On mélange de manière aléatoire tous les verbes de la liste
		Collections.shuffle(verbes);
		
		// On remplit de manière aléatoire la map verbesDemandes
		int compteur = 0;
		for (Verbe verbe : verbes) {
			partie.getVerbesDemandes().put(compteur++, verbe);
		}
		
		System.out.println(partie);
		
		try {
			// On confie la nouvelle partie à la DAO PartieDao
			return partieDao.create(partie);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
