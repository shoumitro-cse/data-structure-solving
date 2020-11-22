// Java program to find minimum and maximum value from singly circular linked list 

// javac -d classes MinMax.java  && cd classes && java MinMax && cd ..

class MinMax { 

	// structure for a node 
	static class Node { 
		int data; 
		Node next; 
	}; 

	// Function to print minimum and maximum 
	// nodes of the circular linked list 
	static void printMinMax(Node head) {
		// check list is empty 
		if (head == null) { 
			return; 
		} 
		// pointer for traversing 
		Node current; 
		// initialize head to current pointer 
		current = head; 
		// initialize max int value to min initialize min int value to max 
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE; 

		// While last node is not reached 
		while (current.next != head) { 
			// If current node data is lesser for min then replace it 
			if (current.data < min) { 
				min = current.data; 
			} 
			// If current node data is greater for max then replace it 
			if (current.data > max) { 
				max = current.data; 
			} 
			current = current.next; 
		}
		System.out.println( "\nMinimum = " + min + ", Maximum = " + max); 
	} 

	// Function to insert a node at the end of 
	// a Circular linked list 
	static Node insertNode(Node head, int data) 
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

			// put first or head node address 
			// in new node link 
			newNode.next = head; 

			// put new node address into 
			// last node link(next) 
			current.next = newNode; 
		} 
		return head; 
	} 

	// Function to print the Circular linked list 
	static void displayList(Node head) 
	{ 

		Node current = head; 

		// if list is empty simply show message 
		if (head == null) 
		{ 
			System.out.printf("\nDisplay List is empty\n"); 
			return; 
		} 

		// traverse first to last node 
		else
		{ 
			do
			{ 
				System.out.printf("%d ", current.data); 
				current = current.next; 
			} while (current != head); 
		} 
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		Node Head = null; 

		Head=insertNode(Head, 99); 
		Head=insertNode(Head, 11); 
		Head=insertNode(Head, 22); 
		Head=insertNode(Head, 33); 
		Head=insertNode(Head, 44); 
		Head=insertNode(Head, 55); 
		Head=insertNode(Head, 66); 

		System.out.println("Initial List: "); 

		displayList(Head); 

		printMinMax(Head); 
	} 
} 

