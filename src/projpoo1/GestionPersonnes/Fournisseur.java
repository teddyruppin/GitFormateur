package projpoo1.GestionPersonnes;

import java.awt.List;

public class Fournisseur extends Personne implements IClient, IFournisseur {

	private String Nfournisseur;

	public Fournisseur(String nom, String prenom, String adresse, String ville, String codepostal, String Nfournisseur) {
		super(nom, prenom, adresse, ville, codepostal);
		this.Nfournisseur = Nfournisseur;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fournisseur :" + super.toString() + " / Numero de fournisseur=" + Nfournisseur + "]";
	}

	@Override
	public void achete(List achat) {
		// TODO Auto-generated method stub
		System.out.println("Fournisseur achete");

	}

	@Override
	public void paie() {
		// TODO Auto-generated method stub
		System.out.println("Fournisseur paie");

	}

	@Override
	public void livre() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commande() {
		// TODO Auto-generated method stub
		
	}
	

	
	public String getNfournisseur() {
		return Nfournisseur;
	}


	public void setNfournisseur(String nfournisseur) {
		Nfournisseur = nfournisseur;
	}

	@Override
	public void estClient() {
		// TODO Auto-generated method stub
		System.out.println("le fournisseur est un client");
		
	}
	

}
