package Base_POO;

public class Carapuce {
	private String nomPokemon;
	private String typePokemon;
	private Integer pointdeviePokemon;
	private String faiblessePokemon;
	private static Integer nombre = 0;
	
	
	
	
	public Carapuce() {
		super();

	}

	public Carapuce(String nomPokemon, String typePokemon, Integer pointdeviePokemon, String faiblessePokemon) {
		super();
		this.nomPokemon = nomPokemon;
		this.typePokemon = typePokemon;
		this.pointdeviePokemon = pointdeviePokemon;
		this.faiblessePokemon = faiblessePokemon;
		Carapuce.nombre = nombre + 1;

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
		System.out.println("carapuce! attaque tsunamamie!");
	}

	public static void increment() {
		System.out.println("vous avez cree: " + nombre + " carapuce.");
	}
}
