package com.filrouge.poe.lyon.JPAPOE.service;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.model.Client;
import com.filrouge.poe.lyon.JPAPOE.model.Voiture;

public interface IVoitureService {
	List<Voiture> listVoiture();
	void ajouterVoiture(Voiture v);
	void modifierVoiture(Voiture v);
	void supprimerVoiture(Voiture v);
	Voiture findVoiture(Integer i);	
	
	List<Voiture> requetenamed(String requete);
	List<Voiture> requetenamed(String requete, Object...tab);
}
