// Java program to find longest palindrome sublist in a list in O(1) time. 

//javac -d classes LongestPalindromeSublist.java  && cd classes && java LongestPalindromeSublist && cd ..
class LongestPalindromeSublist { 

	//structure of the linked list 
	static class Node { 
		int data; 
		Node next; 
	} 

	// function for counting the common elements 
	static int countCommon(Node a, Node b) { 
		int count = 0; 
		// loop to count coomon in the list starting from node a and b 
		// System.out.println("\nCalling....");
		while (a != null && b != null) {// Q(n)
		    // System.out.println("(a.data, b.data) : ("+a.data+", "+b.data+")");
			if (a.data == b.data) {
				++count; 
			} else {
			    break; 
			}
		    a = a.next;
		    b = b.next;
		}
		return count; 
	} 

	// Returns length of the longest palindrome sublist in given list 
	//Time Complexity : O(n2)
	static int maxPalindrome(Node head) {

		int result = 0; 
		Node prev = null, curr = head; 

		// loop till the end of the linked list 
		while (curr != null) { // Q(n) => total O(n*n)
			// The sublist from head to current reversed. 
			Node next = curr.next; 
			curr.next = prev; 

           //head->2->3->5->7->4->7->5->3->2->8->null

           /*check for odd length palindrome */
			result = Math.max(result, 2 * countCommon(prev, next)+1); 
			
			/*check for even length palindrome */
			result = Math.max(result, 2*countCommon(curr, next)); 

			// update prev and curr for next iteration 
			prev = curr; 
			curr = next; 
		} 
		return result; 
	} 

	// Utility function to create a new list node 
	static Node newNode(int key) { 
		Node temp = new Node(); 
		temp.data = key; 
		temp.next = null; 
		return temp; 
	} 

	public static void main(String[] args) {
		/* hwad->2->4->3->4->2->15 */
/*		Node head = newNode(2); 
		head.next = newNode(4); 
		head.next.next = newNode(3); 
		head.next.next.next = newNode(4); 
		head.next.next.next.next = newNode(2); 
		head.next.next.next.next.next = newNode(15); 	*/	

        //head->2->3->5->7->4->7->5->3->2->8->null
		Node head = newNode(2); 
		head.next = newNode(3); 
		head.next.next = newNode(5); 
		head.next.next.next = newNode(7); 
		head.next.next.next.next = newNode(4); 
		head.next.next.next.next.next = newNode(7); 
		head.next.next.next.next.next.next = newNode(5); 
		head.next.next.next.next.next.next.next = newNode(3); 
		head.next.next.next.next.next.next.next.next = newNode(2); 
		head.next.next.next.next.next.next.next.next.next = newNode(8); 

		System.out.println(maxPalindrome(head)); 
	} 
} 


/*
Length of longest palindrome list in a linked list using O(1) extra space
Given a linked list, find length of the longest palindrome list that exist in that linked list.

Examples:

Input  : List = 2->3->7->3->2->12->24
Output : 5
The longest palindrome list is 2->3->7->3->2

Input  : List = 12->4->4->3->14
Output : 2
The longest palindrome list is 4->4*/