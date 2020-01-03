package net.atos.englishbattle.dao;

import java.sql.SQLException;
import java.util.List;

import net.atos.englishbattle.business.Joueur;

public interface JoueurDao {

	Joueur create(Joueur joueur) throws SQLException;

	Joueur findOne(Long id) throws SQLException;

	List<Joueur> findAll() throws SQLException;

}