//****************************
//COSC 1173 Programming Lab
//Name: Andrea Figueroa
//Date: 9/28/2022
//Ask for side measurement
//and print hexagon area
//****************************
import java.util.*;
public class HexagonArea {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter the side: ");
		double side = console.nextDouble();
		double area = (6 * Math.pow(side, 2))/(4 * Math.tan(Math.PI/6));
		System.out.printf("The area of the hexagon is: %.2f", area);
	}
}
