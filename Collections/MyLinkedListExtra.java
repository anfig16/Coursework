/* Andrea Figueroa
 * COSC 2336-01
 * Instructor: Jiangjiang Liu
 * Programming Assignment 7
 * Due: 10/11/2023
 * MyLinkedList class with the contains(), get(),
 * indexOf(), lastIndexOf(), and set() methods defined */

public class MyLinkedListExtra<E> extends MyLinkedList<E>{
	  @Override /** Return true if this list contains the element e */
		public boolean contains(Object e) {
			boolean result = false;
			Node<E> currentNode = head;
			for (int x = 0; x < size; x++) {
				if (currentNode.element.equals(e)) {
					result = true;
					break;
				}
				currentNode = currentNode.next;
			}
			return result;
		}

	  @Override /** Return the element at the specified index */
		public E get(int index) {
			Node<E> currentNode = head;
			for (int x = 0; x < index; x++) {
				currentNode = currentNode.next;
			}
			E currentElement = currentNode.element;
			return currentElement;
		}

	  @Override /** Return the index of the first matching element in 
	   *  this list. Return -1 if no match. */
		public int indexOf(Object e) {
		  Node<E> currentNode = head;
		  for (int x = 0; x < size; x++) {
			  if(currentNode.element.equals(e)) {
				  return x;
			  }
			  currentNode = currentNode.next;
		  }
		  return -1;
		}

	  @Override /** Return the index of the last matching element in 
	   *  this list. Return -1 if no match. */
		public int lastIndexOf(E e) {
		  Node<E> currentNode = head;
		  int index = -1;
		  for(int x=0; x<size; x++) {
			  if(currentNode.element.equals(e)) {
				  index = x;
			  }
			  currentNode = currentNode.next;
		  }
		  return index;
	  	}

	  @Override /** Replace the element at the specified position 
	   *  in this list with the specified element. */
		public E set(int index, E e) {
		  	if(index == 0) {
		  		addFirst(e);
		  	} else if(index == size) {
		  		addLast(e);
		  	} else {
		  		Node<E> newNode = new Node<>(e);
		  		Node<E> currentNode = head;
		  		for(int x=0; x<index-1; x++) {
		  			currentNode = currentNode.next;
		  		}
		  		Node<E> nextNode = currentNode.next;
		  		currentNode.next = newNode;
		  		newNode.next = nextNode;
		  		size++;
		  	}
			return null;
		}
}
