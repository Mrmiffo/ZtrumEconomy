package bookkeeping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book {
	private static int createdBooks;
	private final int id;
	private String name;
	private List<Transaction> transactions;
	private List<Account> availableAccounts;
	
	public Book(String name){
		this.setName(name);
		transactions = new ArrayList<>();
		availableAccounts = new ArrayList<>();
		createdBooks++;
		id = createdBooks;
	}
	
	/**
	 * Creates an account and adds it to the list of available accounts in the book.
	 * @param name of the account
	 * @param accountID the ID of the account
	 * @param accType the account type of the account. Not possible to change after creation
	 * @throws InvalidAccountException if an account with the same account ID already exist.
	 */
	public void addAccount(String name, int accountID, AccountType accType) throws InvalidAccountException{
		for (Account acc: availableAccounts){
			if (acc.getId() == accountID){
				throw new InvalidAccountException("An account with that name already exists. Account not added.");
			}
		}
		availableAccounts.add(new Account(name, accountID, accType));
	}
	
	/**
	 * Removes the account with the specified ID. NOTE: Transactions made with the account will still keep record of the account.
	 * @param accountToRemove The id of the account to remove.
	 * @throws InvalidAccountException if the book has not account with that account id.
	 */
	public void removeAccount(int accountToRemove) throws InvalidAccountException{
		Account accToRemove = null;
		for (Account acc: availableAccounts){
			if (acc.getId() == accountToRemove){
				accToRemove = acc;
			}
		}
		removeAccount(accToRemove);
	}
	
	/**
	 * Removes the specified account from the list of available accounts. NOTE: Transactions made with the account will still keep record of the account.
	 * @param accToRemove the account to remove.
	 * @throws InvalidAccountException if the account to remove is null or if no such account exist in the list of available accounts.
	 */
	public void removeAccount(Account accToRemove) throws InvalidAccountException{
		if (accToRemove == null || !availableAccounts.remove(accToRemove)){
			throw new InvalidAccountException("No such account exist.");
		}
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
	public void addTransaction(String description, Date date, AccountDistribution toAccount, List<AccountDistribution> fromAccounts, List<String> tags) throws InvalidTransactionException, InvalidAccountException {
		if (!availableAccounts.contains(toAccount.account)){
			throw new InvalidAccountException("No such account exist.");
		}
		
		for (AccountDistribution acc: fromAccounts){
			if (!availableAccounts.contains(acc.account)){
				throw new InvalidAccountException("No such account exist.");
			}
		}
		
		List<AccountDistribution> debit = new ArrayList<>();
		List<AccountDistribution> credit = new ArrayList<>();
		if (toAccount.account.getAccType() == AccountType.SAVINGS || toAccount.account.getAccType() == AccountType.EXPENSE){
			debit.add(toAccount);
			credit.addAll(fromAccounts);
		} else {
			debit.addAll(fromAccounts);
			credit.add(toAccount);
		}
		
		
		
		Transaction transactionToAdd = new Transaction(description, date,debit, credit, (String[])tags.toArray());
		transactions.add(transactionToAdd);
	}
	
	/**
	 * Returns the account with the specified account id.
	 * @param accID the id of the account to return
	 * @return the account with the specified id in the book.
	 * @throws InvalidAccountException if no such account exist.
	 */
	public Account getAccount(int accID) throws InvalidAccountException{
		Account accToReturn = null;
		for (Account acc: availableAccounts){
			if (acc.getId() == accID){
				accToReturn = acc;
			}
		}
		if (accToReturn == null){
			throw new InvalidAccountException("No such account exist.");
		}
		return accToReturn;
	}

	/**
	 * @return the id of the book
	 */
	public int getId() {
		return id;
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
	
}
