//*****************
//Andrea Figueroa
//HW 3- Exception Handling
//Spring 2023
//COSC 1174
//*****************

public class ExceptionHandling {
	public static void main(String[] args) {
		String binary = "1101";
		String binary2 = "1210";

		/*tries bin2Dec method with the String binary and binary2, if the method
		 * throws the BinaryFormatException it catches and deals with it*/
		try {
			bin2Dec(binary);
			bin2Dec(binary2);
		} catch(BinaryFormatException bfe) {
			System.out.println("String entered is not a binary string");
		}
		
	}
	
	public static void bin2Dec(String bin) throws BinaryFormatException{
		int binInt = Integer.parseInt(bin);
		
		/*checks each digit of the String bin turned int binInt to see
		 * if it is binary; if it includes a number other than 1 or 0
		 * then it throws custom BinaryFormatException*/
		while (binInt != 0) {
			int temp = binInt%10;
			if(temp==1 || temp==0) {
				binInt = binInt/10;
			} else {
				throw new BinaryFormatException();
			}
		}
		
		//converts String bin to decimal and prints it
		int binToDec = Integer.parseInt(bin, 2);
		System.out.println(bin + " in decimal form is " +binToDec);
	}
}
