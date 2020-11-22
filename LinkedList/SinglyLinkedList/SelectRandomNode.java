// Java program to select a random node from singly linked list 
//javac -d classes SelectRandomNode.java  && cd classes && java SelectRandomNode  && cd ..

import java.util.*; 

// Linked List Class 
class SelectRandomNode { 

	static Node head; 
	static class Node { 
		int data; 
		Node next; 
		Node(int d) { 
			data = d; 
			next = null; 
		} 
	} 

	// A reservoir sampling based function to print a 
	// random node from a linked list 
	void printrandom(Node node) { 

		// If list is empty 
		if (node == null) { 
			return; 
		} 

		// Use a different seed value so that we don't get 
		// same result each time we run this program 
		Math.abs(UUID.randomUUID().getMostSignificantBits()); 

		// Initialize result as first node 
		int result = node.data; 

		// Iterate from the (k+1)th element to nth element 
		Node current = node; 
		// int randomNum = new Random().nextInt((max - min) + 1) + min;
		int randomNum = new Random().nextInt((100 - 1) + 1) +1;
		// System.out.println("Random: " + randomNum ); 

		for (int n = 2; current != null; n++) { 
		    // System.out.println("Random: " + Math.random()%n ); 
			// change result with probability 1/n 
			if (randomNum % n == 0) { 
				result = current.data; 
			} 

			// Move to next node 
			current = current.next; 
		} 
		System.out.println("Randomly selected key is " + result); 

	} 

	static void printList( Node head) { 
		Node temp = head; 
		while (temp != null) 
		{ 
			System.out.printf("%d ", temp.data); 
			temp = temp.next; 
		} 
		System.out.printf("\n"); 
	} 

	// Driver program to test above functions 
	public static void main(String[] args) { 

		SelectRandomNode list = new SelectRandomNode(); 

		list.head = new Node(5); 
		list.head.next = new Node(20); 
		list.head.next.next = new Node(4); 
		list.head.next.next.next = new Node(3); 
		list.head.next.next.next.next = new Node(30); 

        printList(list.head);

		list.printrandom(head); 

	} 
} 


/*
Random rn = new Random();

for(int i =0; i < 100; i++)
{
    int answer = rn.nextInt(10) + 1;
    System.out.println(answer);
}*/