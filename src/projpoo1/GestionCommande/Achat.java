package projpoo1.GestionCommande;

public class Achat {

	private String intitule;
	private int quantite;
	private String date;
	
	
	public Achat(String intitule, int quantite, String date) {
		super();

		this.intitule = intitule;
		this.quantite = quantite;
		this.date = date;
	}
	
	

	@Override
	public String toString() {
		return "Achat [intitule=" + intitule + ", quantite=" + quantite + ", date=" + date + "]";
	}



	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
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

	

}
