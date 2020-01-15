package spring004web.service;

import java.util.Date;
import java.util.List;

import spring004web.bean.Eleves;
import spring004web.enume.Sexe;


public interface IServiceEleve {
	List<Eleves> rechercherEleve();
	void creerEleve(final String nom,
			final String prenom,
			final Date date_naissance,
			final String adresse,
			final Sexe sexe);
	void supprimerEleve(final Integer eIdEleve);
	void modifierEleve(final List<Eleves> eListeEleve);
}
