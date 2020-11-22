// Java program to remove duplicates from a sorted linked list 
class RemoveDuplicateSortList 
{ 
	Node head; // head of list 

	/* Linked list Node*/
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) {data = d; next = null; } 
	} 

// 	void removeDuplicates() 
// 	{ 
//       Node current = head;
//       while(current != null) {
//           Node temp = current;
//           while(temp != null &&  temp.data==current.data) {
//               temp = temp.next;
//           } 
//           current.next = temp;
//           current = current.next;
//       }
//  	} 

    //   void removeDuplicates() {
    //       removeDup(head);
    //   } 
      
    //   void removeDup(Node head) {
    //       if (head == null) return ;
    //       if(head.next != null ) {
    //           if(head.data == head.next.data) {
    //               head.next = head.next.next;
    //               removeDup(head);
    //           } else {
    //               removeDup(head.next);
    //           }
    //       }
    //   }
    
    void removeDuplicates() {
        Node temp=head, prev = head;
        while(temp !=null) {
            if(temp.data != prev.data) {
                prev.next = temp;
                prev = temp;
            }
            temp = temp.next;
        }
        if(prev != temp) {
            prev.next = null;
        }
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
		while (temp != null) 
		{ 
			System.out.print(temp.data+" "); 
			temp = temp.next; 
		} 
		System.out.println(); 
	} 

	/* Driver program to test above functions */
	public static void main(String args[]) 
	{ 
		RemoveDuplicateSortList llist = new RemoveDuplicateSortList(); 
		llist.push(20); 
		llist.push(13); 
		llist.push(13); 
		llist.push(11); 
		llist.push(11); 
		llist.push(11); 
		
		System.out.println("List before removal of duplicates"); 
		llist.printList(); 
		
		llist.removeDuplicates(); 
		
		System.out.println("List after removal of elements"); 
		llist.printList(); 
	} 
} 
/* This code is contributed by Rajat Mishra */	

