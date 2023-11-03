//*****************
//Andrea Figueroa
//HW 3- Exception Handling
//Spring 2023
//COSC 1174
//*****************

//Custom exception for when a string is not a binary string
public class BinaryFormatException extends  IllegalArgumentException{
	//no-arg constructor for custom exception
	public BinaryFormatException() {
	}
	//constructor with message arg
	public BinaryFormatException(String message) {
		super(message);
	}
}
