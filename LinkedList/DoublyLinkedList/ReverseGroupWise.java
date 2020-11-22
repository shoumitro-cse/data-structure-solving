// Reverse a doubly linked list in groups of given size

// Java implementation to reverse a doubly linked list in groups of given size 

//javac -d classes ReverseGroupWise.java  && cd classes && java ReverseGroupWise && cd ..

import java.io.*; 
import java.util.*; 

// Represents a node of doubly linked list 
class Node 
{ 
	int data; 
	Node next, prev; 
} 

class ReverseGroupWise 
{ 

	// function to get a new node 
	static Node getNode(int data) 
	{ 
		// allocating node 
		Node new_node = new Node(); 
		new_node.data = data; 
		new_node.next = new_node.prev = null; 

		return new_node; 
	} 

	// function to insert a node at the beginning of the Doubly Linked List 
	static Node push(Node head, Node new_node) { 
		// since we are adding at the beginning, prev is always NULL 
		new_node.prev = null; 
		// link the old list off the new node 
		new_node.next = head; 
		// change prev of head node to new node 
		if (head != null) 
			head.prev = new_node; 
		// move the head to point to the new node 
		head = new_node; 
		return head; 
	} 

	// function to reverse a doubly linked list in groups of given size 
	// Time Complexity: O(n).
	static Node reverseListInGroupOfGivenSize(Node head, int k) {

		Node current = head; 
		Node next = null; 
		Node newHead = null; 
		int count = 0; 
		// reversing the current group of k 
		// or less than k nodes by adding them at the beginning of list newHead' 
		while (current != null && count < k) { //k=2. So, count=0,1
			next = current.next; 
			newHead = push(newHead, current); 
			current = next; 
			count++; 
		} 
		//head => null<-10<->8<->4<->2->null
		// first call newHead => 8<->10
		// 2nd call newHead => 2<->4
		if (next != null) { 
			// System.out.println("\nhead: "+head.data);
			//10->2<->4
			head.next = reverseListInGroupOfGivenSize(next, k); //head=10 and head.next=2
			// System.out.println("\nhead.next: "+head.next.data);
			head.next.prev = head; 
		} 
		// newHead => null<-8<->10<-> 2<->4->null
		return newHead; 
	}

// Reverse a Doubly Linked List | Set-2
	static Node reverseList(Node head_ref)  {  
	    // if list is empty or it contains  a single node only  
	    if ((head_ref) == null || ((head_ref).next) == null) return null;  
	  
	    Node new_head = null;  
	    Node curr = head_ref, next;  

	    while (curr != null) {  
	        // get pointer to next node  
	        next = curr.next;  
	        // push 'curr' node at the beginning of the list with starting with 'new_head'  
	        new_head = push(new_head, curr);  
	        // update 'curr'  
	        curr = next;  
	    }  
	    // update 'head_ref'  
	    head_ref = new_head; 
	    return head_ref; 
	}   

	// Function to print nodes in a given doubly linked list 
	static void printList(Node head) { 
		while (head != null) { 
			System.out.print(head.data + " "); 
			head = head.next; 
		} 
	} 

	// Driver code 
	public static void main(String args[]) {

		// Start with the empty list 
		Node head = null; 
			
		// Create doubly linked: 10<->8<->4<->2 
		head = push(head, getNode(2)); 
		head = push(head, getNode(4)); 
		head = push(head, getNode(8)); 
		head = push(head, getNode(10)); 

		int k = 2; 
			
		System.out.print("Original list: "); 
		printList(head); 

		// Reverse doubly linked list in groups of size 'k' 
		head = reverseListInGroupOfGivenSize(head, k); 

		System.out.print("\nModified list: "); 
		printList(head);
		// printList(reverseList(head));

		System.out.print("\n"); 
	} 
} 


/*Reverse a doubly linked list in groups of given size

Original list: 10 8 4 2
k=2
Modified list: 8 10 2 4*/