package spring004web.controller;

import java.util.List;

import javax.validation.Valid;

public class ModificationFormEleve {

	@Valid
	private List<ModificationEleve> listeEleves;

	public void setListeEleves(final List<ModificationEleve> plisteEleves) {
		listeEleves = plisteEleves;
	}

	public List<ModificationEleve> getListeEleves() {
		return listeEleves;
	}
}
