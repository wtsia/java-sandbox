/**
 * Description of program: (write a description here)
 * @authors (write your names here)
 * @since (write date here)
 */
public class BankAccount {
	double accountBalance;
	StringBuilder accountHistory = new StringBuilder();
	private double balance;
	
	/**
	 * Default constructor set to 0 balance
	 */
	public BankAccount() {
		this.balance = 0;
	}
	
	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}
	
	public double deposit(double amountDeposit) {
		balance = balance + amountDeposit;
		System.out.println("Deposited " + amountDeposit);
		accountHistory.append("Deposited " + amountDeposit + ", ");
		return balance;
	}
	
	public double withdraw(double amountWithdraw) {
		if (balance - amountWithdraw > 0) {
			balance = balance - amountWithdraw;
			System.out.println("Withdrew " + amountWithdraw);
			accountHistory.append("Withdrew " + amountWithdraw + ", ");
			return balance;
		} else {
			System.out.println("Not enough funds!");
			return balance;
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double amountBalance) {
		this.balance = amountBalance;
	}
	
	public void printInfo() {
		System.out.println("Printing...");
		System.out.println("\nYour Balance is: " + balance);
		System.out.println("Your transactions are:");
		System.out.println(this.accountHistory);
	}
}
