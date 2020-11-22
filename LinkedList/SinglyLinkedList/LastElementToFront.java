// javac -d classes LastElementToFront.java && cd classes && java LastElementToFront && cd ..
/* Java Program to move last element to front in a given linked list */
class LastElementToFront 
{ 
	Node head; // head of list 

	/* Linked list Node*/
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) {data = d; next = null; } 
	} 

    //Time Complexity: O(n) where n is the number of nodes in the given Linked List.
	void moveToFront() { 
		Node last=head, sec_last=null;
       if (last == null || last.next == null) {
       	 return;
       }

       while(last.next != null) {
       	sec_last = last;
       	last = last.next;
       }
       sec_last.next = null;
       last.next = head;
       head = last;
	}				 

					
	/* Utility functions */

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
	void printList() 
	{ 
		Node temp = head; 
		while(temp != null) 
		{ 
		System.out.print(temp.data+" "); 
		temp = temp.next; 
		} 
		System.out.println(); 
	} 

	/* Driver program to test above functions */
	public static void main(String args[]) 
	{ 
		LastElementToFront llist = new LastElementToFront(); 
		/* Constructed Linked List is 1->2->3->4->5->null */
		llist.push(5); 
		llist.push(4); 
		llist.push(3); 
		llist.push(2); 
		llist.push(1); 
		
		System.out.println("Linked List before moving last to front "); 
		llist.printList(); 
		
		llist.moveToFront(); 
		
		System.out.println("Linked List after moving last to front "); 
		llist.printList(); 
	} 
} 
/* This code is contributed by Rajat Mishra */
