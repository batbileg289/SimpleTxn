package batbileg.service;

import java.util.List;

import javax.inject.Inject;

import batbileg.domain.Account;
import batbileg.repo.AcntRepo;
import io.micronaut.spring.tx.annotation.Transactional;

public class AcntServiceImp implements AcntService {

	@Inject
	AcntRepo repo;

	@Transactional
	public List<Account> getAcntList() {
		// Temporary! for only initial data!
		repo.initData();

		return repo.findAll();
	}

}
