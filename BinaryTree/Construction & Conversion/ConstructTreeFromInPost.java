// Java program to construct a tree using inorder and postorder traversals

// javac -d classes ConstructTreeFromInPost.java  && cd classes && java ConstructTreeFromInPost && cd ..

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

// Class Index created to implement pass by reference of Index
class Index {
	int index;
}

class ConstructTreeFromInPost {

   // Time Complexity: O(n2)
	Node buildUtil(int in[], int post[], int inStrt, int inEnd, Index pIndex) {
		// Base case
		if (inStrt > inEnd)
			return null;

		Node node = new Node(post[pIndex.index]);
		pIndex.index--;
		 // If this node has no children then return 
		if (inStrt == inEnd)
			return node;
		 // Else find the index of this node in Inorder traversal 
		int i = search(in, inStrt, inEnd, node.data);
		 // Using index in Inorder traversal, construct left andright subtress 
		node.right = buildUtil(in, post, i+1, inEnd, pIndex);
		node.left = buildUtil(in, post, inStrt, i-1, pIndex);

		return node;
	}

	int search(int arr[], int strt, int end, int value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value)
				break;
		}
		return i;
	}

	// This function mainly initializes index of root
	// and calls buildUtil()
	Node buildTree(int in[], int post[], int n) {
		Index pIndex = new Index();
		pIndex.index = n-1;
		return buildUtil(in, post, 0, n-1, pIndex);
	}


	/* This funtcion is here just to test */
	void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args) {

		ConstructTreeFromInPost tree = new ConstructTreeFromInPost();

		int in[] = new int[] {2, 1, 3};
		int post[] = new int[] {2, 3, 1};
		int n = in.length;

		Node root = tree.buildTree(in, post, n);

/*		      1
		    /   \
		   2     3 */

		System.out.println("\n\nPreorder of the constructed tree : ");
		tree.preOrder(root);
		System.out.println();
	}
}


/*
Construct a Binary Tree from Postorder and Inorder


Given Postorder and Inorder traversals, construct the tree.

Examples: 

Input: 
in[]   = {2, 1, 3}
post[] = {2, 3, 1}

Output: Root of below tree
      1
    /   \
   2     3 


Input: 
in[]   = {4, 8, 2, 5, 1, 6, 3, 7}
post[] = {8, 4, 5, 2, 6, 7, 3, 1} 

Output: Root of below tree
          1
       /     \
     2        3
   /    \   /   \
  4     5   6    7
    \
      8                  */