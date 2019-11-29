package projpoo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import projpoo1.Exception.ErreurSaisie;
import projpoo1.GestionCommande.Achat;
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
 static List<IClient> lic = new ArrayList<IClient>();

 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		while (x == false) {
		
		System.out.println("rentrer un client : 1" );
		System.out.println("rentrer un salarié : 2" );
		System.out.println("rentrer un fournisseur : 3" );
		System.out.println("liste clients : 4" );
		System.out.println("liste salariés : 5" );
		System.out.println("liste fournisseurs : 6" );
		System.out.println("saisir un PATRON : 7");
		System.out.println("afficher un PATRON : 8");
		System.out.println("liste IClient : 9");
		System.out.println("saisir achat pour un IClient : 10");

		
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
			System.out.println("saisir achat pour un IClient");
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
//////////////////////////////////////////////////////////
		

	
	public static void achatClient(IClient cl) {
		boolean sorti = false;
		la.clear();
		while (sorti == false) {
			System.out.println("Nom de l'article? ");
			String nom = sc.nextLine();

			System.out.println("Quantite de l'article? ");
			int qte = sc.nextInt();
		
			System.out.println("Date de l'achat? ");
			String date = sc.next();
			
			Achat monAchat = new Achat(nom, qte, date); 
			System.out.println(monAchat);
			la.add((Achat)monAchat);
			
			System.out.println("avez vous d'autres achats a faire? oui/non");
			String st = sc.next();
			if (st.equals("non")) {
				sorti = true;
			}
			
		}
		cl.achete(la);
	}
	

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
		

				
		
	

	

	public static void gereclient(IClient client) {
		client.achete(null);
		client.paie();
		client.estClient();
	}

}
