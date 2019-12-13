package com.filrouge.poe.lyon.JPAPOE.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "vehicule")
public class Voiture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "modele", length = 50, nullable = false)
	private String modele;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_creation", nullable = false)
	private Date date;
	
	@Column(name = "quantite", length = 50, nullable = false)
	private int qte;
	
	@Column(name = "prixHt", length = 50, nullable = false, columnDefinition = "0.0")
	private float prix;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", modele=" + modele + ", date=" + date + ", qte=" + qte + ", prix=" + prix + "]";
	}
	
	
	
}
