//Unrolled Linked List | Set 1 (Introduction)
// Java program to implement unrolled linked list and traversing it. 
//javac -d classes UnrolledLinkedList.java  && cd classes && java UnrolledLinkedList && cd ..

import java.util.*;

class UnrolledLinkedList{
	
	static final int maxElements = 4;

	// Unrolled Linked List Node 
	static class Node 
	{ 
		int numElements; 
		int []array = new int[maxElements]; 
		Node next; 
	}; 

	// Function to traverse am unrolled 
	// linked list and print all the elements
	static void printUnrolledList(Node n) { 
		while (n != null) { 
			// Print elements in current node 
			for(int i = 0; i < n.numElements; i++) {
				System.out.print(n.array[i] + " "); 
			}
			// Move to next node 
			n = n.next; 
		} 
	   System.out.println(); 
	} 

	// Program to create an unrolled linked list 
	// with 3 Nodes 
	public static void main(String[] args) 
	{ 
		Node head = null; 
		Node second = null; 
		Node third = null; 

		// Allocate 3 Nodes 
		head = new Node();
		second = new Node();
		third = new Node();

		// Let us put some values in second 
		// node (Number of values must be 
		// less than or equal to maxElement) 
		head.numElements = 3; 
		head.array[0] = 1; 
		head.array[1] = 2; 
		head.array[2] = 3; 

		// Link first Node with the 
		// second Node 
		head.next = second; 

		// Let us put some values in 
		// second node (Number of values
		// must be less than or equal to 
		// maxElement) 
		second.numElements = 3; 
		second.array[0] = 4; 
		second.array[1] = 5; 
		second.array[2] = 6; 

		// Link second Node with the third Node 
		second.next = third; 

		// Let us put some values in third 
		// node (Number of values must be
		// less than or equal to maxElement) 
		third.numElements = 3; 
		third.array[0] = 7; 
		third.array[1] = 8; 
		third.array[2] = 9; 
		third.next = null; 

		printUnrolledList(head); 
	} 
} 

