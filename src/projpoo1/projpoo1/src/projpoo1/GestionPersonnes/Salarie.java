package projpoo1.GestionPersonnes;

import java.util.List;
import java.util.Scanner;

import projpoo1.Exception.ErreurSaisie;
import projpoo1.GestionAchatCommande.Achat;
import projpoo1.verif.Verifications;

public class Salarie extends Personne implements IClient, IPatron {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Nsecu;
	private String salaire;
	private boolean estClient = true;
	private List<Achat> listeAchat;

	public Salarie(String nom, String prenom, String adresse, String ville, String codepostal, String Nsecu,
			String salaire) {
		super(nom, prenom, adresse, ville, codepostal);
		this.Nsecu = Nsecu;
		this.salaire = salaire;
	}

	public static void creerSalarier(Scanner sc, List<Personne> lp) {
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

		System.out.println("Numero de sécurite social? ");
		String insee = "";
		try {
			insee = Verifications.verifNumeroSecuriteSocial();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Salaire? (avec une ',')");
		String sal = "";
		try {
			sal = Verifications.verifSalaire();
		} catch (Exception e) {
			e.printStackTrace();
		}

		IPatron monSalarie = (IPatron) new Salarie(nom, prenom, adr, vil, cod, insee, sal);
		System.out.println(monSalarie);
		lp.add((Personne) monSalarie);
	}

	@Override
	public String toString() {
		return "Salarié :" + super.toString() + " / Numero de sécurité social = " + Nsecu + " / Salaire du salarié = "
				+ salaire + " €" + "]";
	}

	@Override
	public void achete(List<Achat> Achat) {
		this.listeAchat = Achat;
	}

	@Override
	public void paie() {
		System.out.println("OK paiement");
		this.paie();
	}

	public boolean estClient() {
		return this.estClient;
	}

	public String getNsecu() {
		return Nsecu;
	}

	public void setNsecu(String nsecu) {
		Nsecu = nsecu;
	}

	public String getSalaire() {
		return salaire;
	}

	public List<Achat> getListeAchat() {
		return listeAchat;
	}

	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}

	public static void testeUniciteSecu(String ns, List<Personne> l) throws ErreurSaisie {
		// boucle for pour se balader dans la liste de personne, condition p pour si on
		// chope un Salarie,
		// condition string ns egal au numero de secu du salarie en castant salarie et
		// p.
		for (Personne p : l) {
			if (p instanceof Salarie) {
				if (ns.equals(((Salarie) p).getNsecu()))
					throw new ErreurSaisie("Num�ro s�curit� existe d�j� : " + ns);
			}

		}

	}

	@Override
	public void embauche() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paieSalarie() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void licencie() {
		// TODO Auto-generated method stub
		
	}

}