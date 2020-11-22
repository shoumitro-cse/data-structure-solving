//Rearrange a linked list such that all even and odd positioned nodes are together
//javac -d classes RearrangeEvenOddPositioned.java  && cd classes && java RearrangeEvenOddPositioned && cd ..

class RearrangeEvenOddPositioned { 

	// Linked List Node 
	static class Node { 
		int data; 
		Node next; 
	} 

	// A utility function to create a new node 
	static Node newNode(int key) { 
		Node temp = new Node(); 
		temp.data = key; 
		temp.next = null; 
		return temp; 
	} 

	static Node rearrangeEvenOdd(Node head) { 

		if (head == null) 
			return null; 

		Node odd = head; 
		Node even = head.next; 
 
		Node evenFirst = even; 

		while (1 == 1) { 
			if (odd == null || even == null || (even.next) == null) { 
				odd.next = evenFirst; 
				break; 
			} 
			odd.next = even.next; 
			odd = even.next; 

			if (odd.next == null) { 
				even.next = null; 
				odd.next = evenFirst; 
				break; 
			} 
			even.next = odd.next; 
			even = odd.next; 
		} 
		return head; 
	} 

	// A utility function to print a linked list 
	static void printlist(Node node) { 
		while (node != null) { 
			System.out.print(node.data + "->"); 
			node = node.next; 
		} 
		System.out.println("NULL") ; 
	} 

	// Driver code 
	public static void main(String[] args) {
	 
		Node head = newNode(1); 
		head.next = newNode(2); 
		head.next.next = newNode(3); 
		head.next.next.next = newNode(4); 
		head.next.next.next.next = newNode(5); 

		System.out.println("Given Linked List"); 
		printlist(head); 

		head = rearrangeEvenOdd(head); 

		System.out.println("Modified Linked List"); 
		printlist(head); 
	} 
} 

