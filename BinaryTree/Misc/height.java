// Java program to find height of tree 

// A binary tree node 
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

class BinaryTree 
{ 
	Node root; 

	/* Compute the "maxDepth" of a tree -- the number of 
	nodes along the longest path from the root node 
	down to the farthest leaf node.*/
	int maxDepth(Node node) 
	{ 
		if (node == null) 
			return 0; 
		else
		{ 
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left); 
			int rDepth = maxDepth(node.right); 

			/* use the larger one */
			if (lDepth > rDepth) 
				return (lDepth + 1); 
			else
				return (rDepth + 1); 
		} 
	} 
	
	/* Driver program to test above functions */
	public static void main(String[] args) 
	{ 
		BinaryTree tree = new BinaryTree(); 

		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 

		System.out.println("Height of tree is : " + 
									tree.maxDepth(tree.root)); 
	} 
} 

/*// Java program to find height 
// of complete binary tree 
// from total nodes. 
import java.lang.*; 

class GFG { 
	
	// Function to calculate height 
	static int height(int N) 
	{ 
		return (int)Math.ceil(Math.log(N + 
					1) / Math.log(2)) - 1; 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
		int N = 6; 
		System.out.println(height(N)); 
	} 
} 

// This code is contributed by 
// Smitha Dinesh Semwal 
*/


/*Height of a complete binary tree (or Heap) with N nodes
Consider a Binary Heap of size N. We need to find height of it.

Examples :

Input : N = 6
Output : 2
        ()
      /    \
     ()     ()
    /  \    /
  ()    () ()

Input : N = 9
Output :
        ()
      /    \
     ()     ()
    /  \    /  \
  ()    () ()   ()
 / \
()  ()
Recommended: Please try your approach on {IDE} first, before moving on to the solution.
Let the size of heap be N and height be h
If we take few examples, we can notice that the value of h in a complete binary tree is ceil(log2(N+1)) – 1.
Examples :

 N    h
---------
 1    0
 2    1
 3    1
 4    2
 5    2
 .....
 .....*/