package spring004web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring004web.bean.Eleves;
import spring004web.dao.IEleveDao;
import spring004web.enume.Sexe;

@Service
public class ServiceEleve implements IServiceEleve {

	@Autowired
	private IEleveDao dao;

	@Transactional(readOnly = true)
	public List<Eleves> rechercherEleve() {
		return dao.rechercherEleve();
	}

	@Transactional
	public void creerEleve(String nom, String prenom, Date date_naissance, String adresse, Sexe sexe) {
		final Eleves lEleve = new Eleves();
		lEleve.setNom(nom);
		lEleve.setPrenom(prenom);
		lEleve.setDate_naissance(date_naissance);
		lEleve.setAdresse(adresse);
		lEleve.setSexe(sexe);
		lEleve.setClasse(1);
	
		dao.creerEleve(lEleve);		
	}

	@Transactional
	public void supprimerEleve(Integer eIdEleve) {
		final Eleves lEleve = new Eleves();
		lEleve.setId(eIdEleve);
		dao.supprimerEleve(lEleve);		
	}

	@Transactional
	public void modifierEleve(List<Eleves> eListeEleve) {
		for (final Eleves lEleve : eListeEleve) {
			dao.modifierEleve(lEleve);
			System.err.println(eListeEleve);
		}		
	}
}
