package batbileg.service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import batbileg.repo.AcntRepo;
import io.micronaut.context.annotation.Parallel;

@Singleton
@Parallel
public class InitData {

	@Inject
	AcntRepo repo;

	@PostConstruct
	void initialize() {
		System.out.println("=============== INIT DATA ===============");
		repo.initData();
	}
}
