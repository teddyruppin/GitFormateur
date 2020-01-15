package spring004web.dao;

import java.util.List;

import spring004web.bean.Eleves;

public interface IEleveDao {
	
	List<Eleves> rechercherEleve();
	void creerEleve(final Eleves eEleves);
	void supprimerEleve(final Eleves eEleves);
	void modifierEleve(final Eleves eEleves);

}
