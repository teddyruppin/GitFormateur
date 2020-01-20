package spring004web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring004web.bean.Eleves;
import spring004web.service.IServiceEleve;

@Controller
@RequestMapping(value = "/afficherListeEleves")
public class AfficherListeEleves {

	@Autowired
	private IServiceEleve eleve;

	@RequestMapping(method = RequestMethod.GET)
	public String afficher(ModelMap pModel) {
		final List<Eleves> lListeEleves = eleve.rechercherEleve();
		pModel.addAttribute("listeEleves", lListeEleves);
		return "listeEleves";
	}
}