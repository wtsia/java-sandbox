/**
 * Description of program: (write a description here)
 * @authors (write your names here)
 * @since (write date here)
 */
public class BankAccount {
	private double balance;
	
	/**
	 * Default constructor set to 0 balance
	 */
	public BankAccount() {
		this.balance = 0.00;
	}
	
	public double deposit(double amountDeposit) {
		balance = balance + amountDeposit;
		return balance;
	}
	
	public double withdraw(double amountWithdraw) {
		if (balance - amountWithdraw > 0) {
			balance = balance - amountWithdraw;
			return balance;
		} else {
			return balance;
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double amountBalance) {
		this.balance = amountBalance;
	}
}
