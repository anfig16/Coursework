//*****************
//Andrea Figueroa
//HW 6- Recursion
//Programming Exercise 18.22
//Decimal to hex test program
//Spring 2023
//COSC 1337
//*****************
import java.util.*;

public class dec2HexTestProgram {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a decimal number: ");
		int value = scan.nextInt();
		String hexResult = DecToHexRecursion.dec2Hex(value);
		System.out.println("Hex equivalent of " + value + " is " + hexResult);
		
	}
}
