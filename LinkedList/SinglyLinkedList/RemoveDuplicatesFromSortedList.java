// Java program to remove all occurrences of duplicates from a sorted linked list 

// class to create Linked lIst 
class RemoveDuplicatesFromSortedList { 
		
	// head of linked list 
	Node head = null;

	class Node {
		// value in the node 
		int val; 
		Node next; 
		Node(int v) { 
			// default value of the next pointer field 
			val = v; 
			next = null; 
		} 
	} 

	// Function to insert data nodes into 
	// the Linked List at the front 
	public void insert(int data) { 
		Node new_node = new Node(data); 
		new_node.next = head; 
		head = new_node; 
	} 

	// Function to remove all occurrences of duplicate elements 
	//Time Complexity : O(n)
	public void removeAllDuplicates() { 
		
		// Create a dummy node that acts like a fake head of list pointing to the original head 
		Node dummy = new Node(0); 

		// Dummy node points to the original head 
		dummy.next = head; 
		Node prev = dummy; 
		Node current = head; 

		while (current != null) { //O(n)

			while (current.next != null && prev.next.val == current.next.val) {
				current = current.next; 
			}
			if (prev.next == current) {
				prev = prev.next; 
			} else {
				prev.next = current.next; 
			}
			current = current.next; 
		} 
		head = dummy.next; 
	} 

	// Function to print the list elements 
	public void printList() 
	{ 
		Node trav = head; 
		if (head == null) 
			System.out.print(" List is empty" ); 
			
		while (trav != null) 
		{ 
			System.out.print(trav.val + " "); 
			trav = trav.next; 
		} 
	} 

	// Driver code 
	public static void main(String[] args) {

		RemoveDuplicatesFromSortedList ll = new RemoveDuplicatesFromSortedList(); 
		ll.insert(53); 
		ll.insert(53); 
		ll.insert(49); 
		ll.insert(49); 
		ll.insert(35); 
		ll.insert(28); 
		ll.insert(28); 
		ll.insert(23);
		 		
		System.out.println("\nBefore removal of duplicates"); 
		ll.printList(); 

		ll.removeAllDuplicates(); 

		System.out.println("\nAfter removal of duplicates"); 
		ll.printList(); 
		System.out.println(); 



		RemoveDuplicatesFromSortedList ll2 = new RemoveDuplicatesFromSortedList(); 
		ll2.insert(44); 
		ll2.insert(44); 
		ll2.insert(11); 
		ll2.insert(11); 
		ll2.insert(11); 
		
		System.out.println("\nBefore removal of duplicates"); 
		ll2.printList(); 

		ll2.removeAllDuplicates(); 
		System.out.println("\nAfter removal of duplicates"); 
		ll2.printList(); 
		System.out.println(); 
	} 
} 



/*Remove all occurrences of duplicates from a sorted Linked List
Given a sorted linked list, delete all nodes that have duplicate
numbers (all occurrences), leaving only numbers that appear once in the original list. 

Examples:

Input : 23->28->28->35->49->49->53->53
Output : 23->35

Input : 11->11->11->11->75->75
Output : empty List*/
