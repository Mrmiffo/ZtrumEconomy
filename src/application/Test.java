package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bookkeeping.AccountType;
import bookkeeping.Book;
import bookkeeping.Distribution;
import bookkeeping.InvalidAccountException;
import bookkeeping.InvalidTransactionException;
import bookkeeping.InvalidValueException;
import bookkeeping.Tag;
import bookkeeping.Transaction;
import bookkeeping.TransactionFactory;

public class Test {

	public static void main(String[] arg) throws InvalidValueException, InvalidAccountException, InvalidTransactionException{
		Book testBook = new Book("test");
		testBook.addAccount("TestAcc", 1, AccountType.CREDIT);
		testBook.addAccount("TestAcc2", 2, AccountType.SAVINGS);
		testBook.addAccount("TestAcc3", 3, AccountType.EXPENSE);
		Tag tag1 = new Tag("Tag1");
		Tag tag2 = new Tag("Tag2");
		
		List<Tag> tagList1 = new ArrayList<>();
		tagList1.add(tag1);
		tagList1.add(tag2);

		List<Distribution> fromAccounts = new ArrayList<>();
		List<Distribution> toAccounts = new ArrayList<>();
		
		fromAccounts.add(new Distribution("Dist1", new Date(), testBook.getAccount(1), 10, tagList1));
		fromAccounts.add(new Distribution("Dist3", new Date(), testBook.getAccount(3), 0, tagList1));
		toAccounts.add(new Distribution("Dist2", new Date(), testBook.getAccount(2), 10, tagList1));
		
		
		TransactionFactory.addTransaction(testBook, fromAccounts, toAccounts);

		for (Transaction tran: testBook.getAccount(1).getTransactions()){
			System.out.println(tran.toString());
		}
		
		for (Transaction tran: testBook.getAccount(2).getTransactions()){
			System.out.println(tran.toString());
		}
		
		for (Transaction tran: testBook.getAccount(3).getTransactions()){
			System.out.println(tran.toString());
		}
	}
}
