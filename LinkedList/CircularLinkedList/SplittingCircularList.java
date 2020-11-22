//Splitting starting N nodes into new Circular Linked List while preserving the old nodes

// avac -d classes SplittingCircularList.java  && cd classes && java SplittingCircularList && cd ..
public class SplittingCircularList { 

	Node last; 

	static class Node { 
		int data; 
		Node next; 
	}; 

	// Function to add a node to the empty list 
	public Node addToEmpty(int data) 
	{ 
		// If not empty 
		if (this.last != null) 
			return this.last; 

		// Creating a node dynamically 
		Node temp = new Node(); 

		// Assigning the data 
		temp.data = data; 
		this.last = temp; 

		// Creating the link 
		this.last.next = this.last; 

		return last; 
	} 

	// Function to add a node to the 
	// beginning of the list 
	public Node addBegin(int data) 
	{ 

		// If list is empty 
		if (last == null) 
			return addToEmpty(data); 

		// Create node 
		Node temp = new Node(); 
		// Assign data 
		temp.data = data; 

		temp.next = this.last.next; 
		this.last.next = temp; 

		return this.last; 
	} 

	// Function to traverse and print the list 
	public void traverse() 
	{ 
		Node p; 

		// If list is empty 
		if (this.last == null) { 
			System.out.println("List is empty."); 
			return; 
		} 

		// Pointing to the first Node of the list 
		p = this.last.next; 

		// Traversing the list 
		do { 
			System.out.print(p.data + " "); 
			p = p.next; 
		} while (p != this.last.next); 

		System.out.println(""); 
	} 

	// Function to find the length of the CircularLinkedList 
	public int length() { 
		// Stores the length 
		int x = 0; 

		// List is empty 
		if (this.last == null) 
			return x; 

		// Iterator Node to traverse the List 
		Node head = this.last.next; 
		while (head.next != this.last.next) { 
			x++; 
			head = head.next; 
		} 

		// Return the length of the list 
		return (x + 1); 
	} 

	// Function to split the first k nodes into 
	// a new CircularLinkedList and the remaining 
	// nodes stay in the original CircularLinkedList 
	public Node split(int k) { 

		// Empty Node for reference 
		Node pass = new Node(); 

		// Check if the list is empty 
		// If yes, then return null 
		if (this.last == null) 
			return this.last; 

		// NewLast will contain the last node of the new split list 
		// itr to iterate the node till the required node 
		Node newLast, itr = this.last; 
		for (int i = 0; i < k; i++) { 
			itr = itr.next; 
		} 

		// Update NewLast to the required node and 
		// link the last to the start of rest of the list 
		newLast = itr; 
		pass.next = itr.next; 
		newLast.next = this.last.next; 
		this.last.next = pass.next; 

		// Return the last node of the required list 
		return newLast; 
	} 

	// Driver code 
	public static void main(String[] args) {

		SplittingCircularList clist = new SplittingCircularList(); 
		clist.last = null; 

		clist.addToEmpty(12); 
		clist.addBegin(10); 
		clist.addBegin(8); 
		clist.addBegin(6); 
		clist.addBegin(4); 
		clist.addBegin(2); 

		System.out.println("Original list:"); 
		clist.traverse(); 

		int k = 4; 

		// Create a new list for the starting k nodes 
		SplittingCircularList clist2 = new SplittingCircularList(); 

		// Append the new last node into the new list 
		clist2.last = clist.split(k); 

		// Print the new lists 
		System.out.println("The new lists are:"); 
		clist2.traverse(); 
		clist.traverse(); 
	} 
} 



/*Splitting starting N nodes into new Circular Linked List while preserving the old nodes
Given a circular linked list with N nodes and an integer K where 0 < K < N, 
the task is to split the first K nodes into a new list and at the same time preserving 
the rest of the nodes in the original circular linked list.

Examples:

Input: 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8, K = 3
Output:
Original list:
2 3 4 5 6 7 8
The new lists are:
2 3 4
5 6 7 8

Input: 2 -> 4 -> 6 -> 8- > 10 -> 12, N = 4
Output:
Original list:
2 4 6 8 10 12
The new lists are:
2 4 6 8
10 12*/