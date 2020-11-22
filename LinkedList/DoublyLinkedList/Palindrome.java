// Check if a doubly linked list of characters is palindrome or not
// javac -d classes Palindrome.java  && cd classes && java Palindrome && cd ..

class Palindrome 
{ 

	// Structure of node 
	static class Node 
	{ 
		char data; 
		Node next; 
		Node prev; 
	}; 

	/* Given a reference (pointer to pointer) to 
	the head of a list and an int, inserts a 
	new node on the front of the list. */
	static Node push(Node head_ref, char new_data) 
	{ 
		Node new_node = new Node(); 
		new_node.data = new_data; 
		new_node.next = head_ref; 
		new_node.prev = null; 
		if (head_ref != null) 
		head_ref.prev = new_node ; 
		head_ref = new_node; 
		return head_ref; 
	} 

	// Function to check if list is palindrome or not 
	// Time complexity: O(n)
// Auxiliary Space : O(1)
	static boolean isPalindrome(Node start) 
	{ 
		if (start == null) 
		return true; 

		// Find lastmost node 
		Node last = start; 
		while (last.next != null) 
			last = last.next; 

		while (start != last) 
		{ 
			if (start.data != last.data) 
				return false; 

			start = start.next; 
			last = last.prev; 
		} 

		return true; 
	} 

	// Driver program 
	public static void main(String[] args) 
	{ 
		Node head = null; 
		head = push(head, 'l'); 
		head = push(head, 'e'); 
		head = push(head, 'v'); 
		head = push(head, 'e'); 
		head = push(head, 'l'); 
        //head=> l<->e<->v<->e<->l  === level

		if (isPalindrome(head)) 
			System.out.printf("It is Palindrome\n"); 
		else
			System.out.printf("Not Palindrome\n"); 
	} 
} 

