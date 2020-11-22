 // javac LinkedList.java && java LinkedList



// A complete working Java program to demonstrate deletion in singly 
// linked list
public class LinkedList {

	Node head; // head of list 

	/* Linked list Node*/
	class Node { 
		int data; 
		Node next; 
		Node(int d) { 
			data = d; 
			next = null; 
		} 
	} 

	/* Given a key, deletes the first occurrence of key in linked list */
	void deleteNode(int key) { 
		// Store head node 
		Node current_node = head, prev_node = null; 

		// If head node itself holds the key to be deleted 
		if (current_node != null && current_node.data == key) { 
			head = current_node.next; // Changed head 
			return; 
		} 

		// Search for the key to be deleted, keep track of the 
		// previous node as we need to change temp.next 
		while (current_node != null && current_node.data != key) { 
			prev_node = current_node; 
			current_node = current_node.next; 
		}	 

		// If key was not present in linked list 
		if (current_node == null) return; 

		// Unlink the node from linked list 
		prev_node.next = current_node.next; 
	} 

	/* Inserts a new Node at front of the list. */
	public void prepend(int new_data) { 
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
	}

    public void append(int new_data) {

    	Node new_node = new Node(new_data);
        
        if (head == null) {
        	new_node.next = head; 
		    head = new_node;
        	return ;
        }

        Node current_node = head;
    	while(current_node.next != null) {
          current_node = current_node.next;
    	}
    	current_node.next = new_node;
    }

    public void insert(int index_item, int new_data) {
    	Node new_node = new Node(new_data);

    	Node current_node = head;
    	while(current_node.data != index_item) {
           current_node = current_node.next;
    	}
        
        if (current_node.data == index_item) {
	    	new_node.next = current_node.next;
	    	current_node.next = new_node;
       }
      
    }

	/* This function prints contents of linked list starting from 
		the given node */
	public void printList() { 
		Node current_node = head; 
		while (current_node != null) { 
			System.out.print(current_node.data+" "); 
			current_node = current_node.next; 
		} 
	} 

	/* Drier program to test above functions. Ideally this function 
	should be in a separate user class. It is kept here to keep 
	code compact */
	public static void main(String[] args) {

		LinkedList llist = new LinkedList(); 

		llist.prepend(7); 
		llist.prepend(1); 
		llist.prepend(3); 

		llist.append(2); 
        llist.append(4); 
        
        llist.insert(2, 8); 

		System.out.println("\nCreated Linked list is:"); 
		llist.printList(); 

		llist.deleteNode(7); // Delete node at position 4 

		System.out.println("\nLinked List after Deletion at position 4:"); 
		llist.printList(); 
        System.out.println();
	} 
} 

