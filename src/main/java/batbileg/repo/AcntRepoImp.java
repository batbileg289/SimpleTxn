package batbileg.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import batbileg.domain.Account;

public class AcntRepoImp implements AcntRepo {

	@PersistenceContext
	private EntityManager em;

	public List<Account> findAll() {
		return em.createQuery("SELECT a FROM Account as a", Account.class).getResultList();
	}

	public Account findByAcntNum(String num) {
		TypedQuery<Account> q = em.createQuery("SELECT a FROM Account as a where a.acntNum = :num", Account.class)
				.setParameter("num", num);
		Account a = null;
		try {
			a = q.getSingleResult();
			a.getAcntName();
		} catch (NoResultException nre) {
			// TODO Handle NoResultException and convert to user friendly message
		}
		return a;
	}

	// Temporary! for initial data!
	public void initData() {
		if (init)
			return;
		init = true;
		Account a1 = new Account("a1", "Batbileg", new BigDecimal("1000"));
		Account a2 = new Account("a2", "David", new BigDecimal("1000"));
		em.persist(a1);
		em.persist(a2);
	}
	private static boolean init = false;

}
