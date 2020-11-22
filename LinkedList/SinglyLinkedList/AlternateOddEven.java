// Java program to rearrange nodes as alternate odd even nodes in 
// javac -d classes AlternateOddEven.java  && cd classes && java AlternateOddEven  && cd ..

class AlternateOddEven { 

	// Structure node 
	static class Node { 
		int data; 
		Node next; 
	}; 

	// A utility function to print 
	// linked list 
	static void printList(Node node) { 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	} 

	// Function to create newNode 
	// in a linkedlist 
	static Node newNode(int key) { 
		Node temp = new Node(); 
		temp.data = key; 
		temp.next = null; 
		return temp; 
	} 

	// Function to insert at beginning 
	static Node insertBeg(Node head, int val) { 
		Node temp = newNode(val); 
		temp.next = head; 
		head = temp; 
		return head; 
	} 


	// 	Time Complexity : O(n)
	// Auxiliary Space : O(1)

	// Function to rearrange the 
	// odd and even nodes 
	static Node rearrange(Node head) { 
		// Step 1: Segregate even and odd nodes 
		// Step 2: Split odd and even lists 
		// Step 3: Merge even list into odd list 
		Node even; 
		Node temp, prev_temp; 
		Node odd_list, even_list, odd_ptr, event_ptr, ptr=null; 

		// Step 1: Segregate Odd and Even Nodes 
		temp = (head).next; 
		prev_temp = head; 

		while (temp != null) 
		{ 

			// Backup next pointer of temp 
			Node x = temp.next; 

			// If temp is odd move the node 
			// to beginning of list 
			if (temp.data % 2 != 0) 
			{ 
				prev_temp.next = x; 
				temp.next = (head); 
				(head) = temp; 
			} 
			else
			{ 
				prev_temp = temp; 
			} 

			// Advance Temp Pointer 
			temp = x; 
		} 

		// Step 2 
		// Split the List into Odd and even 
		temp = (head).next; 
		prev_temp = (head); 

		while (temp != null && temp.data % 2 != 0) 
		{ 
			prev_temp = temp; 
			temp = temp.next; 
		} 

		even = temp; 

		// End the odd List (Make last node null) 
		prev_temp.next = null; 

		// Step 3: 
		// Merge Even List into odd 
		odd_list = head; 
		even_list = even; 
		printList(odd_list);
		printList(even_list);

		while (even_list != null && odd_list != null) 
		{ 

			// While both lists are not 
			// exhausted Backup next 
			// pointers of odd_list and even_list 
			odd_ptr = odd_list.next; 
			event_ptr = even_list.next; 

			odd_list.next = even_list; 
			even_list.next = odd_ptr; 

			// ptr points to the latest node added 
			ptr = even_list; 

			// Advance i and j pointers 
			odd_list = odd_ptr; 
			even_list = event_ptr; 
		} 

		if (odd_list == null) 
		{ 

			// Odd list exhausts before even, 
			// append remainder of even list to odd. 
			ptr.next = even_list; 
		} 

		// The case where even list exhausts before 
		// odd list is automatically handled since we 
		// merge the even list into the odd list 
		return head; 
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		Node head = newNode(8); 
		head = insertBeg(head, 7); 
		head = insertBeg(head, 6); 
		head = insertBeg(head, 3); 
		head = insertBeg(head, 5); 
		head = insertBeg(head, 1); 
		head = insertBeg(head, 2); 
		head = insertBeg(head, 10); 

		System.out.println("Linked List:" ); 
		printList(head); 
		System.out.println("Rearranged List" ); 
		head=rearrange(head); 
		printList(head); 
	} 
} 

