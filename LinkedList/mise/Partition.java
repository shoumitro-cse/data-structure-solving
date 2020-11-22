// Java program to partition a linked list around a given value. 
//javac -d classes Partition.java  && cd classes && java Partition && cd ..

class Partition { 

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

 
	static Node partition(Node head, int x) { 
		 // Let us initialize start and tail nodes of new list 
		Node tail = head; 
		// Now iterate original list and connect nodes 
		Node curr = head; 
		while (curr != null) {

			Node next = curr.next; 
			if (curr.data < x) { 
				 // Insert node at head. 
				curr.next = head; 
				head = curr; 
			} else { // Append to the list of greater values 
				 // Insert node at tail. 
				tail.next = curr; 
				tail = curr; 
			} 
			curr = next; 
		} 
		tail.next = null; 
		// The head has changed, so we need to return it to the user. 
		return head; 
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
		System.out.println(" "); 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		/* Start with the empty list */
		Node head = newNode(3); 
		head.next = newNode(5); 
		head.next.next = newNode(8); 
		head.next.next.next = newNode(2); 
		head.next.next.next.next = newNode(10); 
		head.next.next.next.next.next = newNode(2); 
		head.next.next.next.next.next.next = newNode(1); 

		printList(head); 

		int x = 5; 
		head = partition(head, x); 
		printList(head); 
	} 
} 



/*Partitioning a linked list around a given value and If we don’t care about making 
the elements of the list “stable”

Given a linked list and a value x, partition a linked list around a value x, 
such that all nodes less than x come before all nodes greater than or equal to x. 
If x is contained within the list the values of x only need to be after the elements 
less than x (see below). The partition element x can appear anywhere in the 
“right partition”; it does not need to appear between the left and right partitions.

Similar problem : Partitioning a linked list around a given value and keeping the original order

Examples:

Input :  3 -> 5 -> 10 -> 2 -> 8 -> 2 -> 1 
         x = 5
Output : 1-> 2-> 2-> 3-> 5-> 10-> 8*/