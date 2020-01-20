package spring004web.controller;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


public class CreationFormEleve {

	@NotEmpty
	private String nom;
	
	@NotEmpty
	private String prenom;
	
	@NotEmpty
	private String classe;
	
	@NotEmpty
	private String date;
	
	@NotEmpty
	private String adresse;
	
	@NotEmpty
	@Pattern(regexp = "HOMME|FEMME")
	private String sexe;

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

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	
}
