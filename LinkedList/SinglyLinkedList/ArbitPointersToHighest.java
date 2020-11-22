// Point arbit pointer to greatest value right side node in a linked list

//javac -d classes ArbitPointersToHighest.java  && cd classes && java ArbitPointersToHighest && cd ..
class ArbitPointersToHighest { 

	/* Link list node */
	static class Node { 
		int data; 
		Node next, arbit; 
	}                                                            

	/* Function to reverse the linked list */
	static Node reverse(Node head) { 
		Node prev = null, current = head, next = null; 
		while (current != null) { 
			next = current.next; 
			current.next = prev; 
			prev = current; 
			current = next; 
		} 
		return prev; 
	} 


/*	static Node populateArbit(Node head) { 
		head = reverse(head); 
		Node max = head; 
		Node temp = head.next; 
		while (temp != null) { 
			temp.arbit = max; 
			if (max.data < temp.data) 
				max = temp; 
			temp = temp.next; 
		} 
		return reverse(head); 
	} */


    static Node maxNode; 
    static void populateArbit(Node head) { 
  
        if (head == null) 
            return; 
  
        /* if head->next is null it means we reached at 
        the last node just update the max and maxNode */
        if (head.next == null) { 
            maxNode = head; 
            return; 
        } 
  
        /* Calling the populateArbit to the next node */
        populateArbit(head.next); 
  
        /* updating the arbit node of the current 
        node with the maximum value on the right side */
        head.arbit = maxNode; 
  
        /* if current Node value id greater then 
        the previous right node then update it */
        if (head.data > maxNode.data) 
            maxNode = head; 
  
        return; 
    } 

	// Utility function to print result linked list 
	static void printNextArbitPointers(Node node) {

		System.out.println("Node\tNext Pointer\tArbit Pointer"); 
		while (node != null) {

			System.out.print(node.data + "\t\t"); 

			if (node.next != null) 
				System.out.print(node.next.data + "\t\t"); 
			else
				System.out.print("NULL" +"\t\t"); 

			if (node.arbit != null) 
				System.out.print(node.arbit.data); 
			else
				System.out.print("NULL"); 

			System.out.println(); 
			node = node.next; 
		} 
	} 

	/* Function to create a new node with given data */
	static Node newNode(int data) { 
		Node new_node = new Node(); 
		new_node.data = data; 
		new_node.next = null; 
		return new_node; 
	} 

	/* Driver code*/
	public static void main(String[] args) { 
		Node head = newNode(5); 
		head.next = newNode(10); 
		head.next.next = newNode(2); 
		head.next.next.next = newNode(3); 

		// head = populateArbit(head); 
		populateArbit(head); 

		System.out.println("Resultant Linked List is: "); 
		printNextArbitPointers(head); 

	} 
} 

