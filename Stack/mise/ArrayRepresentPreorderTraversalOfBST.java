// Check if a given array can represent Preorder Traversal of Binary Search Tree

//javac -d classes ArrayRepresentPreorderTraversalOfBST.java  && cd classes && java ArrayRepresentPreorderTraversalOfBST && cd ..

import java.util.Stack; 

class BinarySearchTree { 

	boolean canRepresentBST(int pre[], int n) { 
		// Create an empty stack 
		Stack<Integer> s = new Stack<Integer>(); 
		// Initialize current root as minimum possible value 
		int root = Integer.MIN_VALUE; 
		// Traverse given array 
		for (int i = 0; i < n; i++) { 
			// If we find a node who is on right side and smaller than root, return false 
			if (pre[i] < root) { 
				return false; 
			} 
			while (!s.empty() && s.peek() < pre[i]) { 
				root = s.pop(); 
			} 
			s.push(pre[i]); 
		} 
		return true; 
	} 

} 

class ArrayRepresentPreorderTraversalOfBST {

	public static void main(String args[]) { 

		BinarySearchTree bst = new BinarySearchTree(); 
		int[] pre1 = new int[]{40, 30, 35, 80, 100}; 
		int n = pre1.length; 

		if (bst.canRepresentBST(pre1, n) == true) { 
			System.out.println("true"); 
		} else { 
			System.out.println("false"); 
		} 

/*		int[] pre2 = new int[]{40, 30, 35, 20, 80, 100}; 
		int n1 = pre2.length; 
		if (bst.canRepresentBST(pre2, n) == true) { 
			System.out.println("true"); 
		} else { 
			System.out.println("false"); 
		} */
	} 
}



/*Check if a given array can represent Preorder Traversal of Binary Search Tree

Given an array of numbers, return true if given array can represent preorder traversal 
of a Binary Search Tree, else return false. Expected time complexity is O(n).

Examples:

Input:  pre[] = {2, 4, 3}
Output: true
Given array can represent preorder traversal
of below tree
    2
     \
      4
     /
    3

Input:  pre[] = {2, 4, 1}
Output: false
Given array cannot represent preorder traversal
of a Binary Search Tree.

Input:  pre[] = {40, 30, 35, 80, 100}
Output: true
Given array can represent preorder traversal
of below tree
     40
   /   \
 30    80 
  \      \
  35     100 


Input:  pre[] = {40, 30, 35, 20, 80, 100}
Output: false
Given array cannot represent preorder traversal
of a Binary Search Tree.
Recommended: Please solve it




Algorithm:

1) Create an empty stack.
2) Initialize root as INT_MIN.
3) Do following for every element pre[i]
     a) If pre[i] is smaller than current root, return false.
     b) Keep removing elements from stack while pre[i] is greater
        then stack top. Make the last removed item as new root (to
        be compared next).
        At this point, pre[i] is greater than the removed root
        (That is why if we see a smaller element in step a), we 
        return false)
     c) push pre[i] to stack (All elements in stack are in decreasing
        order) */