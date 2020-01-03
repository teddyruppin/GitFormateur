package net.atos.englishbattle.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

import net.atos.englishbattle.business.Niveau;
import net.atos.englishbattle.business.Partie;
import net.atos.englishbattle.business.Question;
import net.atos.englishbattle.business.Verbe;
import net.atos.englishbattle.dao.QuestionDao;
import net.atos.englishbattle.dao.impl.QuestionDaoImpl;
import net.atos.englishbattle.service.QuestionService;
import net.atos.englishbattle.service.VerbeService;

public class QuestionServiceImpl implements QuestionService {

	private VerbeService verbeService = new VerbeServiceImpl();
	private QuestionDao questionDao = new QuestionDaoImpl();
	
	@Override
	public Question ajouterQuestionAPartie(Partie partie) {
		
		// On vérifie que les verbes en base n'ont pas été tous demandés dans 
		// la partie en cours
		if (partie.getQuestions().size()==partie.getVerbesDemandes().size())
		{
			// Tous les verbes ont été demandés, nous ne pouvons pas renvoyer de nouvelle question
			return null;
		}

		// Ca c'était avant...
		//Verbe verbe = verbeService.recupererVerbeAleatoire();
		
		// On questionne la map pour connaître le prochain verbe à demander
		// partie.getQuestions().size() correspond à la clé demandée
		Verbe verbe = partie.getVerbesDemandes().get(partie.getQuestions().size());
		
		Question question = new Question();
		// La nouvelle question connait sa partie
		// Ce faisait, une fois en base, la clé étrangère partie_id sera fournie
		// pour cette question
		question.setPartie(partie);
		// La partie connait la nouvelle question
		partie.getQuestions().add(question);
		// On demande à verbeService de nous fournir un verbe aléatoire
		question.setVerbe(verbe);
		// On définit la date d'envoi avec la date actuelle
		question.setDateEnvoi(new Date());
		
		if (!partie.getJoueur().getNiveau().getNom().equals(Niveau.EXPERT)) {
			// On affiche soit le prétérit soit le participe passé
			Random random = new Random();
			int choix = random.nextInt(2);
			if (choix==0) {
				question.setAffichePreterit(true);
			}
			else
			{
				question.setAffichePreterit(false);
			}
		}
		try {
			return questionDao.create(question);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean verifierReponses(Question question) {
		question.setDateReponse(new Date());
		
		try {
			questionDao.update(question);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		// Est-ce que le joueur a répondu dans les temps ?
		if (question.getTempsDeReponseEnMillisecondes()>60000) {
			return false;
		}
		
		return question.getVerbe().getPreterit().equalsIgnoreCase(question.getReponsePreterit())
			&& question.getVerbe().getParticipePasse().equalsIgnoreCase(question.getReponseParticipePasse());
	}

}
