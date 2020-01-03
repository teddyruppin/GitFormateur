package net.atos.englishbattle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.atos.englishbattle.business.Question;
import net.atos.englishbattle.dao.ConnexionBdd;
import net.atos.englishbattle.dao.QuestionDao;
import net.atos.englishbattle.dao.Requetes;

public class QuestionDaoImpl implements QuestionDao {

	private Connection connection;

	public QuestionDaoImpl() {
		try {
			this.connection = ConnexionBdd.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Question create(Question question) throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(Requetes.AJOUT_QUESTION,
				Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, question.getPartie().getId());
		ps.setLong(2, question.getVerbe().getId());
		ps.setBoolean(3, question.getAffichePreterit());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		
		if (rs.next()) {
			question.setId(rs.getLong(1));
		}
		
		return question;
	}

	@Override
	public List<Question> findAll() throws SQLException {
		List<Question> questions = new ArrayList<>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(Requetes.TOUTES_LES_QUESTIONS);
		// Tant qu'il y a des résultat dans le resultset
		// autrement dit: tant qu'il y a des lignes à lire dans l'ensemble de résultat
		while (rs.next()) {
			Question question = new Question();
			question.setId(rs.getLong(1));
			question.setReponsePreterit(rs.getString(2));
			question.setReponseParticipePasse(rs.getString(3));
			questions.add(question);
		}
		return questions;
	}

	@Override
	public Question findOne(Long id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requetes.QUESTION_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Question question = new Question();
			question.setId(rs.getLong(1));
			question.setReponsePreterit(rs.getString(2));
			question.setReponseParticipePasse(rs.getString(3));
			return question;
		}
		return null;
	}

	@Override
	public Question update(Question question) throws SQLException {
		// Met à jour la date de réponse, la réponse du joueur pour le prétérit et la
		// réponse du joueur pour le participe passé
		PreparedStatement ps = connection.prepareStatement(Requetes.MAJ_QUESTION);

		// Big up Sumaira !
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(question.getDateReponse());
		ps.setTimestamp(1, new Timestamp(calendar.getTimeInMillis()));
		
		ps.setString(2, question.getReponsePreterit());
		ps.setString(3, question.getReponseParticipePasse());
		ps.setLong(4, question.getId());
		ps.executeUpdate();
		return question;
	}
}
