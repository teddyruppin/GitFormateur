package spring004web.service;

import java.util.List;

import spring004web.bean.Classes;

public interface IServiceClasse {
	List<Classes> rechercherClasse();
	void creerClasses(final String nom, final String prof);
	void supprimerClasses(final Integer cIdClasses);
	void modifierClasses(final List<Classes> cListeClasses);
}
