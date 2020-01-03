package net.atos.englishbattle.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.atos.englishbattle.business.Verbe;
import net.atos.englishbattle.dao.ConnexionBdd;
import net.atos.englishbattle.dao.Requetes;
import net.atos.englishbattle.dao.VerbeDao;

public class VerbeDaoImpl implements VerbeDao {

	private Connection connection;

	// Constructeur: récupère la connexion avec la bdd englishbattle
	public VerbeDaoImpl() throws SQLException, ClassNotFoundException {
		try {
			this.connection = ConnexionBdd.getConnection();
		} catch (SQLException e) {
			throw new SQLException("Impossible de communiquer avec la base. Merci de démarrer MySQL.");
		}
		catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Impossible de communiquer avec la base. Merci d'ajouter le driver MySQL");
		}
	}

	@Override
	public Verbe create(Verbe verbe) throws SQLException {

		// On déclare un objet de type PreparedStatement
		java.sql.PreparedStatement ps = connection.prepareStatement(Requetes.AJOUT_VERBE,
				Statement.RETURN_GENERATED_KEYS);

		// on remplace le premier ? par la baseVerbale
		ps.setString(1, verbe.getBaseVerbale());

		// on remplace le 2eme ? par le preterit
		ps.setString(3, verbe.getPreterit());

		// on remplace le 3eme ? par le participe passe
		ps.setString(2, verbe.getParticipePasse());

		// on remplace le 4eme ? par la traduction
		ps.setString(4, verbe.getTraduction());

		// On envoie la requête SQL à MySQL
		ps.executeUpdate();
		// On demande à MySQL de nous donner la clé générée pour
		// le nouvel enregistrement pour l'objet verbe
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();

		// on definie l'id du verbe avec ce que mySQL a choisie comme id pour
		// l'enregistrement
		verbe.setId(rs.getLong(1));
		return verbe;
	}

	@Override
	public List<Verbe> findAll() throws SQLException {

		List<Verbe> verbes = new ArrayList<>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(Requetes.TOUS_LES_VERBES);
		while (rs.next()) {
			Verbe verbe = new Verbe();
			verbe.setId(rs.getLong(1));
			verbe.setBaseVerbale(rs.getString(2));
			verbe.setPreterit(rs.getString(4));
			verbe.setParticipePasse(rs.getString(3));
			verbe.setTraduction(rs.getString(5));
			verbes.add(verbe);
		}
		return verbes;

	}

	@Override
	public Verbe findRandom() throws SQLException {
		Verbe verbe = null;
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(Requetes.VERBE_ALEATOIRE);
		if (rs.next()) {
			verbe = new Verbe();
			verbe.setId(rs.getLong(1));
			verbe.setBaseVerbale(rs.getString(2));
			verbe.setPreterit(rs.getString(4));
			verbe.setParticipePasse(rs.getString(3));
			verbe.setTraduction(rs.getString(5));
		}
		return verbe;

	}

	@Override
	public Verbe findOne(Long idVerbe) throws SQLException {

		PreparedStatement ps = connection.prepareStatement(Requetes.VERBE_PAR_ID);
		// On remplace le ? par l'id du verbe demandé
		ps.setLong(1, idVerbe);

		// Pour une requête de type SELECT on invoque
		// la méthode executeQuery()
		ResultSet rs = ps.executeQuery();

		// Est-ce que MySQL a renvoyé des résultats ?
		if (rs.next()) {
			Verbe verbe = new Verbe();

			// rs = result set, cela correspond à ce que MySQL affiche lorsque l'on execute
			// une
			// requête
			verbe.setId(rs.getLong(1));
			verbe.setBaseVerbale(rs.getString(2));
			verbe.setPreterit(rs.getString(4));
			verbe.setParticipePasse(rs.getString(3));
			verbe.setTraduction(rs.getString(5));

			return verbe;
		}
		// L'id demandé n'existe pas en base (dans la table Verbe)
		// on renvoit null
		return null;
	}

}