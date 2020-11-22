// Java program to delete a given key from circular doubly linked list.
//Doubly Circular Linked List | Set 2 (Deletion)


 //javac -d classes CircularDoublyLinkedList.java  && cd classes && java CircularDoublyLinkedList && cd ..

class CircularDoublyLinkedList { 

	// structure of a Node 
	static class Node { 
		int data; 
		Node next; 
		Node prev; 
	}; 

	// Function to insert node in the list 
	static Node insert(Node start, int value) {

		// If the list is empty, create a single node circular and doubly list 
		if (start == null) { 
			Node new_node = new Node(); 
			new_node.data = value; 
			new_node.next = new_node.prev = new_node; 
			start = new_node; 
			return start; 
		} 

		// If list is not empty. Find last node  
		Node last = (start).prev; 

		// Create Node dynamically 
		Node new_node = new Node(); 
		new_node.data = value; 

		// Start is going to be next of new_node 
		new_node.next = start; 

		// Make new node previous of start 
		(start).prev = new_node; 

		// Make last preivous of new node 
		new_node.prev = last; 

		// Make new node next of old last 
		last.next = new_node; 
		return start; 
	} 

	// Function to delete a given node from the list 
	static Node deleteNode(Node start, int key) {

		// If list is empty 
		if (start == null) 
			return null; 

		// Find the required node Declare two pointers and initialize them 
		Node curr = start, prev_1 = null; 
		while (curr.data != key) { 
			// If node is not present in the list 
			if (curr.next == start) { 
				System.out.printf("\nList doesn't have node with value = %d", key); 
				return start; 
			} 

			prev_1 = curr; 
			curr = curr.next; 
		} 

		// Check if node is the only node in list 
		if (curr.next == start && prev_1 == null) { 
			(start) = null; 
			return start; 
		} 

		// If list has more than one node, check if it is the first node 
		if (curr == start) { // delete first node
			
			prev_1 = (start).prev; // Move prev_1 to last node 

			// Move start ahead 
			start = (start).next; 

			// Adjust the pointers of prev_1 and start node 
			prev_1.next = start; 
			(start).prev = prev_1; 

		} else if (curr.next == start) { // delete last node
			prev_1.next = start; 
			(start).prev = prev_1;

		} else { // delete middle node
			Node temp = curr.next; 
			prev_1.next = temp; 
			temp.prev = prev_1; 
		} 
		return start; 
	} 

	static int searchList(Node start, int search) {  
	    Node temp = start;  
	      
	    int count = 0, flag = 0, value;  
	      
	    if(temp == null)  {
	        return -1;  
	    } else {  

	        while(temp.next != start)  {  // more than one node
	            // Increment count for location  
	            count++;  
	            if(temp.data == search)  {  
	                flag = 1;  
	                count--;  
	                break;  
	            }  
	            // Increment temp pointer  
	            temp = temp.next;  
	        }  

	        if(temp.data == search) {  // only one node
	            count++;  
	            flag = 1;  
	        }  
	           
	        if(flag == 1)  
	            System.out.println("\n"+search +" found at location "+   count);  
	        else
	            System.out.println("\n"+search +" not found");  
	    }  
	    return -1; 
	} 

	// Function to display list elements 
	static void display(Node start) {
		Node temp = start; 
        do {
			System.out.printf("%d ", temp.data); 
			temp = temp.next; 
		} while (temp != start);
		System.out.printf("\n"); 
	} 

	// Driver program to test above functions 
	public static void main(String args[]) { 

		// Start with the empty list 
		Node start = null; 

		// Created linked list will be head->4->5->6->7->8->(head)
		start = insert(start, 4); 
		start = insert(start, 5); 
		start = insert(start, 6); 
		start = insert(start, 7); 
		start = insert(start, 8); 

		System.out.printf("List Before Deletion: "); 
		display(start); 

		searchList(start, 8); // search a node

		// Delete the node which is not present in list 
		start = deleteNode(start, 9); 
		System.out.printf("\nList After Deletion: "); 
		display(start); 

		// Delete the first node 
		start = deleteNode(start, 4); 
		System.out.printf("\nList After Deleting %d: ", 4); 
		display(start); 

		// Delete the last node 
		start = deleteNode(start, 8); 
		System.out.printf("\nList After Deleting %d: ", 8); 
		display(start); 

		// Delete the middle node 
		start = deleteNode(start, 6); 
		System.out.printf("\nList After Deleting %d: ", 6); 
		display(start); 
		System.out.println();
	} 
} 

