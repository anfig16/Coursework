//*****************
//Andrea Figueroa
//HW 7- Generics
//Programming Exercise 19.9
//Generic method for sorting an ArrayList
//Spring 2023
//COSC 1174
//*****************
import java.util.*;
public class SortArrayList {
	public static void main(String[] args) {
		//test sort method with Integer ArrayList
		ArrayList<Integer> myList1 = new ArrayList<>();
		myList1.add(4);
		myList1.add(2);
		myList1.add(7);
		myList1.add(0);
		System.out.println("Original ArrayList: " + myList1);
		sort(myList1);
		System.out.println("Sorted ArrayList: " + myList1);
		
		
		System.out.println();
		
		
		//test sort method with String ArrayList
		ArrayList<String> myList2 = new ArrayList<>();
		myList2.add("d");
		myList2.add("a");
		myList2.add("c");
		myList2.add("b");
		System.out.println("Original ArrayList: " + myList2);
		sort(myList2);
		System.out.println("Sorted ArrayList: " + myList2);
	}
	
	//sorts an ArrayList of any Object type
	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		Collections.sort(list);
	}
}
