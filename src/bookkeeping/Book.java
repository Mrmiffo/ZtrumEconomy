package bookkeeping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book {
	private static int createdBooks;
	private final int id;
	private String name;
	private List<Account> availableAccounts;
	
	public Book(String name){
		this.setName(name);
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
	
	public boolean containsAccount(Account account){
		return availableAccounts.contains(account);
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
	
	public String toString(){
		return name;
	}
	
	public List<Account> getAllAccounts(){
		List<Account> toReturn = new ArrayList<>();
		toReturn.addAll(availableAccounts);
		return toReturn;
	}
	
	public boolean equals(Object o){
		if (this == o){
			return true;
		} else if (!(o instanceof Book)){
			return false;
		} else if (this.getName().equals(((Book)o).getName()) && this.id == ((Book)o).id){
			return true;
		} else return false;
	}
}
