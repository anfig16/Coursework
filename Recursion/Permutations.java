//*****************
//Andrea Figueroa
//HW 6- Recursion
//Programming Exercise 18.25
//Prints out all permutations of a string
//Spring 2023
//COSC 1337
//*****************
public class Permutations {

	public static void displayPermutation(String s) {
		displayPermutation(" ", s);
	}
	
	//helper method
	public static void displayPermutation(String s1, String s2) {
		if(s2.equals("")) {
			System.out.println(s1);
		} else {
			for(int x=0; x<s2.length(); x++) {
				displayPermutation(s1 + s2.substring(x, x+1), s2.substring(0,x) + s2.substring(x+1));
			}
		}	
	}
	
}
