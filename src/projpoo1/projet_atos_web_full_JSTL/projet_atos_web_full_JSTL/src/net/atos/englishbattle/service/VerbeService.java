package net.atos.englishbattle.service;

import java.util.List;

import net.atos.englishbattle.business.Verbe;
import net.atos.englishbattle.exceptions.AucunVerbeException;

public interface VerbeService {

	/**
	 * Cette méthode importe le fichier CSV disponible à
	 * l'adresse https://www.clelia.fr/Battle/englishbattle161.csv
	 * @throws AucunVerbeException 
	 */
	void importerVerbes() throws AucunVerbeException;
	
	List<Verbe> recupererVerbes();
	
	Verbe recupererVerbe(Long id);
	
	Verbe recupererVerbeAleatoire();
	
	
	
}
