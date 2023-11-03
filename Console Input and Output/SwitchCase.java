//****************************
//COSC 1173 Programming Lab
//Name: Andrea Figueroa
//Date: 9/21/2022
//Ask user for number 1-12 and
//print out corresponding month
//****************************
import java.util.*;
public class SwitchCase {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Please input an integer between 1 to 12: ");
		int month = console.nextInt();
		String result = "";
		switch(month) {
			case 1:
				result="January";
				break;
			case 2:
				result="February";
				break;
			case 3:
				result="March";
				break;
			case 4:
				result="April";
				break;
			case 5:
				result="May";
				break;
			case 6:
				result="June";
				break;
			case 7:
				result="July";
				break;
			case 8:
				result="August";
				break;
			case 9:
				result="September";
				break;
			case 10:
				result="October";
				break;
			case 11:
				result="November";
				break;
			case 12:
				result="December";
				break;
			default: 
				System.out.println("Invalid integer, please try again");
				result = "invalid";
		}
		System.out.println("The month is: " + result);
	}	
}
