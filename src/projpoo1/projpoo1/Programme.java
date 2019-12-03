package projpoo1;

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
import projpoo1.GestionPersonnes.IPatron;
import projpoo1.GestionPersonnes.Patron;
import projpoo1.GestionPersonnes.Personne;
import projpoo1.GestionPersonnes.Salarie;

public class Programme {

 static boolean reussi = false;
 static Scanner sc = new Scanner(System.in);
 static List<Personne> lp = new ArrayList<Personne>();
 static List<Achat> la = new ArrayList<Achat>();
 static List<Commande> lco = new ArrayList<Commande>();
 static List<IClient> lic = new ArrayList<IClient>();
 static List<IFournisseur> lif = new ArrayList<IFournisseur>();

 
	public static void main(String[] args) {
		/**
		IClient cl1 = new Client("cl1","CL1","","","","","","","");
		IClient cl2 = new Fournisseur("fo1","FO1","","","","","","","");
		Personne p1 = new Client("cl2","CL","","","","","","","");
		Salarie s1 = new Salarie("sa1","SA1","","","","","","","");
		
		Programme.gereclient(cl1);
		Programme.gereclient(cl2);
		
		List<Personne> lp = new ArrayList<Personne>();
		lp.add((Client)cl1);
		lp.add((Fournisseur)cl2);
		lp.add(p1);
		lp.add(s1);
		
		for (Personne p:lp) {
			System.out.println(p);
		}
		*/
		
		
		boolean x = false;
		String persC = "";
		String persF = "";

		
		while (x == false) {
		
		System.out.println("1 : rentrer un client" );
		System.out.println("2 : rentrer un salarié" );
		System.out.println("3 : rentrer un fournisseur" );
		System.out.println("4 : liste clients" );
		System.out.println("5 : liste salariés" );
		System.out.println("6 : liste fournisseurs" );
		System.out.println("7 : saisir un PATRON");
		System.out.println("8 : afficher un PATRON");
		System.out.println("9 : liste IClient");
		System.out.println("10 : saisir achat pour un IClient");
		System.out.println("11 : afficher la liste d'achat avec le client");
		System.out.println("12 : liste IFournisseur");
		System.out.println("13 : saisir commande pour un IFournisseur");
		System.out.println("14 : afficher la liste des commandes avec le fournisseur");

		
		System.out.println("Choix? ");
		String choix = sc.nextLine();
		
		
		switch (choix) {
		
		case "1":
			System.out.println("Vous voulez ajouter un client" );
			Programme.creerClient();
			break;
			
		case "2":
			System.out.println("Vous voulez ajouter un salarie" );
			Programme.creerSalarier();
			break;
			
		case "3":
			System.out.println("Vous voulez ajouter un fournisseur");
			Programme.creerFournisseur();
			break;
			
		case "4":
			System.out.println("Voici la liste des clients" );
			for (Personne p:lp) {
				if (p instanceof Client) {
					System.out.println(p);
				}
			}
			break;
			
		case "5":
			System.out.println("Voici la liste des salariés" );
			for (Personne p:lp) {
				if (p instanceof Salarie) {
					System.out.println(p);
				}
			}
			break;
			
		case "6":
			System.out.println("Voici la liste des fournisseurs");
			for (Personne p:lp) {
				if (p instanceof Fournisseur) {
					System.out.println(p);
				}
			}
			break;
			
		case "7":
			System.out.println("Saisissez un nouveau patron");
			for (Personne p:lp) {
				if (p instanceof Patron) {
					lp.remove(p);
					break;
				}
			}
			Programme.saisirPatron();
			break;	
			
		case "8":
			System.out.println("Voici le patron");
			for (Personne p:lp) {
				if (p instanceof Patron) {
					System.out.println(p);
				}
			}
			break;
			
		case "9":
			System.out.println("Voici la liste des IClient");
			for (Personne p:lp) {
				if (p instanceof IClient) {
					if (((IClient) p).estClient()==true) {
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
			for (Personne p:lp) {
				if (p instanceof IClient) {
					Personne cln = (Personne) p;
					if (((IClient) p).estClient()==true) {
						if (persC.equals(cln.getNom())){	
							achatClient((IClient)p);
							System.out.println(p);
							System.out.println("pour Monsieur ou Madame: " + persC);

							}
						}
					}
				}
			break;
			
		case "11":
			for (Achat p:la) {
							System.out.println(p);
							System.out.println("pour Monsieur ou Madame: " + persC);
					}
			break;
			
		case "12":
			System.out.println("Voici la liste des IFournisseur");
			for (Personne p:lp) {
				if (p instanceof IFournisseur) {
					if (((IFournisseur) p).estFournisseur()==true) {
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
			for (Personne p:lp) {
				if (p instanceof IFournisseur) {
					Personne frn = (Personne) p;
					if (((IFournisseur) p).estFournisseur()==true) {
						if (persF.equals(frn.getNom())){	
							commandeFournisseur((IFournisseur)frn);
							System.out.println(p);
							System.out.println("pour Monsieur ou Madame: " + persF);
							}
						}
					}
				}
			break;
			
		case "14":
			for (Commande p:lco) {
							System.out.println(p);
							System.out.println("pour Monsieur ou Madame: " + persF);
					}
			break;
			
		default:
			System.out.println("Rentrer une valeur proposée");
			break;
			
			
		}
		


		System.out.println("voulez vous arreter le programme oui/non");
		String arret = sc.nextLine();
		
		if ( arret.equals("oui")) {
			x = true;
		}
		}
		System.out.println("FIN DU PROGRAMME");
	}
	
	// 1
	public static void creerClient() {
		//Scanner sc = new Scanner(System.in);

		System.out.println("Nom? ");
		String nom = sc.nextLine();

		System.out.println("Prenom? ");
		String prenom = sc.nextLine();
	
		System.out.println("Adresse? ");
		String adr = sc.nextLine();

		System.out.println("Ville? ");
		String vil = sc.nextLine();

		System.out.println("Code postal? ");
		String cod;
		do {
			cod = sc.nextLine();
			if (!cod.matches("\\d{1,5}")){
				System.out.println("Rentrez un code postal du type XXXXX");
			}
		} while (!cod.matches("\\d{1,5}"));
	
		
		System.out.println("Numero de client? ");
		String nc = "";
		reussi = false;
		while (reussi==false) {			
		do {
			nc = sc.nextLine();
			if (!nc.matches("\\d{1,9}")){
				System.out.println("Rentrez un Numero de client compris entre 1 et  9 chiffres");
			}
			else
			{
				try {
					Client.testeUniciteNumClient(nc, lp);
					reussi = true;
				} catch (ErreurSaisie e) {
					System.out.println("le numero rentré existe déjà, veuillez en rentrer un nouveau");
				}
			}
		} while (!nc.matches("\\d{13}") && reussi==false);
		}
		
		
		System.out.println("êtes vous client? true/false ");
		Boolean ec = sc.nextBoolean();
		sc.nextLine();
		
		System.out.println("êtes vous fournisseur? true/false ");
		Boolean ef = sc.nextBoolean();
		sc.nextLine();
		
		IClient monClient = new Client(nom, prenom, adr, vil, cod, nc, ec, ef);
		System.out.println(monClient);
		lp.add((Personne) monClient);
		
	}
	
	
//////////////////////////////////////////////////////////
	
	

		

	
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
			la.add((Achat)monAchat);
			
			System.out.println("avez vous d'autres achats a faire? oui/non");
			String st = sc.next();
			if (st.equals("non")) {
				sorti = true;
			}
		}
		cl.achete(la);
	}
	
	
	
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
			lco.add((Commande)maCommande);
			
			System.out.println("avez vous d'autres commande a faire? oui/non");
			String st = sc.next();
			if (st.equals("non")) {
				sorti = true;
			}
		}
		fr.commande(lco);
	}
	
	
	
	
	
//////////////////////////////////////////////////////////

	

	// 2
	public static void creerSalarier() {
		//Scanner sc = new Scanner(System.in);
		System.out.println("Nom? ");
		String nom = sc.nextLine();

		System.out.println("Prenom? ");
		String prenom = sc.nextLine();
	
		System.out.println("Adresse? ");
		String adr = sc.nextLine();

		System.out.println("Ville? ");
		String vil = sc.nextLine();

		System.out.println("Code postal? ");
		String cod = sc.nextLine();
		do {
			cod = sc.nextLine();
			if (!cod.matches("\\d{1,5}")){
				System.out.println("Rentrez un code postal du type XXXXX");
			}
		} while (!cod.matches("\\d{1,5}"));
		
		
	
		
		System.out.println("Numero de sécurite social? ");
		String insee="";
		reussi = false;
		
		while (reussi==false) {
			
		do {
			insee = sc.nextLine();
			if (!insee.matches("\\d{13}")){
				System.out.println("Rentrez un Numero de Sécurité du type X XX XX XX XXX XXX");
			}
			else
			{
				try {
					Salarie.testeUniciteSecu(insee,lp);
					reussi = true;
				} catch (ErreurSaisie e) {
					System.out.println("le numero rentré existe déjà, veuillez en rentrer un nouveau");
				}
			}
		} while (!insee.matches("\\d{13}") && reussi==false);
		}
		

		
		System.out.println("Salaire? (avec une ',')");
		String sal;
		
		do {
			sal = sc.nextLine();
			if (!sal.matches("\\d{1,9}\\,\\d{2}€")){
				System.out.println("Rentrez un salaire du type XXXXX,XX €");
			}
		} while (!sal.matches("\\d{1,9}\\,\\d{2}€"));
		
		//sc.close();
		
		
		IPatron monSalarie = (IPatron) new Salarie(nom, prenom, adr, vil, cod, insee, sal);
		System.out.println(monSalarie);
		lp.add((Personne) monSalarie);
	}
	
	
	// 3
	public static void creerFournisseur() {
		//Scanner sc = new Scanner(System.in);
		System.out.println("Nom? ");
		String nom = sc.nextLine();

		System.out.println("Prenom? ");
		String prenom = sc.nextLine();
	
		System.out.println("Adresse? ");
		String adr = sc.nextLine();

		System.out.println("Ville? ");
		String vil = sc.nextLine();

		System.out.println("Code postal? ");
		String cod;
		do {
			cod = sc.nextLine();
			if (!cod.matches("\\d{1,5}")){
				System.out.println("Rentrez un code postal du type XXXXX");
			}
		} while (!cod.matches("\\d{1,5}"));

		
		System.out.println("Numero de fournisseur? ");
		String nfourni = "";
		reussi = false;

		while (reussi==false) {			
		do {
			nfourni = sc.nextLine();
			if (!nfourni.matches("\\d{1,9}")){
				System.out.println("Rentrez un Numero de fournisseur compris entre 1 et  9 chiffres");
			}
			else
			{
				try {
					Fournisseur.testeUniciteNumFournisseur(nfourni, lp);
					reussi = true;
				} catch (ErreurSaisie e) {
					System.out.println("le numero rentré existe déjà, veuillez en rentrer un nouveau");
				}
			}
		} while (!nfourni.matches("\\d{13}") && reussi==false);
		}
		
		System.out.println("êtes vous client? true/false ");
		Boolean ec = sc.nextBoolean();
		sc.nextLine();
		
		System.out.println("êtes vous fournisseur? true/false ");
		Boolean ef = sc.nextBoolean();
		sc.nextLine();
		

		//sc.close();
		
		IFournisseur monFournisseur = new Fournisseur(nom, prenom, adr, vil, cod, nfourni, ec, ef);
		System.out.println(monFournisseur);
		lp.add((Personne) monFournisseur);
	}
	
	
	public static void saisirPatron() {
		System.out.println("Nom? ");
		String nom = sc.nextLine();

		System.out.println("Prenom? ");
		String prenom = sc.nextLine();
	
		System.out.println("Adresse? ");
		String adr = sc.nextLine();

		System.out.println("Ville? ");
		String vil = sc.nextLine();

		System.out.println("Code postal? ");
		String cod;
		do {
			cod = sc.nextLine();
			if (!cod.matches("\\d{1,5}")){
				System.out.println("Rentrez un code postal du type XXXXX");
			}
		} while (!cod.matches("\\d{1,5}"));
		
		
		System.out.println("Numero de sécurite social? ");
		String insee="";
		reussi = false;
		
		while (reussi==false) {
			
		do {
			insee = sc.nextLine();
			if (!insee.matches("\\d{13}")){
				System.out.println("Rentrez un Numero de Sécurité du type X XX XX XX XXX XXX");
			}
			else
			{
				try {
					Salarie.testeUniciteSecu(insee,lp);
					reussi = true;
				} catch (ErreurSaisie e) {
					System.out.println("le numero rentré existe déjà, veuillez en rentrer un nouveau");
				}
			}
		} while (!insee.matches("\\d{13}") && reussi==false);
		}
		

		
		System.out.println("Salaire? (avec une ',')");
		String sal;
		
		do {
			sal = sc.nextLine();
			if (!sal.matches("\\d{1,9}\\,\\d{2}€")){
				System.out.println("Rentrez un salaire du type XXXXX,XX €");
			}
		} while (!sal.matches("\\d{1,9}\\,\\d{2}€"));
		
		
		IPatron monPatron = (IPatron) new Patron(nom, prenom, adr, vil, cod, insee, sal);
		System.out.println(monPatron);
		lp.add((Personne) monPatron);
		

	}
		

	public static Date verifDate(String date) throws Exception {
		
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd/MM/yyyy");
		format.setLenient(false);
		Date date1 = format.parse(date);
		return date1;
	}
			
	

	public static void gereclient(IClient client) {
		client.achete(null);
		client.paie();
		client.estClient();
	}

}
