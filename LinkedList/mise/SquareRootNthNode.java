// Squareroot(n)-th node in a Linked List
//javac -d classes SquareRootNthNode.java  && cd classes && java SquareRootNthNode && cd ..

class SquareRootNthNode { 

	// Linked list node 
	static class Node { 
		int data; 
		Node next; 
	} 
	static Node head = null; 

	// Function to get the sqrt(n)th 
	// node of a linked list 
	static int printSqrtNode(Node head) {

		Node sqrtn = null; 
		int i = 1, j = 1; 
		
		// Traverse the list 
		while (head != null) 
		{ 
			// check if j = sqrt(i) 
			if (i == j * j) 
			{ 
				// for first node 
				if (sqrtn == null) 
					sqrtn = head; 
				else
					sqrtn = sqrtn.next; 
				
				// increment j if j = sqrt(i) 
				j++; 
			} 
			i++; 
			
			head=head.next; 
		} 
		
		// return node's data 
		return sqrtn.data; 
	} 

	static void print(Node head) 
	{ 
		while (head != null) 
		{ 
			System.out.print( head.data + " "); 
			head = head.next; 
		} 
		System.out.println(); 
	} 

	// function to add a new node at the 
	// beginning of the list 
	static void push( int new_data) 
	{ 
		// allocate node 
		Node new_node = new Node(); 
		
		// put in the data 
		new_node.data = new_data; 
		
		// link the old list off the new node 
		new_node.next = head; 
		
		// move the head to point to the new node 
		head = new_node; 
	} 

	/* Driver code*/
	public static void main(String[] args) 
	{ 
		/* Start with the empty list */
		push( 40); 
		push( 30); 
		push( 20); 
		push( 10); 
		System.out.print("Given linked list is:"); 
		print(head); 
		System.out.print("sqrt(n)th node is " + printSqrtNode(head)+"\n"); 
	} 
} 

/*Squareroot(n)-th node in a Linked List

Given a Linked List, write a function that accepts the head node of the linked list 
as a parameter and returns the value of node present at (floor(sqrt(n)))th position
in the Linked List, where n is the length of the linked list or the total number of 
nodes in the list.
Examples:

Input: 1->2->3->4->5->NULL
Output: 2

Input : 10->20->30->40->NULL
Output : 20

Input : 10->20->30->40->50->60->70->80->90->NULL
Output : 30*/