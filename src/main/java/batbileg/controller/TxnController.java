package batbileg.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import batbileg.TxnRequest;
import batbileg.TxnResponse;
import batbileg.domain.Account;
import batbileg.service.AcntService;
import batbileg.service.TxnService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

@Controller("/txn")
@Validated
public class TxnController {

	@Inject
	TxnService txn;
	@Inject
	AcntService acnt;

	// for account information
	@Get
	public List<Account> getList() {
		return acnt.getAcntList();
	}

	@Post
	public HttpResponse<TxnResponse> txn(@Valid @Body TxnRequest req) {
		TxnResponse res = txn.txn(req);
		return HttpResponse.ok(res);
	}
}
