package net.atos.englishbattle.service;

import net.atos.englishbattle.business.Partie;
import net.atos.englishbattle.business.Question;

public interface QuestionService {

	/**
	 * Cette méthode ajoute une question à la partie
	 * donnée en paramètre
	 * @param partie
	 * @return
	 */
	Question ajouterQuestionAPartie(Partie partie);
	
	/**
	 * Cette méthode vérifie que les réponses données
	 * par le joueur sont justes
	 * @param question
	 * @return true si le joueur a donné les bonnes réponses
	 */
	boolean verifierReponses(Question question);
}
