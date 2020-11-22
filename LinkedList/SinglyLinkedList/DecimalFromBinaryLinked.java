// Java Program to find decimal value of binary linked list 
//javac -d classes DecimalFromBinaryLinked.java  && cd classes && java DecimalFromBinaryLinked && cd ..

class DecimalFromBinaryLinked { 
	
	// Link list Node / 
	static class Node { 
		boolean data; 
		Node next; 
	}; 

	// Returns decimal value of binary linked list / 
	static int decimalValue( Node head) { 
		// Initialized result 
		int res = 0; 
		// Traverse linked list 
		while (head != null) { 
			// Multiply result by 2 and add head's data 
			res = (res << 1) + (head.data?1:0); 
			// Move next 
			head = head.next; 
		} 
		return res; 
	} 

	// Utility function to create a new node. 
	static Node newNode(int data) { 
		Node temp = new Node(); 
		temp.data = (data==1? true:false); 
		temp.next = null; 
		return temp; 
	} 

	// Driver code/ 
	public static void main(String args[]) { 
		// Start with the empty list / 
		Node head = newNode(1); 
		head.next = newNode(0); 
		head.next.next = newNode(1); 
		head.next.next.next = newNode(1); 

		System.out.print( "Decimal value is "+decimalValue(head)+"\n"); 
	} 
} 

