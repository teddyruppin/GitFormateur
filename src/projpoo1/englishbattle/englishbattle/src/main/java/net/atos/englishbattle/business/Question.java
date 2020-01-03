package net.atos.englishbattle.business;

import java.util.Date;

public class Question {

	// L'id peut être null car la question n'a pas encore été 
	// enregistrée en base de données
	private Long id;
	
	// Quel est le verbe demandé pour
	// cette question ?
	private Verbe verbe;
	
	// A quelle partie appartient cette
	// question ?
	private Partie partie;
	
	// A quelle date et heure la question
	// a été envoyée ?
	private Date dateEnvoi;
	
	// A quelle date et heure le joueur
	// a donné ses réponses ?
	private Date dateReponse;
	
	// Quelle réponse pour le prétérit
	// le joueur a donné ?
	private String reponsePreterit;
	private String reponseParticipePasse;
	private static Long compteur = 0L;
	
	// Pour chaque question, si le joueur n'est pas expert, on doit dévoiler soit le prétérit soit le participe passé
	// il faut retenir ce choix dans un nouvel attribut
	private Boolean affichePreterit = null;
	
	public Question() {
		id = ++compteur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Verbe getVerbe() {
		return verbe;
	}

	public void setVerbe(Verbe verbe) {
		this.verbe = verbe;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public Date getDateReponse() {
		return dateReponse;
	}

	public void setDateReponse(Date dateReponse) {
		this.dateReponse = dateReponse;
	}

	public String getReponsePreterit() {
		return reponsePreterit;
	}

	public void setReponsePreterit(String reponsePreterit) {
		this.reponsePreterit = reponsePreterit;
	}

	public String getReponseParticipePasse() {
		return reponseParticipePasse;
	}

	public void setReponseParticipePasse(String reponseParticipePasse) {
		this.reponseParticipePasse = reponseParticipePasse;
	}

	public long getTempsDeReponseEnMillisecondes()
	{
		return getDateReponse().getTime()-getDateEnvoi().getTime();
	}
	
	public Boolean getAffichePreterit() {
		return affichePreterit;
	}

	public void setAffichePreterit(Boolean affichePreterit) {
		this.affichePreterit = affichePreterit;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", verbe=" + verbe + ", partie=" + partie.getId() + ", dateEnvoi=" + dateEnvoi
				+ ", dateReponse=" + dateReponse + ", reponsePreterit=" + reponsePreterit + ", reponseParticipePasse="
				+ reponseParticipePasse + "]";
	}	
}
