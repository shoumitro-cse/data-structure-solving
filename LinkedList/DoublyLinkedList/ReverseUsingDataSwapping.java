// Reverse a Doubly Linked List | Set 4 (Swapping Data)

//javac -d classes ReverseUsingDataSwapping.java  && cd classes && java ReverseUsingDataSwapping && cd ..


class ReverseUsingDataSwapping {

	static class Node { 
		int data; 
		Node prev, next; 
	}; 

	static Node newNode(int val) { 
		Node temp = new Node(); 
		temp.data = val; 
		temp.prev = temp.next = null; 
		return temp; 
	} 

	static void printList(Node head) { 
		while (head.next != null) { 
			System.out.print(head.data+ " <-> "); 
			head = head.next; 
		} 
		System.out.println( head.data ); 
	} 

	// Insert a new node at the head of the list 
	static Node insert(Node head, int val) { 
		Node temp = newNode(val); 
		temp.next = head; 
		head.prev = temp; 
		head = temp; 
	  return head; 
	} 

/*	// Function to reverse the list 
	static Node reverseList(Node head) {

		Node first = head, last = head; 
		// Traverse the list and set last pointer to end of list 
		while (last.next != null) {
			last = last.next; 
		}
		// Swap data of first and last pointer and move 
		// them towards each other until they meet or cross each other 
		while (first != last) { 
			// Swap data of first and last pointer 
			int t = first.data; 
			first.data = last.data; 
			last.data = t; 
			// Advance first pointer 
			first = first.next; 
			// Advance last pointer 
			last = last.prev; 
		} 
		return head; 
	} */

	// Reverse a Doubly linked list using recursion
	static Node reverseList(Node node) {  
	    // If empty list, return  
	    if (node == null) return null;  
	    // Otherwise, swap the next and prev  
	    Node temp = node.next;  
	    node.next = node.prev;  
	    node.prev = temp;  
	    // If the prev is now null, the list has been fully reversed  
	    if (node.prev == null) return node;  
	    // Otherwise, keep going  
	    return reverseList(node.prev);  
	}

	// Driver code 
	public static void main(String args[]) 
	{ 
		Node head = newNode(5); 
		head = insert(head, 4); 
		head = insert(head, 3); 
		head = insert(head, 2); 
		head = insert(head, 1); 

		printList(head); 
		System.out.println("List After Reversing"); 
		head=reverseList(head); 
		printList(head); 

	} 
} 


/*
Reverse a Doubly Linked List | Set 4 (Swapping Data)
Given a Doubly Linked List, we are asked to reverse the list in-place without using any extra space.

Examples:

Input : 1 <--> 2 <--> 5 <--> 6 <--> 7
Output : 7 <--> 6 <--> 5 <--> 2 <--> 1

Input : 11 <--> 22 <--> 33 <--> 22 <--> 1
Output : 1 <--> 22 <--> 33 <--> 22 <--> 11*/