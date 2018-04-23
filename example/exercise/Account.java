package exercise;

public class Account {

	private long balance;

	public Account(long initialBalance) {
		this.balance = initialBalance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public long getBalance() {
		return balance;
	}

	public void inpayment(long amount) throws AccountException {
		if (amount >= 0) {
			this.balance += amount;
		} else {
			throw new AccountException("No negative inpayments!");
		}
	}

	public void outpayment(long amount) throws AccountException {
		if(amount < 0 ) {
			throw new AccountException("No negative outpayments!");
		} else {
		this.balance = balance - amount;
		}
	}
	public boolean isBalancePositive() {
		if(balance >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
