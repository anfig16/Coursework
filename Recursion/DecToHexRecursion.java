//*****************
//Andrea Figueroa
//HW 6- Recursion
//Programming Exercise 18.22
//Decimal to hex recursive program
//Spring 2023
//COSC 1337
//*****************
public class DecToHexRecursion {
	static String[] numToHex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	static String ans = "";
	
	public static String dec2Hex(int value) {
		int result = value/16;
		int quotient = value%16;

		if(result==0) {
			ans+= numToHex[quotient];
		} else {
			 dec2Hex(value/16);
			 ans+= numToHex[quotient];
		}
		return ans;
	}
}
