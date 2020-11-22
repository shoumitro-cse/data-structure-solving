// Find the sum of last n nodes of the given Linked List
// / javac -d classes SumOfLastNnodes.java  && cd classes && java SumOfLastNnodes && cd ..

import java.util.*; 

class SumOfLastNnodes { 
	
	/* A Linked list node */
	static class Node { 
		int data; 
		Node next; 
	}; 
	static Node head; 
	static int n, sum; 

	// function to insert a node at the beginning of the linked list 
	static void push(Node head_ref, int new_data) { 
		/* allocate node */
		Node new_node = new Node(); 
		
		/* put in the data */
		new_node.data = new_data; 
		
		/* link the old list to the new node */
		new_node.next = head_ref; 
		
		/* move the head to point to the new node */
		head_ref = new_node; 
		head = head_ref; 
	} 

	/*1. Time Complexity: O(n), where n is the number of nodes in the linked list.
	  2. Auxiliary Space: O(n), if system call stack is being considered.*/
	static void sumOfLastN_Nodes(Node head) { 
		// if head = NULL 
		if (head == null) 
			return; 
		// recursively traverse the remaining nodes 
		sumOfLastN_Nodes(head.next); 

		// if node count 'n' is greater than 0 
		if (n > 0) { 
			// accumulate sum 
			sum = sum + head.data; 
			// reduce node count 'n' by 1 
			--n; 
		} 
	} 

/*	// utility function to find the sum of last 'n' nodes 
    // using recursion
	static int sumOfLastN_NodesUtil(Node head, int n) { 
		// if n == 0 
		if (n <= 0) 
			return 0; 
		sum = 0; 
		// find the sum of last 'n' nodes 
		sumOfLastN_Nodes(head); 
		// required sum 
		return sum; 
	} 
*/


/*	
   // utility function to find the sum of last 'n' nodes 
	// 1. Time Complexity: O(n), where n is the number of nodes in the linked list.
	// 2. Auxiliary Space: O(n), stack size
	static int sumOfLastN_NodesUtil(Node head, int n) { 
	    // if n == 0 
	    if (n <= 0) 
	        return 0; 
	  
	    Stack<Integer> st = new Stack<Integer>(); 
	    int sum = 0; 
	  
	    // traverses the list from left to right 
	    while (head != null)  
	    { 
	  
	        // push the node's data onto the stack 'st' 
	        st.push(head.data); 
	  
	        // move to next node 
	        head = head.next; 
	    } 
	  
	    // pop 'n' nodes from 'st' and 
	    // add them 
	    while (n-- >0) 
	    { 
	        sum += st.peek(); 
	        st.pop(); 
	    } 
	  
	    // required sum 
	    return sum; 
	} */


	/*Time Complexity: O(n), where n is the number of nodes in the linked list.
	Auxiliary Space: O(1)*/
	private static int sumOfLastN_NodesUtil(Node head, int n) { 
        // if n == 0 
        if (n <= 0) 
            return 0; 
        int sum = 0, temp = 0; 
        Node ref_ptr, main_ptr; 
        ref_ptr = main_ptr = head; 
  
        while (ref_ptr != null && (n--) > 0) { 
            sum += ref_ptr.data; 
            ref_ptr = ref_ptr.next; 
        } 
        while (ref_ptr != null) { 
            temp += main_ptr.data; 
            sum += ref_ptr.data; 
            main_ptr = main_ptr.next; 
            ref_ptr = ref_ptr.next; 
        } 
        // sum = sum of all none.
        // temp = sum of all node before last n node.
       return (sum - temp); 
    } 

	public static void main(String[] args) { 
		head = null; 
		// create linked list head->10->6->8->5->12->null
		push(head, 12); 
		push(head, 4); 
		push(head, 8); 
		push(head, 6); 
		push(head, 10); 

		n = 2; 
		System.out.print("Sum of last " + n + " nodes = " + sumOfLastN_NodesUtil(head, n)); 
		System.out.println(); 
	} 
} 



/*Find the sum of last n nodes of the given Linked List
Given a linked list and a number n. 
Find the sum of last n nodes of the linked list.

Constraints: 0 <= n <= number of nodes in the linked list.

Examples:

Input : 10->6->8->4->12, n = 2
Output : 16
Sum of last two nodes:
12 + 4 = 16

Input : 15->7->9->5->16->14, n = 4
Output : 44*/