package projetJUNIT4_01.classes;

import java.util.Date;

public class Personne {
	private String nom;
	private String prenom;
	private Date dateDaissance;
	private Integer age;

	public Personne(String nom, String prenom, Date dateDaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDaissance = dateDaissance;
		this.age = 0;
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

	public Date getDateDaissance() {
		return dateDaissance;
	}

	public Integer getAge() {
		return age;
	}

	
}
