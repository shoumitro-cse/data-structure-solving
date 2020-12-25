// Diagonal Traversal of Binary Tree

//javac -d classes DiagonalTraversal.java  && cd classes && java DiagonalTraversal && cd ..

import java.util.*;

public class DiagonalTraversal {
	// Tree node
	static class Node {
		int data;
		Node left;
		Node right;
		//constructor
		Node(int data) {
			this.data=data;
			left = null;
			right =null;
		}
	}
	

/*	static void diagonalPrintUtil(Node root, int d, HashMap<Integer, Vector<Integer>> diagonalPrint) {
		// Base case
		if (root == null)
			return;
		// get the list at the particular d value
		Vector<Integer> k = diagonalPrint.get(d);
		// k is null then create a 
		// vector and store the data
		if (k == null) {
			k = new Vector<>();
			k.add(root.data);
		} else {
			k.add(root.data);
		}
		// Store all nodes of same line together as a vector
		diagonalPrint.put(d, k);
		// Increase the vertical distance if left child
		diagonalPrintUtil(root.left, d + 1, diagonalPrint);
		// Vertical distance remains same for right child
		diagonalPrintUtil(root.right, d, diagonalPrint);
	}
	
	// Print diagonal traversal of given binary tree
	static void diagonalPrint(Node root) {

		// create a map of vectors to store Diagonal elements
		HashMap<Integer, Vector<Integer>> diagonalPrint = new HashMap<>();

		diagonalPrintUtil(root, 0, diagonalPrint);
		
		System.out.println("Diagonal Traversal of Binnary Tree");

		for (Entry<Integer, Vector<Integer>> entry : diagonalPrint.entrySet()) {
			System.out.println(entry.getValue());
		}

	}*/


	//Iterative diagonal traversal of binary tree
	static void diagonalPrint(Node root) {  
	    // base case  
	    if (root == null)  
	        return;  
	    // inbuilt queue of Treenode  
	    Queue<Node> q= new LinkedList<Node>();  
	    // add root  
	    q.add(root);  
	    // add delimiter  
	    q.add(null);  
	    while (q.size()>0) {  
	        Node temp = q.remove();  
	        // if current is delimiter then insert another  
	        // for next diagonal and cout nextline  
	        if (temp == null) {  
	            // if queue is empty return  
	            if (q.size()==0)  
	                return;  
	            // output nextline  
	            System.out.println(); 
	            // add delimiter again  
	            q.add(null);  
	        } else {  
	            while (temp != null) {  
	                System.out.print( temp.data + " ");  
	                // if left child is present add into queue  
	                if (temp.left != null)  
	                    q.add(temp.left);  
	                // current equals to right child  
	                temp = temp.right;  
	            }  
	        }  
	    }  
	} 
	
	// Driver program
	public static void main(String[] args) {
		
		Node root = new Node(8);

		root.left = new Node(3);
		root.right = new Node(10);

		root.left.left = new Node(1);
		root.left.right = new Node(6);

		root.right.right = new Node(14);
		root.right.right.left = new Node(13);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);
		
		diagonalPrint(root);
	    System.out.println("");  
	}
}


/*Output : 
Diagonal Traversal of binary tree : 
 8 10 14
 3 6 7 13
 1 4*/