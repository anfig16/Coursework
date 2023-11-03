/* Andrea Figueroa
 * COSC 2336-01
 * Instructor: Jiangjiang Liu
 * Programming Assignment 7
 * Due: 10/11/2023
 * Tests out the five methods defined
 * in the MyLinkedListExtra class */
import java.util.*;

public class MyLinkedListAugmentedAndreaFigueroa {
	public static void main(String[] args) {
		MyLinkedListExtra<String> myList = new MyLinkedListExtra<>();
		myList.add("Mike");
		myList.add("Jim");
		myList.add("Alice");
		myList.add("George");
		myList.add("Stevie");
		myList.add("Cheryl");
		myList.add("George");
		myList.add("Jane");
		myList.add("Ella");
		myList.add("Jenny");
		myList.add("Kathy");
		myList.add("Jane");
		
		System.out.println("Original list:\n" + myList.toString());
		System.out.print("Enter a name: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		System.out.print("Enter an index at which to store this name: ");
		int index = scan.nextInt();
		
		myList.set(index, name);
		
		System.out.println("Revised list:\n" + myList.toString());
		System.out.println("List contains Sue: " + myList.contains("Sue"));
		System.out.println("Item at index 3: " + myList.get(3));
		System.out.println("Index of George: " + myList.indexOf("George"));
		System.out.println("Last index of George: " + myList.lastIndexOf("George"));
		
		
	}
}
