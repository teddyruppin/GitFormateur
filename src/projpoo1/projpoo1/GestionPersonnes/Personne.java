package projpoo1.GestionPersonnes;

import java.io.Serializable;

/**
 * 
 * @author Teddy RUPPIN
 * @version 1.0
 * <b> JavaDoc pour la POE lYON 2019 </b>
 *
 */

public class Personne implements Serializable {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String nom;
		private String prenom;
		private String adresse;
		private String ville;
		private String codepostal;

		
		/**
		 * Constructeur de la classe Personne
		 * 
		 * @param nom
		 * @param prenom
		 * @param adresse
		 * @param ville
		 * @param codepostal
		 * 
		 */
			
		public Personne(String nom, String prenom, String adresse, String ville, String codepostal) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.adresse = adresse;
			this.ville = ville;
			this.codepostal = codepostal;



		}

		@Override
		public String toString() {
			return "Personne [Nom=" + nom + " / Prenom=" + prenom + " / Adresse=" + adresse + " / Ville=" + ville
					+ " / Code postal=" + codepostal;
		}



		/**
		 * 
		 * @return <b> retourne le nom </b>
		 */
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

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getVille() {
			return ville;
		}

		public void setVille(String ville) {
			this.ville = ville;
		}

		public String getCodepostal() {
			return codepostal;
		}

		public void setCodepostal(String codepostal) {
			this.codepostal = codepostal;
		}		
/*
		public static void testeUnicite(String string) throws MonException{
		
			try {
				string.equals(.Salarie());
			} 
			catch (Exception e) {
				throw new MonException("ce numero existe deja");
			}
			
		}
			
		*/
	}

