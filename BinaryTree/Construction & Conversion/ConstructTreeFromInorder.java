// Java program to construct tree from inorder traversal 

//javac -d classes ConstructTreeFromInorder.java  && cd classes && java ConstructTreeFromInorder && cd ..

class Node { 
	int data; 
	Node left, right; 
	Node(int item) { 
		data = item; 
		left = right = null; 
	} 
} 

class ConstructTreeFromInorder { 

	Node root; 
	
	// Time Complexity: O(n^2)
	Node buildTree(int inorder[], int start, int end, Node node) { 
		if (start > end) 
			return null; 
		 // Find index of the maximum element from Binary Tree 
		int i = max(inorder, start, end); 
		 // Pick the maximum value and make it root 
		node = new Node(inorder[i]); 
		 // If this is the only element in inorder[start..end], then return it 
		if (start == end) 
			return node; 
		 // Using index in Inorder traversal, construct left and right subtress 
		node.left = buildTree(inorder, start, i-1, node.left); 
		node.right = buildTree(inorder, i+1, end, node.right); 

		return node; 
	} 
	
	 // Function to find index of the maximum value in arr[start...end] 
	int max(int arr[], int strt, int end) {

		int i, max = arr[strt], maxind = strt; 
		for (i = strt+1; i <= end; i++) { 
			if (arr[i] > max) { 
				max = arr[i]; 
				maxind = i; 
			} 
		} 
		return maxind; 
	} 

	 // This funtcion is here just to test buildTree() 
	void printInorder(Node node) {

		if (node == null) 
			return; 
		 // first recur on left child 
		printInorder(node.left); 
		 // then print the data of node 
		System.out.print(node.data + " "); 
		 // now recur on right child 
		printInorder(node.right); 
	} 

	public static void main(String args[]) { 

		ConstructTreeFromInorder tree = new ConstructTreeFromInorder(); 
		
		int inorder[] = new int[]{5, 10, 40, 30, 28}; 
		int len = inorder.length; 
		Node mynode = tree.buildTree(inorder, 0, len - 1, tree.root); 

	    /* 
		  40 
		  / \ 
		10	 30 
		/		 \ 
		5		 28 */

		System.out.println("\n\nInorder traversal of the constructed tree is "); 
		tree.printInorder(mynode); 
		System.out.println(); 
	} 
} 


/*Construct Special Binary Tree from given Inorder traversal

Given Inorder Traversal of a Special Binary Tree in which key of every node is greater 
than keys in left and right children, construct the Binary Tree and return root.
Examples:

Input: inorder[] = {5, 10, 40, 30, 28}
Output: root of following tree
         40
       /   \
      10     30
     /         \
    5          28 

Input: inorder[] = {1, 5, 10, 40, 30, 
                    15, 28, 20}
Output: root of following tree
          40
        /   \
       10     30
      /         \
     5          28
    /          /  \
   1         15    20*/