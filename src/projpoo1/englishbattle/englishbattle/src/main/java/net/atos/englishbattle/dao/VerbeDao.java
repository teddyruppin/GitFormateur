package net.atos.englishbattle.dao;

import java.sql.SQLException;
import java.util.List;

import net.atos.englishbattle.business.Verbe;

public interface VerbeDao {

	Verbe create(Verbe verbe) throws SQLException;

	List<Verbe> findAll() throws SQLException;

	Verbe findRandom() throws SQLException;

	Verbe findOne(Long idVerbe) throws SQLException;

}