package projpoo1.verif;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import projpoo1.Exception.ErreurSaisie;
import projpoo1.GestionPersonnes.Client;
import projpoo1.GestionPersonnes.Fournisseur;
import projpoo1.GestionPersonnes.Personne;
import projpoo1.GestionPersonnes.Salarie;

public class Verifications {
	
	public static Scanner sc = new Scanner(System.in);
	static boolean reussi = false;
	static List<Personne> lp = new ArrayList<Personne>();

	
	public static Date verifDate(String date) throws Exception {

		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd/MM/yyyy");
		format.setLenient(false);
		Date date1 = format.parse(date);
		return date1;
	}

	public static String verifCodePostal() {
		String code;
		do {
			code = sc.nextLine();
			if (!code.matches("\\d{1,5}")) {
				System.out.println("Rentrez un code postal du type XXXXX");
			}
		} while (!code.matches("\\d{1,5}"));
		return code;
	}

	public static String verifSalaire() {
		String sal;
		do {
			sal = sc.next();
			if (!sal.matches("\\d{1,9}\\,\\d{2}€")) {
				System.out.println("Rentrez un salaire du type XXXXX,XX€");
			}
		} while (!sal.matches("\\d{1,9}\\,\\d{2}€"));
		return sal;
	}

	public static String verifNumeroClient() throws ErreurSaisie {
		String num = null;
		reussi = false;
		while (reussi == false) {
			do {
				num = sc.nextLine();
				if (!num.matches("\\d{1,9}")) {
					System.out.println("Rentrez un Numero de client compris entre 1 et  9 chiffres");
				} else {
					try {
						Client.testeUniciteNumClient(num, lp);
						reussi = true;
					} catch (ErreurSaisie e) {
						throw new ErreurSaisie("le numero rentr� existe d�j�, veuillez en rentrer un nouveau");
					}
				}
			} while (!num.matches("\\d{13}") && reussi == false);
		}
		return num;
	}

	public static String verifNumeroSecuriteSocial() throws Exception {
		reussi = false;
		String num = null;
		while (reussi == false) {

			do {
				num = sc.nextLine();
				if (!num.matches("\\d{13}")) {
					System.out.println("Rentrez un Numero de S�curit� du type X XX XX XX XXX XXX");
				} else {
					try {
						Salarie.testeUniciteSecu(num, lp);
						reussi = true;
					} catch (ErreurSaisie e) {
						System.out.println("le numero rentr� existe d�j�, veuillez en rentrer un nouveau");
					}
				}
			} while (!num.matches("\\d{13}") && reussi == false);
		}
		return num;
	}

	public static String verifNumeroFournisseur() throws Exception {
		reussi = false;
		String num = null;
		while (reussi == false) {
			do {
				num = sc.nextLine();
				if (!num.matches("\\d{1,9}")) {
					System.out.println("Rentrez un Numero de fournisseur compris entre 1 et  9 chiffres");
				} else {
					try {
						Fournisseur.testeUniciteNumFournisseur(num, lp);
						reussi = true;
					} catch (ErreurSaisie e) {
						System.out.println("le numero rentr� existe d�j�, veuillez en rentrer un nouveau");
					}
				}
			} while (!num.matches("\\d{13}") && reussi == false);
		}
		return num;
	}

}
