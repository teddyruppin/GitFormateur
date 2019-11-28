package projpoo1.GestionPersonnes;

import java.awt.List;

public class Salarie extends Personne implements IClient {

	private String Nsecu;
	private String salaire;

	public Salarie(String nom, String prenom, String adresse, String ville, String codepostal, String Nsecu, String salaire) {
		super(nom, prenom, adresse, ville, codepostal);
		this.Nsecu = Nsecu;
		this.salaire = salaire;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Salarié :" + super.toString() + " / Numero de sécurité social=" + Nsecu + " / Salaire du salarié=" + salaire +" €" +"]";
	}
	


	@Override
	public void achete(List achat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paie() {
		// TODO Auto-generated method stub

	}
	
	public void estClient() {
		
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



	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}

}
