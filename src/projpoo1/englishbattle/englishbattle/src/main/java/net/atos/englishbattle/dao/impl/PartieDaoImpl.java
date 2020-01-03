package net.atos.englishbattle.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.atos.englishbattle.business.Joueur;
import net.atos.englishbattle.business.Partie;
import net.atos.englishbattle.dao.ConnexionBdd;
import net.atos.englishbattle.dao.JoueurDao;
import net.atos.englishbattle.dao.PartieDao;
import net.atos.englishbattle.dao.Requetes;

public class PartieDaoImpl implements PartieDao {

	private Connection connection;
	// On met en oeuvre le patron DAO
	private JoueurDao joueurDao = new JoueurDaoImpl();

	public PartieDaoImpl() {
		try {
			this.connection = ConnexionBdd.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Partie create(Partie partie) throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(Requetes.AJOUT_PARTIE,
				Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, partie.getJoueur().getId());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		partie.setId((rs.getLong(1)));
		return partie;
	}

	@Override
	public Partie findOne(Long id) throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(Requetes.PARTIE_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Partie partie = new Partie();
			partie.setId(rs.getLong(1));
			partie.setJoueur(joueurDao.findOne(rs.getLong(2)));
			return partie;
		}
		return null;
	}

	@Override
	public List<Partie> findAll() throws SQLException {
		List<Partie> parties = new ArrayList<>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(Requetes.TOUTES_LES_PARTIES);
		while (rs.next()) {
			Partie partie = new Partie();
			partie.setId(rs.getLong(1));
			// Grâce à joueurDao on récupère l'objet Joueur associé à la partie
			partie.setJoueur(joueurDao.findOne(rs.getLong(2)));
			parties.add(partie);
		}
		return parties;
	}

}
