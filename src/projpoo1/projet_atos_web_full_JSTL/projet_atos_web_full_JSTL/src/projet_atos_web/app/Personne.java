package projet_atos_web.app;
/**
 * 
 * @author Administrateur
 * Une classe de type "Bean" possède que des données privés 
 * avec des getter et des setter
 * et aussi un constructeur sans paramètre
 */
public class Personne {
	private String nom;
	private String prenom;
	/**
	 * Constructeur Personne sans paramètre avec initialisation des données
	 * privées 
	 */
	public Personne() {
		// TODO Auto-generated constructor stub
		this.nom = "Nom par défaut";
		this.prenom = "Prénom par défaut";
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
