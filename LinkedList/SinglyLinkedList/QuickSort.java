// Java program for Quick Sort on Singly Linled List 

/*sort a linked list using quick sort*/
public class QuickSort {

	static class Node { 
		int data; 
		Node next; 

		Node(int d) 
		{ 
			this.data = d; 
			this.next= null; 
		} 
	} 

	Node head; 

	void addNode(int data) { 
		if(head == null) 
		{ 
			head = new Node(data); 
			return; 
		} 

		Node curr = head; 
		while(curr.next != null) 
			curr = curr.next; 

		Node newNode = new Node(data); 
		curr.next = newNode; 
	} 

	void printList(Node n) { 
		while(n != null) 
		{ 
			System.out.print(n.data); 
			System.out.print(" "); 
			n = n.next; 
		} 
	} 

	Node paritionLast(Node start, Node end) {
       if(start == end || start == null || end == null) return start;

       Node pivot_prev = start, curr = start;
       int pivot_data = end.data;

       while(start != end) {
       	if (start.data < pivot_data) {
       		pivot_prev = curr;
            int t = curr.data;
            curr.data = start.data;
            start.data = t;
       		curr = curr.next;
       	}
         start = start.next;
       }

       int t=curr.data;
       curr.data = pivot_data;
       end.data = t;

      return pivot_prev;
	}

	public void sort(Node start, Node end) {
        if(start == end) return;

        Node pivot_prev = paritionLast(start, end);

/*        sort(start, pivot_prev); // first division
        sort(pivot_prev.next.next, end); // 2nd division */

        sort(start, pivot_prev); // first division

        if(pivot_prev != null && pivot_prev == start) // pivot start
          sort(pivot_prev.next, end);

        //if pivot is in between of the list, 
        else if(pivot_prev != null && pivot_prev.next != null)
          sort(pivot_prev.next.next, end); // else if must be use
	}

/*	void reverse() {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
          Node next = curr.next;
          curr.next = prev;
          prev = curr;

          curr = next; //increemrnt
		}

		head = prev;
	}*/

	void reverse() {
		head = reverseList(head);
	}

	Node reverseList(Node node) {
		if(node == null || node.next == null) return node;
		Node rest = reverseList(node.next);
		node.next.next = node;
		node.next=null;
		return rest;
	}

	// Driver Code 
	public static void main(String[] args) { 
		QuickSort list = new QuickSort(); 
		list.addNode(30); 
		list.addNode(3); 
		list.addNode(4); 
		list.addNode(20); 
		list.addNode(5); 

		Node n = list.head; 
		while(n.next != null) 
			n= n.next; 

		System.out.println("Linked List before sorting"); 
		list.printList(list.head); 

		list.sort(list.head , n); 

		System.out.println("\nLinked List after sorting"); 
		list.reverse();
		list.printList(list.head); 
		System.out.println(); 
	} 
} 

// This code is contributed by trinadumca 
