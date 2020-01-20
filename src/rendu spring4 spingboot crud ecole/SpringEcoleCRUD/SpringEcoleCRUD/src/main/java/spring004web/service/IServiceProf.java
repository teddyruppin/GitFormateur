package spring004web.service;

import java.util.Date;
import java.util.List;

import spring004web.bean.Profs;
import spring004web.enume.Sexe;

public interface IServiceProf {

	List<Profs> rechercherProf();
	void creerProf(final String nom,
			final String prenom,
			final Date date_naissance,
			final String adresse,
			final Sexe sexe);
	void supprimerProf(final Integer pIdProf);
	void modifierProf(final List<Profs> pListeProf);
}
