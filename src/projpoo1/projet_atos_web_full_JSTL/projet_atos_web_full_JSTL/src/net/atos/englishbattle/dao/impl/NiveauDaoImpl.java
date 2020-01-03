package net.atos.englishbattle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.atos.englishbattle.business.Niveau;
import net.atos.englishbattle.business.Verbe;
import net.atos.englishbattle.dao.ConnexionBdd;
import net.atos.englishbattle.dao.NiveauDao;
import net.atos.englishbattle.dao.Requetes;

public class NiveauDaoImpl implements NiveauDao {

	private Connection connection;
	
	public NiveauDaoImpl() {
		try {
			this.connection = ConnexionBdd.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public Niveau create(Niveau niveau) throws SQLException {

		// On déclare un objet de type PreparedStatement
		java.sql.PreparedStatement ps = connection.prepareStatement(Requetes.AJOUT_NIVEAU,
				Statement.RETURN_GENERATED_KEYS);
		
		// on remplace le ? par le nom du niveau
		ps.setString(1, niveau.getNom());

		// On envoie la requête SQL à MySQL
		ps.executeUpdate();
		
		// On demande à MySQL de nous donner la clé générée pour
		// le nouvel enregistrement pour l'objet niveau
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();

		// on definit l'id du niveau avec ce que mySQL a choisie comme id pour
		// l'enregistrement
		niveau.setId(rs.getLong(1));
		return niveau;

	}

	@Override
	public List<Niveau> findAll() throws SQLException {
		List<Niveau> niveaux = new ArrayList<>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(Requetes.TOUS_LES_NIVEAUX);
		while (rs.next()) {
			Niveau niveau = new Niveau();
			niveau.setId(rs.getLong(1));
			niveau.setNom(rs.getString(2));
			niveaux.add(niveau);
		}
		return niveaux;
	}

	@Override
	public Niveau findOne(Long id) throws SQLException {
		Niveau niveau = null;
		PreparedStatement ps = connection.prepareStatement(Requetes.NIVEAU_PAR_ID);

		// On remplace le ? par l'id du niveau demandé
		ps.setLong(1, id);
		
		// Pour une requête de type SELECT on invoque 
		// la méthode executeQuery()
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			niveau = new Niveau();
			niveau.setId(rs.getLong(1));
			niveau.setNom(rs.getString(2));
		}
		return niveau;
	}

}
