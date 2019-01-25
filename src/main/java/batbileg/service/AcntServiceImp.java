package batbileg.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import batbileg.domain.Account;
import batbileg.repo.AcntRepo;
import io.micronaut.spring.tx.annotation.Transactional;

public class AcntServiceImp implements AcntService {

	@Inject
	AcntRepo repo;
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public List<Account> getAcntList() {
		return repo.findAll();
	}
}
