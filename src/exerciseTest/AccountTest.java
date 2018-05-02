package exerciseTest;

import static org.junit.Assert.*;
import exercise.*;
import org.junit.*;

public class AccountTest {
	private static Account account; 
	private static final long INIT_ACCOUNT_BALANCE = 0;

	public AccountTest() {
		
		
	}

	@BeforeClass
	public static void setUpAccount() {
		AccountTest.account = new Account(INIT_ACCOUNT_BALANCE);
	}

	@Before
	public void setUp() {
		account.setBalance(INIT_ACCOUNT_BALANCE);
	} 

	@Test
	public void testAccountBalance() {
		assertEquals(INIT_ACCOUNT_BALANCE, account.getBalance());
	}

	@Test
	public void inpaymentTest() throws AccountException {
		account.inpayment(500);
		account.inpayment(200);
		assertEquals(INIT_ACCOUNT_BALANCE + 500 + 200, account.getBalance());
	}

	@Test(expected = AccountException.class)
	public void inpaymentNegativeTest() throws AccountException {
		account.inpayment(-200);
	}

	@Test
	public void inpaymentZeroTest() throws AccountException {
		long balanceBefore = account.getBalance();
		account.inpayment(0);
		assertEquals(balanceBefore, account.getBalance());
	}
	@Test
	public void outpaymentTest() throws AccountException {
		account.outpayment(500);
		account.outpayment(200);
		assertEquals(INIT_ACCOUNT_BALANCE - 500 - 200, account.getBalance());
	}
	
	@Test
	public void outpaymentZeroTest() throws AccountException {
		long balanceBefore = account.getBalance();
		account.outpayment(0);
		assertEquals(balanceBefore, account.getBalance());
	}
	
	@Test(expected = AccountException.class)
	public void outpaymentNegativeTest() throws AccountException {
		account.outpayment(-200);
	}
	
	@Test
	public void isPositiveTest() throws AccountException {
		account.inpayment(200);
		assertTrue(account.isBalancePositive());
	}
	
	@Test
	public void isNegativeTest() throws AccountException {
		account.outpayment(200);
		assertFalse(account.isBalancePositive());
	}
}