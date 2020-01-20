package spring004web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring004web.bean.Classes;
import spring004web.dao.IClasseDao;

@Service
public class ServiceClasse implements IServiceClasse {

	@Autowired
	private IClasseDao dao;
	
	@Transactional(readOnly = true)
	public List<Classes> rechercherClasse() {
		return dao.rechercherClasses();
	}

	@Transactional
	public void creerClasses(final String nom, final String prof) {
		final Classes cClasse = new Classes();
		cClasse.setNom(nom);
		cClasse.setProf(1);
		
		dao.creerClasses(cClasse);
	}

	@Transactional
	public void supprimerClasses(Integer cIdClasses) {
		final Classes cClasse = new Classes();
		cClasse.setId(cIdClasses);
		dao.supprimerClasses(cClasse);
	}

	@Transactional
	public void modifierClasses(List<Classes> cListeClasses) {
		for (final Classes cClasse : cListeClasses) {
			dao.modifierClasses(cClasse);
	}


}}
