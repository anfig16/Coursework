/* Andrea Figueroa
 * COSC 2336-01
 * Instructor: Jiangjiang Liu
 * Programming Assignment 5
 * Due: 9/27/2023
 * Submitted: 9/27/2023
 * Prompts user to enter two strings, and checks to see if the
 * second string is contained in the first one. If a match is found,
 * then the starting index of the match is printed, otherwise it prints unmatched*/
import java.util.*;

public class PatternMatchingAndreaFigueroa {
	public static void main(String[] args) {
		
		//Prompt user for two strings
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a string s1: ");
		String s1 = scan.nextLine();
		System.out.print("Enter a string s2: ");
		String s2 = scan.nextLine();
		
		boolean matchResult = false;	//variable to tell if complete match was found
		int index1 = 0;		//variable to keep starting index of the match
		int index2 = 0;		//variable for keeping track of s2 as it matches inside s1
		
		//Goes through s1 checking if it contains s2
		for(int x=0; x<s1.length(); x++) {
			/*Stores the starting match index of s1 in index1 if the current index of s1
			  matches the start of s2 */
			if(s1.charAt(x) == s2.charAt(index2) && index2 == 0) {
				index1 = x;
			} 
			/* Updates index2 to check next index in s2 if current letters match, if it matched 
			   before and doesn't match now then it 1. resets index1 (the start of found match), 
			   2. resets index2 to begin matching from beginning of s2 again, and  3. decrements 
			   x by one so it can check the unmatched letter again against the beginning of s2 */
			if(s1.charAt(x) == s2.charAt(index2)) {
				index2++;
			} else if(index2 >= 1) {
				index1 = -1;
				index2 = 0;
				x--;
			}
			//Breaks out of the loop once the first full match of s2 inside of s1 is found
			if(index2 == s2.length()) {
				matchResult = true;
				break;
			}
		}
		
		//Prints out first index of a match of s2 inside s1 if found
		if(matchResult) {
			System.out.println("matched at index " + index1);
		} else {
			System.out.println("unmatched");
		}
	}
}
