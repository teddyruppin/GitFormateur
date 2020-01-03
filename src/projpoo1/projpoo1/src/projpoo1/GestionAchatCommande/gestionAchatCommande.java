package projpoo1.GestionAchatCommande;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import projpoo1.GestionPersonnes.IClient;
import projpoo1.GestionPersonnes.IFournisseur;
import projpoo1.GestionPersonnes.Personne;
import projpoo1.verif.Verifications;

public class gestionAchatCommande {

	public static Scanner sc = new Scanner(System.in);

	static List<Achat> la = new ArrayList<Achat>();
	static List<Personne> lp = new ArrayList<Personne>();
	static List<Commande> lco = new ArrayList<Commande>();
	static List<IClient> lic = new ArrayList<IClient>();
	static List<IFournisseur> lif = new ArrayList<IFournisseur>();

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
				dt = Verifications.verifDate(date);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Achat monAchat = new Achat(nom, qte, dt);
			System.out.println(monAchat + "\n");
			la.add((Achat) monAchat);

			System.out.println("avez vous d'autres achats a faire? oui/non");
			String st = sc.next();
			System.out.println(monAchat);
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
				dt = Verifications.verifDate(date);
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

}
