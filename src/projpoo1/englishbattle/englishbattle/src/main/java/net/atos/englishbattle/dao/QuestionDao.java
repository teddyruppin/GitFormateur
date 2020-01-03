package net.atos.englishbattle.dao;

import java.sql.SQLException;
import java.util.List;

import net.atos.englishbattle.business.Question;

public interface QuestionDao {

	Question create(Question question) throws SQLException;

	List<Question> findAll() throws SQLException;

	Question findOne(Long id) throws SQLException;

	/**
	 * Cette méthode met à jour la question, elle est utilisée une fois que
	 * le joueur a donné ses réponses
	 * 
	 * @param question
	 * @return
	 * @throws SQLException
	 */
	Question update(Question question) throws SQLException;

}