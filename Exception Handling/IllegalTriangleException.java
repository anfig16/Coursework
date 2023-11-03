//*****************
//Andrea Figueroa
//HW 4- Exception Handling
//Programming Exercise 12.5
//Spring 2023
//COSC 1337
//*****************
public class IllegalTriangleException extends Exception{
	//no-arg constructor
	public IllegalTriangleException() {
	}
	//constructor with message as argument
	public IllegalTriangleException(String message) {
		super(message);
	}
}
