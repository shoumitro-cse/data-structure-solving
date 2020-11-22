// Java program to check if a linked list with loop is palindrome or not. 
// Check linked list with a loop is palindrome or not
//javac -d classes LoopIsPalindromeOrNot.java  && cd classes && java LoopIsPalindromeOrNot && cd ..
import java.util.*; 

class LoopIsPalindromeOrNot 
{ 

	/* Link list node */
	static class Node 
	{ 
		int data; 
		Node next; 
	} 

  // Then find the starting node of loop
	static Node getLoopstart(Node loop_node, Node head) {

		Node ptr1 = loop_node;//last => 20 
		Node ptr2 = loop_node; //20

		// Count the number of nodes in loop 
		int k = 1, i; 
		while (ptr1.next != ptr2) { 
			ptr1 = ptr1.next; 
			k++; 
		} 

		// Fix one pointer to head 
		ptr1 = head; 

		// And the other pointer to k nodes after head 
/*		System.out.println("\nloop_node = "+loop_node.data);// 20
		System.out.println("k = "+k);*/
		ptr2 = head; 
		for (i = 0; i < k; i++) // k=3
			ptr2 = ptr2.next; 

		/* Move both pointers at the same pace, 
		they will meet at loop starting node */
/*	    System.out.println("ptr1 = "+ptr1.data);
	    System.out.println("ptr2 = "+ptr2.data);
	    System.out.println();*/

/*	    head->50->20->15->20->50
                       ^------^	 */    
		while (ptr2 != ptr1) { // ptr1==ptr2=15
			ptr1 = ptr1.next; 
			ptr2 = ptr2.next; 
/*		    System.out.println("ptr1 = "+ptr1.data);
		    System.out.println("ptr2 = "+ptr2.data);		    
	        System.out.println();*/
		}

		return ptr1; // 15
	} 

   // Detect the loop using Floyd Cycle Detection Algorithm.
	static Node detectAndgetLoopstarting(Node head) {

		Node slow_p = head, fast_p = head,loop_start = null; 

		//Start traversing list and detect loop 
		while (slow_p != null && fast_p != null && fast_p.next != null) {

			slow_p = slow_p.next; 
			fast_p = fast_p.next.next; 

			/* If slow_p and fast_p meet then find 
			the loop starting node*/
			if (slow_p == fast_p) { // slow_p=fast_p=20
				loop_start = getLoopstart(slow_p, head); //last 20. so slow_p=20
				break; 
			} 
		} 

		// Return starting node of loop 
		return loop_start; // return => 15
	} 

   // Check linked list is palindrome or not  
	static boolean isPalindromeUtil(Node head, Node loop_start) {

		Node ptr = head; 
		Stack<Integer> stack = new Stack<Integer> (); 

/*		Traverse linked list until last node 
		is equal to loop_start and store the elements till start in a stack */
		int count = 0; 
		while (ptr != loop_start || count != 1) { //loop_start=15
			stack.push(ptr.data); 
			if (ptr == loop_start) {
				count = 1; 		
			}
/*			System.out.println("loop start: "+loop_start.data);
			System.out.println("loop : "+ptr.data);
			System.out.println("count : "+count);*/
			ptr = ptr.next; 
		} 
		ptr = head; 
		count = 0; 
		
		// System.out.println(s);
        //stack = [50, 20, 15, 20, 50] first peek()=50, then 20 so soon.
		//head->50->20->15->20->51->15

		// Traverse linked list until last node is equal to loop_start second time 
		while (ptr != loop_start || count != 1) { 
			// Compare data of node with the top of stack If equal then continue 
			if (ptr.data == stack.peek()) {
				stack.pop(); 
			} else {
/*				System.out.println("ptr : "+ptr.data);
				System.out.println("stack : "+s.peek());*/
				return false; 
			}
			if (ptr == loop_start) 
				count = 1; 
			ptr = ptr.next; 
		} 
		// Return true if linked list is palindrome 
		return true; 
	} 

	// Function to find if linked list 
	// is palindrome or not 
	static boolean isPalindrome(Node head) { 
		// Find the loop starting node 
		Node loop_start = detectAndgetLoopstarting(head); //15

		// Check if linked list is palindrome 
		return isPalindromeUtil(head, loop_start); //loop_start=15
	} 

	static Node newNode(int key) 
	{ 
		Node temp = new Node(); 
		temp.data = key; 
		temp.next = null; 
		return temp; 
	} 

	/* Driver code*/
	public static void main(String[] args) 
	{ 

		Node head = newNode(50); 
		head.next = newNode(20); 
		head.next.next = newNode(15); 
		head.next.next.next = newNode(20); 
		head.next.next.next.next = newNode(50); 
		// head.next.next.next.next = newNode(51); 
		// head.next.next.next.next.next = newNode(51); 

		/* Create a loop for testing */
		head.next.next.next.next.next = head.next.next; 

		if(isPalindrome(head) == true) 
			System.out.println("Palindrome"); 
		else
			System.out.println("Not Palindrome"); 

	} 
} 

/*
Check linked list with a loop is palindrome or not

Algorithm:
	1. Detect the loop using Floyd Cycle Detection Algorithm.
	2. Then find the starting node of loop.
	3. Check linked list is palindrome or not.

Input : 1 -> 2 -> 3 -> 2
             /|\      \|/
               ------- 1  
Output: Palindrome
Linked list is 1 2 3 2 1 which is a 
palindrome.

Input : 1 -> 2 -> 3 -> 4
             /|\      \|/
               ------- 1  
Output: Not Palindrome
Linked list is 1 2 3 4 1 which is a 
not palindrome.*/