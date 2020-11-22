//Find a triplet from three linked lists with sum equal to a given number

//javac -d classes FindTripletSum.java  && cd classes && java FindTripletSum  && cd ..
class FindTripletSum 
{ 
	Node head; // head of list 

	/* Linked list Node*/
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) {data = d; next = null; } 
	} 

/*Time complexity: 
 1. The linked lists b and c can be sorted in O(nLogn) time using Merge Sort. 
 2. The step 2 takes O(n*n) time.
  So the overall time complexity is O(nlogn) + O(nlogn) + O(n*n) = O(n*n).*/

	/* A function to chech if there are three elements in a, b 
	and c whose sum is equal to givenNumber. The function 
	assumes that the list b is sorted in ascending order and 
	c is sorted in descending order. */
boolean isSumSorted(FindTripletSum la, FindTripletSum lb, FindTripletSum lc, int givenNumber) {
	Node a = la.head; 
	// Traverse all nodes of la 
	while (a != null) { // O(n)
		Node b = lb.head; 
		Node c = lc.head; 
		// for every node in la pick 2 nodes from lb and lc 
		while (b != null && c!=null) { //O(n)

			int sum = a.data + b.data + c.data; 
			if (sum == givenNumber) { 
				System.out.println("Triplet found " + a.data + " " + b.data + " " + c.data); 
				return true; 
			} 
			// If sum is smaller then look for greater value of b 
			else if (sum < givenNumber) 
				b = b.next; 
			else
				c = c.next; 
		} 
		a = a.next; 
	} 
	System.out.println("No Triplet found"); 
	return false; 
} 


	/* Given a reference (pointer to pointer) to the head 
	of a list and an int, push a new node on the front 
	of the list. */
	void push(int new_data) 
	{ 
		/* 1 & 2: Allocate the Node & 
				Put in the data*/
		Node new_node = new Node(new_data); 

		/* 3. Make next of new Node as head */
		new_node.next = head; 

		/* 4. Move the head to point to new Node */
		head = new_node; 
	} 

	/* Driver program to test above functions */
	public static void main(String args[]) 
	{ 
		FindTripletSum llist1 = new FindTripletSum(); 
		FindTripletSum llist2 = new FindTripletSum(); 
		FindTripletSum llist3 = new FindTripletSum(); 

		/* Create Linked List llist1 100->15->5->20 */
		llist1.push(20); 
		llist1.push(5); 
		llist1.push(15); 
		llist1.push(100); 

		/*create a sorted linked list 'b' 2->4->9->10 */
		llist2.push(10); 
		llist2.push(9); 
		llist2.push(4); 
		llist2.push(2); 

		/*create another sorted linked list 'c' 8->4->2->1 */
		llist3.push(1); 
		llist3.push(2); 
		llist3.push(4); 
		llist3.push(8); 

		int givenNumber = 25; 
		llist1.isSumSorted(llist1,llist2,llist3,givenNumber); 
	} 
} 
