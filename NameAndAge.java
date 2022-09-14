import java.util.Scanner;
import java.util.Calendar;

public class NameAndAge {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Hello, my name is Winston! This is a Homework 4B!");

		// query user for name
		System.out.println("Hello user, what is your name?\nType response below:");
		String name = in.nextLine();

		// output name greeting
		System.out.printf("\nHello, %s!\n", name);
		
		// query user for year of birth
		System.out.println("I must say, it is a beautiful name! What year were you born?\nType response below:");
		int birthYear = in.nextInt();

		Calendar currentDate = Calendar.getInstance();
		int currentYear = currentDate.get(Calendar.YEAR);
		int ageYears = currentYear - birthYear;

		// output age response
		System.out.printf("\nHello, %s! You are approximately %d years old (young!)\n\n", name, ageYears);
	}
}
