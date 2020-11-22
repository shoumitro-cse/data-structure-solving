// Java program to sort a linked list, already sorted by absolute values 
//javac -d classes SortFromAbsoluteSortList.java  && cd classes && java SortFromAbsoluteSortList && cd ..

class SortFromAbsoluteSortList {

	static Node head; // head of list 
	
	/* Linked list Node*/
	static class Node { 
		int data; 
		Node next; 
		Node(int d) {data = d; next = null; } 
	} 
	
	// To sort a linked list by actual values. 
		// The list is assumed to be sorted by absolute 
		// values. 
	Node sortedList(Node head) {

		// Initialize previous and current nodes 
		Node prev = head; 
		Node curr = head.next; 
		
		// Traverse list 
		while(curr != null) // O(n)
		{ 
			// If curr is smaller than prev, then it must be moved to head 
			if(curr.data < prev.data) {

				// Detach curr from linked list 
				prev.next = curr.next; 
				
				// Move current node to beginning 
				curr.next = head; 
				head = curr; 
				
				// Update current 
				curr = prev; 
			} else {
			  prev = curr; 
			}
			// Move current 
			curr = curr.next; 
		} 
		return head; 
	} 
	
	/* Inserts a new Node at front of the list. */
	public void push(int new_data) 
	{ 
		/* 1 & 2: Allocate the Node & 
				Put in the data*/
		Node new_node = new Node(new_data); 
	
		/* 3. Make next of new Node as head */
		new_node.next = head; 
	
		/* 4. Move the head to point to new Node */
		head = new_node; 
	} 
	
	/* Function to print linked list */
	void printList(Node head) 
	{ 
		Node temp = head; 
		while (temp != null) 
		{ 
		System.out.print(temp.data+" "); 
		temp = temp.next; 
		} 
		System.out.println(); 
	} 
	
	/* Driver program to test above functions */
	public static void main(String args[]) {

		SortFromAbsoluteSortList llist = new SortFromAbsoluteSortList(); 
		
		/* Constructed Linked List is 0->1-> -2->3->4->5-> -5->null */
		llist.push(-5); 
		llist.push(5); 
		llist.push(4); 
		llist.push(3); 
		llist.push(-2); 
		llist.push(1); 
		llist.push(0); 
		
		System.out.println("Original List :"); 
		llist.printList(llist.head); 
		
		llist.head = llist.sortedList(head); 

		System.out.println("Sorted list :"); 
		llist.printList(llist.head); 
	} 
} 
