//*****************
//Andrea Figueroa
//HW 11- Lists, Stacks, Queues, and Priority Queues
//Programming Exercise 20.2
//Spring 2023
//COSC 1174
//*****************
import java.util.*;

public class LinkedListNumbers {
	public static void main(String[] args) {
		
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		Scanner scan = new Scanner(System.in);
		
		//Prompts for the numbers
		System.out.print("Number of inputs: ");
		int totalNums = scan.nextInt();
		System.out.print("Enter your " + totalNums + " numbers: ");
		
		/*Stores the numbers entered by the user into the LinkedList,
		  does not store duplicate numbers */
		for(int x=0; x<totalNums; x++) {
			Integer input = Integer.parseInt(scan.next());
			if(!(list1.contains(input))){
				list1.add(input);
			}	
		}
		
		System.out.println();
		System.out.println("Your numbers: " + list1.toString());
		
		/* Asks user if they want to sort, shuffle, or reverse
		their numbers and prints out the result;
		Repeats this process until user enters "Stop" */
		while(true) {
			System.out.print("Sort, Shuffle, or Reverse? (type \"Stop\" to stop) ");
			String answer = scan.next();
			if(answer.equals("Sort")) {
				Collections.sort(list1);
				System.out.println(list1.toString());
			}
			if(answer.equals("Shuffle")) {
				Collections.shuffle(list1);
				System.out.println(list1.toString());
			}
			if(answer.equals("Reverse")) {
				Collections.reverse(list1);
				System.out.println(list1.toString());
			}
			if(answer.equals("Stop")) {
				break;
			}
			
		}
		
		//After user enters "Stop", prints out the final list before ending
		System.out.println("\nFinal result: " + list1.toString());
		scan.close();
	}
}
