// Remove all Fibonacci Nodes from a Circular Singly Linked List
//javac -d classes RemoveAllFibonacciNodes.java  && cd classes && java RemoveAllFibonacciNodes && cd ..

import java.util.*; 

class RemoveAllFibonacciNodes { 

	// Structure for a node 
	static class Node { 
		int data; 
		Node next; 
	}; 

	// Function to insert a node at the beginning 
	// of a Circular linked list 
	static Node push(Node head_ref, int data) 
	{ 
		// Create a new node and make head as next 
		// of it. 
		Node ptr1 = new Node(); 
		Node temp = head_ref; 
		ptr1.data = data; 
		ptr1.next = head_ref; 

		// If linked list is not null then 
		// set the next of last node 
		if (head_ref != null) { 

			// Find the node before head 
			// and update next of it. 
			while (temp.next != head_ref) 
				temp = temp.next; 

			temp.next = ptr1; 
		} 
		else

			// Point for the first node 
			ptr1.next = ptr1; 

		head_ref = ptr1; 
		return head_ref; 
	} 

	// Delete the node from a Circular Linked list 
	static void deleteNode(Node head_ref, Node del) 
	{ 
		Node temp = head_ref; 

		// If node to be deleted is head node 
		if (head_ref == del) 
			head_ref = del.next; 

		// Traverse list till not found 
		// delete node 
		while (temp.next != del) { 
			temp = temp.next; 
		} 

		// Copy the address of the node 
		temp.next = del.next; 

		// Finally, free the memory 
		// occupied by del 
		del = null; 

		return; 
	} 

	// Function to find the maximum node of the circular linked list 
	static int largestElement(Node head_ref) { 
		// Pointer for traversing 
		Node current; 
		// Initialize head to the current pointer 
		current = head_ref; 
		// Initialize min int value to max 
		int maxEle = Integer.MIN_VALUE; 
		// While the last node is not reached 
		do { 
			// If current node data is greater for max then replace it 
			if (current.data > maxEle) { 
				maxEle = current.data; 
			} 

			current = current.next; 
		} while (current != head_ref); 

		return maxEle; 
	} 

	// Function to create hash table to check Fibonacci numbers 
	static void createHash(HashSet<Integer> hash, int maxElement) { 
		int prev = 0, curr = 1; 
		// Adding the first two elements to the hash 
		hash.add(prev); 
		hash.add(curr); 
		// Inserting the Fibonacci numbers into the hash 
		while (curr <= maxElement) { 
			int temp = curr + prev; 
			hash.add(temp); 
			prev = curr; 
			curr = temp; 
		} 
	} 

	// Function to delete all the Fibonacci nodes from the singly circular linked list 
	static void deleteFibonacciNodes(Node head) { 
		// Find the largest node value in Circular Linked List 
		int maxEle = largestElement(head); 
		// Creating a hash containing all the Fibonacci numbers 
		// upto the maximum data value in the circular linked list 
		HashSet<Integer> hash = new HashSet<Integer>(); 
		createHash(hash, maxEle); 
		Node ptr = head; 
		// Traverse the list till the end 
		do { 
			// If the node's data is Fibonacci, delete node 'ptr' 
			if (hash.contains(ptr.data)) {
				deleteNode(head, ptr); 
			}
			// Point to the next node 
			ptr = ptr.next; 
		} while (ptr != head); 
	} 

	// Function to print nodes in a given Circular linked list 
	static void printList(Node head) 
	{ 
		Node temp = head; 
		if (head != null) { 
			do { 
				System.out.printf("%d ", temp.data); 
				temp = temp.next; 
			} while (temp != head); 
			System.out.printf("\n"); 
		} 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		// Initialize lists as empty 
		Node head = null; 

		// Created linked list will be 
		// 9.11.34.6.13.20 
		head = push(head, 20); 
		head = push(head, 13); 
		head = push(head, 6); 
		head = push(head, 34); 
		head = push(head, 11); 
		head = push(head, 9); 

		printList(head);

		deleteFibonacciNodes(head); 

		printList(head); 
	} 
} 

/*
Remove all Fibonacci Nodes from a Circular Singly Linked List
Given a circular singly linked list containing N nodes, the task is to 
remove all the nodes from the list which contains Fibonacci data values.

Examples:

Input: CLL = 9 -> 11 -> 34 -> 6 -> 13 -> 20
Output: 9 -> 11 -> 6 -> 20
Explanation:
The list contains 2 fibonacci data values 32 and 13.
Therefore, the nodes containing this data has been deleted

Input: 5 -> 11 -> 16 -> 21 -> 17 -> 10
Output: 11 -> 16 -> 17 -> 10
Explanation:
The list contains 2 fibonacci data values 5 and 21.
Therefore, the nodes containing this data has been deleted*/