//*****************
//Andrea Figueroa
//HW 7- Generics
//Programming Exercise 19.3
//Method removes duplicates from an
//ArrayList of any type and returns it
//Spring 2023
//COSC 1337
//*****************
import java.util.*;

public class NoDuplicates {
	public static void main(String[] args) {
		//remove duplicates of Integer ArrayList and print it out
		ArrayList<Integer> myList = new ArrayList<>();
		myList.add(1);
		myList.add(2);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(4);
		System.out.println("Original list: " + myList);
		System.out.println("List without duplicates: " + removeDuplicates(myList));
		
		//remove duplicates of String ArrayList and print it out
		ArrayList<String> myList2 = new ArrayList<>();
		myList2.add("hi");
		myList2.add("hi");
		myList2.add("wassup");
		myList2.add("hola");
		myList2.add("ciao");
		myList2.add("ciao");
		System.out.println("\nOriginal list: " + myList2);
		System.out.println("List without duplicates: " + removeDuplicates(myList2));

		
	}
	
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> list2 = new ArrayList<>();
		
		for(int x=0; x<list.size(); x++) {
			if(!(list2.contains(list.get(x)))) {
				list2.add(list.get(x));
			}
		}
		
		return list2;
	}
}
