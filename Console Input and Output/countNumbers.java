//****************************
//COSC 1173 Programming Lab
//Name: Andrea Figueroa
//Date: 10/5/2022
//Ask for number range
//and inc/dec value and print results
//****************************
import java.util.*;
public class countNumbers {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int samples = 0;
		int start = 0;
		int end = 0;
		int countBy = 0;
		String special = "no";
		
		int num = 1;
		System.out.print("Please enter how many samples: ");
		samples = console.nextInt();
		
		for(int x=0; x<samples; x++) {
			System.out.print("Please enter starting number: ");
			start = console.nextInt();
			System.out.print("Please enter ending number: ");
			end = console.nextInt();
			System.out.print("Please enter counting value (include \"-\" sign): ");
			countBy = console.nextInt();
			System.out.print("Different counting values?(yes/no): ");
			special = console.next();

			System.out.println("\nSample " + num);
			num++;
			
			if((start>end && countBy>0) || (start<end && countBy<0)) { 
				//stop program from running endlessly if error counting value
				System.out.println("Please correct counting value");
				break;
			}
			
			System.out.println(start);
			
			int startLoop = start;
			if(special.equals("yes")) {
				System.out.println(countBy);
				startLoop=countBy;
			}
			while(startLoop!=end){
				if(countBy>0) { 
				//stop program from looping endlessly if error calculating
					if(startLoop>end) {
						break;
					}
				}
				startLoop+=countBy;
				System.out.println(startLoop);
			}
			System.out.println();
		}
	}
}
