//Insertion at Specific Position in a Circular Doubly Linked List
 //javac -d classes InsertionSpecificPositionCircularDoublyList.java  && cd classes && java InsertionSpecificPositionCircularDoublyList && cd ..

class InsertionSpecificPositionCircularDoublyList 
{ 

	// Doubly linked list node 
	static class node 
	{ 
		int data; 
		node next; 
		node prev; 
	}; 

	// Utility function to create a node in memory 
	static node getNode() 
	{ 
		return new node(); 
	} 

	// Function to display the list 
	static int displayList( node temp) 
	{ 
		node t = temp; 
		if (temp == null) 
			return 0; 
		else
		{ 
			System.out.println( "The list is: "); 

			while (temp.next != t) 
			{ 
				System.out.print( temp.data + " "); 
				temp = temp.next; 
			} 

			System.out.println( temp.data ); 

			return 1; 
		} 
	} 

	// Function to count nunmber of 
	// elements in the list 
	static int countList( node start) 
	{ 
		// Declare temp pointer to 
		// traverse the list 
		node temp = start; 

		// Variable to store the count 
		int count = 0; 

		// Iterate the list and 
		// increment the count 
		while (temp.next != start) 
		{ 
			temp = temp.next; 
			count++; 
		} 

		// As the list is circular, increment 
		// the counter at last 
		count++; 

		return count; 
	} 

	// Function to insert a node at 
	// a given position in the 
	// circular doubly linked list 
	static node insertAtLocation( node start, int data, int loc) { 
		// Declare two pointers 
		node temp, newNode; 
		int i, count; 

		// Create a new node in memory 
		newNode = getNode(); 

		// Point temp to start 
		temp = start; 

		// count of total elements in the list 
		count = countList(start); 

		// If list is empty or the position is 
		// not valid, return false 
		if (temp == null || count < loc) {
			return start; 
		} else { 
			// Assign the data 
			newNode.data = data; 

			// Iterate till the loc 
			for (i = 1; i < loc - 1; i++) 
			{ 
				temp = temp.next; 
			} 

			// See in Image, circle 1 
			newNode.next = temp.next; 

			// See in Image, Circle 2 
			(temp.next).prev = newNode; 

			// See in Image, Circle 3 
			temp.next = newNode; 

			// See in Image, Circle 4 
			newNode.prev = temp; 

			return start; 
		} 

	}

  //Reverse a doubly circular linked list
	static node reverse(node head)  {  

	    if (head==null) return null;  
	  
	    // Initialize a new head pointer  
	    node new_head = null;  
	  
	    // get pointer to the the last node  
	    node last = head.prev;  
	  
	    // set 'curr' to last node  
	    node curr = last, prev;  
	  
	    // traverse list in backward direction  
	    do {
	        prev = curr.prev;  
	        new_head=insertEnd(new_head, curr);  
	        curr = prev;  
	    } while (curr != last);
	  
	    // head pointer of the reversed list  
	    return new_head;  
	} 

	// Function to insert at the end  
	static node insertEnd(node head, node new_node)  
	{  
	    // If the list is empty, create a single node circular and doubly list  
	    if (head == null)  {  
	        new_node.next = new_node.prev = new_node;  
	        head = new_node;  
	        return head;  
	    }  
	  
	    // If list is not empty // Find last node / 
	    node last = (head).prev;  
	  
	    // Start is going to be next of new_node  
	    new_node.next = head;  
	  
	    // Make new node previous of start  
	    (head).prev = new_node;  
	  
	    // Make last preivous of new node  
	    new_node.prev = last;  
	  
	    // Make new node next of old last  
	    last.next = new_node;  
	    return head; 
	}

   // Convert an Array to a Circular Doubly Linked List
	static node createList(int arr[], int n, node start) { 
		// Declare newNode and temporary pointer 
		node newNode, last; 
		int i; 

		// Iterate the loop until array length 
		for (i = 0; i < n; i++) 
		{ 
			// Create new node 
			newNode = getNode(); 

			// Assign the array data 
			newNode.data = arr[i]; 

			// If it is first element 
			// Put that node prev and next as start 
			// as it is circular 
			if (i == 0) 
			{ 
				start = newNode; 
				newNode.prev = start; 
				newNode.next = start; 
			} else { 
				// Find the last node 
				last = (start).prev; 
				// Add the last node to make them in circular fashion 
				last.next = newNode; 
				newNode.next = start; 
				newNode.prev = last; 
				last = start; 
				last.prev = newNode; 
			} 
		} 
		return start; 
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		// Array elements to create 
		// circular doubly linked list 
		int arr[] = { 1, 2, 3, 4, 5, 6 }; 
		int n = arr.length; 

		// Start Pointer 
		node start = null; 

		// Create the List 
		start = createList(arr, n, start); 

		// Display the list before insertion 
		displayList(start); 
		displayList(reverse(start)); 

		// Inserting 8 at 3rd position 
		start = insertAtLocation(start, 8, 3); 

		// Display the list after insertion 
		displayList(start); 
	} 
} 

