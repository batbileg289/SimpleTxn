package batbileg.repo;

import java.util.List;

import batbileg.domain.Account;

public interface AcntRepo {

	List<Account> findAll();

	Account findByAcntNum(String num);

	void initData();
}
