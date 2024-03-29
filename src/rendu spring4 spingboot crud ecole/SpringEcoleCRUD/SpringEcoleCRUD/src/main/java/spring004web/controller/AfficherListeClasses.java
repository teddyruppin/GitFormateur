package spring004web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring004web.bean.Classes;
import spring004web.service.IServiceClasse;

@Controller
@RequestMapping(value = "/afficherListeClasses")
public class AfficherListeClasses {

	@Autowired
	private IServiceClasse classe;

	@RequestMapping(method = RequestMethod.GET)
	public String afficher(ModelMap pModel) {
		final List<Classes> lListeClasses = classe.rechercherClasse();
		pModel.addAttribute("listeClasses", lListeClasses);
		return "listeClasses";
	}
}
