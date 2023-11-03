//*****************
//Andrea Figueroa
//HW 4- Exception Handling
//Programming Exercise 11.1
//Spring 2023
//COSC 1337
//*****************
import java.util.*;
public class TestTriangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//user input
		System.out.print("Enter three sides of the triangle: ");
		double side1 = scan.nextDouble();
		double side2 = scan.nextDouble();
		double side3 = scan.nextDouble();
		System.out.print("Enter color: ");
		String color = scan.next();
		System.out.print("Triangle fill (true/false): ");
		boolean filled = scan.nextBoolean();
		//utilizes user input to create Triangle object if no IllegalTriangleException is thrown
		//and prints out info of the triangle
		try {
			Triangle triangle  = new Triangle(side1, side2, side3);
			triangle.setColor(color);
			triangle.setFilled(filled);
			System.out.println("\nArea of the triangle: " + triangle.getArea());
			System.out.println("Perimeter of the triangle: " + triangle.getPerimeter());
			System.out.println("Color of the triangle: " + triangle.getColor());
			System.out.println("Filled: " + triangle.isFilled());
			
		} catch(IllegalTriangleException ite) {
			System.out.println("Illegal triangle sides: sum of two sides is not greater than the other side");
		}
		
	}
}
