package batbileg;

public class TxnResponse {
	private int code = 0;// default value
	private String description = "Successful";// default value
	private Object data;

	public TxnResponse() {
	}

	public TxnResponse(Object data) {
		this.data = data;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
