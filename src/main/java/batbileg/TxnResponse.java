package batbileg;

public class TxnResponse {
	private int code = 0;// default value - Success
	private String description;
	private Long txnId;

	public TxnResponse(String desc, Long txnId) {
		this.description = desc;
		this.txnId = txnId;
	}

	public TxnResponse(int code, String desc) {
		this.code = code;
		this.description = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

}
