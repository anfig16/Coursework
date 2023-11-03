//*****************
//Andrea Figueroa
//HW 6- Recursion
//Programming Exercise 18.25
//Print permutations test program
//Spring 2023
//COSC 1337
//*****************
import java.util.*;

public class PermutationsTestProgram {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String input = scan.next();
		Permutations.displayPermutation(input);
	}
}
