package projpoo1.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import projpoo1.GestionAchatCommande.Achat;
import projpoo1.GestionAchatCommande.Commande;
import projpoo1.GestionPersonnes.Client;
import projpoo1.GestionPersonnes.Fournisseur;
import projpoo1.GestionPersonnes.IClient;
import projpoo1.GestionPersonnes.IFournisseur;
import projpoo1.GestionPersonnes.Patron;
import projpoo1.GestionPersonnes.Personne;
import projpoo1.GestionPersonnes.Salarie;
import projpoo1.verif.Affichages;

public class Menu {

	public static Scanner sc = null;

	static List<Achat> la = new ArrayList<Achat>();
	static List<Personne> lp = new ArrayList<Personne>();
	static List<Commande> lco = new ArrayList<Commande>();
	static List<IClient> lic = new ArrayList<IClient>();
	static List<IFournisseur> lif = new ArrayList<IFournisseur>();

	private static String choixt = null;

	public static void quitter() {

	}

	public static void menu() {

		Menu.lp = Affichages.lp;
		
		System.out.println("---------------------------------");
		Map<String, IExecute> menu = new HashMap<String, IExecute>();
		
		menu.put("1 : Menu de saisie de personnel", Menu::menuSaisir);
		menu.put("2 : Menu d'affichage de liste", Menu::menuAfficherListe);
		menu.put("3 : Gestion achats/commande", Menu::menuGestion);
		menu.put("4 : Menu de sauvegarde", Menu::menuSauvegarde);
		menu.put("q : Quitter", Menu::quitter);
		menu.keySet().stream().sorted().forEach(System.out::println);
		
		System.out.println("---------------------------------");

		while (true) {
			choixt = sc.next();

			menu.entrySet().stream().filter(e -> e.getKey().charAt(0) == choixt.charAt(0))
					.forEach(e -> e.getValue().apply());
		}
	}

	public static void menuSaisir() {
		
		System.out.println("---------------------------------");
		Map<String, IExecute> menu = new HashMap<String, IExecute>();
		
		menu.put("1 : Rentrer un client", Affichages::saisirClient);
		menu.put("2 : Rentrer un salarié", Affichages::saisirSalarie);
		menu.put("3 : Rentrer un fournisseur", Affichages::saisirFournisseur);
		menu.put("4 : Rentrer un nouveau patron", Affichages::saisirPatron);
		menu.put("r : Retourner au menu principal", Menu::menu);
		menu.keySet().stream().sorted().forEach(System.out::println);
		
		System.out.println("---------------------------------");

		while (true) {
			choixt = sc.next();

			menu.entrySet().stream().filter(e -> e.getKey().charAt(0) == choixt.charAt(0))
					.forEach(e -> e.getValue().apply());
		}
	}

	public static void menuAfficherListe() {
		
		System.out.println("---------------------------------");
		Map<String, IExecute> menu = new HashMap<String, IExecute>();

		menu.put("1 : Afficher liste clients",
				() -> Affichages.afficheListe(lp.stream().filter(item -> item instanceof Client), "Clients"));
		menu.put("2 : Afficher liste salariés",
				() -> Affichages.afficheListe(lp.stream().filter(item -> item instanceof Salarie), "Salariés"));
		menu.put("3 : Afficher liste fournisseurs",
				() -> Affichages.afficheListe(lp.stream().filter(item -> item instanceof Fournisseur), "Fournisseurs"));
		menu.put("4 : Afficher le patron",
				() -> Affichages.afficheListe(lp.stream().filter(item -> item instanceof Patron), "Patron"));
		menu.put("5 : Afficher les Iclient",
				() -> Affichages.afficheListe(lp.stream().filter(item -> item instanceof IClient), "IClient"));
		menu.put("6 : Afficher les Ifournisseur",
				() -> Affichages.afficheListe(lp.stream().filter(item -> item instanceof IFournisseur), "IFournisseur"));
		menu.put("t : Afficher tous le personnel",
				() -> Affichages.afficheListe(lp.stream().filter(item -> item instanceof Personne), "Personne"));
		menu.put("r : Retourner au menu principal", Menu::menu);

		menu.keySet().stream().sorted().forEach(System.out::println);
		System.out.println("---------------------------------");

		while (true) {
			choixt = sc.next();

			menu.entrySet().stream().filter(e -> e.getKey().charAt(0) == choixt.charAt(0))
					.forEach(e -> e.getValue().apply());
		}

	}

	public static void menuSauvegarde() {
		
		System.out.println("---------------------------------");
		Map<String, IExecute> menu = new HashMap<String, IExecute>();
		
		menu.put("1 : Sauvegarder la liste de personnes", Affichages::sauvegardePersonnel);
		menu.put("2 : Charger une liste de personnes", Affichages::chargePersonnel);
		menu.put("r : Retourner au menu principal", Menu::menu);
		menu.keySet().stream().sorted().forEach(System.out::println);
		
		System.out.println("---------------------------------");

		while (true) {
			choixt = sc.next();

			menu.entrySet().stream().filter(e -> e.getKey().charAt(0) == choixt.charAt(0))
					.forEach(e -> e.getValue().apply());
		}
	}
	
	public static void menuGestion() {
		
		System.out.println("---------------------------------");
		Map<String, IExecute> menu = new HashMap<String, IExecute>();

		menu.put("1 : Saisir un achat", Affichages::saisirAchatIClient);
		menu.put("2 : Saisir une commande", Affichages::saisirCommandeIFournisseur);
		menu.put("3 : Afficher les Iclient qui ont acheté un article", Affichages::afficheAchatIClient);
		menu.put("4 : Afficher les Ifournisseur qui ont commandé", Affichages::afficheCommandeIFournisseur);
		menu.put("r : Retourner au menu principal", Menu::menu);
		menu.keySet().stream().sorted().forEach(System.out::println);
		
		System.out.println("---------------------------------");

		while (true) {
			choixt = sc.next();

			menu.entrySet().stream().filter(e -> e.getKey().charAt(0) == choixt.charAt(0))
					.forEach(e -> e.getValue().apply());
		}
	}
}

/*
 * boolean x = false; while (x == false) {
 * 
 * System.out.println("1 : rentrer un client");
 * System.out.println("2 : rentrer un salarié");
 * System.out.println("3 : rentrer un fournisseur");
 * System.out.println("4 : liste clients");
 * System.out.println("5 : liste salariés");
 * System.out.println("6 : liste fournisseurs");
 * System.out.println("7 : saisir un PATRON");
 * System.out.println("8 : afficher un PATRON");
 * System.out.println("9 : liste IClient");
 * System.out.println("10 : saisir achat pour un IClient");
 * System.out.println("11 : afficher la liste d'achat avec le client");
 * System.out.println("12 : liste IFournisseur");
 * System.out.println("13 : saisir commande pour un IFournisseur");
 * System.out.println("14 : afficher la liste des commandes avec le fournisseur"
 * ); System.out.println("15 : Sauvegarder du personnel");
 * System.out.println("16 : Charger du personnel");
 * 
 * System.out.println("Choix? "); String choix = sc.nextLine();
 * 
 * switch (choix) {
 * 
 * case "1": Affichages.saisirClient(); break;
 * 
 * case "2": Affichages.saisirSalarie(); break;
 * 
 * case "3": Affichages.saisirFournisseur(); break;
 * 
 * case "4": Affichages.afficheListe(lp.stream().filter(item -> item instanceof
 * Client), "Clients"); break;
 * 
 * case "5": Affichages.afficheListe(lp.stream().filter(item -> item instanceof
 * Salarie), "Salaries"); break;
 * 
 * case "6": Affichages.afficheListe(lp.stream().filter(item -> item instanceof
 * Fournisseur), "Fournisseur"); break;
 * 
 * case "7": Affichages.saisirPatron(); break;
 * 
 * case "8": Affichages.afficheListe(lp.stream().filter(item -> item instanceof
 * Patron), "Patron"); break;
 * 
 * case "9": Affichages.afficheIClient(); break;
 * 
 * case "10": Affichages.saisirAchatIClient(); break;
 * 
 * case "11": Affichages.afficheAchatIClient(); break;
 * 
 * case "12": Affichages.afficheIFournisseur(); break;
 * 
 * case "13": Affichages.saisirCommandeIFournisseur(); break;
 * 
 * case "14": Affichages.afficheCommandeIFournisseur(); break;
 * 
 * case "15": Affichages.sauvegardePersonnel(); break;
 * 
 * case "16": Affichages.chargePersonnel(); break;
 * 
 * default: System.out.println("Rentrer une valeur propos�e"); break;
 * 
 * }
 * 
 * System.out.println("voulez vous arreter le programme oui/non"); String arret
 * = sc.nextLine();
 * 
 * if (arret.equals("oui")) { x = true; } }
 * System.out.println("FIN DU PROGRAMME");
 */
