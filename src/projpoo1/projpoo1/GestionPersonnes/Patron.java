package projpoo1.GestionPersonnes;

import java.util.List;
import java.util.Scanner;

import projpoo1.Programme;

public class Patron extends Salarie implements IPatron {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Nsecu;
	private String salaire;

	public Patron(String nom, String prenom, String adresse, String ville, String codepostal, String Nsecu,
			String salaire) {
		super(nom, prenom, adresse, ville, codepostal, Nsecu, salaire);
		this.Nsecu = Nsecu;
		this.salaire = salaire;
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
			Programme.verifCodePostal(cod);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		System.out.println("Numero de s�curite social? ");
		String insee = "";
		try {
			Programme.verifNumeroSecuriteSocial(insee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Salaire? (avec une ',')");
		String sal = "";
		try {
			Programme.verifSalaire(sal);
		} catch (Exception e) {
			e.printStackTrace();
		}

		IPatron monPatron = (IPatron) new Patron(nom, prenom, adr, vil, cod, insee, sal);
		System.out.println(monPatron);
		lp.add((Personne) monPatron);

	}

	@Override
	public String toString() {
		return "Patron " + super.toString() + "[Nsecu=" + Nsecu + ", salaire=" + salaire + "]";
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
