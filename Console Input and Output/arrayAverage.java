//****************************
//COSC 1173 Programming Lab
//Name: Andrea Figueroa
//Date: 10/19/2022
//Compute array average 
//as well as the min/max number
//****************************
import java.lang.reflect.Array;
import java.util.*;
public class arrayAverage {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		double[] arr = new double[10];
		System.out.print("Please enter 10 numbers: ");
		for(int x=0; x<arr.length; x++) {
			arr[x] = console.nextDouble();
		}
		double average = average(arr);
		System.out.println("The average of the array is: " + average);
		//Bonus
		System.out.println("\nBonus:");
		double min = min(arr);
		System.out.println("The min number of the array is: " + min);
		double max = max(arr);
		System.out.println("The max number of the array is: " + max);
		
	}
	//returns the average of the array
	public static double average(double[] arr) {
		double total = 0;
		for(int y=0; y<arr.length; y++) {
			total += arr[y];
		}
		double avg = total/arr.length;
		return avg;
	}
	//returns the min number of the array
	public static double min(double[] arr) {
		double min = arr[0];
		for(int m=0; m<arr.length; m++) {
			if(arr[m] < min) {
				min = arr[m];
			}
		}
		return min;
	}
	//returns the max number of the array
	public static double max(double[] arr) {
		double max = arr[0];
		for(int k=0; k<arr.length; k++) {
			if(arr[k] > max) {
				max = arr[k];
			}
		}
		return max;
	}
}
