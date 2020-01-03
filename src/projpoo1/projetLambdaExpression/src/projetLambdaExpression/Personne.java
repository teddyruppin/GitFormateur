package projetLambdaExpression;

public class Personne {

	private String name;
	private String prenom;
	private Integer numeroPerso;
	
	public Personne(String prenom, String name, int numeroPerso) {
	    this.name = name;
	    this.prenom = prenom;
	    this.numeroPerso = numeroPerso;
	  }

	public static int nameCompare(Personne a1, Personne a2) {
		return a1.name.compareTo(a2.name);
	}
	
	public static int prenomCompare(Personne a1, Personne a2) {
		return a1.prenom.compareTo(a2.prenom);
	}
	
	public static int numeroCompare(Personne a1, Personne a2) {
		return a1.numeroPerso.compareTo(a2.numeroPerso);
	}

	public String toString() {
		return  "[ " + prenom +" , " + name + " , " + numeroPerso + " ]";
	}
}
