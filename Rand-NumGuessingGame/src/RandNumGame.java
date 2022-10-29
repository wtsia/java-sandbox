/**
 * Description: 
 * @author Winston
 *
 */
import java.util.Scanner;
import java.util.Random;

public class RandNumGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random randGen = new Random();
		
		int[] inputArray = new int[3];
		boolean validInput = false;
		int num1;
		int num2;
		int absVal = 0;
		int randNum;
		int guessNum;
		int guessRemaining;
		int guessCounter = 0;
		double guessOdds;
		final int guessLimit = 5;
		
		
		welcome();
		
		while (validInput == false) {
			if (inputArray[0] == 0 && inputArray[1] == 0) {
				num1 = input.nextInt();
				num2 = input.nextInt();
				numCompare(num1, num2, inputArray);
			} else {
				absVal = inputArray[2];
				validInput = true;
			}
		}
		
		randNum = randGen.nextInt(absVal) + inputArray[0];
		guessOdds = 100 - oddsCalculator(guessLimit, absVal)*100;
		System.out.println("*******************  Introduction  *********************");
		System.out.printf("You are awarded %d guesses.\n", guessLimit);
		System.out.printf("Assuming %d random unique guesses, your odds of getting it\n", guessLimit);
		System.out.printf("right is: %.2f%%\n", guessOdds);
		System.out.println("May the odds be ever in your favor.");
		System.out.println("********************************************************");
		System.out.printf("I am a number, between %d  and %d. What am I?\n> ", inputArray[0], inputArray[1]);
		
		while (validInput == true) {
			guessNum = input.nextInt();
			guessCounter++;
			guessRemaining = guessLimit - guessCounter;
			if (guessCounter == guessLimit) {
				System.out.printf("Close! But no cigar. The answer was %d. Better luck next time!", randNum);
			} else {
				if (guessNum == randNum) {
					System.out.println("You got it!");
					System.exit(0);
				} else if (guessNum > randNum) {
					System.out.printf("Too high! You have %d guesses left. Try again.\n> ", guessRemaining);
				} else {
					System.out.printf("Too low! You have %d guesses left. Try again.\n> ", guessRemaining);
				}
			}
		}
	}
	
	/**
	 * 
	 */
	public static void welcome() {
		System.out.println("This is a guessing game.");
		System.out.println("enter the lower and highest values for the range:");
		System.out.print("> ");
	}
	
	/**
	 * 
	 * @param numin1
	 * @param numin2
	 * @param array
	 * @return
	 */
	public static int[] numCompare(int numin1, int numin2, int[] array) {
		if (numin1 > numin2) {
			array[0] = numin2;
			array[1] = numin1;
			array[2] = array[1] - array[0];
		} else if (numin2 > numin1) {
			array[0] = numin1;
			array[1] = numin2;
			array[2] = array[1] - array[0];
		} else {
			System.out.print("This range is 0! You might as well guess your name! \nTry Again!\n> ");
		}
		return array;
	}
	
	/**
	 * 
	 * @param guesses
	 * @param range
	 * @return
	 */
	public static double oddsCalculator(double guesses, double range) {
		double odds = (range-1)/range;
		for (int i = 1; i < guesses; i++) {
			range--;
			odds = odds*((range - 1)/range);
		}
		return odds;
	}
}
