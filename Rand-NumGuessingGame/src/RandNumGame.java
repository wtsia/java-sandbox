import java.util.Scanner;
import java.util.Random;

/**
 * A program that mimics a number guessing game. Uses the Random method from
 * java.util.Random to create a randomly generated number generated based on
 * time. This however also means that given time, a user may be able to
 * deterministically ascertain the number.
 * 
 * @author Winston Tsia
 * @date 10/29/2022
 */
public class RandNumGame {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			Random randGen = new Random();

			// Declared variables
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

			// checks if input array is initialized to default values
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

			// produces a random number based on the calculated magnitude absVal and
			// indexes it to begin at the smaller end of the range
			randNum = randGen.nextInt(absVal) + inputArray[0];
			guessOdds = 100 - oddsCalculator(guessLimit, absVal) * 100;
			introduction(guessLimit, guessOdds, inputArray);

			// logic that checks for guess limits and maintains the game.
			while (validInput == true) {
				guessNum = input.nextInt();
				guessCounter++;
				guessRemaining = guessLimit - guessCounter;
				if (guessCounter == guessLimit) {
					System.out.printf("Close! But no cigar. The answer was %d. Better luck next time!", randNum);
					System.exit(0);
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
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

	/**
	 * Welcome method that prints out a welcome page
	 */
	public static void welcome() {
		System.out.println("This is a guessing game.");
		System.out.println("enter the lowest and highest values for the range:");
		System.out.print("> ");
	}

	/**
	 * A method that organizes 2 input numbers into a 3 element array as well as
	 * calculates the distance between the two, and returns the result as a filled 3
	 * element array. If an invalid range is given, it outputs an empty array and a
	 * statement to 'try again'.
	 * 
	 * @param numin1 first user input integer.
	 * @param numin2 second user input integer.
	 * @param array  an empty array to store the compared values and calculation.
	 * @return array
	 */
	public static int[] numCompare(int numin1, int numin2, int[] array) {
		if (numin1 > numin2) {
			array[0] = numin2;
			array[1] = numin1;
			array[2] = array[1] - array[0] + 1;
		} else if (numin2 > numin1) {
			array[0] = numin1;
			array[1] = numin2;
			array[2] = array[1] - array[0] + 1;
		} else {
			System.out.print("This range is 0! You might as well guess your name! \nTry Again!\n> ");
		}
		return array;
	}

	/**
	 * Calculates the probability of guessing 5 unique numbers
	 * 
	 * @param guesses an input guess limit.
	 * @param range   an input value that reflects the magnitude between two input
	 *                numbers
	 * @return odds
	 */
	public static double oddsCalculator(double guesses, double range) {
		double odds = (range - 1) / range;
		for (int i = 1; i < guesses; i++) {
			range--;
			odds = odds * ((range - 1) / range);
		}
		return odds;
	}

	/**
	 * Prints an introductory statement with information relevant for the user, and
	 * queries for guess inputs.
	 * 
	 * @param guessLimit limit of guesses set in the program.
	 * @param guessOdds  variable used to store odds.
	 * @param array      3 element array to store range numbers and a calculated
	 *                   value.
	 */
	public static void introduction(int guessLimit, double guessOdds, int[] array) {
		System.out.println("*******************  Introduction  *********************");
		System.out.printf("You are awarded %d guesses.\n", guessLimit);
		System.out.printf("Assuming %d random unique guesses, your odds of getting it\n", guessLimit);
		System.out.printf("right is: %.2f%%\n", guessOdds);
		System.out.println("May the odds be ever in your favor.");
		System.out.println("********************************************************");
		System.out.printf("I am a number, between %d  and %d. What am I?\n> ", array[0], array[1]);
	}
}
