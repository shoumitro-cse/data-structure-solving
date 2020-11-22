// Count pairs from two linked lists whose sum is equal to a given value

import java.util.Arrays; 
import java.util.Iterator; 
import java.util.LinkedList; 
import java.util.HashSet; 


class CountPairsFromTwoLinkedLists { 

	/*Time Complexity: O(n1*n2)
	  Auxiliary Space: O(1)  */
	  
/*	static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) { 
		int count = 0; 
		// traverse the 1st linked list 
		Iterator<Integer> itr1 = head1.iterator(); 
		while(itr1.hasNext()) {  //O(n*n)
			// for each node of 1st list traverse the 2nd list 
			Iterator<Integer> itr2 = head2.iterator(); 
			Integer t = itr1.next(); 
			while(itr2.hasNext()) { 
				if ((t + itr2.next()) == x) {// if sum of pair is equal to 'x' increment count 
					count++; 
				}
			} 
		} 			
		// required count of pairs	 
		return count; 
	} */


/*	// Time Complexity: O(n1*logn1) + O(n2*logn2)
	// Auxiliary Space: O(1)
	static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) { 
        int count = 0; 
        // sort head1 in ascending order and head2 in descending order 
        Collections.sort(head1); 
        Collections.sort(head2,Collections.reverseOrder()); 
          
        // traverse both the lists from left to right 
        Iterator<Integer> itr1 = head1.iterator(); 
        Iterator<Integer> itr2 = head2.iterator(); 
          
        Integer num1 = itr1.hasNext() ? itr1.next() : null; 
        Integer num2 = itr2.hasNext() ? itr2.next() : null; 
          
        while(num1 != null && num2 != null) {      
                            
            if ((num1 + num2) == x) { 
                num1 = itr1.hasNext() ? itr1.next() : null; 
                num2 = itr2.hasNext() ? itr2.next() : null; 
                count++;  
            } else if ((num1 + num2) > x) {// if this sum is greater than x, then move itr2 to next node 
                num2 = itr2.hasNext() ? itr2.next() : null; 
            } else {// else move itr1 to next node  
                num1 = itr1.hasNext() ? itr1.next() : null; 
            } 
        } 
                             
        // required count of pairs      
        return count; 
    }*/


    static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) { 
        
        int count = 0; 
        HashSet<Integer> us = new HashSet<Integer>(); 
        // insert all the elements of 1st list in the hash table(unordered_set 'us') 
        
        Iterator<Integer> itr1 = head1.iterator(); 
        while (itr1.hasNext()) { 
            us.add(itr1.next());     
        } 

        Iterator<Integer> itr2 = head2.iterator(); 
        // for each element of 2nd list 
        while (itr2.hasNext()) { 
            // find (x - head2->data) in 'us' 
            boolean bool =  us.add(x - itr2.next());
            if (!bool) 
                count++;      
        } 
        return count; 
    } 
	
	// Driver method 
	public static void main(String[] args) {

		Integer arr1[] = {3, 1, 5, 7}; 
		Integer arr2[] = {8, 2, 5, 3}; 
		
		// create linked list1 3->1->5->7 
		LinkedList<Integer> head1 = new LinkedList<Integer>(Arrays.asList(arr1)); 
		
		// create linked list2 8->2->5->3 
		LinkedList<Integer> head2 = new LinkedList<Integer>(Arrays.asList(arr2)); 
		
		int x = 10; 
		
		System.out.println("Count = " + countPairs(head1, head2, x)); 
	}	 
} 




/*Count pairs from two linked lists whose sum is equal to a given value
Given two linked lists(can be sorted or unsorted) of size n1 and n2 of distinct elements.
Given a value x. The problem is to count all pairs from both lists whose sum is equal 
to the given value x.

Note: The pair has an element from each linked list.

Examples:

Input : list1 = 3->1->5->7
        list2 = 8->2->5->3
        x = 10
Output : 2
The pairs are:
(5, 5) and (7, 3)

Input : list1 = 4->3->5->7->11->2->1
        list2 = 2->3->4->5->6->8-12
        x = 9         
Output : 5


1. Method 2 (Sorting): 
	 Sort the 1st linked list in ascending order and the 2nd linked list
	 in descending order using merge sort technique. Now traverse both the lists from left
	 to right in the following way:

Algorithm:

countPairs(list1, list2, x)
  Initialize count = 0
  while list != NULL and list2 != NULL
     if (list1->data + list2->data) == x
        list1 = list1->next    
        list2 = list2->next
        count++
    else if (list1->data + list2->data) > x
        list2 = list2->next
    else
        list1 = list1->next
  return count 

*/