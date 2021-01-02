// Count BST subtrees that lie in given range

class CountSubtreesGivenRange { 

	// A BST node 
	static class node { 
		int data; 
		node left, right; 
	}; 

	// int class 
	static class INT { 
		int a; 
	} 

	// A utility function to check if data of root is 
	// in range from low to high 
	static boolean inRange(node root, int low, int high) { 
		return root.data >= low && root.data <= high; 
	} 

	// A recursive function to get count 
	// of nodes whose subtree is in range 
	// from low to hgih. This function returns 
	// true if nodes in subtree rooted under 
	// 'root' are in range. 
	static boolean getCountUtil(node root, int low, int high, INT count) 
	{ 
		// Base case 
		if (root == null) 
			return true; 
		// Recur for left and right subtrees 
		boolean l = getCountUtil(root.left, low, high, count); 
		boolean r = getCountUtil(root.right, low, high, count); 

		if (l && r && inRange(root, low, high)) { 
			++count.a; 
			return true; 
		} 
	  return false; 
	} 

	// A wrapper over getCountUtil(). 
	// This function initializes count as 0 
	// and calls getCountUtil() 
	static INT getCount(node root, int low, int high) 
	{ 
		INT count = new INT(); 
		count.a = 0; 
		getCountUtil(root, low, high, count); 
		return count; 
	} 

	// Utility function to create new node 
	static node newNode(int data) 
	{ 
		node temp = new node(); 
		temp.data = data; 
		temp.left = temp.right = null; 
		return (temp); 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		// Let us con the BST shown in the above figure 
		node root = newNode(10); 
		root.left = newNode(5); 
		root.right = newNode(50); 
		root.left.left = newNode(1); 
		root.right.left = newNode(40); 
		root.right.right = newNode(100); 
		/* Let us construct BST shown in above example 
		        10
		      /    \
		    5       50
		   /       /  \
		 1       40   100
		 */
		int l = 5; 
		int h = 45; 
		System.out.println("Count of subtrees in [" + l + ", "+ h + "] is " + getCount(root, l, h).a); 
	} 
} 


/*
Count BST subtrees that lie in given range


Given a Binary Search Tree (BST) of integer values and a range [low, high], 
return count of nodes where all the nodes under that node (or subtree rooted 
	with that node) lie in the given range.
Examples:

Input:
        10
      /    \
    5       50
   /       /  \
 1       40   100
Range: [5, 45]
Output:  1 
There is only 1 node whose subtree is in the given range.
The node is 40 


Input:
        10
      /    \
    5       50
   /       /  \
 1       40   100
Range: [1, 45]
Output:  3 
There are three nodes whose subtree is in the given range.
The nodes are 1, 5 and 40 
*/