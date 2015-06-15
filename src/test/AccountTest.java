/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bookkeeping.Account;
import bookkeeping.AccountType;

/**
 * @author Marvin
 *
 */
public class AccountTest {

	Account test;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		test = new Account("testAccount", 1, AccountType.CREDIT);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void testAccountName() {
		assertTrue(test.getName().equals("testName"));
	}
	
	@Test
	public void testAccountNo() {
		assertTrue(test.getId() == 1);
	}
	
	@Test
	public void testAccountType() {
		assertTrue(test.getAccType() == AccountType.CREDIT);
	}
	
	

}
