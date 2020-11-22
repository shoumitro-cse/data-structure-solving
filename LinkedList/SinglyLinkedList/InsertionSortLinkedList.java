// Java program to sort link list  using insertion sort 

public class InsertionSortLinkedList {

	node head; 
	node sorted; 

	static class node { 
		int val; 
		node next; 

		public node(int val) { 
			this.val = val; 
		} 
	} 

	void push(int val) { 
		/* allocate node */
		node newnode = new node(val); 
		/* link the old list off the new node */
		newnode.next = head; 
		/* move the head to point to the new node */
		head = newnode; 
	} 

	// function to sort a singly linked list using insertion sort 
	void insertionSort(node headref) { 
		// Initialize sorted linked list 
		sorted = null; 
		node current = headref; 
		// Traverse the given linked list and insert every 
		// node to sorted 
		while (current != null) { 
			// Store next for next iteration 
			node next = current.next; 
			// insert current in sorted linked list 
			sortedInsert(current); 
			// Update current 
			current = next; 
		} 
		// Update head_ref to point to sorted linked list 
		head = sorted; 
	} 

	void sortedInsert(node newnode) { 
		/* Special case for the head end */
		if (sorted == null || sorted.val >= newnode.val) { 
			newnode.next = sorted; 
			sorted = newnode; 
		} else { 
			node current = sorted; 
			while (current.next != null && current.next.val < newnode.val) { 
				current = current.next; 
			} 
			newnode.next = current.next; 
			current.next = newnode; 
		} 
	} 

	/* Function to print linked list */
	void printlist(node head) { 
		while (head != null) { 
			System.out.print(head.val + " "); 
			head = head.next; 
		} 
	} 
	
	// Driver program to test above functions 
	public static void main(String[] args) { 

		InsertionSortLinkedList list = new InsertionSortLinkedList(); 
		list.push(5); 
		list.push(20); 
		list.push(4); 
		list.push(3); 
		list.push(30); 

		System.out.println("\nLinked List before Sorting.."); 
		list.printlist(list.head); 
		
		list.insertionSort(list.head); 

		System.out.println("\n\nLinkedList After sorting"); 
		list.printlist(list.head); 
		System.out.println(); 
		
		list.sortedInsert(new node(6));
		list.sortedInsert(new node(40));
		list.sortedInsert(new node(25));

		System.out.println("\nLinkedList After Insert"); 
		list.printlist(list.head); 
		System.out.println(); 
	} 
} 

