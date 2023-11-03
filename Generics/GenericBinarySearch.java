//*****************
//Andrea Figueroa
//HW 7- Generics
//Programming Exercise 19.7
//Generic method for binary search
//Spring 2023
//COSC 1174
//*****************
import java.util.*;
public class GenericBinarySearch {
	public static void main(String[] args) {
		//test binarySearch with Integer array
		Integer[] myList1 = {10, 2, 7, 4, 3, 1, 3};
		int key1 = 7;
		int result1 = binarySearch(myList1, key1);

		if(result1 == -1) {
			System.out.println("Key \"" + key1 + "\" not found in list");
		} else {
			System.out.println("Key \"" + key1 + "\" found at index " + result1);
		}
		
		
		//test binarySearch with String array
		String[] myList2 = {"d", "f", "a", "c", "b", "e"};
		String key2 = "g";
		int result2 = binarySearch(myList2, key2);		
		
		if(result2 == -1) {
			System.out.println("Key \""+ key2+ "\" not found in list");
		} else {
			System.out.println("Key \"" + key2 + "\" found at index " + result2);
		}
		
	}
	
	//generic method for finding a key in an array using a binary search method
	//if key is found, then returns its index, else returns -1
	public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
		Arrays.sort(list);
		int high = list.length -1;
		int low = 0;
		
		while(high >= low) {
			int middle = (low+high)/2;
			if(key.compareTo(list[middle]) < 0) {
				high = middle - 1;
			}
			else if(key.compareTo(list[middle]) == 0) {
				return middle;
			} else {
				low = middle + 1;
			}
		}
		
		return -1;
	}
}
