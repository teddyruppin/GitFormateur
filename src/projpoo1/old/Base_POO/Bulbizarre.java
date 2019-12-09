package old.Base_POO;

// creation de la classe Bulbizarre 

public class Bulbizarre {
	private String nomPokemon;
	private String typePokemon;
	private Integer pointdeviePokemon;
	private String faiblessePokemon;
	private static Integer nombre = 0;
	
	/**
	@Override
	public String toString() {
		return "Bulbizarre [nomPokemon=" + nomPokemon + ", typePokemon=" + typePokemon + ", pointdeviePokemon="
				+ pointdeviePokemon + "]";
	}
	*/
	
		

	public Bulbizarre(String nomPokemon, String typePokemon, Integer pointdeviePokemon, String faiblessePokemon) {
		super();
		this.nomPokemon = nomPokemon;
		this.typePokemon = typePokemon;
		this.pointdeviePokemon = pointdeviePokemon;
		this.faiblessePokemon = faiblessePokemon;
		Bulbizarre.nombre = nombre + 1;
	}


	public String getNomPokemon() {
		return nomPokemon;
	}

	public void setNomPokemon(String nomPokemon) {
		this.nomPokemon = nomPokemon;
	}

	public String getTypePokemon() {
		return typePokemon;
	}

	public void setTypePokemon(String typePokemon) {
		this.typePokemon = typePokemon;
	}

	public Integer getPointdeviePokemon() {
		return pointdeviePokemon;
	}

	public void setPointdeviePokemon(Integer pointdeviePokemon) {
		this.pointdeviePokemon = pointdeviePokemon;
	}
	
	
	public String getFaiblessePokemon() {
		return faiblessePokemon;
	}

	public void setFaiblessePokemon(String faiblessePokemon) {
		this.faiblessePokemon = faiblessePokemon;
	}
	
	public void attaque() {
		System.out.println("bulbizarre! attaque lianefolie!");
	}

	public static void increment() {
		System.out.println("vous avez cree: " + nombre + " bulbizarre.");
	}
}
