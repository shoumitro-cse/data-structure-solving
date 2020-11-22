// Check whether the length of given linked list is Even or Odd

// javac -d classes LengthtOfListEvenOrOdd.java  && cd classes && java LengthtOfListEvenOrOdd && cd ..

import java.io.*; 

// Java program to check length of a given linklist 
class LengthtOfListEvenOrOdd { 
	Node head = null; 

	// Defining structure 
	static class Node { 
		int data; 
		Node next; 
		Node(int data) {
			this.data=data;
			next=null;
		}
	} 

	// Function to check the length of linklist 
	static int LinkedListLength(Node head) { 
		while (head != null && head.next != null) { 
			head = head.next.next; 
		} 
		// System.out.println(head.data);
		if (head == null) 
			return 1; 
		else 
		   return 0; 
	} 
		
	// Push function 
	static void push(Node head, int info) { 
		// Allocating node 
		Node node = new Node(info); 
		// Next of new node to head 
		node.next = (head); 
		// head points to new node 
		head = node; 
	} 

	// Driver code 
	public static void main(String[] args) { 
		LengthtOfListEvenOrOdd list = new LengthtOfListEvenOrOdd();

        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);

		// System.out.println(list.head.data);
		int check = LinkedListLength(list.head); 
		
		// Checking for length of linklist 
		if(check == 0) { 
			System.out.println("Odd"); 
		} else { 
			System.out.println("Even"); 
		} 
	} 
} 

/*Check whether the length of given linked list is Even or Odd
Given a linked list, task is to make a function which check whether
 the length of linked list is even or odd.
Examples:

Input : 1->2->3->4->NULL
Output : Even

Input : 1->2->3->4->5->NULL
Output : Odd*/