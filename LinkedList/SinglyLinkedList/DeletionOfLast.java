// A Java program to demonstrate deletion of last Node in singly linked list 
//javac -d classes DeletionOfLast.java  && cd classes && java DeletionOfLast && cd ..
class DeletionOfLast { 
	

	// A linked list Node 
	static class Node { 
		int key; 
		Node next; 
	}; 

/*	static Node deleteLast(Node head, int key) { 
		Node x = null; 
		Node temp = head; 
		while (temp != null) { 
			if (temp.key == key) 
				x = temp; 
			temp = temp.next; 
		} 
		if (x != null) { 
			x.key = x.next.key; 
			x.next = x.next.next; 
		} 
		return head; 
	} */


    // Good code from above
	// Function to delete the last occurrence  
	static void deleteLast(Node head, int x)  {  

	    Node temp = head, ptr = null;  
	    while (temp!=null) {  
	  	    if (temp.key == x)  
	            ptr = temp;      
	        temp = temp.next;  
	    }  
	  
	    // If the last occurrence is the last node  
	    if (ptr != null && ptr.next == null)  
	    {  
	        temp = head;  
	        while (temp.next != ptr)  
	            temp = temp.next;  
	        temp.next = null;  
	    }  
	  
	    // If it is not the last node  
	    if (ptr != null && ptr.next != null) 
	    {  
	        ptr.key = ptr.next.key;  
	        // temp = ptr.next;  
	        ptr.next = ptr.next.next;  
	        // System.gc(); 
	    }  
	} 


	/// Utility function to create a new node with 
	//given key / 
	static Node newNode(int key) { 
		Node temp = new Node(); 
		temp.key = key; 
		temp.next = null; 
		return temp; 
	} 

	// This function prints contents of linked list 
	// starting from the given Node 
	static void printList( Node node) { 
		while (node != null) 
		{ 
			System.out.printf(" %d ", node.key); 
			node = node.next; 
		} 
	} 

	// Driver code/ 
	public static void main(String args[]) { 
		// /Start with the empty list / 
		Node head = newNode(1); 
		head.next = newNode(2); 
		head.next.next = newNode(3); 
		head.next.next.next = newNode(5); 
		head.next.next.next.next = newNode(2); 
		head.next.next.next.next.next = newNode(10); 

		System.out.printf("Created Linked List: "); 
		printList(head); 

		deleteLast(head, 2); 

		System.out.printf("\nLinked List after Deletion of 1: "); 
		printList(head); 
		System.out.println(); 
	} 
} 

