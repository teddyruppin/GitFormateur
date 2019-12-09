package projpoo1.GestionPersonnes;

import java.util.List;
import java.util.Scanner;

import projpoo1.verif.Verifications;

public class Patron extends Salarie implements IPatron {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Patron(String nom, String prenom, String adresse, String ville, String codepostal, String Nsecu,
			String salaire) {
		super(nom, prenom, adresse, ville, codepostal, Nsecu, salaire);

	}

	public static void saisirPatron(Scanner sc, List<Personne> lp) {
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

		System.out.println("Numero de s�curite social? ");
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

		IPatron monPatron = (IPatron) new Patron(nom, prenom, adr, vil, cod, insee, sal);
		System.out.println(monPatron);
		lp.add((Personne) monPatron);

	}

	@Override
	public String toString() {
		return "Patron " + super.toString();
	}

	@Override
	public void embauche() {
		this.embauche();
	}

	@Override
	public void licencie() {
		this.licencie();
	}

	@Override
	public void paieSalarie() {
		this.paieSalarie();
	}

}
