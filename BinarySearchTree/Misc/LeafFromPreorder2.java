// Recursive Java program to find leaf 
// nodes from given preorder traversal 

//javac -d classes LeafFromPreorder2.java  && cd classes && java LeafFromPreorder2 && cd ..

class LeafFromPreorder2 
{ 

	static int i = 0; 

	// Print the leaf node from the given preorder of BST. 
	static boolean isLeaf(int pre[], int n, int min, int max) {

		if (i >= n) { 
			return false; 
		} 

		if (pre[i] > min && pre[i] < max) { 
			i++; 
			boolean left = isLeaf(pre, n, min, pre[i-1]); 
			boolean right = isLeaf(pre, n, pre[i-1], max); 
			if (!left && !right) { 
				System.out.print(pre[i-1] + " "); 
			} 
			return true; 
		} 
		return false; 
	} 

	static void printLeaves(int preorder[], int n) { 
		isLeaf(preorder, n, Integer.MIN_VALUE, Integer.MAX_VALUE); 
	} 

	// Driver code 
	public static void main(String[] args) { 
		int preorder[] = {890, 325, 290, 530, 965}; 
		int n = preorder.length; 
		printLeaves(preorder, n); 
	} 
} 


/*
Leaf nodes from Preorder of a Binary Search Tree (Using Recursion)

Given Preorder traversal of a Binary Search Tree. Then the task is print leaf nodes of the 
Binary Search Tree from the given preorder.

Examples :

Input : preorder[] = {890, 325, 290, 530, 965};
Output : 290 530 965

Tree represented is,
      890
     /   \
  325    965
  /  \
290   530

Input :  preorder[] = { 3, 2, 4 };
Output : 2 4
*/