//Josephus Circle using circular linked list

//javac -d classes JosephusCircle.java  && cd classes && java JosephusCircle && cd ..

public class JosephusCircle { 
	
	// Node class to store data 
	static class Node { 
		public int data ; 
		public Node next; 
		public Node( int data ) { 
			this.data = data; 
			next=null;
		} 
	} 
	
	/* Function to find the only person left 
	after one in every m-th node is killed in a circle of n nodes */

	// Time complexity: O(m * n)

	static void getJosephusPosition(int m, int n) { 

		// Create a circular linked list of size N. 
		Node head = new Node(1); 
		Node prev = head; 
		for(int i = 2; i <= n; i++) { 
			prev.next = new Node(i); 
			prev = prev.next; 
		} 
		// head => 1 2 3 4 5->(head)
		// Connect last node to first or create circular list
		prev.next = head; 
		print(head);
		
		/* while only one node is left in the linked list*/
		Node ptr1 = head, ptr2 = head; 
		
		while(ptr1.next != ptr1) { 
			// Find m-th node 
			int count = 1; 
			while(count != m) { //m=2
				ptr2 = ptr1;   
				ptr1 = ptr1.next; 
				count++; 
			} 
			
			/* Remove the m-th node */
			ptr2.next = ptr1.next; 
			ptr1 = ptr2.next; 
		} 

		// print(ptr1);
		// print(ptr2);
		System.out.println ("(Josephus Circle Position) is " + ptr1.data); 
	} 

	static void print(Node node) {
		Node temp = node;
		do {
			System.out.print(temp.data+" ");
           temp = temp.next;
		} while(temp != node);
		System.out.print("\n");
	}
	
	/* Driver program to test above functions */
	public static void main(String args[]) { 
		int n = 5, m = 2; 
		getJosephusPosition(m, n); 
	} 
} 


/*Josephus Circle using circular linked list
Time complexity: O(m * n)



There are n people standing in a circle waiting to be executed. 
The counting out begins at some point in the circle and proceeds
around the circle in a fixed direction. In each step, a certain
number of people are skipped and the next person is executed. 
The elimination proceeds around the circle (which is becoming smaller
and smaller as the executed people are removed), until only the last person remains,
who is given freedom. Given the total number of persons n and a number m which indicates 
that m-1 persons are skipped and m-th person is killed in circle. 
The task is to choose the place in the initial circle so that you are the last one 
remaining and so survive.

Examples :

Input : Length of circle : n = 4
        Count to choose next : m = 2
Output : 1

Input : n = 5
        m = 3
Output : 4


We have discussed different solutions of this problem (here and here). 
In this post a simple circular linked list based solution is discussed.
1) Create a circular linked list of size n.
2) Traverse through linked list and one by one delete every m-th node until there is one node left.
3) Return value of the only left node.

*/