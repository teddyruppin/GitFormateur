package projpoo1.GestionAchatCommande;

import java.util.Date;

public class Achat {

	private String intitule;
	private int quantite;
	private Date date;
	
	
	public Achat(String intitule, int quantite, Date date) {
		super();

		this.intitule = intitule;
		this.quantite = quantite;
		this.date = date;
	}
	
	

	@Override
	public String toString() {
		return "Achat [intitule=" + intitule + ", quantite=" + quantite + ", date=" + date + "]";
	}



	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getIntitule() {
		return intitule;
	}
	
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	public int getQuantite() {
		return quantite;
	}
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	/*
	public void verifDate(String date) throws Exception {
		if () {
			
		}
		
	}*/

	

}
