/* Andrea Figueroa
 * COSC 2336-01
 * Instructor: Jiangjiang Liu
 * Programming Assignment 2
 * Due: 9/6/2023
 * Submitted: 9/6/2023
 * Prompts user to enter 10 integers and 5 strings, 
 * sorts both through the sort method and displays 
 * the results to the console	*/
import java.util.*;

public class GenericSortAndreaFigueroa {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Prompt for 10 integers
		System.out.print("Enter 10 integers: ");
		ArrayList<Integer> list = new ArrayList<>();
		for(int index = 0; index < 10; index++) {
			list.add(index, scan.nextInt());
		}
		sort(list);
		System.out.print("The sorted numbers are: ");
		for(int k=0;k<list.size();k++) {
			System.out.print(list.get(k) + " ");
		}
		
		//Prompt for 5 strings
		System.out.print("\nEnter 5 strings: ");
		ArrayList<String> list2 = new ArrayList<>();
		for(int index = 0; index < 5; index++) {
			list2.add(index, scan.next());
		}
		sort(list2);
		System.out.print("The sorted strings are: ");
		for(int k=0;k<list2.size();k++) {
			System.out.print(list2.get(k) + " ");
		}
		
	}
	//Generic method that sorts an ArrayList of Comparable items
	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {

		E currentMin = list.get(0);
		int currentMinIndex;
		
		for(int y=0; y<list.size(); y++) {
			currentMinIndex = y;
			currentMin = list.get(y);
			
			for(int x=y; x<list.size(); x++) {
				//Finds the currentMin in values not checked yet
				if(currentMin.compareTo(list.get(x)) > 0) {
					currentMin = list.get(x);
					currentMinIndex = x;
				}
			}
			
			//Sets the currentMin to the front of the list (after any 
			//minimums previously put at the front), and puts whatever 
			//was at the front before in the old place of currentMin
			list.set(currentMinIndex, list.get(y));
			list.set(y, currentMin);	
		}
	}
}
