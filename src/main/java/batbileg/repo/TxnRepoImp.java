package batbileg.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import batbileg.domain.Txn;

public class TxnRepoImp implements TxnRepo {

	@PersistenceContext
	private EntityManager em;

	public void save(Txn t) {
		em.persist(t);
	}

}
