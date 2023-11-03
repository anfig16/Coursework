//****************************
//COSC 1173 Programming Lab
//Name: Andrea Figueroa
//Date: 9/14/2022
//Determine BMI weight status
//****************************
import java.util.*;
public class CalculatorBMI {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input your BMI: ");
		double BMI = scan.nextDouble();
		String status = "";
		if(BMI<18.5) {
			status = "Underweight";
		}
		if(18.5<= BMI && BMI<25.0) {
			status = "Normal or Healthy Weight";
		}
		if(25.0<=BMI && BMI<30) {
			status = "Overweight";
		}
		if(BMI>=30) {
			status = "Obese";
		}
		System.out.println("Your weight status is: " + status);
		scan.close();
	}
}
