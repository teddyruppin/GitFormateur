package net.atos.englishbattle.business;

public class Niveau {
	
	public static final String DEBUTANT = "débutant";
	public static final String INTERMEDIAIRE = "intermédiaire";
	public static final String EXPERT = "expert";
	
	// Ajout des attributs privés
	private Long id;
	private String nom;
	private static Long compteur = 0L;

	// Génération des constructeurs
	public Niveau() {
		super();
		id = ++compteur;
	}

	public Niveau(String nom) {
		this();
		this.nom = nom;
	}

	// Génération des getters/setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// Génération de la méthode toString()

	@Override
	public String toString() {
		return "Niveau [id=" + id + ", nom=" + nom + "]";
	}

}
