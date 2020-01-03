package net.atos.englishbattle;

import java.util.List;

import net.atos.englishbattle.business.Joueur;
import net.atos.englishbattle.service.JoueurService;
import net.atos.englishbattle.service.impl.JoueurServiceImpl;

public class Main {

	public static void main(String[] args) {

		JoueurService jo = new JoueurServiceImpl();
		
		try {
			jo.recupereNbParties().stream().forEach(
					j -> System.out.println(j.getNbParties()));
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
}
