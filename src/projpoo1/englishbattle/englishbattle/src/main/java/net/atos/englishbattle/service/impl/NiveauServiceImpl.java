package net.atos.englishbattle.service.impl;

import java.sql.SQLException;
import java.util.List;

import net.atos.englishbattle.business.Niveau;
import net.atos.englishbattle.dao.NiveauDao;
import net.atos.englishbattle.dao.impl.NiveauDaoImpl;
import net.atos.englishbattle.service.NiveauService;

public class NiveauServiceImpl implements NiveauService {

	private NiveauDao niveauDao = new NiveauDaoImpl();
	
	@Override
	public Niveau ajouterNiveau(String nom) {
		// On transmet au constructeur de Niveau le nom donné en paramètre
		Niveau niveau = new Niveau(nom);
		try {
			// On confie l'objet niveau à la DAO
			niveauDao.create(niveau);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return niveau;
	}

	@Override
	public void ajouterNiveaux() {
		ajouterNiveau(Niveau.DEBUTANT);
		ajouterNiveau(Niveau.INTERMEDIAIRE);
		ajouterNiveau(Niveau.EXPERT);
	}
	
	@Override
	public List<Niveau> recupererNiveaux() {
		try {
			return niveauDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Niveau recupererNiveauParId(Long id) {
		try {
			return niveauDao.findOne(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
