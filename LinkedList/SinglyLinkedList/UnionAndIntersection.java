// Java program to find union and intersection of two unsorted linked lists 
//javac -d classes UnionAndIntersection.java  && cd classes && java UnionAndIntersection  && cd ..

import java.util.HashMap; 
import java.util.HashSet; 
import java.util.*; 


class UnionAndIntersection { 

	Node head; // head of list 
	/* Linked list Node*/
	class Node { 
		int data; 
		Node next; 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 

	/* Function to get Union of 2 Linked Lists */
	void getUnion(Node head1, Node head2) {
		Node t1 = head1, t2 = head2; 
		// insert all elements of list1 in the result 
		while (t1 != null) { 
			push(t1.data); 
			t1 = t1.next; 
		} 
		// insert those elements of list2 that are not present 
		while (t2 != null) { 
			if (!isPresent(head, t2.data)) {
				push(t2.data); 
			}
			t2 = t2.next; 
		} 
	} 

	void getIntersection(Node head1, Node head2) { 
		Node result = null; 
		Node t1 = head1; 
		while (t1 != null) { 
			if (isPresent(head2, t1.data)) {
				push(t1.data); 
			}
			t1 = t1.next; 
		} 
	} 

	/* Utility function to print list */
	void printList() { 
		Node temp = head; 
		while (temp != null) { 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} 
		System.out.println(); 
	} 

	/* Inserts a node at start of linked list */
	void push(int new_data) { 
		/* 1 & 2: Allocate the Node & Put in the data*/
		Node new_node = new Node(new_data); 
		/* 3. Make next of new Node as head */
		new_node.next = head; 
		/* 4. Move the head to point to new Node */
		head = new_node; 
	} 

	/* A utilty function that returns true 
	if data is present in linked list 
	else return false */
	boolean isPresent(Node head, int data) { 
		Node t = head; 
		while (t != null) { 
			if (t.data == data) 
				return true; 
			t = t.next; 
		} 
		return false; 
	} 

	void getIntersection2(Node head1, Node head2) {
        HashSet<Integer> hset = new HashSet<>(); 
        Node n1 = head1; 
        Node n2 = head2; 
        // loop stores all the elements of list1 in hset 
        while (n1 != null) { 
            hset.add(n1.data); 
            n1 = n1.next; 
        } 
        while (n2 != null) { 
            if (hset.contains(n2.data)) { 
                push(n2.data); 
            } 
            n2 = n2.next; 
        } 
    } 

    void getUnion2(Node head1, Node head2) { 
/*        HashMap<Integer, Integer> hmap = new HashMap<>(); 
        Node n1 = head1; 
        Node n2 = head2;   
        while (n1 != null) { 
            hmap.put(n1.data, 1); 
            n1 = n1.next; 
        } 
        while (n2 != null) { 
            hmap.put(n2.data, 1);
            n2 = n2.next; 
        } 
        for (int a : hmap.keySet()) { 
            push(a); 
        } */

        HashSet<Integer> hset = new HashSet<>(); 
        Node n1 = head1; 
        Node n2 = head2; 
        // loop stores all the elements of list1 in hset 
        while (n1 != null) { 
            hset.add(n1.data); 
            n1 = n1.next; 
        } 
        while (n2 != null) { 
            hset.add(n2.data); 
            n2 = n2.next; 
        } 
       
        Iterator<Integer> i = hset.iterator(); 
        while (i.hasNext()) 
            push(i.next()); 
    } 

	/* Driver program to test above functions */
	public static void main(String args[]) {

		UnionAndIntersection llist1 = new UnionAndIntersection(); 
		UnionAndIntersection llist2 = new UnionAndIntersection(); 
		UnionAndIntersection unin = new UnionAndIntersection(); 
		UnionAndIntersection intersecn = new UnionAndIntersection(); 

		/*create a linked lits 10->15->5->20 */
		llist1.push(20); 
		llist1.push(4); 
		llist1.push(15); 
		llist1.push(10); 

		/*create a linked lits 8->4->2->10 */
		llist2.push(10); 
		llist2.push(2); 
		llist2.push(4); 
		llist2.push(8); 

		// intersecn.getIntersection(llist1.head, llist2.head); 
		intersecn.getIntersection2(llist1.head, llist2.head); 
		// unin.getUnion(llist1.head, llist2.head); 
		unin.getUnion2(llist1.head, llist2.head); 

		System.out.println("First List is"); 
		llist1.printList(); 

		System.out.println("Second List is"); 
		llist2.printList(); 

		System.out.println("Intersection List is"); 
		intersecn.printList(); 

		System.out.println("Union List is"); 
		unin.printList(); 
	} 
} 


/*Union and Intersection of two Linked Lists
Last Updated: 09-11-2020
Given two Linked Lists, create union and intersection
 lists that contain union and intersection of the elements 
 present in the given lists. Order of elements in output lists doesn’t matter.
 
Example:

Input:
   List1: 10->15->4->20
   lsit2:  8->4->2->10
Output:
   Intersection List: 4->10
   Union List: 2->8->20->4->15->10*/


/*Complexity Analysis:

Time Complexity: O(m*n).
Here ‘m’ and ‘n’ are number of elements present in first and second lists respectively.
For union: For every element in list-2 we check if that element is already present in 
the resultant list made using list-1.
For intersection: For every element in list-1 we check if that element is also present in list-2.
Auxiliary Space: O(1).
No use of any data structure for storing values.*/