//Sorted insert in a doubly linked list with head and tail pointers
// javac -d classes SortedInsertHeadTailPointers.java  && cd classes && java SortedInsertHeadTailPointers && cd ..

import java.io.*; 
import java.util.*; 

// A linked list node 
class Node 
{ 
	int info; 
	Node prev, next; 
} 

class SortedInsertHeadTailPointers 
{ 

	static Node head, tail; 

	// Function to insetail new node 
	static void nodeInsetail(int key) 
	{ 
		Node p = new Node(); 
		p.info = key; 
		p.next = null; 

		// If first node to be insetailed in doubly linked list 
		if (head == null) 
		{ 
			head = p; 
			tail = p; 
			head.prev = null; 
			return; 
		} 

		// If node to be insetailed has value less than first node 
		if (p.info < head.info) // insert first
		{ 
			p.prev = null; 
			head.prev = p; 
			p.next = head; 
			head = p; 
			return; 
		} 
			
		// If node to be insetailed has value more than last node 
		if (p.info > tail.info) // insert last 
		{ 
			p.prev = tail; 
			tail.next = p; 
			tail = p; 
			return; 
		} 

        // insert middle
		// Find the node before which we need to  insert p. 
		Node temp = head.next; 
		while(temp.info < p.info) {
			temp = temp.next; 
		}
				
		// Insert new node before temp 
		(temp.prev).next = p; 
		p.prev = temp.prev; 
		temp.prev = p; 
		p.next = temp; 
	} 

	// Function to print nodes in from left to right 
	static void printList(Node temp) 
	{ 
		while (temp != null) 
		{ 
				System.out.print(temp.info + " "); 
				temp = temp.next; 
		} 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		head = tail = null; 
		nodeInsetail(30); 
		nodeInsetail(50); 
		nodeInsetail(90); 
		nodeInsetail(10); 
		nodeInsetail(40); 
		nodeInsetail(110); 
		nodeInsetail(60); 
		nodeInsetail(95); 
		nodeInsetail(23); 

		System.out.println("Doubly linked list on printing from left to right"); 
		printList(head); 
		System.out.println(); 
	} 
} 



/*Sorted insert in a doubly linked list with head and tail pointers
A Doubly linked list is a linked list that consists of a set of sequentially linked
 records called nodes. Each node contains two fields that are references to the previous 
 and to the next node in the sequence of nodes.

The task is to create a doubly linked list by inserting nodes such that list remains in 
ascending order on printing from left to right. Also, we need to maintain two pointers,
 head (points to first node) and tail (points to last node).

Examples:

Input : 40 50 10 45 90 100 95
Output :10 40 45 50 90 95 100

Input : 30 10 50 43 56 12
Output :10 12 30 43 50 56*/