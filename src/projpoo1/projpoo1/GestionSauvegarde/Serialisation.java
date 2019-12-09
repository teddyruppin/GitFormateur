package projpoo1.GestionSauvegarde;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import projpoo1.GestionPersonnes.Personne;
import projpoo1.Menu.Menu;

public class Serialisation {

	static List<Personne> lp = new ArrayList<Personne>();

	public static void sauvegardeListe(String nomFichier) throws IOException {

		FileOutputStream fos = new FileOutputStream(nomFichier + ".ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(Menu.lp);
		oos.flush();
		oos.close();
	}

	@SuppressWarnings("unchecked")
	public static void chargeListe(String nomFichier) throws Exception {

		FileInputStream fis = new FileInputStream(nomFichier + ".ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Menu.lp = (List<Personne>) ois.readObject();
		ois.close();
	}

}
