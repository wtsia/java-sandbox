/**
 * Description: A program made for an Extra Credit assignment that contains prompt 1 and 2 from Extra Credit
 * @author Winston Tsia
 * @date 10/26/2022
 */
import java.util.Scanner;
import java.util.Arrays;

public class MidtermExtraCredit {	
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		final int size = 10;
		int digitSet[] = new int[size];
		
		welcomePage();
		
		// take input  
		for (int i=0; i<size; i++) {
			digitSet[i] = scnr.nextInt();
		}
		
		int max = maximum(digitSet);
		int min = minimum(digitSet);
		
		// prompt 1
		System.out.println("Maximum value: " + max);
		System.out.println("Minimum value: " + min);
		normalize1(digitSet, max);
		normalize2(digitSet, max, min);
		
		// prompt 2
		System.out.printf("Average: %.2f \n", average(digitSet));
		System.out.printf("\nMedian: %.2f \n", median(digitSet));
	}

	public static void welcomePage() {
		System.out.println("*** Welcome to my Extra Credit (Stats) Program! ***");
		System.out.println("Chooo! Enter the Values:");
	}
	
	// sample data: 10 11 12 13 14 15 16 17 34 21
	// sample data: 1 2 3 4 5 6 7 8 9 10
	// sample data: 1 23 34 555 56 6 78 89 11 0
	public static int minimum(int[] array) {
		int min = array[0];
		for (int i=1; i < array.length; i++)
			if (array [i] < min) {
				min = array[i];
			}
		return min;
	}
	
	public static int maximum(int[] array) {
		int max = array[0];
		for (int i=1; i < array.length; i++)
			if (array [i] > max) {
				max = array[i];
			}
		return max;
	}
	
	public static void normalize1(int[] array, int max) {
		System.out.println("Normalized (max) values: ");
		for (int i=0; i < array.length; i++) {
			System.out.printf("%.2f ", (double)array[i] / max);
		}
		System.out.println();
	}
	
	public static void normalize2(int[] array, int max, int min) {
		System.out.println("Normalized (max-min) values: ");
		for (int i=0; i < array.length; i++) {
			System.out.printf("%.2f ", (double)(array[i]-min) / (max - min));
		}
		System.out.println();
	}
	
	public static double average(int[] array) {
		double total = 0;
		for (int i=0; i < array.length; i++) {
			total += array[i];
		}
		return (total/array.length);
	}
	
	public static double median(int[] array) {
		Arrays.sort(array);
		System.out.print("Sorted Array: ");
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		return ((array[4] + array[5]) / 2.0);
	}
}