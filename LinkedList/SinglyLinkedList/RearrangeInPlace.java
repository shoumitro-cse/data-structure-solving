//Rearrange a given linked list in-place.
//javac -d classes RearrangeInPlace.java  && cd classes && java RearrangeInPlace  && cd ..
class RearrangeInPlace { 

	static Node head; // head of the list 
	static class Node { 
		int data; 
		Node next; 
		Node(int d) { 
			data = d; 
			next = null; 
		} 
	} 

	void printlist(Node node) { 
		if (node == null) { 
			return; 
		} 
		while (node != null) { 
			System.out.print(node.data + " -> "); 
			node = node.next; 
		} 
	    System.out.println("null"); 
	} 

	Node reverselist(Node node) { 
		Node prev = null, curr = node, next; 
		while (curr != null) { 
			next = curr.next; 
			curr.next = prev; 
			prev = curr; 
			curr = next; 
		} 
		node = prev; 
		return node; 
	} 

	// Time Complexity: O(n)
	// Auxiliary Space: O(1)
	void rearrange(Node node) { 

		// 1) Find the middle point using tortoise and hare method 
		Node slow = node, fast = slow.next; 
		while (fast != null && fast.next != null) { 
			slow = slow.next; 
			fast = fast.next.next; 
		} 

		// 2) Split the linked list in two halves 
		// node1, head of first half 1 -> 2 -> 3 
		// node2, head of second half 4 -> 5 
		Node node1 = node; 
		Node node2 = slow.next; 
		slow.next = null; 

		// 3) Reverse the second half, i.e., 5 -> 4 
		node2 = reverselist(node2); 

		// 4) Merge alternate nodes 
		node = new Node(0); // Assign dummy Node 

		// curr is the pointer to this dummy Node, which will 
		// be used to form the new list 
		Node curr = node; 
		while (node1 != null || node2 != null) { //Time Complexity of this solution is O(n).

			// First add the element from first list 
			if (node1 != null) { 
				curr.next = node1; 
				curr = curr.next; 
				node1 = node1.next; 
			} 

			// Then add the element from second list 
			if (node2 != null) { 
				curr.next = node2; 
				curr = curr.next; 
				node2 = node2.next; 
			} 
		} 
	} 

	public static void main(String[] args) { 

		RearrangeInPlace list = new RearrangeInPlace(); 
		list.head = new Node(1); 
		list.head.next = new Node(2); 
		list.head.next.next = new Node(3); 
		list.head.next.next.next = new Node(4); 
		list.head.next.next.next.next = new Node(5); 

		list.printlist(head); // print original list 

		list.rearrange(head); // rearrange list as per ques

		list.printlist(head); // print modified list 
	} 
} 

/*Rearrange a given linked list in-place.

Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. 

Rearrange the nodes in the list so that the
 new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …

Examples:

Input:  1 -> 2 -> 3 -> 4
Output: 1 -> 4 -> 2 -> 3

Input:  1 -> 2 -> 3 -> 4 -> 5
Output: 1 -> 5 -> 2 -> 4 -> 3 */