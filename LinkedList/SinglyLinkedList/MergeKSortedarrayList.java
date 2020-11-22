// Java program to merge k sorted arrays of size n each 
// javac -d classes MergeKSortedarrayList.java  && cd classes && java MergeKSortedarrayList  && cd ..

import java.util.PriorityQueue;
import java.util.Comparator;
class Node { 
	int data; 
	Node next; 
	Node(int data) 
	{ 
		this.data = data; 
	} 
} 

public class MergeKSortedarrayList { 

   //Divide and Conquer.
	public static Node SortedMerge(Node a, Node b) { //Time Complexity O(Log n)

		Node result = null; 
		/* Base cases */
		if (a == null) 
			return b; 
		else if (b == null) 
			return a; 

		/* Pick either a or b, and recur */
		if (a.data <= b.data) { 
			result = a; 
			result.next = SortedMerge(a.next, b); 
		} else { 
			result = b; 
			result.next = SortedMerge(a, b.next); 
		} 

		return result; 
	} 

	/*Complexity Analysis:
	1. Time Complexity: O(nk logk).As outer while loop in function mergeKLists() runs log k times
	and every time it processes nk elements.
	2. Auxiliary Space: O(1).As no extra space is required.*/
	public static Node mergeKLists(Node arr[], int last) { 
		// repeat until only one list is left 
		while (last != 0) { 
			int i = 0, j = last; // j=2
			// (i, j) forms a pair 
			while (i < j) { 
				// merge List i with List j and store merged list in List i 
				arr[i] = SortedMerge(arr[i], arr[j]); 
				// consider next pair 
				i++; j--; 
				if (i >= j) {// If all pairs are merged, update last 
					last = j; 
				}
			} 
		} 

		return arr[0]; 
	} 


/*Complexity Analysis: 

	1. Time Complexity: O(N * k * log k), where, ‘N’ is the total number of elements among all the 
	linked lists and ‘k’ is the total number of lists.
	Insertion and deletion in a min-heap requires log k time. So the overall time complexity 
	is O(N * log k).
	
	2. Auxiliary Space: O(k). 
	The priority queue will have atmost ‘k’ number of elements at any point of time,
	 hence the additional space required for our algorithm is O(k).*/
    public static Node mergeKSortedLists(Node arr[], int k) {
        Node head = null, last = null;
        // priority_queue 'pq' implemeted as min heap with the help of 'compare' function
        PriorityQueue<Node> pq
            = new PriorityQueue<>(
                new Comparator<Node>() {
                    public int compare(Node a, Node b){
                        return a.data - b.data;
                    }
                });
        // push the head nodes of allthe k lists in 'pq'
        for (int i = 0; i < k; i++) {
            if (arr[i] != null) {
               pq.add(arr[i]);
            }
        }
/*        while (!pq.isEmpty()) {
            Node top = pq.peek();
            System.out.println(top.data);
            pq.remove();
        }*/
        // pq = 1,2,0  
        // pq = 0,1,2 // true list   
 
        while (!pq.isEmpty()) {
            Node top = pq.peek();
            pq.remove();
            if (top.next != null)
                pq.add(top.next);
            if (head == null) {
                head = top;
                last = top;
            } else {
                last.next = top;
                last = top;
            }
        }
        // head node of the required merged list
        return head;
    }


	/* Function to print nodes in a given linked list */
	public static void printList(Node node) { 
		while (node != null) { 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.print("\n"); 
	} 

	public static void main(String args[]) {

		int k = 3; // Number of linked lists 
		int n = 4; // Number of elements in each list 

		// an array of pointers storing the head nodes of the linked lists 
		Node arr[] = new Node[k]; 

		arr[0] = new Node(1); 
		arr[0].next = new Node(3); 
		arr[0].next.next = new Node(5); 
		arr[0].next.next.next = new Node(7); 

		arr[1] = new Node(2); 
		arr[1].next = new Node(4); 
		arr[1].next.next = new Node(6); 
		arr[1].next.next.next = new Node(8); 

		arr[2] = new Node(0); 
		arr[2].next = new Node(9); 
		arr[2].next.next = new Node(10); 
		arr[2].next.next.next = new Node(11); 

		// Merge all lists 
		// Node head = mergeKLists(arr, k - 1); 
		Node head = mergeKSortedLists(arr, k); 
		printList(head); 
	} 
} 



/*Merge K sorted linked lists | Set 1
Given K sorted linked lists of size N each, merge them and print the sorted output.

Examples:

Input: k = 3, n =  4
list1 = 1->3->5->7->NULL
list2 = 2->4->6->8->NULL
list3 = 0->9->10->11->NULL

Output: 0->1->2->3->4->5->6->7->8->9->10->11
Merged lists in a sorted order 
where every element is greater 
than the previous element.

Input: k = 3, n =  3
list1 = 1->3->7->NULL
list2 = 2->4->8->NULL
list3 = 9->10->11->NULL

Output: 1->2->3->4->7->8->9->10->11
Merged lists in a sorted order 
where every element is greater 
than the previous element.*/