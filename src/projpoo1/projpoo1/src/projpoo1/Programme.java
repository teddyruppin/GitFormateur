package projpoo1;

import java.util.Scanner;

import projpoo1.GestionPersonnes.Client;
import projpoo1.Menu.Menu;
import projpoo1.verif.Affichages;

/**
 * 
 * @author Teddy RUPPIN
 * @version 1.0 <b> JavaDoc pour la POE lYON 2019 </b>
 *
 */

public class Programme {

	static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		
		Menu.sc = Programme.sc;
		Client.sc = Affichages.sc;

		Menu.menu();
		
	}
}
