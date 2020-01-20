package spring004web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring004web.bean.Profs;
import spring004web.service.IServiceProf;

@Controller
@RequestMapping(value = "/afficherListeProfs")
public class AfficherListeProfs {

	@Autowired
	private IServiceProf prof;

	@RequestMapping(method = RequestMethod.GET)
	public String afficher(ModelMap pModel) {
		final List<Profs> lListeProfs = prof.rechercherProf();
		pModel.addAttribute("listeProfs", lListeProfs);
		return "listeProfs";
	}
}