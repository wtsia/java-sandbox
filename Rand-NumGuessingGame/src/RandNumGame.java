import java.util.Scanner;
import java.util.Random;

public class RandNumGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random randGen = new Random();
		
		int[] inputArray = new int[2];
		boolean validInput = false;
		int num1;
		int num2;
		int absVal = 0;
		
		welcome();
		
		while (validInput == false) {
			num1 = input.nextInt();
			num2 = input.nextInt();
			numCompare(num1, num2, absVal, inputArray, validInput);
		}
		
	}
	
	public static void welcome() {
		System.out.println("This is a guessing game.");
		System.out.println("enter the lower and highest values for the range:");
		System.out.print("> ");
	}
	
	public static int[] numCompare(int numin1, int numin2, int absVal, int[] array, boolean statusCheck) {
		if (numin1 > numin2) {
			array[0] = numin2;
			array[1] = numin1;
			statusCheck = true;
			absVal = array[1] - array[0];
			System.out.print("numCompare works!");
		} else if (numin2 > numin1) {
			array[0] = numin1;
			array[1] = numin2;
			statusCheck = true;
			absVal = array[1] - array[0];
			System.out.print("numCompare works!");
		} else {
			System.out.print("This range is 0! You might as well guess your name! \nTry Again!\n> ");
		}
		return array;
	}
}
