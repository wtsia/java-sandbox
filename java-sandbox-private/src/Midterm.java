import java.util.Arrays;
import java.util.Scanner;

/**
 * Description: A program that outputs a simple sideways histogram
 * @author Winston Tsia
 * @date 10/21/2021
 */
public class Midterm {
	public static void welcomePage() {
		System.out.println("*** Winston's Histogram Generator Program ***");
		System.out.println("Enter a set of single digit numbers (-1 to end):");
	}
	public static void generateHistogram(int counters[]) {
		for (int n=0;n<10;n++) {
			System.out.print(n + ": ");
			int counterNum = counters[n];
			for (int m=0;m<counterNum;m++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		welcomePage();
		
		int[] digitSet = new int[100];
		int[] counters = new int[10];
		int inputDigit = scnr.nextInt();
		
		// sample:
		// 1 2 3 4 5 6 7 8 9 2 4 6 8 2 8 6 6 6 1 2 3 4 5 6 7 8 9 0 0 0 6 6 4 8 8 8 10 -1
		// 1 1 1 2 2 2 3 3 3 4 4 4 5 5 5 6 6 7 7 8 8 9 -1
		while (inputDigit != -1) {
			try {
				digitSet[inputDigit] = inputDigit;
				counters[inputDigit]++;
				inputDigit = scnr.nextInt();
			} catch (Exception e) {
				System.out.println("Hey, you gave me something weird. Make sure it's all single digits!");
				System.out.println("Anyways, here is your other data without the weird number:");
				break;
			}
		}
		
		generateHistogram(counters);
		System.out.println("Zai Jian! Sayonara! Goodbye!");
	}
}