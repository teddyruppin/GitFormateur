package projet_atos_web.app;

import java.util.ArrayList;
import java.util.List;

public class ListePersonne {
	private List<Personne> personnes;
	public ListePersonne() {
		// TODO Auto-generated constructor stub
		this.personnes =  new ArrayList<Personne>();
	}
	public List<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	public void add(Personne personne) {
		this.personnes.add(personne);
	}
}
