// Check if a Binary Tree (not BST) has duplicate values

//javac -d classes CheckDuplicateValues.java  && cd classes && java CheckDuplicateValues && cd ..


import java.util.HashSet; 

class Node { 
	int data; 
	Node left,right; 
	Node(int data) 
	{ 
		this.data=data; 
	} 
};

public class CheckDuplicateValues { 

	//Function that used HashSet to find presence of duplicate nodes 
	public static boolean checkDupUtil(Node root, HashSet<Integer> s) { 
		// If tree is empty, there are no duplicates. 
		if (root == null) 
			return false; 
		// If current node's data is already present. 
		if (s.contains(root.data)) 
			return true; 
		// Insert current node 
		s.add(root.data); 
		// Recursively check in left and right subtrees. 
		return checkDupUtil(root.left, s) || checkDupUtil(root.right, s); 
	} 
	
	// To check if tree has duplicates 
	public static boolean checkDup(Node root) { 
		HashSet<Integer> s = new HashSet<>(); 
		return checkDupUtil(root, s); 
	} 

	public static void main(String args[]) { 

		Node root = new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(2); 
		root.left.left = new Node(3); 

		/*		 1
				/ \
			   2   2
			  /
			 3	*/

		if (checkDup(root)) 
			System.out.println("\n\nYes"); 
		else
			System.out.println("\n\nNo"); 
	} 
} 


/*
Check if a Binary Tree (not BST) has duplicate values


Check if a Binary Tree (not BST) has duplicate values

Examples:

Input : Root of below tree
         1
       /   \
      2     3
             \
              2
Output : Yes
Explanation : The duplicate value is 2.

Input : Root of below tree
         1
       /   \
     20     3
             \
              4
Output : No
Explanation : There are no duplicates.*/