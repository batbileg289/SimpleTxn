package batbileg.service;

import batbileg.TxnRequest;
import batbileg.TxnResponse;

public interface TxnService {
	public TxnResponse txn(TxnRequest req);
}
