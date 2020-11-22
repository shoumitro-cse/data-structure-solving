// Insert node into the middle of the linked list

//javac -d classes InsertNodeMiddleOfList.java  && cd classes && java InsertNodeMiddleOfList  && cd ..

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class InsertNodeMiddleOfList {

	static Node head; // head of list 

	/* Node Class */
	static class Node { 
		int data; 
		Node next; 
		
		// Constructor to create a new node 
		Node(int d) { 
			data = d; 
			next = null; 
		} 
	} 

/*    // Time Complexity: O(n)
	static void insertAtMid(int x) {

		// if list is empty 
		if (head == null) {
			head = new Node(x); 
		} else { 
			Node newNode = new Node(x); 

			Node ptr = head; 
			int len = 0; 

			while (ptr != null) { 
				len++; 
				ptr = ptr.next; 
			} 

			int count = ((len % 2) == 0) ? (len / 2) : (len + 1) / 2; 
			ptr = head; 

			while (count-- > 1) 
				ptr = ptr.next; 
			newNode.next = ptr.next; 
			ptr.next = newNode; 
		} 
	} */

    // Time Complexity: O(n)
	static void insertAtMid(int x) { 
        // if list is empty 
        if (head == null) {
           head = new Node(x); 
        } else { 
            // get a new node 
            Node newNode = new Node(x); 
            // assign values to the slow and fast pointers 
            Node slow = head; 
            Node fast = head.next; 
  
            while (fast != null && fast.next != null)  { 
                // move slow pointer to next node 
                slow = slow.next; 
                // move fast pointer two nodes  at a time 
                fast = fast.next.next; 
            } 
            // insert the 'newNode' and adjust the required links 
            newNode.next = slow.next; 
            slow.next = newNode; 
        } 
    } 

	// function to display the linked list 
	static void display() { 
		Node temp = head; 
		while (temp != null) { 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} 
		System.out.print("\n"); 
	} 

	// Driver program to test above 
	public static void main (String[] args) { 
		// Creating the list 1.2.4.5 
		head = null; 
		head = new Node(1); 
		head.next = new Node(2); 
		head.next.next = new Node(4); 
		head.next.next.next = new Node(5); 
		
		System.out.println("Linked list before "+ "insertion: "); 
		display(); 

		int x = 3; 
		insertAtMid(x); 

		System.out.println("\nLinked list after"+ " insertion: "); 
		display(); 
	} 
} 

/*Insert node into the middle of the linked list
Given a linked list containing n nodes. The problem is to insert a 
new node with data x at the middle of the list. If n is even, then insert 
the new node after the (n/2)th node, else insert the new node after the (n+1)/2th node.

Examples:

Input : list: 1->2->4->5
        x = 3
Output : 1->2->3->4->5

Input : list: 5->10->4->32->16
        x = 41
Output : 5->10->4->41->32->16*/