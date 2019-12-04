package projpoo1.GestionPersonnes;

public class Patron extends Salarie implements IPatron {
	
	private String Nsecu;
	private String salaire;

	public Patron(String nom, String prenom, String adresse, String ville, String codepostal, String Nsecu, String salaire) {
		super(nom, prenom, adresse, ville, codepostal, Nsecu, salaire);
		this.Nsecu = Nsecu;
		this.salaire = salaire;
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "Patron " + super.toString() + "[Nsecu=" + Nsecu + ", salaire=" + salaire + "]";
	}



	@Override
	public void embauche() {
		// TODO Auto-generated method stub
		this.embauche();
	}

	@Override
	public void licencie() {
		// TODO Auto-generated method stub
		this.licencie();
	}

	@Override
	public void paieSalarie() {
		// TODO Auto-generated method stub
		this.paieSalarie();
	}

}
