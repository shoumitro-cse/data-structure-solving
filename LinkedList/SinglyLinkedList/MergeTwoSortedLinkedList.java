// Java program to merge two sorted linked list such that merged 
// list is in reverse order 

//javac -d classes MergeTwoSortedLinkedList.java  && cd classes && java MergeTwoSortedLinkedList  && cd ..
class MergeTwoSortedLinkedList { 

	Node head; // head of list 
	static Node a, b; 

	/* Node Class */
	static class Node { 

		int data; 
		Node next; 

		// Constructor to create a new node 
		Node(int d) { 
			data = d; 
			next = null; 
		} 
	} 

	void printlist(Node node) { 
		while (node != null) { 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
	} 

	Node sortedmerge(Node node1, Node node2) { 
		
		// if both the nodes are null 
		if (node1 == null && node2 == null) { 
			return null; 
		} 

		// resultant node 
		Node res = null; 

		// if both of them have nodes present traverse them 
		while (node1 != null && node2 != null) { 

			// Now compare both nodes current data 
			if (node1.data <= node2.data) { 
				Node temp = node1.next; 
				node1.next = res; 
				res = node1; 
				node1 = temp; 
			} else { 
				Node temp = node2.next; 
				node2.next = res; 
				res = node2; 
				node2 = temp; 
			} 
		} 

		// If second list reached end, but first list has 
		// nodes. Add remaining nodes of first list at the 
		// front of result list 
		while (node1 != null) { 
			// System.out.println("\n\n\n"+node1.data);// 25
			Node temp = node1.next; 
			node1.next = res; 
			res = node1; 
			node1 = temp; 
		} 

		// If first list reached end, but second list has 
		// node. Add remaining nodes of first list at the 
		// front of result list 
		while (node2 != null) { 
			Node temp = node2.next; 
			node2.next = res; 
			res = node2; 
			node2 = temp; 
		} 

		return res; 

	} 


	Node sortedMerge(Node headA, Node headB) { 
	    /* a dummy first node to   hang the result on */
	    Node dummyNode = new Node(0); 
	    /* tail points to the  last result node */
	    Node tail = dummyNode; 
	    while(true)  { 
	        /* if either list runs out, use the other list */
	        if(headA == null) { 
	            tail.next = headB; 
	            break; 
	        } 
	        if(headB == null) { 
	            tail.next = headA; 
	            break; 
	        } 
	       /*Compare the data of the two lists whichever lists' data is smaller,
	         append it into tail and advance the head to the next Node */
	        if(headA.data <= headB.data) { 
	            tail.next = headA; 
	            headA = headA.next; 
	        } else { 
	            tail.next = headB; 
	            headB = headB.next; 
	        } 
	        /* Advance the tail */
	        tail = tail.next; 
	    } 
	    return dummyNode.next; 
	}

    Node sortedMergeRec(Node a, Node b) { 

		Node result = null; 
		/* Base cases */
		if (a == null) 
			return b; 
		if (b == null) 
			return a; 

		/* Pick either a or b, and recur */
		if (a.data <= b.data) { 
			result = a; 
			result.next = sortedMergeRec(a.next, b); 
		} else { 
			result = b; 
			result.next = sortedMergeRec(a, b.next); 
		} 
		return result; 
	}  

   public Node SortedMerge(Node A, Node B)   { 
        if(A == null) return B; 
        if(B == null) return A; 

        if(A.data < B.data)  { 
            A.next = SortedMerge(A.next, B); 
            return A; 
        } else { 
            B.next = SortedMerge(A, B.next); 
            return B; 
        } 
    } 



	/*Time complexity:O(n).
	As only one traversal of the linked lists is needed.
	Auxiliary Space:O(1).
	As there is no space required.*/
    static Node mergeUtil(Node h1, Node h2) { 
        // if only one node in first list simply point its head to second list 
        if (h1.next == null) { 
            h1.next = h2; 
            return h1; 
        } 
        // Initialize current and next pointers of both lists 
        Node curr1 = h1, next1 = h1.next; 
        Node curr2 = h2, next2 = h2.next; 
  
        while (next1 != null && curr2 != null) { 
            // if curr2 lies in between curr1 and next1 
            // then do curr1->curr2->next1 
            if ((curr2.data) >= (curr1.data) && (curr2.data) <= (next1.data)) { 
                next2 = curr2.next; 
                curr1.next = curr2; 
                curr2.next = next1; 
  
                // now let curr1 and curr2 to point to their immediate next pointers 
                curr1 = curr2; 
                curr2 = next2; 
            } else { 
                // if more nodes in first list 
                if (next1.next != null) { 
                    next1 = next1.next; 
                    curr1 = curr1.next; 
                } else { 
                // else point the last node of first list to the remaining nodes of second list 
                    next1.next = curr2; 
                    return h1; 
                } 
            } 
        } 
        return h1; 
    } 

    // Merges two given lists in-place. This function 
    // mainly compares head nodes and calls mergeUtil() 
    static Node merge(Node h1, Node h2) {

        if (h1 == null) 
            return h2; 
        if (h2 == null) 
            return h1; 
        // start with the linked list whose head data is the least 
        if (h1.data < h2.data) 
            return mergeUtil(h1, h2); 
        else
            return mergeUtil(h2, h1); 
    }

	public static void main(String[] args) { 

		MergeTwoSortedLinkedList list = new MergeTwoSortedLinkedList(); 
		Node result = null; 

		/*Let us create two sorted linked lists to test 
		the above functions. Created lists shall be 
		a: 5->10->15 
		b: 2->3->20*/
		list.a = new Node(5); 
		list.a.next = new Node(10); 
		list.a.next.next = new Node(15); 
		list.a.next.next.next = new Node(25); 

		list.b = new Node(2); 
		list.b.next = new Node(3); 
		list.b.next.next = new Node(20); 

		System.out.println("List a before merge :"); 
		list.printlist(a);

		System.out.println("\nList b before merge :"); 
		list.printlist(b); 

		// result = list.sortedmerge(a, b); 
		//result = list.sortedMerge(a, b); 
		// result = list.sortedMergeRec(a, b); 
		// result = list.SortedMerge(a, b); 
		result = list.merge(a, b); 

		System.out.println("\nMerged linked list : "); 
		list.printlist(result); 
		System.out.println(); 

	} 
} 

