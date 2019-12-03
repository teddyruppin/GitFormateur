package projet01;

import java.util.Arrays;
//import java.util.Date;
import java.util.Scanner;
import java.lang.Math;

public class Programme {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//System.out.println("Run effectuer");
		/**
		 * int, boolean, float sont des types de variables
		 * non objet = primitive
		 * String, Integer, Long, Double, Float sont des types objets
		 * 
		 */
		
		
		/**Date madate;
		Object o1 = new Object();
		int i1=23;
		madate = new Date();
		System.out.println(2*i1);
		System.out.println(madate);
		System.out.println(o1);		
		*/
		
		Programme op = new Programme();
		//op.info();
		//op.atelier01();
		//op.atelier02();
		//op.atelier03();
		op.atelier04();
		//op.atelier05();
		//op.atelier06();
		//op.atelier07();
		//op.atelier08();
		//op.atelier09();
		//op.atelier10();
		

	}
	
	public void info() {
		
	}
	
	public void atelier01() {
		
	}
	
	public void atelier02() {
		int i = 1;
		boolean b = true;
		float f = 0.0f;
		String phrase = "bonjour";
		
		System.out.println(i);
		System.out.println(b);
		System.out.println(f);
		System.out.println(phrase);
		
	}
	
	
	public void atelier03() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nom svp?");
		String nom = sc.nextLine();
		System.out.println("Prenom svp?");
		String prenom = sc.nextLine();
		System.out.println("Age svp?");
		String age = sc.nextLine();
		System.out.println("votre nom est " + nom + ", votre prénom est " + prenom + " et vous avez " + age + " ans.");
		sc.close();
	}
	
	public void atelier04() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrer un nombre a?");
		int a = sc.nextInt();
		
		System.out.println("Entrer un nombre b?");
		int b = sc.nextInt();
		

		
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
		System.out.println(a+b-(a/b));
		System.out.println(a+(b-a)/b);
		
		System.out.println(a==b);
		System.out.println(a!=b);
		System.out.println(a>b);
		System.out.println(a>=b);
		System.out.println(a<b);
		System.out.println(a<=b);
		
		System.out.println("Entrer true ou false pour c?");
		boolean c = sc.nextBoolean();
		
		System.out.println("Entrer true ou false pour d?");
		boolean d = sc.nextBoolean();
		
		System.out.println(c&&d);
		System.out.println(c||d);
		System.out.println(!c);

		sc.close();
	}
	
	public void atelier05() {
		byte a = 127;
		short b = 32767;
		//b=a; byte vers short OK
		//a=b; short vers byte PAS OK
		System.out.println(a);
		
	}
	
	public void atelier06() {
		String s = "chaine de caractere";
		String s2 = new String("une autre chaine de caractere");
		String s3 = new String(" une chaine de caractere");
		String s4 = "chaine de caractere";
		
		System.out.println(s==s2);
		System.out.println(s==s3);
		System.out.println(s==s4);
		System.out.println(s=="une chaine de caractere");
		
		System.out.println("avec equals");
		System.out.println(s.equals(s2));
		System.out.println(s.equals(s3));
		System.out.println(s.equals(s4));
		System.out.println(s.equals("une chaine de caractere"));

		System.out.println(s.length());
		System.out.println(s.toUpperCase());
		
		String x= "n";
		System.out.println(s.indexOf(x));

	}

	public void atelier07() {
		
		double a = 10;
		double b = 5;
		
		double min = Math.min(a, b);
		double max = Math.max(a, b);
		double abs = Math.abs(a);
		double rand = Math.random();

		System.out.println("min = " +min+ " max = " + max + " absolut = " +abs+ " random = " + 10*rand);
		
	}
	
	public void atelier08() {
		boolean a = true;
		boolean b = false;
		byte c = 1;
		byte d = 3;
		
		if (a==true) {
			System.out.println("ca marche!");
		}
		
		if (b==false) {
			System.out.println("ca marche aussi !!");
		}
		
		if (c==d) {
			System.out.println("c = d");
		}
			else if (c==1 && d==2){
				System.out.println(" c = 1 et d = 2");				
			}
		else {
			System.out.println("'c' est different de 'd'");
		}
		
		
		int x = 8;
		switch (x) {
		case 1:
			System.out.println(x);
			break;
		case 2:
			System.out.println(x);
			break;
		case 3:
			System.out.println(x);
			break;
		case 4:
			System.out.println(x);
			break;
		case 5:
			System.out.println(x);
			break;

		default:
			System.out.println(10);
			break;
		}
		
	}
	
	
	
	public void atelier09() {
		
		int i = 1;
		
		while (i!=6) {
			System.out.println(i);
			i++;
		}
		
		do {
			System.out.println("!!");
		} while (i==0);
		
		for  (i = 1; i < 6; i++) {
			System.out.println(i);
		}
	}
	
	public void atelier10() {
		
		String t[] = {"pikachu", "salameche","bulbizarre","carapuce","racaillou"};
		Arrays.parallelSort(t);
		
		System.out.println("for");
		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
		
		System.out.println("while");
		int i = 0;
		while (i<t.length) {
			System.out.println(t[i]);
			i++;
		}
		System.out.println("do while");
		int j = 0;
		do {
			System.out.println(t[j]);
			j++;
		} while (j<t.length);
		
		System.out.println("for each");
		for (String s : t) {
			System.out.println(s);
		}
		
		System.out.println("afficher la place de carapuce");
		for (int j2 = 0; j2 < t.length; j2++) {
			if (t[j2].equals("carapuce")) {
				System.out.println("Postion : "+j2);
			}
		}
		
		System.out.println("liste d'evolution des pokemons");
		String evo[][] = {{"pikachu", "salameche","bulbizarre","carapuce","racaillou"},{"raichu","","","tortank","onyx"}};
		for (int k = 0; k < (evo.length)/2; k++) {
			System.out.println();
		}
		
		
	}
	
	
	
	
	
	

	/**
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	*/
}