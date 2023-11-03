//****************************
//COSC 1173 Programming Lab
//Name: Andrea Figueroa
//Date: 9/7/2022
//Convert pounds to kilograms
//****************************
import java.util.Scanner;

public class PoundsToKilograms {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number in pounds: ");
		double pounds = scan.nextDouble();
		double kilo = 0.45*pounds;
		System.out.printf("Equals to %.2f kilograms", kilo);
		//printf rounds the kilograms
		scan.close();
	}
}
