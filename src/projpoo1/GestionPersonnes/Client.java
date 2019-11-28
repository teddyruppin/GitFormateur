package projpoo1.GestionPersonnes;

import java.awt.List;
import java.util.Scanner;

public class Client extends Personne implements IFournisseur, IClient {

	private String Nclient;
	static Scanner sc = new Scanner(System.in);
	
	public Client(String nom, String prenom, String adresse, String ville, String codepostal, String Nclient) {
		super(nom, prenom, adresse, ville, codepostal);
		this.Nclient = Nclient;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Client :" + super.toString() + " / Numero client=" + Nclient + "]";
	}

	@Override
	public void livre() {
		// TODO Auto-generated method stub

	}

	@Override
	public void commande() {
		// TODO Auto-generated method stub

	}

	@Override
	public void achete(List achat) {
		// TODO Auto-generated method stub
		System.out.println("Client achete");
		return;

	}

	@Override
	public void paie() {
		// TODO Auto-generated method stub
		System.out.println("Client paie");

	}
	

	

	public String getNclient() {
		return Nclient;
	}


	public void setNclient(String nclient) {
		Nclient = nclient;
	}

	@Override
	public void estClient() {
		// TODO Auto-generated method stub
		String s = sc.nextLine();
		if (s.equals("oui")) {
			System.out.println("le client est un client");
		}
		else 
		{
			System.out.println("le client n'est pas un client");
		}

	}

}
