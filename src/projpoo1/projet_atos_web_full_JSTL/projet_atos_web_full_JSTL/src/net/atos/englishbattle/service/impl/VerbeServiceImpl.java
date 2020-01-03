package net.atos.englishbattle.service.impl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import net.atos.englishbattle.business.Verbe;
import net.atos.englishbattle.dao.VerbeDao;
import net.atos.englishbattle.dao.impl.VerbeDaoImpl;
import net.atos.englishbattle.exceptions.AucunVerbeException;
import net.atos.englishbattle.service.VerbeService;

public class VerbeServiceImpl implements VerbeService {

	private static Random random = new Random();
	// On déclare un objet de type VerbeDao
	private VerbeDao verbeDao = null;
	
	public VerbeServiceImpl() {
		try {
			// On essaie d'instancier l'objet de type VerbeDao
			verbeDao = new VerbeDaoImpl();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	@Override
	public void importerVerbes() throws AucunVerbeException{
		
		// On importe le fichier CSV en ligne
		// Pour chaque ligne du fichier CSV on crée un objet
		// de type Verbe
		try {
			// On crée un objet de type URL
			URL url = new URL("https://www.clelia.fr/Battle/englishbattle161.csv");
		
			// On crée un lecteur à partir du flux d'entrée générée par l'URL
			// == méthode GET du protocole HTTP
			Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()), "UTF-8");
			
			// On crée un parser en donnant en paramètre le reader et le format CSV standard
			// Big up Emilie !
			CSVParser csvParser = new CSVParser(reader, CSVFormat.RFC4180);
			
			// On parcourt le csvParser, on ajoute un objet de type Verbe à liste verbes
			for (CSVRecord record : csvParser) {
				Verbe verbe = new Verbe();
				verbe.setBaseVerbale(record.get(1));
				verbe.setParticipePasse(record.get(2));
				verbe.setPreterit(record.get(3));
				verbe.setTraduction(record.get(4));
				try {
					verbeDao.create(verbe);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			csvParser.close();
			
		} catch (MalformedURLException e) {
			System.out.println("Le fichier CSV n'est pas disponible. Au revoir.");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Impossible de créer le flux d'entrée. C'est la faute du stagiaire. Au revoir");
			System.exit(1);
		}
		
		try {
			if (verbeDao.findAll().isEmpty()) throw new AucunVerbeException();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Verbe> recupererVerbes() {
		try {
			return verbeDao.findAll();
		} catch (SQLException e) {
			System.out.println("Impossible de communiquer avec la base.");
			System.exit(0);
		}
		return null;
	}

	@Override
	public Verbe recupererVerbe(Long id) {
		try {
			return verbeDao.findOne(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Verbe recupererVerbeAleatoire() {
		try {
			return verbeDao.findRandom();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
