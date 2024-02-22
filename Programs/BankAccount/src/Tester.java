/**
 * Description of program: (write a description here)
 * @authors (write your names here)
 * @since (write date here)
 */
import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BankAccount myAccount = new BankAccount();
		char menuStatus = 'y';
		welcome();
		
		while(menuStatus == 'y') {
			bankMenu();
			String userInput = input.next().toLowerCase();
			userInput = userInput.split(" ")[0];
			System.out.println(userInput);
			try {
				if (!userInput.equals("e")) {
					double amountTransfer;
					switch (userInput) {
						case "deposit":
							System.out.println("Enter an amount to deposit:");
							System.out.print(">> ");
							amountTransfer = input.nextDouble();
							myAccount.deposit(amountTransfer);
							break;
						case "withdraw":
							System.out.println("Enter an amount to withdraw:");
							System.out.print(">> ");
							amountTransfer = input.nextDouble();
							myAccount.withdraw(amountTransfer);
							break;
						case "print":
							myAccount.printInfo();
							break;
						default:
							System.out.println("Not a valid input.");
							break;
					}
				} else {
					menuStatus = 'n';
					System.out.println("Goodbye!");
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println("Error!");
			}
		}
	}
	
	public static void bankMenu() {
		System.out.println("\nPlease choose one of the following \nactions via typing commands:\n");
		System.out.println("* Deposit");
		System.out.println("* Withdraw");
		System.out.println("* Print Statement");
		System.out.println("To exit, please type \"e\"\n");
		System.out.print(">> ");
	}
	
	public static void welcome() {
		System.out.println("********************************");
		System.out.println("| Welcome to Java Mutual Bank. |");
		System.out.println("********************************");
	}
}
