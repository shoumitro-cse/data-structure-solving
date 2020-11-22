// Intersection of two Sorted Linked 

// javac -d classes IntersectionTwoSortedLinked.java && cd classes && java IntersectionTwoSortedLinked && cd ..
class IntersectionTwoSortedLinked 
{ 
	Node head; // head of list 

	/* Linked list Node*/
	static class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) {data = d; next = null; } 
	} 

	public static IntersectionTwoSortedLinked sortedIntersect(Node head1, Node head2) {
       IntersectionTwoSortedLinked list = new IntersectionTwoSortedLinked();
       
       if (head1 == null || head2 == null) {
       	return null;
       }

       while(head1 != null && head2 != null) {
       	if (head1.data == head2.data) {
       		list.push(head1.data);
       		head1 = head1.next;
       		head2 = head2.next;
       	} else if(head1.data < head2.data) {
       		head1 = head1.next;
       	} else {
       		head2 = head2.next;
       	}
       }
       return list;
	}

/*Complexity Analysis: 
1. Time Complexity: O(m+n) where m and n are number of 
   nodes in first and second linked lists respectively. 
2. Only one traversal of the lists are needed.
3. Auxiliary Space: O(max(m, n)). 
4. The output list can store at most m+n nodes.*/
	public static Node sortedIntersectRec(Node head1, Node head2) {

       Node res = new Node(0);
       if (head1 == null || head2 == null) return null;

       if (head1.data < head2.data) {
       	 return sortedIntersectRec(head1.next, head2);
       }
       if (head1.data > head2.data) {
       	 return sortedIntersectRec(head1, head2.next);
       }


   	   res=head1;
       res.next = sortedIntersectRec(head1.next, head2.next);
       return res;
     }
			 
	public void push(int new_data) 
	{ 
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
	} 

	/* Function to print linked list */
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


	public static void main(String args[]) {

		IntersectionTwoSortedLinked llist = new IntersectionTwoSortedLinked(); 
		/* Constructed Linked List is 1->2->3->4->6->null */
		llist.push(6); 
		llist.push(4); 
		llist.push(3); 
		llist.push(2); 
		llist.push(1); 		

		IntersectionTwoSortedLinked llist2 = new IntersectionTwoSortedLinked(); 
		/* Constructed Linked List is 2->4->6->8->null */
		llist2.push(8); 
		llist2.push(6); 
		llist2.push(4); 
		llist2.push(2); 
		
		System.out.println("List 1 "); 
		llist.printList(llist.head); 
				
		System.out.println("List 2 "); 
		llist2.printList(llist2.head); 		

		IntersectionTwoSortedLinked list = sortedIntersect(llist.head, llist2.head);
		
		System.out.println("sorted Intersect list(I) "); 
		llist2.printList(list.head);

		System.out.println("sorted Intersect list(R) "); 
		llist2.printList(sortedIntersectRec(llist.head, llist2.head)); 
	} 
} 

