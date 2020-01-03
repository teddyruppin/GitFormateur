package net.atos.englishbattle.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partie {

	private Long id;
	private Joueur joueur;
	private List<Question> questions;
	// La map contient deux colonnes: la première correspond à la clé,
	// la seconde correspond à la valeur
	private Map<Integer, Verbe> verbesDemandes = new HashMap<>();
	
	public Partie() {
		questions = new ArrayList<>();
	}
	
	public Partie(Joueur joueur) {
		this();
		this.joueur = joueur; 
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public Long getTempsMoyenDeReponseEnMillisecondes() {
		if (questions.size()==0) return null;
		
		long tempsMoyenDeReponseEnMillisecondes = 0;
		for (Question question : questions) {
			tempsMoyenDeReponseEnMillisecondes += question.getTempsDeReponseEnMillisecondes();
		}
		return tempsMoyenDeReponseEnMillisecondes/questions.size();
	}

	public Map<Integer, Verbe> getVerbesDemandes() {
		return verbesDemandes;
	}

	public void setVerbesDemandes(Map<Integer, Verbe> ttrtrrt) {
		this.verbesDemandes = ttrtrrt;
	}
	
	@Override
	public String toString() {
		return "Partie [id=" + id + ", joueur=" + joueur.getEmail() + ", questions=" + questions + "]";
	}
}