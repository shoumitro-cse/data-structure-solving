// Java code implementation for above approach 

// javac -d classes Print.java  && cd classes && java Print && cd ..

class Print 
{ 

	/* A linked list node */
	static class Node 
	{ 
		int data; 
		Node next; 
	}; 

	/* Prints a linked list in reverse manner */
	static void print_list(Node head) { 
		if (head == null) { 
			return; 
		} 
		System.out.print(head.data + " "); // forword print
		print_list(head.next); 
		// System.out.print(head.data + " "); //reverse print
	} 

	/* prints alternate nodes of a Linked List, first 
	from head to end, and then from end to head. */
	static void fun2(Node start) { 
		if (start == null) { 
			return; 
		} 

		System.out.print(start.data + " "); 

		if (start.next != null) { 
			fun2(start.next.next); 
		} 
		System.out.print(start.data + " "); 
	} 

	/* UTILITY FUNCTIONS TO TEST print_list() and fun2() */
	/* Given a reference (pointer to pointer) to the head 
	of a list and an int, push a new node on the front 
	of the list. */
	static Node push(Node head_ref, int new_data) 
	{ 
		/* allocate node */
		Node new_node = new Node(); 

		/* put in the data */
		new_node.data = new_data; 

		/* link the old list off the new node */
		new_node.next = (head_ref); 

		/* move the head to point to the new node */
		(head_ref) = new_node; 
		return head_ref; 
	} 

	/* Driver code */
	public static void main(String[] args) 
	{ 
		/* Start with the empty list */
		Node head = null; 

		/* Using push() to conbelow list 
		1->2->3->4->5 */
		head = push(head, 5); 
		head = push(head, 4); 
		head = push(head, 3); 
		head = push(head, 2); 
		head = push(head, 1); 

		System.out.print("Output of print_list() for " + "list 1->2->3->4->5 \n"); 
		print_list(head); 

		System.out.print("\nOutput of fun2() for " + "list 1->2->3->4->5 \n"); 
		fun2(head); 
		System.out.println(); 
	} 
} 

