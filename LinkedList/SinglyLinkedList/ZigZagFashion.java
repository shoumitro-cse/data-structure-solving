// Java program to arrange linked list in zigzag fashion
//javac -d classes ZigZagFashion.java  && cd classes && java ZigZagFashion  && cd ..

class ZigZagFashion { 

	/* Link list Node */
	static class Node { 
		int data; 
		Node next; 
	} 
	static Node head = null; 
	static int temp = 0; 

	/*Complexity Analysis:
		Time Complexity: O(n).
		Traversal of list is done only once and it has ‘n’ elements.
		Auxiliary Space: O(1).
		No use of extra data structure for storing values.*/
	static void zigZagList(Node head) { 
		// If flag is true, then next node should be greater in the desired output. 
		boolean flag = true; 

		// Traverse linked list starting from head. 
		Node current = head; 
		while (current != null && current.next != null) { 
				/* "<" relation expected */
			if (flag == true) { 
				/* If we have a situation like A > B > C 
			where A, B and C are consecutive Nodes 
			in list we get A > B < C by swapping B 
			and C */
				if (current.data > current.next.data) { 
					temp = current.data; 
					current.data = current.next.data; 
					current.next.data = temp; 
				} 
			} else { /* ">" relation expected */ 
				/* If we have a situation like A < B < C where 
			A, B and C are consecutive Nodes in list we 
			get A < C > B by swapping B and C */
				if (current.data < current.next.data) { 
					temp = current.data; 
					current.data = current.next.data; 
					current.next.data = temp; 
				} 
			} 

			current = current.next; 

			/* flip flag for reverse checking */
			flag = !(flag); 
		} 
	} 

	/* UTILITY FUNCTIONS */
	/* Function to push a Node */
	static void push(int new_data) 
	{ 
		/* allocate Node */
		Node new_Node = new Node(); 

		/* put in the data */
		new_Node.data = new_data; 

		/* link the old list off the new Node */
		new_Node.next = (head); 

		/* move the head to point to the new Node */
		(head) = new_Node; 
	} 

	/* Function to print linked list */
	static void printList(Node Node) 
	{ 
		while (Node != null) { 
			System.out.print(Node.data + "->"); 
			Node = Node.next; 
		} 
		System.out.println("NULL"); 
	} 

	/* Driver code*/
	public static void main(String[] args) 
	{ 
		/* Start with the empty list */
		// Node head = null; 

		// create a list 4 -> 3 -> 7 -> 8 -> 6 -> 2 -> 1 
		// answer should be -> 3 7 4 8 2 6 1 
		push(1); 
		push(2); 
		push(6); 
		push(8); 
		push(7); 
		push(3); 
		push(4); 

		System.out.println("Given linked list "); 
		printList(head); 

		zigZagList(head); 

		System.out.println("Zig Zag Linked list "); 
		printList(head); 
	} 
} 


/*Rearrange a Linked List in Zig-Zag fashion
Last Updated: 16-06-2020
Given a linked list, rearrange 
it such that converted list should be of the 
form a < b > c < d > e < f .. 
where a, b, c.. are consecutive data node of the linked list.

Examples:

Input:  1->2->3->4
Output: 1->3->2->4  //a=1 < b=3 > c=2 < d=4  =>  a < b > c < d

Input:  11->15->20->5->10
Output: 11->20->5->15->10*/