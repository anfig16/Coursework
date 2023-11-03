//****************************
//COSC 1173 Programming Lab
//Name: Andrea Figueroa
//Date: 10/26/2022
//Compute array row sum 
//****************************
import java.util.*;
public class MultidimensionalArray {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter a 3 by 4 matrix row by row: ");
		double[][] matrix = new double[3][4];
		
		//puts user numbers into array
		for(int x=0; x<matrix.length; x++) {
			for(int y=0; y<matrix[x].length; y++) {
				matrix[x][y] = console.nextDouble();
			}
		}
		System.out.println();
		//calculates sum of each row and prints it out
		for(int x=0; x<matrix.length; x++) {
			double sum = 0;	
			for(int y=0; y<matrix[x].length; y++) {
				sum+=matrix[x][y];
			}
			System.out.println("Sum of the elements at Row " + x + " is: " + sum);
		}
		
		//bonus
		System.out.println("\nBonus:");
		System.out.println("Which column do you want to sum?");
		int column = console.nextInt();
		double columnSum = sumColumn(matrix, column);
		System.out.println("Sum for column " + column + " is: " + columnSum);
	}
	//bonus
	public static double sumColumn(double[][] m, int columnIndex) {
		double sum = 0;
		for(int x=0; x<m.length; x++) {
			sum += m[x][columnIndex];
		}
		return sum;
	}
}
