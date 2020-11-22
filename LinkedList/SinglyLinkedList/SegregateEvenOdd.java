// Java program to segregate even and odd nodes in a LinkedList
// javac -d classes SegregateEvenOdd.java  && cd classes && java SegregateEvenAdd  && cd ..
class SegregateEvenAdd 
{ 
	static Node head; // head of list 

	/* Linked list Node*/
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 


   //Time complexity: O(n)
	void segregateEvenOdd() {
        Node eventStart=null;
        Node eventEnd=null;
        Node oddStart=null;
        Node oddEnd=null;
        Node current=head;

        while(current != null) {
          int ele = current.data;
          
          if (ele%2 == 0) { // for event chine
	          if (eventStart == null) {
	             eventStart = current;
	          	 eventEnd = eventStart;
	          } else {
	             eventEnd.next = current;
	             eventEnd = eventEnd.next;
	          }	         
          }	         

          if (ele%2 != 0) { // for odd chine
	          if (oddStart == null) {
	             oddStart = current;
	          	 oddEnd = oddStart;
	          } else {
	             oddEnd.next = current;
	             oddEnd = oddEnd.next;
	          }	
	       }

	       current = current.next;
          }

        if(eventStart == null && oddStart == null) return;

        eventEnd.next = oddStart; // join event and odd chine
        oddEnd.next = null; // add null in last
        head = eventStart; // point to head

	} 

	/* Given a reference (pointer to pointer) to the head 
		of a list and an int, push a new node on the front 
		of the list. */
	void push(int new_data) 
	{ 
		/* 1 & 2: Allocate the Node & 
				Put in the data*/
		Node new_node = new Node(new_data); 

		/* 3. Make next of new Node as head */
		new_node.next = head; 

		/* 4. Move the head to point to new Node */
		head = new_node; 
	} 

	// Utility function to print a linked list 
	void printList(Node head) 
	{ 
		Node temp = head; 
		while(temp != null) 
		{ 
			System.out.print(temp.data+" "); 
			temp = temp.next; 
		} 
		System.out.println(); 
	} 


   // Time Complexity: O(n) 
   // Space Complexity: O(1)
	static Node reverseList(Node node) {
	    SegregateEvenAdd llist = new SegregateEvenAdd(); 
		if(node == null || node.next == null) return node;
		Node head = reverseList(node.next);
		node.next.next = node;
		node.next=null;
		llist.printList(head);
		return head;
	}


	/* Driver program to test above functions */
	public static void main(String args[]) 
	{ 
		SegregateEvenAdd llist = new SegregateEvenAdd(); 
        llist.push(11); 
        llist.push(10); 
        llist.push(9); 
        llist.push(6); 
        llist.push(4); 
        llist.push(1); 
        llist.push(0); 
		System.out.println("Origional Linked List"); 
		llist.printList(llist.head); 


		llist.segregateEvenOdd(); 

		System.out.println("Modified Linked List"); 
		llist.printList(llist.head); 
		llist.printList(llist.reverseList(llist.head)); 
	} 
} 
