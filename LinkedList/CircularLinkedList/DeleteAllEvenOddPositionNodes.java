// Java program to delete all even and odd position nodes from Singly Circular Linked list 
// javac -d classes DeleteAllEvenOddPositionNodes.java  && cd classes && java DeleteAllEvenOddPositionNodes && cd ..

class DeleteAllEvenOddPositionNodes 
{ 
	
	// structure for a node 
	static class Node 
	{ 
		int data; 
		Node next; 
	}; 

	// Function return number of nodes present in list 
	static int Length(Node head) 
	{ 
		Node current = head; 
		int count = 0; 
		
		// if list is empty simply return length zero 
		if (head == null) 
		{ 
			return 0; 
		} 
		
		// traverse forst to last node 
		else
		{ 
			do
			{ 
				current = current.next; 
				count++; 
			} while (current != head); 
		} 
		return count; 
	} 

	// Function print data of list 
	static void Display( Node head) 
	{ 
		Node current = head; 

		// if list is empty simply show message 
		if (head == null) 
		{ 
			System.out.printf("\nDisplay List is empty\n"); 
			return; 
		} 
		
		// traverse forst to last node 
		else
		{ 
			do
			{ 
				System.out.printf("%d ", current.data); 
				current = current.next; 
			} while (current != head); 
			System.out.printf("\n"); 
		} 
	} 

	/* Function to insert a node at the end of 
	a Circular linked list */
	static Node Insert(Node head, int data) 
	{ 
		Node current = head; 
		// Create a new node 
		Node newNode = new Node(); 

		// check node is created or not 
		if (newNode == null) 
		{ 
			System.out.printf("\nMemory Error\n"); 
			return null; 
		} 
		
		// insert data into newly created node 
		newNode.data = data; 

		// check list is empty 
		// if not have any node then 
		// make first node it 
		if (head == null) 
		{ 
			newNode.next = newNode; 
			head = newNode; 
			return head; 
		} 
		
		// if list have already some node 
		else
		{ 
			// move firt node to last node 
			while (current.next != head) 
			{ 
				current = current.next; 
			} 
			
			// put first or head node address in new node link 
			newNode.next = head; 
			
			// put new node address into last node link(next) 
			current.next = newNode; 
		} 
		return head; 
	} 

	// Utitlity function to delete a Node 
	static Node deleteNode(Node head_ref, Node del) 
	{ 
		Node temp = head_ref; 
		
		// If node to be deleted is head node 
		if (head_ref == del) 
		{ 
			head_ref = del.next; 
		} 

		// traverse list till not found 
		// delete node 
		while (temp.next != del) 
		{ 
			temp = temp.next; 
		} 

		// copy address of node 
		temp.next = del.next; 
		return head_ref; 
	} 

	// Function to delete First node of 
	// Circular Linked List 
	static Node DeleteFirst(Node head) 
	{ 
		Node previous = head, next = head; 
		// check list have any node 
		// if not then return 
		if (head == null) 
		{ 
			System.out.printf("\nList is empty\n"); 
			return head; 
		} 
		
		// check list have single node 
		// if yes then delete it and return 
		if (previous.next == previous) 
		{ 
			head = null; 
			return head; 
		} 
		
		// traverse second to first 
		while (previous.next != head) 
		{ 
			previous = previous.next; 
			next = previous.next; 
		} 
		
		// now previous is last node and 
		// next is first node of list 
		// first node(next) link address 
		// put in last node(previous) link 
		previous.next = next.next; 

		// make second node as head node 
		head = previous.next; 
		return head; 
	} 

	// Function to delete odd position nodes 
	static Node DeleteAllOddNode(Node head) { 
		int len = Length(head); 
		int count = 0; 
		Node previous = head; 

		// check list have any node if not then return 
		if (head == null) 
		{ 
			System.out.printf("\nDelete Last List is empty\n"); 
			return null; 
		} 

		// if list have single node means 
		// odd position then delete it 
		if (len == 1) { 
			head = DeleteFirst(head); 
			return head; 
		} 
		while (len > 0) { 
			// delete first position node which is odd position 
			if (count == 0) { 
				// Function to delete first node 
				head = DeleteFirst(head); 
			} 

			if (count % 2 == 0 && count != 0) { 
				head = deleteNode(head, previous); 
			} 

			previous = previous.next; 

			len--; 
			count++; 
		} 
		return head; 
	} 

	// Function to delete all even position nodes 
	static Node DeleteAllEvenNode( Node head) 
	{ 
		// Take size of list 
		int len = Length(head); 

		int count = 1; 
		Node previous = head, next = head; 

		// Check list is empty if empty simply return 
		if (head == null) { 
			System.out.printf("\nList is empty\n"); 
			return null; 
		} 
		// if list have single node then return 
		if (len < 2) { 
			return null; 
		} 

		// make first node is previous 
		previous = head; 

		// make second node is current 
		next = previous.next; 

		while (len > 0) { 
			if (count % 2 == 0) { 
				previous.next = next.next; 
				previous = next.next; 
				next = previous.next; 
			} 

			len--; 
			count++; 
		} 
		return head; 
	} 


		// Function to calculate sum and product  
	static void sumProduct( Node head, int key)  {  
	    
	    Node current = head;  
	    
	    int sum = 0, product = 1;  
	    
	    // if list is empty simply show message  
	    if (head == null) {  
	        System.out.print("\nDisplay List is empty\n");  
	        return;  
	    } else {  

	        do {  
	            // check if current node's data is divisible by key  
	            if ((current.data) % key == 0) {  
	                // Calculate sum  
	                sum += current.data;  
	                // Calculate product  
	                product *= current.data;  
	            }  
	            current = current.next;  
	        } while (current != head);  
	    }  
	    
	    System.out.print( "\n\nSum = " + sum + ", Product = " + product+"\n\n");  
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		Node head = null; 
		head = Insert(head, 99); 
		head = Insert(head, 11); 
		head = Insert(head, 22); 
		head = Insert(head, 33); 
		head = Insert(head, 44); 
		head = Insert(head, 55); 
		head = Insert(head, 66); 

		sumProduct(head, 11);

		// Deleting Odd positioned nodes 
		System.out.printf("Initial List: "); 
		Display(head); 

		System.out.printf("\nAfter deleting Odd position nodes: "); 
		head = DeleteAllOddNode(head); 
		Display(head); 

		// Deleting Even positioned nodes 
		System.out.printf("\n\nInitial List: "); 
		Display(head); 

		System.out.printf("\nAfter deleting even position nodes: "); 
		head = DeleteAllEvenNode(head); 
		Display(head); 
	} 
} 


/*Delete all odd or even positioned nodes from Circular Linked List
Last Updated: 03-02-2020
Delete all odd position nodes from circular linked list
Given a Singly Circular Linked List, starting from the first node delete all odd position nodes in it.

Note: Linked list is considered to have 1-based indexing. That is, first element in the linked list is at position 1.

Examples:

Input : List = 99->11->22->33
Output : 11->33

Input : List = 90->10->20->30
Output : 10->30*/