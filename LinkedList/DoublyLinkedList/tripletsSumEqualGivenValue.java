// Count triplets in a sorted doubly linked list whose sum is equal to a given value x
//  javac -d classes tripletsSumEqualGivenValue.java  && cd classes && java tripletsSumEqualGivenValue && cd ..

import java.io.*; 
import java.util.*; 

// Represents node of a doubly linked list 
class Node 
{ 
	int data; 
	Node prev, next; 
	Node(int val) 
	{ 
		data = val; 
		prev = null; 
		next = null; 
	} 
} 

class tripletsSumEqualGivenValue { 
/*
	// function to count pairs whose sum equal to given 'value' 
	static int countPairs(Node first, Node second, int value) { 
	    int count = 0; 
	   
	    // The loop terminates when either of two pointers 
	    // become null, or they cross each other (second.next 
	    // == first), or they become same (first == second) 
	    while (first != null && second != null &&  
	           first != second && second.next != first) { 
	        // pair found 
	        if ((first.data + second.data) == value) { 
	            // increment count 
	            count++; 
	            // move first in forward direction 
	            first = first.next; 
	            // move second in backward direction 
	            second = second.prev; 
	        } 
	        // if sum is greater than 'value' 
	        // move second in backward direction 
	        else if ((first.data + second.data) > value) 
	            second = second.prev; 
	        // else move first in forward direction 
	        else
	            first = first.next; 
	    } 
	    // required count of pairs 
	    return count; 
	} 
	   
	// function to count triplets in a sorted doubly linked list 
	// whose sum is equal to a given value 'x' 
	//Time Complexity: O(n2)
    //Auxiliary Space: O(1)
	static int countTriplets(Node head, int x) { 
	    // if list is empty 
	    if (head == null) 
	        return 0; 
	    Node current, first, last; 
	    int count = 0; 
	    // get pointer to the last node of the doubly linked list 
	    last = head; 
	    while (last.next != null) {
	        last = last.next; 
	    }
	    // traversing the doubly linked list 
	    for (current = head; current != null; current = current.next) { 
	        // for each current node 
	        first = current.next; 
	        // count pairs with sum(x - current.data) in the range 
	        // first to last and add it to the 'count' of triplets 
	        count += countPairs(first, last, x - current.data); 
	    } 
	    // required count of triplets 
	    return count; 
	}*/

/*	// 	Time Complexity: O(n2)
	// Auxiliary Space: O(n)
	static int countTriplets(Node head, int x) { 
	    Node ptr, ptr1, ptr2; 
	    int count = 0; 
	    // unordered_map 'um' implemented as hash table 
	    HashMap<Integer,Node> um = new HashMap<Integer,Node>(); 
	    // insert the <node data, node pointer> tuple in 'um' 
	    for (ptr = head; ptr != null; ptr = ptr.next) {
	        um.put(ptr.data, ptr); 
	    }
	   
	    // generate all possible pairs 
	    for (ptr1 = head; ptr1 != null; ptr1 = ptr1.next) 
	        for (ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next) { 

	 	        int p_sum = ptr1.data + ptr2.data; 
	  
	            if (um.containsKey(x - p_sum) && um.get(x - p_sum) != ptr1 && um.get(x - p_sum) != ptr2) {
	                // increment count 
	                count++; 
	            }
	        } 
	    // required count of triplets division by 3 as each triplet is counted 3 times 
	    return (count / 3); 
	} */


	/*Time Complexity: O(n3)
	Auxiliary Space: O(1)*/	

	static int countTriplets(Node head, int x) 
	{ 
			Node ptr1, ptr2, ptr3; 
			int count = 0; 

			// generate all possible triplets 
			for (ptr1 = head; ptr1 != null; ptr1 = ptr1.next) {
				for (ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next) {
					for (ptr3 = ptr2.next; ptr3 != null; ptr3 = ptr3.next) {
						// if elements in the current triplet sum up to 'x' 
						if ((ptr1.data + ptr2.data + ptr3.data) == x) {
							// increment count 
							count++; 
							System.out.println("("+ptr1.data+", "+ptr2.data+", "+ptr3.data+")=="+x);
						}	
					}	
				}
			}

			// required count of triplets 
			return count; 
	} 

	// A utility function to insert a new node at the 
	// beginning of doubly linked list 
	static Node insert(Node head, int val) { 
			// allocate node 
			Node temp = new Node(val); 

			if (head == null) 
				head = temp; 
			else { 
				temp.next = head; 
				head.prev = temp; 
				head = temp; 
			} 
		
			return head; 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
			// start with an empty doubly linked list 
			Node head = null; 
			
			// insert values in sorted order 
			head = insert(head, 9); 
			head = insert(head, 8); 
			head = insert(head, 6); 
			head = insert(head, 5); 
			head = insert(head, 4); 
			head = insert(head, 2); 
			head = insert(head, 1); // head
            //hrad=> null<-1<->2<->4<->5<->6<->8<->9->null
			int x = 17; 
			System.out.println("count = " + countTriplets(head, x)); 
	} 
} 

