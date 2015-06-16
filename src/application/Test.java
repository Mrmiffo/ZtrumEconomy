package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bookkeeping.AccountDistribution;
import bookkeeping.AccountType;
import bookkeeping.Book;
import bookkeeping.InvalidAccountException;
import bookkeeping.InvalidTransactionException;
import bookkeeping.InvalidValueException;
import bookkeeping.Transaction;

public class Test {

	public static void main(String[] arg) throws InvalidValueException, InvalidAccountException, InvalidTransactionException{
		Book test = new Book("test");
		test.addAccount("TestAcc", 1, AccountType.CREDIT);
		test.addAccount("TestAcc2", 2, AccountType.SAVINGS);
		List<String> tags1 = new ArrayList<>();
		tags1.add("Tag1");
		tags1.add("Tag2");
		
		List<AccountDistribution> accDist1 = new ArrayList<>();
		accDist1.add(new AccountDistribution(test.getAccount(2), 4.5));
		accDist1.add(new AccountDistribution(test.getAccount(1), 0.5));
		
		test.addTransaction("TestTran1", new Date(), new AccountDistribution(test.getAccount(2), 5), accDist1, tags1);
		test.addTransaction("TestTran2", new Date(1), new AccountDistribution(test.getAccount(1), 5), accDist1, tags1);
		test.addTransaction("TestTran3", new Date(40), new AccountDistribution(test.getAccount(1), 5), accDist1, tags1);
		for (Transaction tran: test.getTransactions(new Date(10), new Date())){
			System.out.println(tran.toString());
		}
	}
}
