// Print path from root to a given node in a binary tree

// javac -d classes PrintPathGivenNode.java  && cd classes && java PrintPathGivenNode && cd ..  

import java.util.ArrayList; 


class Node 
{ 
	int data; 
	Node left, right; 
	Node(int data) 
	{ 
		this.data=data; 
		left=right=null; 
	} 
}; 

public class PrintPathGivenNode { 

	public static boolean hasPath(Node root, ArrayList<Integer> arr, int x) { 
		// if root is NULL there is no path 
		if (root==null) 
			return false; 
		// push the node's value in 'arr' 
		arr.add(root.data);	 
		// if it is the required node return true 
		if (root.data == x)	 
			return true; 
		// else check whether the required node lies 
		// in the left subtree or right subtree of the current node 
		if (hasPath(root.left, arr, x) || hasPath(root.right, arr, x)) 
			return true; 

		arr.remove(arr.size()-1); 

	  return false;			 
	} 

  // Time complexity: O(n) in worst case, where n is the number of nodes in the binary tree.
	public static void printPath(Node root, int x) { 
		// ArrayList to store the path 
		ArrayList<Integer> arr = new ArrayList<>(); // also use stack
		// if required node 'x' is present then print the path 
		if (hasPath(root, arr, x)) { 
			for (int i=0; i<arr.size()-1; i++) {
				System.out.print(arr.get(i)+"->"); 
			}
			System.out.print(arr.get(arr.size() - 1));	 
		} else {
		   // 'x' is not present in the binary tree 
			System.out.print("No Path"); 
		}
	} 

	public static void main(String args[]) { 

		Node root=new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(3); 
		root.left.left = new Node(4); 
		root.left.right = new Node(5); 
		root.right.left = new Node(6); 
		root.right.right = new Node(7); 

		/*       1
		       /   \
		      2     3
		     / \   /  \
		    4   5  6   7*/
		
		int x=5; 
		printPath(root, x); 
		System.out.println(); 
	} 
} 

/*
Print path from root to a given node in a binary tree

Given a binary tree with distinct nodes(no two nodes have the same have data values). 
The problem is to print the path from root to a given node x. If node x is not present 
then print “No Path”.

Examples:

Input :          1
               /   \
              2     3
             / \   /  \
            4   5  6   7

               x = 5

Output : 1->2->5

Algorithm:
1. If root = NULL, return false.
2. push the root’s data into arr[].
3. if root’s data = x, return true.
4. if node x is present in root’s left or right subtree, return true.
5. Else remove root’s data value from arr[] and return false.

*/