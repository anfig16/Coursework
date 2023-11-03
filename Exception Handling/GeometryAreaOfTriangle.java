//*****************
//Andrea Figueroa
//HW 4- Exception Handling
//Programming Exercise 2.19
//Spring 2023
//COSC 1337
//*****************
import java.util.*;
public class GeometryAreaOfTriangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter three points for a triangle: ");
		double x1 = scan.nextDouble();
		double y1 = scan.nextDouble();
		double x2 = scan.nextDouble();
		double y2 = scan.nextDouble();
		double x3 = scan.nextDouble();
		double y3 = scan.nextDouble();
		System.out.printf("The area of the triangle is %.1f", getArea(x1, y1, x2, y2, x3, y3));
		
	}
	public static double getArea(double x1, double y1, double x2, double y2, double x3, double y3) {
		double side1 = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
		double side2 = Math.sqrt(Math.pow(x2-x3, 2)+Math.pow(y2-y3, 2));
		double side3 = Math.sqrt(Math.pow(x3-x1, 2)+Math.pow(y3-y1, 2));
		double s = (side1+side2+side3)/2;
		double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return area;
	}
}
