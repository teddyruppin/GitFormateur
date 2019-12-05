package projpoo1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import projpoo1.Exception.ErreurSaisie;
import projpoo1.GestionCommande.Achat;
import projpoo1.GestionCommande.Commande;
import projpoo1.GestionPersonnes.Client;
import projpoo1.GestionPersonnes.Fournisseur;
import projpoo1.GestionPersonnes.IClient;
import projpoo1.GestionPersonnes.IFournisseur;
import projpoo1.GestionPersonnes.Patron;
import projpoo1.GestionPersonnes.Personne;
import projpoo1.GestionPersonnes.Salarie;

/**
 * 
 * @author Teddy RUPPIN
 * @version 1.0 <b> JavaDoc pour la POE lYON 2019 </b>
 *
 */

public class Programme {

	static boolean reussi = false;
	static Scanner sc = new Scanner(System.in);
	static List<Achat> la = new ArrayList<Achat>();
	static List<Personne> lp = new ArrayList<Personne>();
	static List<Commande> lco = new ArrayList<Commande>();
	static List<IClient> lic = new ArrayList<IClient>();
	static List<IFournisseur> lif = new ArrayList<IFournisseur>();

	public static void main(String[] args) {

		boolean x = false;
		String persC = "";
		String persF = "";

		while (x == false) {

			System.out.println("1 : rentrer un client");
			System.out.println("2 : rentrer un salari�");
			System.out.println("3 : rentrer un fournisseur");
			System.out.println("4 : liste clients");
			System.out.println("5 : liste salari�s");
			System.out.println("6 : liste fournisseurs");
			System.out.println("7 : saisir un PATRON");
			System.out.println("8 : afficher un PATRON");
			System.out.println("9 : liste IClient");
			System.out.println("10 : saisir achat pour un IClient");
			System.out.println("11 : afficher la liste d'achat avec le client");
			System.out.println("12 : liste IFournisseur");
			System.out.println("13 : saisir commande pour un IFournisseur");
			System.out.println("14 : afficher la liste des commandes avec le fournisseur");
			System.out.println("15 : Sauvegarder du personnel");
			System.out.println("16 : Charger du personnel");

			System.out.println("Choix? ");
			String choix = sc.nextLine();

			switch (choix) {

			case "1":
				System.out.println("Vous voulez ajouter un client");
				Client.creerClient(sc, lp);
				break;

			case "2":
				System.out.println("Vous voulez ajouter un salarie");
				Salarie.creerSalarier(sc, lp);
				break;

			case "3":
				System.out.println("Vous voulez ajouter un fournisseur");
				Fournisseur.creerFournisseur(sc, lp);
				break;

			case "4":
				System.out.println("Voici la liste des clients");
				for (Personne p : lp) {
					if (p instanceof Client) {
						System.out.println(p);
					}
				}
				break;

			case "5":
				System.out.println("Voici la liste des salari�s");
				for (Personne p : lp) {
					if (p instanceof Salarie) {
						System.out.println(p);
					}
				}
				break;

			case "6":
				System.out.println("Voici la liste des fournisseurs");
				for (Personne p : lp) {
					if (p instanceof Fournisseur) {
						System.out.println(p);
					}
				}
				break;

			case "7":
				System.out.println("Saisissez un nouveau patron");
				for (Personne p : lp) {
					if (p instanceof Patron) {
						lp.remove(p);
						break;
					}
				}
				Patron.saisirPatron(sc, lp);
				break;

			case "8":
				System.out.println("Voici le patron");
				for (Personne p : lp) {
					if (p instanceof Patron) {
						System.out.println(p);
					}
				}
				break;

			case "9":
				System.out.println("Voici la liste des IClient");
				for (Personne p : lp) {
					if (p instanceof IClient) {
						if (((IClient) p).estClient() == true) {
							lic.add((IClient) p);
							System.out.println(p);
						}
					}
				}
				break;

			case "10":
				System.out.println("saisir achat(s) pour un IClient");
				System.out.println("Quel Personne?");
				persC = sc.nextLine();
				for (Personne p : lp) {
					if (p instanceof IClient) {
						Personne cln = (Personne) p;
						if (((IClient) p).estClient() == true) {
							if (persC.equals(cln.getNom())) {
								Programme.achatClient((IClient) p);
								System.out.println(p);
								System.out.println("pour Monsieur ou Madame: " + persC);

							}
						}
					}
				}
				break;

			case "11":
				for (Achat p : la) {
					System.out.println(p);
					System.out.println("pour Monsieur ou Madame: " + persC);
				}
				break;

			case "12":
				System.out.println("Voici la liste des IFournisseur");
				for (Personne p : lp) {
					if (p instanceof IFournisseur) {
						if (((IFournisseur) p).estFournisseur() == true) {
							lif.add((IFournisseur) p);
							System.out.println(p);
						}
					}
				}
				break;

			case "13":
				System.out.println("saisir une commande pour un IFournisseur");
				System.out.println("Quel Personne?");
				persF = sc.nextLine();
				for (Personne p : lp) {
					if (p instanceof IFournisseur) {
						Personne frn = (Personne) p;
						if (((IFournisseur) p).estFournisseur() == true) {
							if (persF.equals(frn.getNom())) {
								commandeFournisseur((IFournisseur) frn);
								System.out.println(p);
								System.out.println("pour Monsieur ou Madame: " + persF);
							}
						}
					}
				}
				break;

			case "14":
				for (Commande p : lco) {
					System.out.println(p);
					System.out.println("pour Monsieur ou Madame: " + persF);
				}
				break;

			case "15":
				String nomFichiersauv;
				System.out.println("Entrez le nom du fichier � sauvegarder:");
				nomFichiersauv = sc.nextLine();
				try {
					Programme.sauvegardeListe(nomFichiersauv);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Fichier sauvegard� avec succ�s.");
				break;

			case "16":
				String nomFichierch;
				System.out.println("Entrez le nom du fichier � charger:");
				nomFichierch = sc.nextLine();
				try {
					Programme.chargeListe(nomFichierch);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Fichier charg� avec succ�s.");
				break;

			default:
				System.out.println("Rentrer une valeur propos�e");
				break;

			}

			System.out.println("voulez vous arreter le programme oui/non");
			String arret = sc.nextLine();

			if (arret.equals("oui")) {
				x = true;
			}
		}
		System.out.println("FIN DU PROGRAMME");
	}

//////////////////////////////		SERIALISATION		////////////////////////////

	public static void sauvegardeListe(String nomFichier) throws IOException {

		FileOutputStream fos = new FileOutputStream(nomFichier + ".ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(lp);
		oos.flush();
		oos.close();
	}

	@SuppressWarnings("unchecked")
	public static void chargeListe(String nomFichier) throws Exception {

		FileInputStream fis = new FileInputStream(nomFichier + ".ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		lp = (List<Personne>) ois.readObject();
		ois.close();
	}

//////////////////////////////		ACHAT CLIENT		////////////////////////////

	public static void achatClient(IClient cl) {
		boolean sorti = false;
		la.clear();
		while (sorti == false) {
			System.out.println("Nom de l'article? ");
			String nom = sc.next();

			System.out.println("Quantite de l'article? ");
			int qte = sc.nextInt();

			System.out.println("Date de l'achat? (format jj/mm/aaaa)  ");
			String date = sc.next();
			Date dt = new Date();
			try {
				dt = Programme.verifDate(date);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Achat monAchat = new Achat(nom, qte, dt);
			System.out.println(monAchat + "\n");
			la.add((Achat) monAchat);

			System.out.println("avez vous d'autres achats a faire? oui/non");
			String st = sc.next();
			if (st.equals("non")) {
				sorti = true;
			}
		}
		cl.achete(la);
	}

//////////////////////////////		COMMANDE FOURNISSEUR		////////////////////////////

	public static void commandeFournisseur(IFournisseur fr) {
		boolean sorti = false;
		lco.clear();
		while (sorti == false) {
			System.out.println("Nom de la commande? ");
			String nom = sc.next();

			System.out.println("Quantite de l'article? ");
			int qte = sc.nextInt();

			System.out.println("Date de l'achat? (format jj/mm/aaaa)  ");
			String date = sc.next();
			Date dt = new Date();
			try {
				dt = Programme.verifDate(date);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Commande maCommande = new Commande(nom, qte, dt);
			System.out.println(maCommande + "\n");
			lco.add((Commande) maCommande);

			System.out.println("avez vous d'autres commande a faire? oui/non");
			String st = sc.next();
			if (st.equals("non")) {
				sorti = true;
			}
		}
		fr.commande(lco);
	}

////////////////////////////		METHODES DE VERIFICATION		//////////////////////////////

	public static Date verifDate(String date) throws Exception {

		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd/MM/yyyy");
		format.setLenient(false);
		Date date1 = format.parse(date);
		return date1;
	}

	public static void verifCodePostal(String code) {
		do {
			code = sc.nextLine();
			if (!code.matches("\\d{1,5}")) {
				System.out.println("Rentrez un code postal du type XXXXX");
			}
		} while (!code.matches("\\d{1,5}"));
	}

	public static void verifSalaire(String sal) {
		do {
			sal = sc.nextLine();
			if (!sal.matches("\\d{1,9}\\,\\d{2}")) {
				System.out.println("Rentrez un salaire du type XXXXX,XX€");
			}
		} while (!sal.matches("\\d{1,9}\\,\\d{2}"));
	}

	public static void verifNumeroClient(String num) throws ErreurSaisie {
		reussi = false;
		while (reussi == false) {
			do {
				num = sc.nextLine();
				if (!num.matches("\\d{1,9}")) {
					System.out.println("Rentrez un Numero de client compris entre 1 et  9 chiffres");
				} else {
					try {
						Client.testeUniciteNumClient(num, lp);
						reussi = true;
					} catch (ErreurSaisie e) {
						throw new ErreurSaisie("le numero rentr� existe d�j�, veuillez en rentrer un nouveau");
					}
				}
			} while (!num.matches("\\d{13}") && reussi == false);
		}
	}

	public static void verifNumeroSecuriteSocial(String num) throws Exception {
		reussi = false;

		while (reussi == false) {

			do {
				num = sc.nextLine();
				if (!num.matches("\\d{13}")) {
					System.out.println("Rentrez un Numero de S�curit� du type X XX XX XX XXX XXX");
				} else {
					try {
						Salarie.testeUniciteSecu(num, lp);
						reussi = true;
					} catch (ErreurSaisie e) {
						System.out.println("le numero rentr� existe d�j�, veuillez en rentrer un nouveau");
					}
				}
			} while (!num.matches("\\d{13}") && reussi == false);
		}
	}

	public static void verifNumeroFournisseur(String num) throws Exception {
		reussi = false;

		while (reussi == false) {
			do {
				num = sc.nextLine();
				if (!num.matches("\\d{1,9}")) {
					System.out.println("Rentrez un Numero de fournisseur compris entre 1 et  9 chiffres");
				} else {
					try {
						Fournisseur.testeUniciteNumFournisseur(num, lp);
						reussi = true;
					} catch (ErreurSaisie e) {
						System.out.println("le numero rentr� existe d�j�, veuillez en rentrer un nouveau");
					}
				}
			} while (!num.matches("\\d{13}") && reussi == false);
		}
	}

}
