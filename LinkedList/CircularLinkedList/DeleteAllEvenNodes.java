// Delete all the even nodes of a Circular Linked List
// Java program to delete all prime node from a Circular singly linked list 

//javac -d classes DeleteAllEvenNodes.java  && cd classes && java DeleteAllEvenNodes && cd .. 

class DeleteAllEvenNodes { 

	// Structure for a node 
	static class Node { 
		int data; 
		Node next; 
	}; 

	// Function to insert a node at the beginning 
	// of a Circular linked list 
	static Node push(Node head_ref, int data) {

		Node ptr1 = new Node(); 
		Node temp = head_ref; 
		ptr1.data = data; 
		ptr1.next = head_ref; 

		// If linked list is not null then 
		// set the next of last node 
		if (head_ref != null) { 
			while (temp.next != head_ref) 
				temp = temp.next; 
			temp.next = ptr1; 
			return head_ref; 
		} 
		else
			ptr1.next = ptr1; // For the first node 

		head_ref = ptr1; 
	return head_ref; 
	} 

	// Delete the node if it is even 
	static Node deleteNode(Node head_ref, Node del) {

		Node temp = head_ref; 
		// If node to be deleted is head node 

		if (head_ref == del) 
			head_ref = del.next; 
		// traverse list till not found  delete node 
		while (temp.next != del) { 
			temp = temp.next; 
		} 
		// copy address of node 
		temp.next = del.next; 

		return head_ref; 
	} 

	// Function to delete all even nodes from the singly circular linked list 
	static Node deleteEvenNodes(Node head) {

		Node ptr = head; 
		Node new_head = head; 
		// traverse list till the end  if the node is even then delete it 
		do { 
			// if node is even 
			if (ptr.data % 2 == 0) {
				// System.out.println(ptr.data);
				head=deleteNode(head, ptr); 
				if (head != new_head) {
					new_head = head;
			      ptr = ptr.next; 	
				}
			}
			// point to next node 
			ptr = ptr.next; 
		} 
		while (ptr != head); 
		return head;
	} 

		// Function to delete all even nodes from the singly circular linked list 
	static Node deleteoddNodes(Node head) {

		Node ptr = head; 
		Node new_head = head; 
		// traverse list till the end  if the node is even then delete it 
		do { 
			// if node is even 
			if (ptr.data % 2 == 1) {
				// System.out.println(ptr.data);
				head=deleteNode(head, ptr); 
				if (head != new_head) {
					new_head = head;
			      ptr = ptr.next; 	
				}
			}
			// point to next node 
			ptr = ptr.next; 
		} 
		while (ptr != head); 
		return head; 
	} 

	// Function to print nodes 
	static void printList(Node head) 
	{ 
		Node temp = head;
		int sum = 0 ; 
		if (head != null) 
		{ 
			do
			{ 
				sum += temp.data;
				System.out.printf("%d ", temp.data); 
				temp = temp.next; 
			} 
			while (temp != head);
			System.out.println("\nsum: "+sum); 
		} 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		// Initialize lists as empty 
		Node head = null; 

		// Created linked list will be 57.11.2.56.12.61 
		head=push(head, 61); 
		head=push(head, 12); 
		head=push(head, 56); 
		head=push(head, 2); 
		head=push(head, 11); 
		head=push(head, 57); 


		printList(head); 
		
		head=deleteEvenNodes(head); 
		// head=deleteoddNodes(head); 

		System.out.println( "\nList after deletion : "); 
		printList(head); 
		System.out.println(); 
	} 

} 

