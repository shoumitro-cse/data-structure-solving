// Java program to clone a linked list with random pointers 
//javac -d classes CloneLinkedListRandomPointers.java  && cd classes && java CloneLinkedListRandomPointers  && cd ..
import java.util.HashMap; 
import java.util.Map; 

// Linked List Node class 
class Node 
{ 
	int data;//Node data 
	Node next, random;//Next and random reference 

	//Node constructor 
	public Node(int data) { 
		this.data = data; 
		this.next = this.random = null; 
	} 
} 

// linked list class 
class CloneLinkedListRandomPointers {

	Node head;//Linked list head reference 

	// Linked list constructor 
	public CloneLinkedListRandomPointers(Node head) { 
		this.head = head; 
	} 

	// push method to put data always at the head 
	// in the linked list. 
	public void push(int data) { 
		Node node = new Node(data); 
		node.next = this.head; 
		this.head = node; 
	} 

	// Method to print the list. 
	void print() { 
		Node temp = head; 
		while (temp != null) { 
			Node random = temp.random; 
			int randomData = (random != null)? random.data: -1; 
			System.out.println("Data = " + temp.data + ", Random data = "+ randomData); 
			temp = temp.next; 
		} 
	} 


/*	// Time complexity : O(n)
	// Auxiliary space : O(n)

	public CloneLinkedListRandomPointers clone() {
		Node origCurr = this.head, cloneCurr = null;
		Map<Node, Node> map = new HashMap<Node, Node>(); 
		while (origCurr != null) { 
			cloneCurr = new Node(origCurr.data); 
			cloneCurr.next = origCurr.next;
			cloneCurr.random = origCurr.random;
			map.put(origCurr, cloneCurr); 
			origCurr = origCurr.next; 
		} 
		return new CloneLinkedListRandomPointers(map.get(this.head)); 
	} */
 
   //Time complexity : O(n)
 	public CloneLinkedListRandomPointers clone() {
		Node origCurr = this.head, cloneCurr = null, curr_head=null;
		while (origCurr != null) { 
			if (cloneCurr == null) {
			   cloneCurr = new Node(origCurr.data); 
			   cloneCurr.next = origCurr.next;
			   cloneCurr.random = origCurr.random;
			   curr_head = cloneCurr;
			} else {
				cloneCurr = new Node(origCurr.data); 
				cloneCurr.next = origCurr.next;
				cloneCurr.random = origCurr.random;
	        }
			origCurr = origCurr.next; 
			cloneCurr = cloneCurr.next;
		} 
		return new CloneLinkedListRandomPointers(curr_head); 
	} 

	public static void main(String[] args) { 

		// Pushing data in the linked list. 
		CloneLinkedListRandomPointers list = new CloneLinkedListRandomPointers(new Node(5)); 
		list.push(4); 
		list.push(3); 
		list.push(2); 
		list.push(1); 

		// Setting up random references. 
		list.head.random = list.head.next.next; 
		list.head.next.random = list.head.next.next.next; 
		list.head.next.next.random = list.head.next.next.next.next; 
		list.head.next.next.next.random = list.head.next.next.next.next.next; 
		list.head.next.next.next.next.random = list.head.next; 

		// Making a clone of the original linked list. 
		CloneLinkedListRandomPointers clone = list.clone(); 

		// Print the original and cloned linked list. 
		System.out.println("Original linked list"); 
		list.print();

		System.out.println("\nCloned linked list"); 
		clone.print(); 
	} 
}
