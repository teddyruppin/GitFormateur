package spring004web.dao;

import java.util.List;

import spring004web.bean.Profs;

public interface IProfDao {

	List<Profs> rechercherProfs();
	void creerProfs(final Profs pProfs);
	void supprimerProfs(final Profs pProfs);
	void modifierProfs(final Profs pProfs);
	
}
