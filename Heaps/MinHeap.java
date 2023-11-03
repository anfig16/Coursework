/* Andrea Figueroa
 * COSC 2336-01
 * Instructor: Jiangjiang Liu
 * Programming Assignment 6
 * Due: 10/4/2023
 * Modifies the Listing 23.9 for the Heap class
 * to create a MinHeap (that takes any type of array) 
 * in which each node is less than or equal to any 
 * of its children */

public class MinHeap<E> {
	private java.util.ArrayList<E> list = new java.util.ArrayList<>();
	  private java.util.Comparator<? super E> c;
	  
	  /** Create a default heap using a natural order for comparison */
	  public MinHeap() {
	    this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
	  }

	  /** Create a heap with a specified comparator */
	  public MinHeap(java.util.Comparator<E> c) {
	    this.c = c;
	  }
	  
	  /** Create a heap from an array of objects */
	  public MinHeap(E[] objects) {
	    this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
	    for (int i = 0; i < objects.length; i++)
	      add(objects[i]);
	  }

	  /** Add a new object into the heap */
	  public void add(E newObject) {
	    list.add(newObject); // Append to the heap
	    int currentIndex = list.size() - 1; // The index of the last node

	    while (currentIndex > 0) {
	      int parentIndex = (currentIndex - 1) / 2;
	      // Swap if the current object is less than its parent
	      if (c.compare(list.get(currentIndex),list.get(parentIndex)) < 0) {  
	        E temp = list.get(currentIndex);
	        list.set(currentIndex, list.get(parentIndex));
	        list.set(parentIndex, temp);
	      }
	      else
	        break; // the tree is a heap now
	      
	      currentIndex = parentIndex;
	    }
	  }

	  /** Remove the root from the heap */
	  public E remove() {
	    if (list.size() == 0) return null;

	    E removedObject = list.get(0);
	    list.set(0, list.get(list.size() - 1));
	    list.remove(list.size() - 1);

	    int currentIndex = 0;
	    
	    while (currentIndex < list.size()) {
	      int leftChildIndex = 2 * currentIndex + 1; 
	      int rightChildIndex = 2 * currentIndex + 2;

	      // Find the minimum between two children
	      if (leftChildIndex >= list.size()) break; // The tree is a heap
	     
	      int minIndex = leftChildIndex;
	      if (rightChildIndex < list.size()) { //checks that rightChildIndex is not outOfBounds
	    	//if the rightChildIndex is smaller than leftChildIndex it swaps them
	        if (c.compare(list.get(minIndex),list.get(rightChildIndex)) > 0) {  
	          minIndex = rightChildIndex;
	        }
	      }

	      // Swap if the current node is more than the minIndex
	      if (c.compare(list.get(currentIndex), list.get(minIndex)) > 0) {  
	        E temp = list.get(minIndex);
	        list.set(minIndex, list.get(currentIndex));
	        list.set(currentIndex, temp);
	        currentIndex = minIndex;
	      }
	      else
	        break; // The tree is a heap
	    }
	    
	    return removedObject;
	  }

	  /** Get the number of nodes in the tree */
	  public int getSize() {
	    return list.size();
	  }
	  
	  /** Return true if heap is empty */
	  public boolean isEmpty() {
	    return list.size() == 0;
	  }
}
