// Partitioning a linked list around a given value and keeping the original order
// javac -d classes PartitioningGivenValue.java  && cd classes && java PartitioningGivenValue && cd ..

class PartitioningGivenValue { 

	/* Link list Node */
	static class Node 
	{ 
		int data; 
		Node next; 
	} 

	// A utility function to create a new node 
	static Node newNode(int data) 
	{ 
		Node new_node = new Node(); 
		new_node.data = data; 
		new_node.next = null; 
		return new_node; 
	} 

	// Function to make two separate lists and return head after concatinating 
	static Node partition(Node head, int x) { 
		
		/* Let us initialize first and last nodes of 
		three linked lists 
			1) Linked list of values smaller than x. 
			2) Linked list of values equal to x. 
			3) Linked list of values greater than x.*/
		Node smallerHead = null, smallerLast = null; 
		Node equalHead = null, equalLast =null; 
		Node greaterHead = null, greaterLast = null; 

		// Now iterate original list and connect nodes 
		// of appropriate linked lists. 
		while (head != null) { // O(n)
			// If current node is equal to x, append it to the list of x values 
			if (head.data == x) { 
				if (equalHead == null) 
					equalHead = equalLast = head; 
				else { 
					equalLast.next = head; 
					equalLast = equalLast.next; 
				} 
			} else if (head.data < x) { 
			  // If current node is less than X, append it to the list of smaller values 
				if (smallerHead == null) 
					smallerLast = smallerHead = head; 
				else { 
					smallerLast.next = head; 
					smallerLast = head; 
				} 
			} else { 
			   // Append to the list of greater values 
				if (greaterHead == null) 
					greaterLast = greaterHead = head; 
				else { 
					greaterLast.next = head; 
					greaterLast = head; 
				} 
			} 
			head = head.next; 
		} 

		// Fix end of greater linked list to NULL if this 
		// list has some nodes 
		if (greaterLast != null) 
			greaterLast.next = null; 

		// Connect three lists 

		// If smaller list is empty 
		if (smallerHead == null) { 
			if (equalHead == null) 
				return greaterHead; 
			equalLast.next = greaterHead; 
			return equalHead; 
		} 

		// If smaller list is not empty 
		// and equal list is empty 
		if (equalHead == null) { 
			smallerLast.next = greaterHead; 
			return smallerHead; 
		} 

		// If both smaller and equal list 
		// are non-empty 
		smallerLast.next = equalHead; 
		equalLast.next = greaterHead; 
		return smallerHead; 
	} 

	/* Function to print linked list */
	static void printList(Node head) 
	{ 
		Node temp = head; 
		while (temp != null) 
		{ 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		/* Start with the empty list */
		Node head = newNode(10); 
		head.next = newNode(4); 
		head.next.next = newNode(5); 
		head.next.next.next = newNode(30); 
		head.next.next.next.next = newNode(2); 
		head.next.next.next.next.next = newNode(50); 

		int x = 3; 
		head = partition(head, x); 
		printList(head); 
		System.out.println();
	} 
} 


/*
Partitioning a linked list around a given value and keeping the original order
Last Updated: 25-02-2020
Given a linked list and a value x, partition it such that all nodes less
 than x come first, then all nodes with value equal to x and 
 finally nodes with value greater than or equal to x. 
 The original relative order of the nodes in each of the three partitions
  should be preserved. The partition must work in-place.

Examples:

Input : 1->4->3->2->5->2->3, 
        x = 3
Output: 1->2->2->3->3->4->5

Input : 1->4->2->10 
        x = 3
Output: 1->2->4->10

Input : 10->4->20->10->3 
        x = 3
Output: 3->10->4->20->10 
*/