package old.Base_POO;

public class Prog_poo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Salameche salameche = new Salameche("Salameche","feu",15,"eau"); //instance de l'objet salameche
		Bulbizarre bulbizarre = new Bulbizarre("Bulbizarre","plante",10,"feu"); //instance de l'objet bulbizarre
		Carapuce carapuce = new Carapuce("Carapuce","eau",12,"feu"); //instance de l'objet carapuce
		
		System.out.println("nom: " + bulbizarre.getNomPokemon());
		System.out.println("type: " + bulbizarre.getTypePokemon());
		System.out.println("PV: " + bulbizarre.getPointdeviePokemon());
		System.out.println("faiblese: " + bulbizarre.getFaiblessePokemon()+ "\n");

		System.out.println("nom: " + salameche.getNomPokemon());
		System.out.println("type: " + salameche.getTypePokemon());
		System.out.println("PV: " + salameche.getPointdeviePokemon());
		System.out.println("faiblesse: " + salameche.getFaiblessePokemon()+ "\n");

		System.out.println("nom: " + carapuce.getNomPokemon());
		System.out.println("type: " + carapuce.getTypePokemon());
		System.out.println("PV: " + carapuce.getPointdeviePokemon());
		System.out.println("faiblesse: " + carapuce.getFaiblessePokemon()+ "\n");
		
		salameche.attaque();
		bulbizarre.attaque();
		carapuce.attaque();
		
		System.out.println("\n");
	
		Bulbizarre.increment();
		Salameche.increment();
		Carapuce.increment();
		 
	}

}
