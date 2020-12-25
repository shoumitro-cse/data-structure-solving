// Java program to print nodes at k distance from root 

// javac -d classes KdistanceFromRoot.java  && cd classes && java KdistanceFromRoot && cd ..
import java.util.*;
class Node 
{ 
	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class KdistanceFromRoot 
{ 
	Node root; 


/*		// Function to print nodes of given level  
	static boolean printKDistant(Node root, int klevel) {//klevel=2

	    Queue<Node> q = new LinkedList<>();  
	    int level = 1;  
	    boolean flag = false;  
	    q.add(root); 
	    // extra null is added to keep track of all the nodes to be added beforelevel is incremented by 1  
	    q.add(null);  
	    while (q.size() > 0) {  
	        Node temp = q.remove();  
	        // print when level is equal to k  
	        if (level == klevel && temp != null) {  
	            flag = true;  
	            System.out.print( temp.data + " ");  
	        }  
	        if (temp == null) {  
	            if (q.peek() != null)  
	                q.add(null);  
	            level++;;  
	            // break the loop if level exceeds the given level number  
	            if (level > klevel)  
	                break;  `
	        }  else {  
	            if (temp.left != null)  
	                q.add(temp.left);  
	  
	            if (temp.right != null)  
	                q.add(temp.right);  
	        }  
	    }  
	    return flag;  
	}*/

	// Time Complexity: O(n) where n is number of nodes in the given binary tree.
	void printKDistant(Node node, int k) { //k=2
		if (node == null) 
			return; 
		if (k == 1) { 
			System.out.print(node.data + " "); 
			return; 
		} else { 
			printKDistant(node.left, k-1); 
			printKDistant(node.right, k-1); 
		} 
	} 
	
	/* Driver program to test above functions */
	public static void main(String args[]) { 
		KdistanceFromRoot tree = new KdistanceFromRoot(); 
		
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(8); 

        /* 
                1 
              /   \ 
             2     3 
            /  \   / 
           4    5 8  
        */
		tree.printKDistant(tree.root, 2); 
		System.out.println(); 
	} 
} 

/*Print nodes at k distance from root

Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.
For example, in the below tree, 4, 5 & 8 are at distance 2 from root.
            1
          /   \
        2      3
      /  \    /
    4     5  8 */



/*Print nodes at k distance from root | Iterative

Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.

Example :

Input :
                20
              /   \
            10    30
           / \    / \
          5  15  25  40
             /
            12

and k = 3
Root is at level 1.

Output :
5 15 25 40*/