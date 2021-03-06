package batbileg.service;

import javax.inject.Inject;

import batbileg.TxnRequest;
import batbileg.TxnResponse;
import batbileg.domain.Account;
import batbileg.domain.Txn;
import batbileg.repo.AcntRepo;
import batbileg.repo.TxnRepo;
import io.micronaut.spring.tx.annotation.Transactional;

public class TxnServiceImp implements TxnService {

	@Inject
	AcntRepo repo;
	@Inject
	TxnRepo txnRepo;

	@Transactional
	public TxnResponse txn(TxnRequest req) {
		
		// Validate account information
		if (null == req.getFrom() || null == req.getTo() || req.getFrom().equals(req.getTo()))
			return new TxnResponse(1, "Bad request!");
		Account from = repo.findByAcntNum(req.getFrom());
		Account to = repo.findByAcntNum(req.getTo());
		if (null == from || null == to)
			return new TxnResponse(2, "Account not found!");
		if (from.getBalance().compareTo(req.getAmount()) < 0)
			return new TxnResponse(3, "Insufficient balance!");

		// Change balance
		from.setBalance(from.getBalance().subtract(req.getAmount()));
		to.setBalance(to.getBalance().add(req.getAmount()));

		// Create transaction history
		Txn t = new Txn(from, to, req.getAmount());
		txnRepo.save(t);

		return new TxnResponse("Successful", t.getId());
	}
}
