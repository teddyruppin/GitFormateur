package projpoo1.GestionPersonnes;

import java.util.List;
import java.util.Scanner;

import projpoo1.Exception.ErreurSaisie;
import projpoo1.GestionCommande.Achat;
import projpoo1.GestionCommande.Commande;

public class Client extends Personne implements IFournisseur, IClient {

	private String Nclient;
	private boolean estClient;
	private boolean estFournisseur;
	//private boolean paie;
	private List<Achat> listeAchat;
	private List<Commande> listeCommande;

	static Scanner sc = new Scanner(System.in);
	
	public Client(String nom, String prenom, String adresse, String ville, String codepostal, String Nclient, Boolean estClient, Boolean estFournisseur) {
		super(nom, prenom, adresse, ville, codepostal);
		this.Nclient = Nclient;
		this.estClient = estClient;
		this.estFournisseur = estFournisseur;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Client :" + super.toString() + " / Numero client=" + Nclient + " / estClient=" + estClient +  " / estFournisseur=" + estFournisseur + "]";
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
		// TODO Auto-generated method stub
		System.out.println("OK paiement");
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
		// TODO Auto-generated method stub
		return this.estFournisseur;
	}
	
	
	public List<Achat> getListeAchat() {
		return listeAchat;
	}
	
	public List<Commande> getListeCommandes(){
		return listeCommande;
	}
	
	
	public static void testeUniciteNumClient (String ns, List<Personne> l) throws ErreurSaisie{
		// boucle for pour se balader dans la liste de personne, condition p pour si on chope un Client,
		// condition string ns egal au numero de secu du salarie en castant salarie et p.
			for(Personne p:l) {
				if(p instanceof Client) {
					if(ns.equals( ((Client)p).getNclient())) throw new ErreurSaisie("Num�ro Client existe d�j� : "+ ns);
				}
			}
		
	}

}
