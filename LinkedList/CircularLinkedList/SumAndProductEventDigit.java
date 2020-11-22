// Sum and Product of nodes with value as even digit sum in Circular Linked List

//javac -d classes SumAndProductEventDigit.java  && cd classes && java SumAndProductEventDigit && cd ..

class SumAndProductEventDigit { 

	// Structure for a node 
	static class Node{ 
		int data; 
		Node next; 
	} 

	// Function to calulate the sum of indivdual digits 
	static int digitSum(int n) { 
		int sum = 0; 
		while (n != 0) { 
			sum = sum + n % 10; 
			n = (int) n / 10; 
			// System.out.println(n);
		} 
		return sum; 
	} 

	// Function to calculate sum and product for event digit.
	static void SumProduct(Node head) {

		Node temp = head; 
		int Sum = 0; 
		int Prod = 1; 
		do { 		
			// Check if current node's data has an even digit sum 
			if (digitSum(temp.data) % 2 == 0) { 
				Sum += temp.data; 
				Prod *= temp.data; 
			} 
			temp = temp.next; 
		} while (temp != head); 

		System.out.print("Sum = " + Sum); 
		System.out.print(", Product = " + Prod); 
	} 

	// Function print the list 
	static void DisplayList(Node head) 
	{ 
		Node temp = head; 
		if (head != null) 
		{ 
			do
			{ 
				
				// Traverse first to last node 
				System.out.print(temp.data + " "); 
				temp = temp.next; 
			} while (temp != head); 
		} 
		System.out.println(); 
	} 

	// Function to insert a node at the ending 
	// of a Circular linked list 
	static Node InsertNode(int key, Node head) 
	{ 

		// Create a new node 
		Node new_node = new Node(); 
		new_node.data = key; 

		// If linked list is null then 
		// make the first node as head 
		// after insertion 
		if (head == null) 
		{ 
			head = new_node; 
			new_node.next = head; 

		} 
		else
		{ 
			
			// traverse to the end and insert 
			// node at the end and make 
			// it point to the head 
			Node temp = head; 
			while (temp.next != head) 
			{ 
				temp = temp.next; 
			} 
			
			temp.next = new_node; 
			new_node.next = head; 
		} 
		return head; 
	} 

	// Driver code 
	public static void main(String args[]) {

		Node head = null; 
		
		head = InsertNode(13, head); 
		head = InsertNode(6, head); 
		head = InsertNode(8, head); 
		head = InsertNode(15, head); 
		head = InsertNode(16, head); 
		
		System.out.print("Initial List: "); 
		
		DisplayList(head); 

		SumProduct(head); 
		
		System.out.print("\n"); 
	} 
} 



/*Sum and Product of nodes with value as even digit sum in Circular Linked List
Given a circular singly linked list containing N nodes, 
The task is to find the sum and product of all the nodes from the list 
whose data value has an even digit sum.

Examples: 

Input: List = 15 -> 16 -> 8 -> 6 -> 13 
Output: Sum = 42, Product = 9360 
Explanation: 
The circular linked list contains: 
15 -> 1 + 5 = 6 
16 -> 1 + 6 = 7 
8 -> 8 
6 -> 6 
13 -> 1 + 3 = 4 
The list contains 4 Even Digit Sum data values 15, 8, 6 and 13. 
Sum = 15 + 8 + 6 + 13 = 42 
Product = 15 * 8 * 6 * 13 = 9360

Input: List = 5 -> 3 -> 4 -> 2 -> 9 
Output: Sum = 6, Product = 8 
Explanation: 
The list contains 2 Even Digit Sum data values 4 and 2. 
Sum = 4 + 2 = 6 
Product = 4 * 2 = 8


Approach: 

Initialize a pointer current with the head of the circular linked list and 
a sum variable sum with 0 and a product variable product with 1.
Start traversing the linked list using a do-while loop until all the nodes get traversed.
If current node data value has an even digit sum. 
Add the value of current node to the sum i.e. sum = sum + current -> data.
Multiply the value of current node to the product i.e. product = product * current -> data.
Increment the pointer to the next node of linked list i.e. temp = temp -> next.
Print the sum and product.
Below is the implementation of the above approach:

*/