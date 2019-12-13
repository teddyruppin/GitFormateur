package com.filrouge.poe.lyon.JPAPOE.dao;

import java.util.List;

import com.filrouge.poe.lyon.JPAPOE.model.Voiture;

public interface IVoitureDao {
	
	List<Voiture> listVoiture();
	void ajouterVoiture(Voiture v);
	void modifierVoiture(Voiture v);
	void supprimerVoiture(Voiture v);
	Voiture findVoiture(Integer i);

}
