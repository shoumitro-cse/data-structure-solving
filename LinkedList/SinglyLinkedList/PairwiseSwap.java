// Java program to pairwise swap elements of a linked list 
class PairwiseSwap { 
	Node head; // head of list 

	/* Linked list Node*/
	class Node { 
		int data; 
		Node next; 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 

    //Time complexity: O(n)
	// void pairWiseSwapfun() { 
 //        Node current = head;
 //        while(current != null && current.next != null) {
        	
 //        	int key = current.data;
 //        	current.data = current.next.data;
 //            current.next.data=key;

 //            current = current.next.next;

 //        }
	// } 


	void pairWiseSwapfun() { 
       pairWiseSwap(head);
	}
    
    // using recursion
    //time complexity O(1) And Space Complexity O(n)
	void pairWiseSwap(Node head) { 
	    if (head != null && head.next != null) { 
	    	int t = head.data;
	  	    head.data= head.next.data;
	  	    head.next.data=t;
	        pairWiseSwap(head.next.next); 
	    } 
	} 

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
		while (temp != null) { 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} 
		System.out.println(); 
	} 

	/* Driver program to test above functions */
	public static void main(String args[]) 
	{ 
		PairwiseSwap llist = new PairwiseSwap(); 

		/* Created Linked List 1->2->3->4->5 */
		llist.push(6); 
		llist.push(5); 
		llist.push(4); 
		llist.push(3); 
		llist.push(2); 
		llist.push(1); 

		System.out.println("Linked List before calling pairWiseSwap() "); 
		llist.printList(); 

		llist.pairWiseSwapfun(); 

		System.out.println("Linked List after calling pairWiseSwap() "); 
		llist.printList(); 
	} 
} 
/* 

Input : 1->2->3->4->5->6->NULL
Output : 2->1->4->3->6->5->NULL

Input : 1->2->3->4->5->NULL
Output : 2->1->4->3->5->NULL

Input : 1->NULL
Output : 1->NULL
 */
