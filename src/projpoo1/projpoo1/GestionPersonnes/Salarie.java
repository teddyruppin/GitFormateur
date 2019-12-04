package projpoo1.GestionPersonnes;

import java.util.List;

import projpoo1.Exception.ErreurSaisie;
import projpoo1.GestionCommande.Achat;

public class Salarie extends Personne implements IClient {

	private String Nsecu;
	private String salaire;
	private boolean estClient = true;
	private List<Achat> listeAchat;

	public Salarie(String nom, String prenom, String adresse, String ville, String codepostal, String Nsecu, String salaire) {
		super(nom, prenom, adresse, ville, codepostal);
		this.Nsecu = Nsecu;
		this.salaire = salaire;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Salarié :" + super.toString() + " / Numero de sécurité social=" + Nsecu + " / Salaire du salarié=" + salaire +" €" +"]";
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
	
	public static void testeUniciteSecu (String ns, List<Personne> l) throws ErreurSaisie{
		// boucle for pour se balader dans la liste de personne, condition p pour si on chope un Salarie,
		// condition string ns egal au numero de secu du salarie en castant salarie et p.
			for(Personne p:l) {
				if(p instanceof Salarie) {
					if(ns.equals( ((Salarie)p).getNsecu())) throw new ErreurSaisie("Numéro sécurité existe déjà : "+ ns);
				}
			
			}

	}


	
}