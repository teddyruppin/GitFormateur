package projpoo1.verif;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import projpoo1.GestionAchatCommande.Achat;
import projpoo1.GestionAchatCommande.Commande;
import projpoo1.GestionAchatCommande.gestionAchatCommande;
import projpoo1.GestionPersonnes.Client;
import projpoo1.GestionPersonnes.Fournisseur;
import projpoo1.GestionPersonnes.IClient;
import projpoo1.GestionPersonnes.IFournisseur;
import projpoo1.GestionPersonnes.Patron;
import projpoo1.GestionPersonnes.Personne;
import projpoo1.GestionPersonnes.Salarie;
import projpoo1.GestionSauvegarde.Serialisation;
import projpoo1.Menu.Menu;

public class Affichages {

	public static Scanner sc = new Scanner(System.in);

	static List<Achat> la = new ArrayList<Achat>();
	public static List<Personne> lp = new ArrayList<Personne>();
	static List<Commande> lco = new ArrayList<Commande>();
	static List<IClient> lic = new ArrayList<IClient>();
	static List<IFournisseur> lif = new ArrayList<IFournisseur>();

	static String persC = "";
	static String persF = "";

	public static void afficheListe(Stream<? extends Personne> lp, String name) {
		System.out.println("Voici la liste des " + name);
		lp.forEach(System.out::println);
		Menu.menu();
	}

	public static void saisirFournisseur() {
		System.out.println("Vous voulez ajouter un fournisseur");
		Fournisseur.creerFournisseur(sc, lp);
		Menu.menu();
	}

	public static void saisirSalarie() {
		System.out.println("Vous voulez ajouter un salarie");
		Salarie.creerSalarier(sc, lp);
		Menu.menu();
	}

	public static void saisirClient() {
		System.out.println("Vous voulez ajouter un client");
		Client.creerClient(sc, lp);
		Menu.menu();
	}

	public static void saisirPatron() {
		System.out.println("Saisissez un nouveau patron");
		for (Personne p : lp) {
			if (p instanceof Patron) {
				lp.remove(p);
				break;
			}
		}
		Patron.saisirPatron(sc, lp);
		Menu.menu();
	}

	public static void afficheIClient() {
		System.out.println("Voici la liste des IClient");
		for (Personne p : lp) {
			if (p instanceof IClient) {
				if (((IClient) p).estClient() == true) {
					lic.add((IClient) p);
					System.out.println(p);
				}
			}
		}
		Menu.menu();
	}

	public static void saisirAchatIClient() {
		System.out.println("saisir achat(s) pour un IClient");
		System.out.println("Quel Personne?");
		persC = sc.nextLine();
		for (Personne p : lp) {
			if (p instanceof IClient) {
				Personne cln = (Personne) p;
				if (((IClient) p).estClient() == true) {
					if (persC.equals(cln.getNom())) {
						gestionAchatCommande.achatClient((IClient) p);
						System.out.println("pour Monsieur ou Madame: " + persC);

					}
				}
			}
		}
		Menu.menu();
	}

	public static void afficheAchatIClient() {
		for (Achat p : la) {
			System.out.println("test");
			System.out.println(p);
			System.out.println("pour Monsieur ou Madame: " + persC);
		}
		Menu.menu();
	}

	public static void afficheIFournisseur() {
		System.out.println("Voici la liste des IFournisseur");
		for (Personne p : lp) {
			if (p instanceof IFournisseur) {
				if (((IFournisseur) p).estFournisseur() == true) {
					lif.add((IFournisseur) p);
					System.out.println(p);
				}
			}
		}
		Menu.menu();
	}

	public static void saisirCommandeIFournisseur() {
		System.out.println("saisir une commande pour un IFournisseur");
		System.out.println("Quel Personne?");
		persF = sc.nextLine();
		for (Personne p : lp) {
			if (p instanceof IFournisseur) {
				Personne frn = (Personne) p;
				if (((IFournisseur) p).estFournisseur() == true) {
					if (persF.equals(frn.getNom())) {
						gestionAchatCommande.commandeFournisseur((IFournisseur) frn);
						System.out.println(p);
						System.out.println("pour Monsieur ou Madame: " + persF);
					}
				}
			}
		}
		Menu.menu();
	}

	public static void afficheCommandeIFournisseur() {
		for (Commande p : lco) {
			System.out.println(p);
			System.out.println("pour Monsieur ou Madame: " + persF);
		}
		Menu.menu();
	}

	public static void sauvegardePersonnel() {
		String nomFichiersauv;
		System.out.println("Entrez le nom du fichier à sauvegarder:");
		nomFichiersauv = sc.nextLine();
		try {
			Serialisation.sauvegardeListe(nomFichiersauv);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Fichier sauvegardé avec succès.");
		Menu.menu();
	}

	public static void chargePersonnel() {
		String nomFichierch;
		System.out.println("Entrez le nom du fichier à charger:");
		nomFichierch = sc.nextLine();
		try {
			Serialisation.chargeListe(nomFichierch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fichier chargé avec succès.");
		Menu.menu();
	}
}
