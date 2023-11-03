//****************************
//COSC 1173 Programming Lab
//Name: Andrea Figueroa
//Date: 10/12/2022
//Ask for Celsius tempterature
//and return it in Fahrenheit
//****************************
import java.util.*;
public class MethodsTemperature {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Please input the temperature in Celsius: ");
		double CTemp = console.nextDouble();
		double FTemp = celsiusToFahrenheit(CTemp);
		System.out.printf("%d Celsius equals to %.1f Fahrenheit.\n\n",(int)CTemp, FTemp);
		
		//bonus
		System.out.println("Celsius     Fahrenheit");
		double f = 0.0;
		for(double x=40.0; x>=31.0; x--) {
			System.out.print(x + "        ");
			f = celsiusToFahrenheit(x);
			System.out.printf("%.1f\n", f);
		}
		
	}
	//converts from Celsius to Fahrenheit
	public static double celsiusToFahrenheit(double celsius) {
		double fTemp = ((double)9/5) * celsius + 32;
		return fTemp;
	}
}
