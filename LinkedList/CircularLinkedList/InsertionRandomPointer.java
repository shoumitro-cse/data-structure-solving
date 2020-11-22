// Insertion in a sorted circular linked list when a random pointer is given

// javac -d classes InsertionRandomPointer.java  && cd classes && java InsertionRandomPointer && cd ..

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class InsertionRandomPointer { 
		
	// Node structure 
	static class Node { 
		Node next; 
		int data; 
	}; 

	// Function to create a node 
	static Node create() { 
		Node new_node = new Node(); 
		new_node.next = null; 

		return new_node; 
	} 

	// Function to find and return the head 
	static Node find_head(Node random) { 
		// If the list is empty 
		if (random == null) return null; 
		Node head, temp = random; 
		// Finding the last node of the linked list the last node must have the highest value 
		// if no such element is present then all the nodes of the linked list must be same 
		while (temp.data < temp.next.data && temp.next != random) { 
			temp = temp.next; 
		} 
		// Return the head 
		return temp.next; 
	} 

	// Function to insert a new_node in the list in sorted fashion. Note that this function 
	// expects a pointer to head node as this can modify the head of the input linked list 
	static Node sortedInsert(Node head_ref, Node new_node) { 
		Node current = head_ref; 
		// If the list is empty 
		if (current == null) { // only one node insert
			new_node.next = new_node; 
			head_ref = new_node; 
		} else if (current.data >= new_node.data) { // insert first node
			while (current.next != head_ref) {
				current = current.next; 
			}
			current.next = new_node; 
			new_node.next = head_ref; 
			head_ref = new_node; 
		} else { // insert middle
			while (current.next != head_ref && current.next.data < new_node.data) { 
				current = current.next; 
			} 
			new_node.next = current.next; 
			current.next = new_node; 
		} 
		// Return the new head 
		return head_ref; 
	} 

	// Function to print the nodes of the linked list 
	static void printList(Node start) {
		Node temp; 
		if (start != null) { 
			temp = start; 
			do { 
				System.out.print(temp.data + " "); 
				temp = temp.next; 
			} while (temp != start); 
		} 
	} 

	public static void main(String args[]) { 
		int arr[] = { 12, 56, 2, 11, 1, 90 }; 
		int list_size, i; 
		// Start with an empty linked list 
		Node start = null; 
		Node temp; 
		// Create linked list from the given array 
		for (i = 0; i < 6; i++) { 
			// Move to a random node if it exists 
			if (start != null) { 
		        // System.out.println("Math.random() * 10: "+Math.random() * 10);
				for (int j = 0; j < (Math.random() * 10); j++) { 
					start = start.next; 
				}
            }
			temp = create(); 
			temp.data = arr[i];
			start = sortedInsert(find_head(start), temp); 
		} 
		// Print the contents of the created list 
		printList(find_head(start)); 
		System.out.println();
	} 
} 


/*Insertion in a sorted circular linked list when a random pointer is given.

Given an array arr[] of integers and a pointer to a random node of a circular
sorted linked list (initially empty), the task is to insert all the elements
 of arr[] in the circular linked list.

Examples:

Input: arr[] = {12, 56, 2, 11, 1, 90}
Output: 1 2 11 12 56 90

Input: arr[] = {6, 2, 78, 45, 200}
Output: 2 6 45 78 200*/