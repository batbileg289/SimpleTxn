package batbileg.controller;

import java.util.List;

import javax.inject.Inject;

import batbileg.TxnRequest;
import batbileg.TxnResponse;
import batbileg.domain.Account;
import batbileg.domain.Txn;
import batbileg.repo.AcntRepo;
import batbileg.repo.TxnRepo;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.spring.tx.annotation.Transactional;

@Controller("/txn")
public class TxnController {

	@Inject
	AcntRepo repo;
	@Inject
	TxnRepo txnRepo;

	@Post
	@Transactional
	public HttpResponse<TxnResponse> txn(@Body TxnRequest req) {
		// Temporary! for only initial data!
		repo.initData();

		// Validate account information
		if (null == req.getFrom() || null == req.getTo() || req.getFrom().equals(req.getTo()))
			return HttpResponse.badRequest(new TxnResponse(1, "Bad request!"));
		Account from = repo.findByAcntNum(req.getFrom());
		Account to = repo.findByAcntNum(req.getTo());
		if (null == from || null == to)
			return HttpResponse.badRequest(new TxnResponse(2, "Account not found!"));
		if (from.getBalance().compareTo(req.getAmount()) < 0)
			return HttpResponse.badRequest(new TxnResponse(3, "Insufficient balance!"));

		// Change balance
		from.setBalance(from.getBalance().subtract(req.getAmount()));
		to.setBalance(to.getBalance().add(req.getAmount()));

		// Create transaction history
		Txn t = new Txn(from, to, req.getAmount());
		txnRepo.save(t);

		// Prepare response
		TxnResponse res = new TxnResponse();
		res.setDescription("Successful. TxnId:" + t.getId());
		return HttpResponse.ok(res);
	}

	
	//for check account information
	@Get
	@Transactional
	public List<Account> getList() {
		// Temporary! for only initial data!
		repo.initData();
		
		return repo.findAll();
	}
}
