package com.springboot.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Boolean affichepreterit;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateenvoi;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datereponse;

	private String reponseparticipepasse;
	private String reponsepreterit;
	
	@ManyToOne
	@JoinColumn(name = "partie_id")
	private Partie partie;	
	
	@ManyToOne
	@JoinColumn(name = "verbe_id")
	private Verbe verbe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAffichepreterit() {
		return affichepreterit;
	}

	public void setAffichepreterit(Boolean affichepreterit) {
		this.affichepreterit = affichepreterit;
	}

	public Date getDateenvoi() {
		return dateenvoi;
	}

	public void setDateenvoi(Date dateenvoi) {
		this.dateenvoi = dateenvoi;
	}

	public Date getDatereponse() {
		return datereponse;
	}

	public void setDatereponse(Date datereponse) {
		this.datereponse = datereponse;
	}

	public String getReponseparticipepasse() {
		return reponseparticipepasse;
	}

	public void setReponseparticipepasse(String reponseparticipepasse) {
		this.reponseparticipepasse = reponseparticipepasse;
	}

	public String getReponsepreterit() {
		return reponsepreterit;
	}

	public void setReponsepreterit(String reponsepreterit) {
		this.reponsepreterit = reponsepreterit;
	}



	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Verbe getVerbe() {
		return verbe;
	}

	public void setVerbe(Verbe verbe) {
		this.verbe = verbe;
	}




	
	

}
