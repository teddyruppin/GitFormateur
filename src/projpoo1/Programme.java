package projpoo1;

import java.util.*;
import java.util.ArrayList;

import projpoo1.MonException;
import projpoo1.GestionPersonnes.Client;
import projpoo1.GestionPersonnes.Fournisseur;
import projpoo1.GestionPersonnes.IClient;
import projpoo1.GestionPersonnes.IFournisseur;
import projpoo1.GestionPersonnes.IPatron;
import projpoo1.GestionPersonnes.Personne;
import projpoo1.GestionPersonnes.Salarie;

public class Programme {

 static boolean reussi = false;
 static Scanner sc = new Scanner(System.in);
 static List<Personne> lp = new ArrayList<Personne>();
 
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
				if (p.getClass().getSimpleName().equals("Client")) {
					System.out.println(p);
				}
			}
			break;
		case "5":
			System.out.println("Voici la liste des salariés" );
			for (Personne p:lp) {
				if (p.getClass().getSimpleName().equals("Salarie")) {
					System.out.println(p);
				}
			}
			break;
		case "6":
			System.out.println("Voici la liste des fournisseurs");
			for (Personne p:lp) {
				if (p.getClass().getSimpleName().equals("Fournisseur")) {
					System.out.println(p);
				}
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
		String nc = sc.nextLine();
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
					Programme.testeUniciteNumClient(nc);
					reussi = true;
				} catch (MonException e) {
					System.out.println("le numero rentré existe déjà, veuillez en rentrer un nouveau");
				}
			}
		} while (!nc.matches("\\d{13}") && reussi==false);
		}
		
		
		//sc.close();
		
		IClient monClient = new Client(nom, prenom, adr, vil, cod, nc);
		System.out.println(monClient);
		lp.add((Personne) monClient);
		
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
					Programme.testeUniciteSecu(insee);
					reussi = true;
				} catch (MonException e) {
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
		
///////////////////////////////////////////////////////////////////		
		
		IPatron monSalarie = (IPatron) new Salarie(nom, prenom, adr, vil, cod, insee, sal);
		System.out.println(monSalarie);
		lp.add((Personne) monSalarie);
	}
///////////////////////////////////////////////////////////////////		
	
	
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
		String nfourni = sc.nextLine();
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
					Programme.testeUniciteNumFournisseur(nfourni);
					reussi = true;
				} catch (MonException e) {
					System.out.println("le numero rentré existe déjà, veuillez en rentrer un nouveau");
				}
			}
		} while (!nfourni.matches("\\d{13}") && reussi==false);
		}
		

		//sc.close();
		
		IFournisseur monFournisseur = new Fournisseur(nom, prenom, adr, vil, cod, nfourni);
		System.out.println(monFournisseur);
		lp.add((Personne) monFournisseur);
	}
	
	

	public static void gereclient(IClient client) {
		client.achete(null);
		client.paie();
		client.estClient();
	}
	
	
	
	public static void testeUniciteSecu (String ns) throws MonException{
		// boucle for pour se balader dans la liste de personne, condition p pour si on chope un Salarie,
		// condition string ns egal au numero de secu du salarie en castant salarie et p.
			for(Personne p:lp) {
				if(p instanceof Salarie) {
					if(ns.equals( ((Salarie)p).getNsecu())) throw new MonException("Numéro sécurité existe déjà : "+ ns);
				}
			}
		
	}
	
	public static void testeUniciteNumClient (String ns) throws MonException{
		// boucle for pour se balader dans la liste de personne, condition p pour si on chope un Client,
		// condition string ns egal au numero de secu du salarie en castant salarie et p.
			for(Personne p:lp) {
				if(p instanceof Client) {
					if(ns.equals( ((Client)p).getNclient())) throw new MonException("Numéro Client existe déjà : "+ ns);
				}
			}
		
	}

	public static void testeUniciteNumFournisseur (String ns) throws MonException{
		// boucle for pour se balader dans la liste de personne, condition p pour si on chope un Fournisseur,
		// condition string ns egal au numero de secu du salarie en castant salarie et p.
			for(Personne p:lp) {
				if(p instanceof Fournisseur) {
					if(ns.equals( ((Fournisseur)p).getNfournisseur())) throw new MonException("Numéro Client existe déjà : "+ ns);
				}
			}
		
	}
}
