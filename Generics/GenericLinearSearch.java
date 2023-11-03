//*****************
//Andrea Figueroa
//HW 7- Generics
//Programming Exercise 19.4
//Generic method for linear search
//Spring 2023
//COSC 1174
//*****************
public class GenericLinearSearch {
	public static void main(String[] args) {
		//test linearSearch method with Integer array
		Integer[] myList1 = {1,2,3,4,5,5,6,7,9};
		int key1 = 8;
		int result1 = linearSearch(myList1, key1);
		
		if(result1 == -1) {
			System.out.println("Key \"" + key1 + "\" not found in list");
		} else {
			System.out.println("Key \"" + key1 + "\" found at index " + result1);
		}
		
		
		//test linearSearch method with String array
		String[] myList2 = {"hi", "hello", "hola", "hola", "ciao"};
		String key2 = "hola";
		int result2 = linearSearch(myList2, key2);
		
		if(result2 == -1) {
			System.out.println("Key \""+ key2+ "\" not found in list");
		} else {
			System.out.println("Key \"" + key2 + "\" found at index " + result2);
		}
		
	}
	
	//generic method for finding a key in an array using a linear search method
	//if key is found, then returns its index, else returns -1
	public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
		for(int x=0; x<list.length; x++) {
			if(list[x].equals(key)) {
				return x;
			}
		}
		return -1;
	}
}
