package projpoo1.GestionPersonnes;

import java.util.List;

import projpoo1.Exception.ErreurSaisie;
import projpoo1.GestionCommande.Achat;
import projpoo1.GestionCommande.Commande;

public class Fournisseur extends Personne implements IClient, IFournisseur {

	private String Nfournisseur;
	private boolean estClient;
	private boolean estFournisseur;
	
	private List<Achat> listeAchat;
	private List<Commande> listeCommande;

	public Fournisseur(String nom, String prenom, String adresse, String ville, String codepostal, String Nfournisseur, Boolean estClient, Boolean estFournisseur) {
		super(nom, prenom, adresse, ville, codepostal);
		this.Nfournisseur = Nfournisseur;
		this.estClient = estClient;
		this.estFournisseur = estFournisseur;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fournisseur :" + super.toString() + " / Numero de fournisseur=" + Nfournisseur + " / estClient= " + estClient + " / estFournisseur= " + estFournisseur +"]";
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
	
	
	public static void testeUniciteNumFournisseur (String ns, List<Personne> l) throws ErreurSaisie{
		// boucle for pour se balader dans la liste de personne, condition p pour si on chope un Fournisseur,
		// condition string ns egal au numero de secu du salarie en castant salarie et p.
			for(Personne p:l) {
				if(p instanceof Fournisseur) {
					if(ns.equals( ((Fournisseur)p).getNfournisseur())) throw new ErreurSaisie("Numéro Client existe déjà : "+ ns);
				}
			}
		
	}





}
