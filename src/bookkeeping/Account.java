package bookkeeping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4003528843342169804L;
	private int id;
	private String name;
	private final AccountType accType;
	private List<Transaction> transactions;
	
	public Account(String name, int id, AccountType accType){
		this.setId(id);
		this.setName(name);
		this.accType = accType;
	}
	
	/**
	 * Creates a new transaction and adds it to the list of transactions in the book.
	 * @param description The description (name) of the transaction
	 * @param date The date when the transaction was created.
	 * @param debitAccount the specification of how the debits are distributed.
	 * @param creditAccount the specification of how the credits are distributed.
	 * @param tags tags for the transaction for reporting purposes.
	 * @throws InvalidTransactionException if the debit and credit values do not match
	 * @throws InvalidAccountException if any of the accounts specified does not exist.
	 */
	void addTransaction(Transaction transaction) throws InvalidTransactionException, InvalidAccountException {
		transactions.add(transaction);
		transactions.sort(new TransactionDateCompare());
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the accType
	 */
	public AccountType getAccType() {
		return accType;
	}
	
	public boolean equals(Object o){
		if (this == o){
			return true;
		} else if (o.getClass() != Account.class){
			return false;
		} else if ((this.id == ((Account)o).id) && (this.name == ((Account)o).name) && (this.accType == ((Account)o).accType)){
			return true;
		}
		return false;
	}
}
