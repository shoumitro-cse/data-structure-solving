// Java program to construct a tree using inorder and preorder traversal 

// javac -d classes ConstructTreeUsingInPre.java  && cd classes && java ConstructTreeUsingInPre && cd ..

class Node { 
	char data; 
	Node left, right; 

	Node(char item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class ConstructTreeUsingInPre { 

	Node root; 



	static int preIndex = 0; 

	Node buildTree(char in[], char pre[], int inStrt, int inEnd) { 

		if (inStrt > inEnd) 
			return null; 
		
		Node temp = new Node(pre[preIndex++]); 
		 // If this node has no children then return 

		if (inStrt == inEnd) // it is important
			return temp; 

		 // Else find the index of this node in Inorder traversal 
		int inIndex = search(in, inStrt, inEnd, temp.data); 
		 // Using index in Inorder traversal, construct left and right subtress 
		temp.left = buildTree(in, pre, inStrt, inIndex - 1); 
		temp.right = buildTree(in, pre, inIndex + 1, inEnd); 

		return temp; 
	} 

	int search(char arr[], int strt, int end, char dataue) 
	{ 
		int i; 
		for (i = strt; i <= end; i++) { 
			if (arr[i] == dataue) 
				return i; 
		} 
		return i; 
	} 

	 // This funtcion is here just to test buildTree() 
	void printInorder(Node node) { 
		if (node == null) 
			return; 
		/* first recur on left child */
		printInorder(node.left); 
		/* then print the data of node */
		System.out.print(node.data + " "); 
		/* now recur on right child */
		printInorder(node.right); 
	} 

	// driver program to test above functions 
	public static void main(String args[]) { 
		ConstructTreeUsingInPre tree = new ConstructTreeUsingInPre(); 
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' }; 
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' }; 
		int len = in.length; 
		Node root = tree.buildTree(in, pre, 0, len - 1); 

		// building the tree by printing inorder traversal 
		System.out.println("Inorder traversal of constructed tree is : "); 
		tree.printInorder(root); 
		System.out.println(); 

/*		  A
		/   \
       B     C
      / \    /
     D   E  F*/

	} 
} 

