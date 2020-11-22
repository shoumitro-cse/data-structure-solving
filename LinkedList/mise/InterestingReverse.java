// An interesting method to print reverse of a linked list
//javac -d classes InterestingReverse.java  && cd classes && java InterestingReverse && cd ..

import java.io.*; 
import java.util.*; 

// Represents node of a linkedlist 
class Node { 
	int data; 
	Node next; 
	Node(int val) 
	{ 
		data = val; 
		next = null; 
	} 
} 

public class InterestingReverse 
{ 

	/* Function to reverse the linked list */
	static void printReverse(Node head, int n) 
	{ 
			int j = 0; 
			Node current = head; 
			while (current != null) { 
				
				// For each node, print proper number 
				// of spaces before printing it 
				for (int i = 0; i < 2 * (n - j); i++) 
					System.out.print("_"); 

				// use of carriage return to move back 
				// and print. 
				System.out.println(current.data); 

				current = current.next; 
				j++; 
			} 
	} 

	/* Function to push a node */
	static Node push(Node head, int data) 
	{ 
			Node new_node = new Node(data); 
			new_node.next = head; 
			head = new_node; 

			return head; 
	} 

	/* Function to print linked list and find its 
	length */
	static int printList(Node head) 
	{ 
			// i for finding length of list 
			int i = 0; 
			Node temp = head; 
			while (temp != null) 
			{ 
					System.out.print(temp.data + " "); 
					temp = temp.next; 
					i++; 
			} 

			return i; 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
			/* Start with the empty list */
			Node head = null; 

			// list nodes are as 6 5 4 3 2 1 
			head = push(head, 1); 
			head = push(head, 2); 
			head = push(head, 3); 
			head = push(head, 4); 
			head = push(head, 5); 
			head = push(head, 6); 

			System.out.println("Given linked list: "); 
				
			// printlist print the list and 
			// return the size of list 
			int n = printList(head); 

			// print reverse list with help 
			// of carriage return function 
			System.out.println("\nReversed Linked list: "); 
			printReverse(head, n); 
			System.out.println(); 

	} 
} 

