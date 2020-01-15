package com.springboot.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name="t_notes")
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idnotes")
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_saisie")
	private Date date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ideleve")
	private Eleve eleve;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idclasse")
	private Classe classe;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idmatiere")
	private Matiere matiere;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idprof")
	private Professeur prof;
	
	private Integer idtrimestre;
	
	private Integer note;
	
	@Lob
	@Column(name="avis" ,columnDefinition = "TEXT")
	private String avis;

	private Float avancement;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Professeur getProf() {
		return prof;
	}

	public void setProf(Professeur prof) {
		this.prof = prof;
	}

	public Integer getIdtrimestre() {
		return idtrimestre;
	}

	public void setIdtrimestre(Integer idtrimestre) {
		this.idtrimestre = idtrimestre;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public Float getAvancement() {
		return avancement;
	}

	public void setAvancement(Float avancement) {
		this.avancement = avancement;
	}

	
	

}
