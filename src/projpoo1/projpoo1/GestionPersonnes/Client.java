package projpoo1.GestionPersonnes;

import java.util.List;
import java.util.Scanner;

import projpoo1.Programme;
import projpoo1.Exception.ErreurSaisie;
import projpoo1.GestionCommande.Achat;
import projpoo1.GestionCommande.Commande;

public class Client extends Personne implements IFournisseur, IClient {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Nclient;
	private boolean estClient;
	private boolean estFournisseur;
	private List<Achat> listeAchat;
	private List<Commande> listeCommande;

	public Client(String nom, String prenom, String adresse, String ville, String codepostal, String Nclient,
			Boolean estClient, Boolean estFournisseur) {
		super(nom, prenom, adresse, ville, codepostal);
		this.Nclient = Nclient;
		this.estClient = estClient;
		this.estFournisseur = estFournisseur;
	}

	public static void creerClient(Scanner sc, List<Personne> lp) {

		System.out.println("Nom? ");
		String nom = sc.nextLine();

		System.out.println("Prenom? ");
		String prenom = sc.nextLine();

		System.out.println("Adresse? ");
		String adr = sc.nextLine();

		System.out.println("Ville? ");
		String vil = sc.nextLine();

		System.out.println("Code postal? ");
		String cod = "";
		try {
			Programme.verifCodePostal(cod);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		System.out.println("Numero de client? ");
		String nc = "";
		try {
			Programme.verifNumeroClient(nc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Etes vous client? true/false ");
		Boolean ec = sc.nextBoolean();
		sc.nextLine();

		System.out.println("Etes vous fournisseur? true/false ");
		Boolean ef = sc.nextBoolean();
		sc.nextLine();

		IClient monClient = new Client(nom, prenom, adr, vil, cod, nc, ec, ef);
		System.out.println(monClient);
		lp.add((Personne) monClient);

	}

	@Override
	public String toString() {
		return "Client :" + super.toString() + " / Numero client=" + Nclient + " / estClient=" + estClient
				+ " / estFournisseur=" + estFournisseur + "]";
	}

	@Override
	public boolean livre() {
		return true;
	}

	@Override
	public void commande(List<Commande> Commande) {
		this.listeCommande = Commande;
	}

	@Override
	public void achete(List<Achat> Achat) {
		this.listeAchat = Achat;
	}

	@Override
	public void paie() {
		this.paie();
	}

	public String getNclient() {
		return Nclient;
	}

	public void setNclient(String nclient) {
		Nclient = nclient;
	}

	@Override
	public boolean estClient() {
		return this.estClient;

	}

	@Override
	public boolean estFournisseur() {
		return this.estFournisseur;
	}

	public List<Achat> getListeAchat() {
		return listeAchat;
	}

	public List<Commande> getListeCommandes() {
		return listeCommande;
	}

	public static void testeUniciteNumClient(String ns, List<Personne> l) throws ErreurSaisie {
		// boucle for pour se balader dans la liste de personne, condition p pour si on
		// chope un Client,
		// condition string ns egal au numero de secu du salarie en castant salarie et
		// p.
		for (Personne p : l) {
			if (p instanceof Client) {
				if (ns.equals(((Client) p).getNclient()))
					throw new ErreurSaisie("Num�ro Client existe d�j� : " + ns);
			}
		}

	}

}
