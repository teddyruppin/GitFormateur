package projpoo1.GestionPersonnes;




public class Personne {
		// TODO Auto-generated constructor stub
		private String nom;
		private String prenom;
		private String adresse;
		private String ville;
		private String codepostal;

		
		/**
		public Personne() {
			//constructor
			this.adresse="";
			this.codepostal="";
			this.nom="";
			this.prenom="";
			this.ville="";
			
			this("","","","",""); // remplace les this. 
		}
		
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

