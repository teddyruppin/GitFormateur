package net.atos.englishbattle.service;

import java.util.List;

import net.atos.englishbattle.business.Niveau;

public interface NiveauService {

	Niveau ajouterNiveau(String nom);
	
	void ajouterNiveaux();
	
	List<Niveau> recupererNiveaux();
	
	Niveau recupererNiveauParId(Long id);

}
