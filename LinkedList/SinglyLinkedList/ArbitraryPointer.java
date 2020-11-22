// Point to next higher value node in a linked list with an arbitrary pointer
//javac -d classes ArbitraryPointer.java  && cd classes && java ArbitraryPointer  && cd ..

class ArbitraryPointer { 

	static Node head; 

	/* Link list node */
	static class Node { 
		int data; 
		Node next, arbit; 

		Node(int data) { 
			this.data = data; 
			next = null; 
			arbit = null; 
		} 
	} 

	// Utility function to print result linked list 
	void printList(Node node, Node anode) {

		System.out.println("Traversal using Next Pointer"); 
		while (node != null) { 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 

		System.out.println("\nTraversal using Arbit Pointer"); 
		while (anode != null) { 
			System.out.print(anode.data + " "); 
			anode = anode.arbit; 
		} 
	} 

	// This function populates arbit pointer in every node to the 
	// next higher value. And returns pointer to the node with 
	// minimum value 
	private Node populateArbit(Node start) { 

		Node temp = start; 

		// Copy next pointers to arbit pointers 
		while (temp != null) { // O(n)
			temp.arbit = temp.next; 
			temp = temp.next; 
		} 

		// Do merge sort for arbitrary pointers and 
		// return head of arbitrary pointer linked list 
		return MergeSort(start); 
	} 

	/* sorts the linked list formed by arbit pointers 
	(does not change next pointer or data) */
	private Node MergeSort(Node start) { // Q(nlogsn)
		
		/* Base case -- length 0 or 1 */
		if (start == null || start.arbit == null) { 
			return start; 
		} 

		/* Split head into 'middle' and 'nextofmiddle' sublists */
		Node middle = getMiddle(start); 
		Node nextofmiddle = middle.arbit; // create nextofmiddle list

		middle.arbit = null; // seperate from start list

		/* Recursively sort the sublists */
		Node left = MergeSort(start); 
		Node right = MergeSort(nextofmiddle); 

		/* answer = merge the two sorted lists together */
		Node sortedlist = SortedMerge(left, right); 

		return sortedlist; 
	} 

	// Utility function to get the middle of the linked list 
	private Node getMiddle(Node source) { 
		// Base case 
		if (source == null) 
			return source; 
		Node fastptr = source.arbit; 
		Node slowptr = source; 

		// Move fastptr by two and slow ptr by one 
		// Finally slowptr will point to middle node 
		while (fastptr != null) { 
			fastptr = fastptr.arbit; 
			if (fastptr != null) 
			{ 
				slowptr = slowptr.arbit; 
				fastptr = fastptr.arbit; 
			} 
		} 
		return slowptr; 
	} 

	private Node SortedMerge(Node a, Node b) {

		Node result = null; 

		/* Base cases */
		if (a == null) 
			return b; 
		else if (b == null) 
			return a; 

		/* Pick either a or b, and recur */
		if (a.data <= b.data) { 
			result = a; 
			result.arbit = SortedMerge(a.arbit, b); 
		} 
		else { 
			result = b; 
			result.arbit = SortedMerge(a, b.arbit); 
		} 

		return result; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		ArbitraryPointer list = new ArbitraryPointer(); 

		/* Let us create the list shown above */
		list.head = new Node(5); 
		list.head.next = new Node(10); 
		list.head.next.next = new Node(2); 
		list.head.next.next.next = new Node(3); 

		/* Sort the above created Linked List */
		Node ahead = list.populateArbit(head); 

		System.out.println("Result Linked List is:"); 
		list.printList(head, ahead); 
		System.out.println(); 
	} 
} 

