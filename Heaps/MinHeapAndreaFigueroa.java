/* Andrea Figueroa
 * COSC 2336-01
 * Instructor: Jiangjiang Liu
 * Programming Assignment 6
 * Due: 10/4/2023
 * Uses the MinHeap class with a array of Integers
 * and a array of Strings and prints each of their 
 * objects out in increasing order  */

public class MinHeapAndreaFigueroa {
	public static void main(String[] args) {
		/** test with Integers */
		Integer[] myIntegers = { 8, 9, 2, 3, 4, 1, 5, 6, 7 };
		
		System.out.println("Unsorted Integers in the array: ");
		for (int i = 0; i < myIntegers.length; i++) {
			System.out.print(myIntegers[i] + " ");
		}
		System.out.println();
		
		MinHeap<Integer> heap = new MinHeap<Integer>(myIntegers);
		System.out.println("Sorted Integers: ");
		while (heap.getSize() > 0) {
			System.out.print(heap.remove() + " ");
		}
		System.out.println();
		
		/** test with Strings */
		String[] myStrings = { "Computer ", "Science ", "Rocks " };
		System.out.println("Unsorted Strings in the array: ");
		for (int i = 0; i < myStrings.length; i++) {
			System.out.print(myStrings[i]);
		}
		System.out.println();
		
		System.out.println("Sorted Strings: ");
		MinHeap<String> stringHeap = new MinHeap<String>(myStrings);
		while (stringHeap.getSize() > 0) {
			System.out.print(stringHeap.remove());
		}
	}
}
