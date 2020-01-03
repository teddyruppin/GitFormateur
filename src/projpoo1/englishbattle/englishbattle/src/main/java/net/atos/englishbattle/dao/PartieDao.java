package net.atos.englishbattle.dao;

import java.sql.SQLException;
import java.util.List;

import net.atos.englishbattle.business.Joueur;
import net.atos.englishbattle.business.Partie;

public interface PartieDao {

	Partie create(Partie partie) throws SQLException;
	
	Partie findOne(Long id) throws SQLException;

	List<Partie> findAll() throws SQLException;

}