package spring004web.controller;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring004web.bean.Eleves;
import spring004web.enume.Sexe;
import spring004web.service.IServiceEleve;

@Controller
public class ModifierListeElevesController {

	@Autowired
	private IServiceEleve service;

	@RequestMapping(value = "/afficherModificationListeEleves", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		if (pModel.get("modification") == null) {
			final List<Eleves> lListeEleves = service.rechercherEleve();
			final ModificationFormEleve lModificationForm = new ModificationFormEleve();
			final List<ModificationEleve> lListe = new LinkedList<ModificationEleve>();
			for (final Eleves lEleves : lListeEleves) {
				final ModificationEleve lModificationCourse = new ModificationEleve();
				lModificationCourse.setId(lEleves.getId());
				lModificationCourse.setNom(lEleves.getNom());
				lModificationCourse.setPrenom(lEleves.getPrenom());
				lModificationCourse.setAdresse(lEleves.getAdresse());
				lModificationCourse.setDate(lEleves.getDate_naissance().toString());
				lModificationCourse.setClasse(lEleves.getClasse().toString());

				lModificationCourse.setSexe(lEleves.getSexe().name());
				lListe.add(lModificationCourse);
			}
			lModificationForm.setListeEleves(lListe);
			pModel.addAttribute("modification", lModificationForm);
		}
		return "modification";
	}

	@RequestMapping(value = "/modifierModificationListeEleves", method = RequestMethod.POST)
	public String modifier(@Valid @ModelAttribute(value = "modification") final ModificationFormEleve pModification,
			final BindingResult pBindingResult, final ModelMap pModel) {
		System.err.println(pBindingResult);
		if (!pBindingResult.hasErrors()) {
			final List<Eleves> lListeEleves = new LinkedList<Eleves>();
			for (final ModificationEleve lModificationEleve : pModification.getListeEleves()) {
				final Eleves lEleve = new Eleves();
				lEleve.setId(lModificationEleve.getId());
				lEleve.setNom(lModificationEleve.getNom());
				lEleve.setPrenom(lModificationEleve.getPrenom());
				lEleve.setAdresse(lModificationEleve.getAdresse());

				String pattern = "yyyy-MM-dd";
				SimpleDateFormat sd = new SimpleDateFormat(pattern);
				sd.setLenient(false);
				try {
					lEleve.setDate_naissance(sd.parse(lModificationEleve.getDate()));
					
				} catch (Exception e) {
					e.getStackTrace();
				}
				
				lEleve.setClasse(Integer.valueOf(lModificationEleve.getClasse()));
				Sexe sexe = Sexe.FEMME;
				if (!lModificationEleve.getSexe().equalsIgnoreCase(Sexe.FEMME.toString()))
					sexe = Sexe.HOMME;
				lEleve.setSexe(sexe);

				lListeEleves.add(lEleve);
			}
			System.err.println("service run");
			service.modifierEleve(lListeEleves);
			System.err.println("ok");
		}
		return afficher(pModel);
	}
}
