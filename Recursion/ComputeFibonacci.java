//*****************
//Andrea Figueroa
//HW 5- Recursion
//Programming Exercise 18.7
//Computes fibonacci and finds number 
//of times method fib is called
//Spring 2023
//COSC 1174
//*****************
import java.util.*;

public class ComputeFibonacci {
	static int count = 1;
	public static void main(String[] args) {
		//create a scanner
		Scanner imput = new Scanner(System.in);
		System.out.print("Enter an index for a Fibonacci numer: ");
		int index = imput.nextInt();
		
		System.out.println("The Fibonnaci number at index " + index
				+ " is " + fib(index));
		System.out.println("Number of times fib method is called: " + count);
	}
	
	public static long fib(long index) {
		if (index == 0)
			return 0;
		else if(index ==1)
			return 1;
		else {
			count+=2;
			return fib(index-1) + fib(index-2);
		}
		
	}
}
