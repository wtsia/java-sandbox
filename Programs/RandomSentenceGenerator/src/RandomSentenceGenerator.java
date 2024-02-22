/**
 * Description of program: generates random sentences from premade array items, for 'n' sentences given 'n' user input range.
 * @author Winston Tsia
 * @since 11/17/2022
 */
import java.util.Scanner;
import java.util.Random;

public class RandomSentenceGenerator {
	/**
	 * Description of method: takes in String arrays of pre-allocated grammatical types. Iterates randomly through String arrays based on Random class and forms somewhat coherent sentences. Returns the resulting sentence.
	 * @param sentenceArticles
	 * @param sentenceNouns
	 * @param sentenceVerbs
	 * @param sentencePrepositions
	 * @return mySentence
	 */
	public static StringBuilder generateSentence(String[] sentenceArticles, String[] sentenceNouns, String[] sentenceVerbs, String[] sentencePrepositions) {
		String[][]sentenceType = {sentenceArticles, sentenceNouns, sentenceVerbs, sentencePrepositions};
		int[]typeIndex = {0, 1, 2, 3, 0, 1};
		StringBuilder mySentence = new StringBuilder();
		String str;
		Random randGen = new Random();
		int randNum;
		for (int i=0; i<6; i++) {
			int a = typeIndex[i];
			randNum = randGen.nextInt(0,sentenceType[a].length);
			if (i==0) {
				str = sentenceType[a][randNum];
				String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
				mySentence.append(cap);
				mySentence.append(" ");
			} else {
				str = sentenceType[a][randNum];
				mySentence.append(str);
				mySentence.append(" ");
			}
		}
		mySentence.deleteCharAt(mySentence.length()-1).append(". ");
		return mySentence;
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		StringBuilder allSentences = new StringBuilder(); 
		String exitString = "";
		
		String[] sentenceArticles = {"a", "the"};
		String[] sentenceNouns = {"dog", "cat", "panda", "sloth", "koala", "horse", "chihuahua"};
		String[] sentenceVerbs = {"jumped", "skipped", "leaped", "stared"};
		String[] sentencePrepositions = {"at", "near", "above", "toward", "over"};
		
		System.out.println("How many random sentences do you want?");
		int input = scnr.nextInt();
		
		while(!exitString.equals("exit")) {
			if (input > 25 || input < 1) {
				System.out.println("Please choose a number between 1 and 25");
				input = scnr.nextInt();
			} else {
				for (int i=0; i<input; i++) {
					StringBuilder sentence = generateSentence(sentenceArticles, sentenceNouns, sentenceVerbs, sentencePrepositions);
					allSentences.append(sentence);
				}
				exitString = "exit";
			}
		}
		System.out.println(allSentences);
	}
}