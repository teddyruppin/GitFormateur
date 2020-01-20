package spring004web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring004web.bean.Profs;
import spring004web.dao.IProfDao;
import spring004web.enume.Sexe;

@Service
public class ServiceProf implements IServiceProf {

	@Autowired
	private IProfDao dao;
	
	@Transactional(readOnly = true)
	public List<Profs> rechercherProf() {
		return dao.rechercherProfs();
	}

	@Transactional
	public void creerProf(String nom, String prenom, Date date_naissance, String adresse, Sexe sexe) {
		final Profs pProf = new Profs();
		pProf.setNom(nom);
		pProf.setPrenom(prenom);
		pProf.setDate_naissance(date_naissance);
		pProf.setAdresse(adresse);
		pProf.setSexe(sexe);
	
		dao.creerProfs(pProf);	
	}

	@Transactional
	public void supprimerProf(Integer pIdProf) {
		final Profs pProf = new Profs();
		pProf.setId(pIdProf);
		dao.supprimerProfs(pProf);	
	}

	@Transactional
	public void modifierProf(List<Profs> pListeProf) {
		for (final Profs pProf : pListeProf) {
			dao.modifierProfs(pProf);
		}	
	}
}
