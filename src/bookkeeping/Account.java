package bookkeeping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable{
	private static final long serialVersionUID = -4003528843342169804L;
	private int id;
	private String name;
	private final AccountType accType;
	private List<Transaction> transactions;
	
	Account(String name, int id, AccountType accType){
		this.setId(id);
		this.setName(name);
		this.accType = accType;
		transactions = new ArrayList<>();
	}
	
	/**
	 * Adds the given transaction the the list of transactions in the 
	 */
	void addTransaction(Transaction transaction){
		transactions.add(transaction);
		sortDate();
	}

	private void sortDate() {
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
	
	public List<Transaction> getTransactions(){
		List<Transaction> toReturn = new ArrayList<>();
		toReturn.addAll(transactions);
		return toReturn;
	}
	
	public String toString(){
		return id + ". " + name;
	}
	
	public boolean equals(Object o){
		if (this == o){
			return true;
		} else if (!(o instanceof Account)){
			return false;
		} else if ((this.id == ((Account)o).id) && (this.name == ((Account)o).name) && (this.accType == ((Account)o).accType)){
			return true;
		}
		return false;
	}
}
