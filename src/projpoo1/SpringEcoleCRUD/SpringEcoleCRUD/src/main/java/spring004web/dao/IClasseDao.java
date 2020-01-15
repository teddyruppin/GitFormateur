package spring004web.dao;

import java.util.List;

import spring004web.bean.Classes;


public interface IClasseDao {

	List<Classes> rechercherClasses();
	void creerClasses(final Classes cClasses);
	void supprimerClasses(final Classes cClasses);
	void modifierClasses(final Classes cClasses);
}
