package gestionWebPersonne.classes;

public class Personne {

	private String nom;
	private String prenom;
	private Integer age;
	
	public Personne() {
		this ("","",null);
	}
	
	public Personne(String nom, String prenom, Integer age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
