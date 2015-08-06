package bookkeeping;

import java.util.List;

public class TransactionFactory {
	
	/**
	 * This method creates a transaction for the given accounts. Will validate the transaction before creating it.
	 * @param bookInUse
	 * @param fromAccounts
	 * @param toAccounts
	 * @throws InvalidValueException if the to and from values in the distributions do not match.
	 * @throws InvalidAccountException if any of the accounts in the Distributions do not exist in the book.
	 */
	public static void addTransaction(Book bookInUse, List<Distribution> fromAccounts, List<Distribution> toAccounts) throws InvalidValueException, InvalidAccountException{
		//Validate that the accounts exist in the book and that the values are the same in to and from. This is the basic logic.
		double fromValue = 0;
		double toValue = 0;
		for (Distribution dist: fromAccounts){
			if (!bookInUse.containsAccount(dist.getAccount())){
				throw new InvalidAccountException("Account: " + dist.getAccount().toString() + " does not exist in the given book. No transaction created.");
			}
			fromValue = fromValue + dist.getValue();
		}
		
		for (Distribution dist: toAccounts){
			if (!bookInUse.containsAccount(dist.getAccount())){
				throw new InvalidAccountException("Account: " + dist.getAccount().toString() + " does not exist in the given book. No transaction created.");
			}
			toValue = toValue + dist.getValue();
		}
		
		if (fromValue != toValue){
			throw new InvalidValueException("The values on the from and to accounts do not match. From: " + fromValue + " To: " + toValue);
		}
		
		//--Validation completed--
		
		//Creates the transaction and adds it to the account. Transaction type depend on the account type and if the transaction is to or from the account.
		for (Distribution dist: fromAccounts){
			TransactionType tranType;
			if (dist.getAccount().getAccType() == AccountType.SAVINGS || dist.getAccount().getAccType() == AccountType.EXPENSE){
				tranType = TransactionType.DEBIT;
			} else {
				tranType = TransactionType.CREDIT;
			}
			dist.getAccount().addTransaction(new Transaction(dist.getName(), dist.getDate(), dist.getValue(),dist.getTags(), tranType));
		}
		
		for (Distribution dist: toAccounts){
			TransactionType tranType;
			if (dist.getAccount().getAccType() == AccountType.SAVINGS || dist.getAccount().getAccType() == AccountType.EXPENSE){
				tranType = TransactionType.CREDIT;
			} else {
				tranType = TransactionType.DEBIT;
			}
			dist.getAccount().addTransaction(new Transaction(dist.getName(), dist.getDate(), dist.getValue(),dist.getTags(), tranType));
		}
		
	}
}
