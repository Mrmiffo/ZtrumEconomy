package bookkeeping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A Transaction is a class representing a registered transaction. The transaction contain one account which is 
 * @author Marvin
 *
 */
public class Transaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4607059024467658524L;
	private static int createdTransactions;
	private final int id;
	private final Date date;
	private final String description;
	private final List<AccountDistribution> debitAccounts;
	private final List<AccountDistribution> creditAccounts;
	private final List<String> tags;
	
	public Transaction(String description, Date date, List<AccountDistribution> debitAccounts, List<AccountDistribution> creditAccount, List<String> tags) throws InvalidTransactionException{
		this.date = (Date) date.clone();
		this.description = description;
		this.tags = new ArrayList<>();
		this.debitAccounts = new ArrayList<>();
		for (AccountDistribution acc: debitAccounts){
			this.debitAccounts.add(acc);
		}
		creditAccounts = new ArrayList<>();
		for (AccountDistribution acc: creditAccount){
			creditAccounts.add(acc);
		}
		for (String tag: tags){
			this.tags.add(tag);
		}
		
		if (getTotalCreditValue() != getTotalDebitValue()){
			throw new InvalidTransactionException("Credit is not equal to debit. Transaction not created.");
		}
		createdTransactions++;
		id = createdTransactions;
	}
	
	public double getDebitValue(Account account){
		double toReturn = 0;
		for (AccountDistribution acc: debitAccounts){
			if (acc.account.equals(account)){
				toReturn = toReturn+acc.value; 
			}
		}
		return toReturn;
	}
	
	public double getCreditValue(Account account){
		double toReturn = 0;
		for (AccountDistribution acc: creditAccounts){
			if (acc.account.equals(account)){
				toReturn = toReturn+acc.value; 
			}
		}
		return toReturn;
	}
	
	public double getTotalDebitValue(){
		double toReturn = 0;
		for (AccountDistribution acc: debitAccounts){
			toReturn = toReturn + acc.value;
		}
		return toReturn;
	}
	
	public double getTotalCreditValue(){
		double toReturn = 0;
		for (AccountDistribution acc: creditAccounts){
			toReturn = toReturn + acc.value;
		}
		return toReturn;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return (Date)date.clone();
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	public String toString(){
		String toReturn = "ID: " + id + " Description: "+ description + " Date: " + date.toString() + " ";
		toReturn = toReturn + "DebitAcc: ";
		for (AccountDistribution acc: debitAccounts){
			toReturn = toReturn + acc.toString() + " ";
		}
		toReturn = toReturn + "CreditAcc: ";
		for (AccountDistribution acc: creditAccounts){
			toReturn = toReturn + acc.toString() + " ";
		}
		toReturn = toReturn + "Tags: ";
		for (int i = 0; i < tags.size(); i++){
			toReturn = toReturn + tags.get(i);
			if (i < tags.size()-1){
				toReturn = toReturn + ", ";
			}
		}
		return toReturn;
	}
	
}
