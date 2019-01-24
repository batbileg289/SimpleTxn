package batbileg.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * Account number
	 */
	private String acntNum;
	
	/**
	 * Account name
	 */
	private String acntName;
	private BigDecimal balance = new BigDecimal("0.0");

	public Account() {
	}

	public Account(String num, String name, BigDecimal bal) {
		this.acntNum = num;
		this.acntName = name;
		this.balance = bal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcntNum() {
		return acntNum;
	}

	public void setAcntNum(String acntNum) {
		this.acntNum = acntNum;
	}

	public String getAcntName() {
		return acntName;
	}

	public void setAcntName(String acntName) {
		this.acntName = acntName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Num:" + acntNum + " Bal:" + balance;
	}

}
