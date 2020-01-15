package spring004web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import spring004web.bean.Profs;

@Repository
public class ProfsDao implements IProfDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Profs> rechercherProfs() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Profs> lCriteriaQuery = lCriteriaBuilder.createQuery(Profs.class);
		final Root<Profs> lRoot = lCriteriaQuery.from(Profs.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Profs> lTypedQuery = entityManager.createQuery(lCriteriaQuery);
		return lTypedQuery.getResultList();
	}

	public void creerProfs(Profs pProfs) {
		entityManager.persist(pProfs);
	}

	public void supprimerProfs(Profs pProfs) {
		final Profs pProf = entityManager.getReference(Profs.class, pProfs.getId());
		entityManager.remove(pProf);
	}

	public void modifierProfs(Profs pProfs) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaUpdate<Profs> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Profs.class);
		final Root<Profs> lRoot = lCriteriaUpdate.from(Profs.class);
		final Path<Profs> lPath = lRoot.get("id");
		final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, pProfs.getId());
		lCriteriaUpdate.where(lExpression);
		lCriteriaUpdate.set("prenom", pProfs.getPrenom());
		final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
		final int lRowCount = lQuery.executeUpdate();
		if (lRowCount != 1) {
			final org.hibernate.Query lHQuery = lQuery.unwrap(org.hibernate.Query.class);
			final String lSql = lHQuery.getQueryString();
			throw new RuntimeException("Nombre d'occurences (" + lRowCount + ") modifiés différent de 1 pour " + lSql);
		}
	}
}
