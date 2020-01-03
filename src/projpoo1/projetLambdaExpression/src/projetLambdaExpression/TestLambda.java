package projetLambdaExpression;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @since JDK 1.8
 *        <hr>
 *        Lancement d'un Thread avec l'interface Runnable surchargée dynamique
 *        avec une expression Lambda
 *        <hr>
 *        Utilisation de la méthode foreach avec une expression lambda
 */

@FunctionalInterface
interface Calculatrice {
	public int calculer(int a, int b);
}

public class TestLambda {

	public static void main(String[] args) {
/*
		new Thread(() -> {
			System.out.println("Runnable");
		}).start();

		List<String> pointList = new ArrayList<String>();
		pointList.add("1");
		pointList.add("2");

		pointList.forEach(p -> {
			System.out.println(p);
		});

		afficher("Bonjour", 5);

		try {
			Calculatrice ocal;
			ocal = (a, b) -> (a + b);
			System.out.println("Addition\t:\t" + ocal.calculer(10, 12));
			ocal = (a, b) -> (a * b);
			System.out.println("Produit\t\t:\t" + ocal.calculer(10, 12));
			ocal = (a, b) -> (a - b);
			System.out.println("Soustraction\t:\t" + ocal.calculer(10, 12));
			ocal = (a, b) -> (a / b);
			System.out.println("Division\t:\t" + ocal.calculer(10, 12));
			ocal = (a, b) -> (a % b);
			System.out.println("Modulo\t\t ->\n\t\t\t le reste est " + ocal.calculer(10, 12));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}*/

		// List<Personne> liste = new ArrayList<Personne>();

		// Stream s = liste.stream();

		/*Personne[] liste1 = {new Personne("Teddy", "Ruppin", "1"), 
							new Personne("Marie", "Baumont", "2"), 
							new Personne("Maxence", "Galland", "3"), 
							new Personne("Xavier", "La", "4") };
		
		Personne[] liste2 = {new Personne("Teddy", "Ruppin", "1"), 
							new Personne("Marie", "Baumont", "2"), 
							new Personne("Maxence", "Galland", "3"), 
							new Personne("Xavier", "La", "4") };*/
		
		Personne[] liste3 = {new Personne("Teddy", "Ruppin", 2548), 
							new Personne("Marie", "Baumont", 2654), 
							new Personne("Maxence", "Galland", 2015), 
							new Personne("Xavier", "La", 2435) };
		
		
		/*System.out.println("Avant les noms triés : " + Arrays.toString(liste1));
		Arrays.sort(liste1, Personne::nameCompare);
		System.out.println("Aprés les noms triés : " + Arrays.toString(liste1));
		
		System.out.println("\n");
		
		System.out.println("Avant les prenoms triés : " + Arrays.toString(liste2));
		Arrays.sort(liste2, Personne::prenomCompare);
		System.out.println("Après les prénom triés : " + Arrays.toString(liste2));
		
		System.out.println("\n");*/
		
		System.out.println("Avant les prenoms triés : " + Arrays.toString(liste3));
		Arrays.sort(liste3, Personne::numeroCompare);
		System.out.println("Après les prénom triés : " + Arrays.toString(liste3));
		
		
	}
	
	

	public static void afficher(String message, int repetition) {
		/**
		 * Implémentation de l'interface Runnable que nous "codons" de façon dynamique
		 * avec une boucle de n "messages" passer en paramètres par les paramètres :
		 * String message et int repetition
		 */
		Runnable r = () -> {

			for (int i = 0; i < repetition; i++) {
				System.out.printf("\t%02d\t-\t%s\n", i, message);
			}
		};
		/**
		 * Instanciation d'un Thread avec l'objet dynamique -> r qui est "codé de façon
		 * dynamique"
		 */
		new Thread(r).start();

	}
}
