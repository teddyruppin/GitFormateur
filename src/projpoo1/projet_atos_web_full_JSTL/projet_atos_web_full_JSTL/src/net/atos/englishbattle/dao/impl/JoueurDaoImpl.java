package net.atos.englishbattle.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.atos.englishbattle.business.Joueur;
import net.atos.englishbattle.dao.ConnexionBdd;
import net.atos.englishbattle.dao.JoueurDao;
import net.atos.englishbattle.dao.NiveauDao;
import net.atos.englishbattle.dao.Requetes;

public class JoueurDaoImpl implements JoueurDao {

	// Mise en oeuvre du patron DAO: une DAO peut faire appel à une autre DAO
	private NiveauDao niveauDao = new NiveauDaoImpl();
	
	private Connection connection;

	public JoueurDaoImpl() {
		try {
			this.connection = ConnexionBdd.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Joueur create(Joueur joueur) throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(Requetes.AJOUT_JOUEUR,
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, joueur.getPseudo());
		ps.setString(2, joueur.getEmail());
		ps.setString(3, joueur.getMotDePasse());
		ps.setLong(4, joueur.getNiveau().getId());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		joueur.setId(rs.getLong(1));
		return joueur;
	}

	
	@Override
	public Joueur findOne(Long id) throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(Requetes.JOUEUR_PAR_ID);
		ps.setLong(1, id);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Joueur joueur = new Joueur();
			joueur.setId(rs.getLong(1));
			return joueur;
		}
		return null;
	}

	@Override
	public List<Joueur> findAll() throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(Requetes.TOUS_LES_JOUEURS);

		ResultSet rs = ps.executeQuery();
		List<Joueur> joueurs = new ArrayList<>();
		while (rs.next()) {
			Joueur joueur = new Joueur();
			joueur.setId(rs.getLong(1));
			joueur.setPseudo(rs.getString(2));
			joueur.setEmail(rs.getString(3));
			joueur.setMotDePasse(rs.getString(4));
			// On restitue le niveau du joueur grâce à la DAO niveauDao
			joueur.setNiveau(niveauDao.findOne(rs.getLong(5)));
			joueurs .add(joueur);
		}
		return joueurs;
	}

}
