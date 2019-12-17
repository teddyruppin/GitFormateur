package com.filrouge.poe.lyon.JPAPOE.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "DEVIS")
@NamedQueries(value = { @NamedQuery(name = "Devis.findAll", query = "SELECT d from Devis AS d"),
		@NamedQuery(name = "ByIClient", query = "SELECT d FROM Devis AS d WHERE d.client.id like ?1") })

public class Devis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/*
	 * on decrit une jointure objet entre la colonne Id_client et le beans client
	 * avec sa clé KP @Id
	 */

	@ManyToOne
	@JoinColumn(name = "ID_CLIENT", nullable = false)
	private Client client;

	@ManyToOne
	@JoinColumn(name = "ID_VEHICULE", nullable = false)
	private Voiture vehicule;

	@ManyToOne
	@JoinColumn(name = "ID_USER", nullable = false)
	private User user;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_CREATION", nullable = false)
	private Date date_Creation;

	@Column(name = "etatdevis", nullable = false)
	private Boolean etatDevis;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voiture getVehicule() {
		return vehicule;
	}

	public void setVehicule(Voiture vehicule) {
		this.vehicule = vehicule;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate_Creation() {
		return date_Creation;
	}

	public void setDate_Creation(Date date_Creation) {
		this.date_Creation = date_Creation;
	}

	public Boolean getEtatDevis() {
		return etatDevis;
	}

	public void setEtatDevis(Boolean etatDevis) {
		this.etatDevis = etatDevis;
	}

	@Override
	public String toString() {
		return "Devis [id=" + id + ", client=" + client + ", vehicule=" + vehicule + ", user=" + user
				+ ", date_Creation=" + date_Creation + ", etatDevis=" + etatDevis + "]";
	}
	
	

}
