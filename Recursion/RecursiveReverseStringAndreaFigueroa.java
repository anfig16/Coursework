/* Andrea Figueroa
 * COSC 2336-01
 * Programming Assignment 1
 * Due: 8/30/2023
 * Submitted: 8/28/2023
 * Program prompts user for a string then calls the 
 * reverseDisplay method to display its reversal */

import java.util.*;

public class RecursiveReverseStringAndreaFigueroa {
	public static void main(String[] args) {
		System.out.print("Enter a string: ");
		Scanner scan = new Scanner(System.in);
		String words = scan.nextLine();
		System.out.print("The reversal of " + words + " is ");
		reverseDisplay(words);
	}
	
	public static void reverseDisplay(String value) {
		int index = value.length()-1;
		if(index == 0) {
			System.out.print(value.substring(0, 1));
		} else {
			System.out.print(value.substring(index, index+1));
			reverseDisplay(value.substring(0,index));
		}
	}
}
