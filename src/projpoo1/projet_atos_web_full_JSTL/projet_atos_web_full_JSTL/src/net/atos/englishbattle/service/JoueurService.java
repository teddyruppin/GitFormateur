package net.atos.englishbattle.service;

import java.util.List;

import net.atos.englishbattle.business.Joueur;

public interface JoueurService {

	Joueur ajouterJoueur(Joueur joueur);
	
	Joueur ajouterJoueur(Long idNiveau, String pseudo, String motDePasse);
	
	List<Joueur> recupererJoueurs();
	
	Joueur recupererJoueurParId(Long id);

}
