// Java program to clone a linked list with next and random pointers in O(n) time 
//Clone a linked list with next and random pointer in O(1) space
// javac -d classes CloneLinkedListRandomPointers2.java  && cd classes && java CloneLinkedListRandomPointers2 && cd ..

class CloneLinkedListRandomPointers2 { 

	// Structure of linked list Node 
	static class Node 
	{ 
		int data; 
		Node next,random; 
		Node(int x) 
		{ 
			data = x; 
			next = random = null; 
		} 
	} 

	// Utility function to print the list. 
	static void print(Node start) 
	{ 
		Node ptr = start; 
		while (ptr != null) 
		{ 
			System.out.println("Data = " + ptr.data + 
						", Random = "+ptr.random.data); 
			ptr = ptr.next; 
		} 
	} 

	// This function clones a given linked list in O(1) space 
	static Node clone(Node start) {
        // start = 1->2->3->4->5->null
		Node curr = start; 
		Node temp = null; 

		// insert additional node after every node of original list 
		while (curr != null) { // Time Complexity O(n) 
			temp = curr.next; 
			// Inserting node 
			curr.next = new Node(curr.data); // Q(1) extra space
			curr.next.next = temp; 
			// System.out.println(curr.data+" "+curr.next.data+" "+curr.next.next.data);
			curr = temp; 
		} 
		// After this loop
        // start = 1->1->2->2->3->3->4->4->5->5->null
		curr = start; 

		// adjust the random pointers of the newly added nodes 
		while (curr != null) { 
			if(curr.next != null) 
				// System.out.println("(curr.random, curr.random.next): ("+curr.random.data+", "+curr.random.next.data+")");
				curr.next.random = (curr.random != null) ? curr.random.next : curr.random; 
			curr = (curr.next != null) ? curr.next.next : curr.next; 
		} 

        //random start = 1->1->2->2->3->3->4->4->5->5->null
		Node original = start;
		Node copy = start.next; 
	    // System.out.println("(original, copy): ("+original.data+", "+copy.data+")");
		

		// save the start of copied linked list 
		temp = copy; 
		// Node temp_org = original; 

		// now separate the original list and copied list 
		while (original != null && copy != null) { 
			original.next = (original.next != null)? original.next.next : original.next; 
			copy.next = (copy.next != null) ? copy.next.next : copy.next; 
			original = original.next; 
			copy = copy.next; 
		} 
/*		copy = 1->2->3->4->5->null
		original = 1->2->3->4->5->null*/
		return temp; 
	} 

	// Driver code 
	public static void main(String[] args) {

		Node start = new Node(1); 
		start.next = new Node(2); 
		start.next.next = new Node(3); 
		start.next.next.next = new Node(4); 
		start.next.next.next.next = new Node(5); 
		// 1->2->3->4->5->null

		// 1's random points to 3 
		start.random = start.next.next; 

		// 2's random points to 1 
		start.next.random = start; 

		// 3's and 4's random points to 5 
		start.next.next.random = start.next.next.next.next; 
		start.next.next.next.random = start.next.next.next.next; 

		// 5's random points to 2 
		start.next.next.next.next.random = start.next; 

		System.out.println("Original list : "); 
		print(start); 

		System.out.println("Cloned list : "); 
		Node cloned_list = clone(start); 
		print(cloned_list); 

	} 
} 

