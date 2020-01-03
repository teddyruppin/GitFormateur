package net.atos.englishbattle.service.impl;

import java.sql.SQLException;
import java.util.List;

import net.atos.englishbattle.business.Joueur;
import net.atos.englishbattle.dao.JoueurDao;
import net.atos.englishbattle.dao.impl.JoueurDaoImpl;
import net.atos.englishbattle.service.JoueurService;
import net.atos.englishbattle.service.NiveauService;

public class JoueurServiceImpl implements JoueurService {

	private JoueurDao joueurDao = new JoueurDaoImpl();
	private NiveauService niveauService = new NiveauServiceImpl();

	@Override
	public Joueur ajouterJoueur(Joueur joueur) {
		try {
			return joueurDao.create(joueur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Joueur ajouterJoueur(Long idNiveau, String pseudo, String motDePasse) {
		Joueur joueur = new Joueur();
		joueur.setPseudo(pseudo);
		joueur.setMotDePasse(motDePasse);
		joueur.setNiveau(niveauService.recupererNiveauParId(idNiveau));
		try {
			return joueurDao.create(joueur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Joueur> recupererJoueurs() {
		try {
			return joueurDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Joueur recupererJoueurParId(Long id) {
		try {
			return joueurDao.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Joueur> recupereNbParties(){
		try {
			return joueurDao.findAllJoueurListe();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}