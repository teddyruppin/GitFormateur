package projpoo1.GestionPersonnes;

import java.util.List;
import java.util.Scanner;

import projpoo1.Exception.ErreurSaisie;
import projpoo1.GestionAchatCommande.Achat;
import projpoo1.GestionAchatCommande.Commande;
import projpoo1.verif.Verifications;

public class Fournisseur extends Personne implements IClient, IFournisseur {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Nfournisseur;
	private boolean estClient;
	private boolean estFournisseur;

	private List<Achat> listeAchat;
	private List<Commande> listeCommande;

	public Fournisseur(String nom, String prenom, String adresse, String ville, String codepostal, String Nfournisseur,
			Boolean estClient, Boolean estFournisseur) {
		super(nom, prenom, adresse, ville, codepostal);
		this.Nfournisseur = Nfournisseur;
		this.estClient = estClient;
		this.estFournisseur = estFournisseur;
		// TODO Auto-generated constructor stub
	}

	public static void creerFournisseur(Scanner sc, List<Personne> lp) {

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
			cod = Verifications.verifCodePostal();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		System.out.println("Numero de fournisseur? ");
		String nfourni = "";
		try {
			nfourni = Verifications.verifNumeroFournisseur();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("�tes vous client? true/false ");
		Boolean ec = sc.nextBoolean();
		sc.nextLine();

		System.out.println("�tes vous fournisseur? true/false ");
		Boolean ef = sc.nextBoolean();
		sc.nextLine();

		IFournisseur monFournisseur = new Fournisseur(nom, prenom, adr, vil, cod, nfourni, ec, ef);
		System.out.println(monFournisseur);
		lp.add((Personne) monFournisseur);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fournisseur :" + super.toString() + " / Numero de fournisseur=" + Nfournisseur + " / estClient= "
				+ estClient + " / estFournisseur= " + estFournisseur + "]";
	}

	@Override
	public void achete(List<Achat> Achat) {
		this.listeAchat = Achat;
	}

	@Override
	public void paie() {
		this.paie();
	}

	@Override
	public boolean livre() {
		return true;
	}

	@Override
	public void commande(List<Commande> Commande) {
		this.listeCommande = Commande;

	}

	public String getNfournisseur() {
		return Nfournisseur;
	}

	public void setNfournisseur(String nfournisseur) {
		Nfournisseur = nfournisseur;
	}

	@Override
	public boolean estClient() {
		return estClient;

	}

	@Override
	public boolean estFournisseur() {
		return this.estFournisseur;
	}

	public List<Commande> getListeCommandes() {
		return listeCommande;
	}

	public List<Achat> getListeAchat() {
		return listeAchat;
	}

	public static void testeUniciteNumFournisseur(String ns, List<Personne> l) throws ErreurSaisie {
		// boucle for pour se balader dans la liste de personne, condition p pour si on
		// chope un Fournisseur,
		// condition string ns egal au numero de secu du salarie en castant salarie et
		// p.
		for (Personne p : l) {
			if (p instanceof Fournisseur) {
				if (ns.equals(((Fournisseur) p).getNfournisseur()))
					throw new ErreurSaisie("Num�ro Fournisseur existe d�j� : " + ns);
			}
		}

	}

}
