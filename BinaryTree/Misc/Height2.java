//Height of binary tree considering even level leaves only

class Height2 { 

	/* A binary tree node has data, pointer to 
	left child and a pointer to right child */
	static class Node { 
		int data; 
		Node left; 
	   Node right; 
	} 

	static int heightOfTreeUtil(Node root, boolean isEven) 
	{ 
		// Base Case 
		if (root == null) 
			return 0; 

		if (root.left == null && root.right == null) { 
			if (isEven == true) 
				return 1; 
			else
				return 0; 
		} 

		/*left stores the result of left subtree, 
		and right stores the result of right subtree*/
		int left = heightOfTreeUtil(root.left, !isEven); 
		int right = heightOfTreeUtil(root.right, !isEven); 

		/*If both left and right returns 0, it means 
		there is no valid path till leaf node*/
		if (left == 0 && right == 0) 
			return 0; 

		return (1 + Math.max(left, right)); 
	} 

	/* Helper function that allocates a new node with the 
	given data and NULL left and right pointers. */
	static Node newNode(int data) 
	{ 
		Node node = new Node(); 
		node.data = data; 
		node.left = null; 
		node.right = null; 

		return (node); 
	} 

	static int heightOfTree(Node root) 
	{ 
		return heightOfTreeUtil(root, false); 
	} 

	/* Driver program to test above functions*/
	public static void main(String[] args) 
	{ 
		// Let us create binary tree shown in above diagram 
		Node root = newNode(1); 

		root.left = newNode(2); 
		root.right = newNode(3); 
		root.left.left = newNode(4); 
		root.left.right = newNode(5); 
		root.left.right.left = newNode(6); 
		System.out.println("Height of tree is " + heightOfTree(root)); 
	} 
} 
