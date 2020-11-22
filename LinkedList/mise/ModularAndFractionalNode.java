// Java program to find fractional node in a linked list 
//javac -d classes ModularAndFractionalNode.java  && cd classes && java ModularAndFractionalNode && cd ..

public class ModularAndFractionalNode {

	 // Linked list node 
	static class Node{ 
		int data; 
		Node next; 

		//Constructor 
		Node (int data){ 
			this.data = data; 
		} 
	} 

	/* Function to find fractional node in the 
	linked list */
	static Node fractionalNode(Node head, int k) 
	{ 
		// Corner cases 
		if (k <= 0 || head == null) 
			return null; 

		Node ModularAndFractionalNode = null; 

		// Traverse the given list 
		int i = 0; 
		for (Node temp = head; temp != null; temp = temp.next) { 

			// For every k nodes, we move ModularAndFractionalNode one step ahead. 
			if (i % k == 0) { 
				// System.out.println(i);
				// First time we see a multiple of k 
				if (ModularAndFractionalNode == null) 
					ModularAndFractionalNode = head; 
				else
					ModularAndFractionalNode = ModularAndFractionalNode.next; 
			} 
			i++; 
		} 
		return ModularAndFractionalNode; 
	} 

	    // Function to find modular node in the linked list 
    static Node modularNode(Node head, int k) 
    { 
        // Corner cases 
        if (k <= 0 || head == null) 
            return null;    
       
        // Traverse the given list 
        int i = 1; 
        Node modularNode = null; 
        for (Node temp = head; temp != null; temp = temp.next) { 
            if (i % k == 0)  {
                modularNode = temp;  
            }
            i++; 
        } 
        return modularNode; 
    } 

	// A utility function to print a linked list 
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data+" "); 
			node = node.next; 
		} 
		System.out.println(); 
	} 

	/* Driver program to test above function */
	public static void main(String[] args) { 
		Node head = new Node(1); 
		head.next = new Node(2); 
		head.next.next = new Node(3); 
		head.next.next.next = new Node(4); 
		head.next.next.next.next = new Node(5); 
		int k =2; 

		System.out.print("List is "); 
		printList(head); 

		Node answer = fractionalNode(head, k); 
		System.out.println("Fractional node is "+ answer.data); 

	    answer = modularNode(head, k); 
		System.out.println("Modular node is "+ answer.data); 
	} 
} 



/*Find the fractional (or n/k – th) node in linked list
Given a singly linked list and a number k, write a function 
to find the (n/k)-th element, where n is the number of elements in the list. 
We need to consider ceil value in case of decimals.

Examples:

Input : list = 1->2->3->4->5->6 
        k = 2
Output : 3
Since n = 6 and k = 2, we print (6/2)-th node 
which is 3.

Input : list = 2->7->9->3->5
        k = 3
Output : 7 
Since n is 5 and k is 3, we print ceil(5/3)-th 
node which is 2nd node, i.e., 7.*/






/*Find modular node in a linked list

Last Updated: 30-10-2020
Given a singly linked list and a number k, find the last node whose n%k == 0, 
where n is the number of nodes in the list.

Examples:

Input : list = 1->2->3->4->5->6->7
        k = 3
Output : 6

Input : list = 3->7->1->9->8
        k = 2
Output : 9*/