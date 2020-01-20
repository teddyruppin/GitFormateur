package spring004web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring004web.bean.Eleves;
import spring004web.service.IServiceEleve;



@Controller
public class SuppressionEleve {

	@Autowired
	private IServiceEleve service;

	@RequestMapping(value = "/afficherSuppressionListeEleves", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Eleves> lListeEleves = service.rechercherEleve();
		pModel.addAttribute("listeEleves", lListeEleves);
		return "suppression";
	}

	@RequestMapping(value = "/supprimerSuppressionListeEleves", method = RequestMethod.GET)
	public String supprimer(@RequestParam(value = "idEleve") final Integer eIdEleve, final ModelMap pModel) {
		service.supprimerEleve(eIdEleve);
		return afficher(pModel);
	}
}
