//find predecessor and successor in a BST

//javac -d classes PredecessorSuccessorBST.java  && cd classes && java PredecessorSuccessorBST && cd ..

class PredecessorSuccessorBST{ 

	// BST Node 
	static class Node { 
		int key; 
		Node left, right; 
		public Node() {

		} 
		public Node(int key) { 
			this.key = key; 
			this.left = this.right = null; 
		} 
	}; 

/*	static Node pre; 
	static Node suc;
	// Function that finds predecessor  
	// and successor of key in BST. 
	static void findPreSuc(Node root, int key) { 
	    if (root == null) 
	        return; 
	    // Search for given key in BST. 
	    while (root != null)  { 
	        // If root is given key. 
	        if (root.key == key) { 
	            // the minimum value in right subtree is predecessor. 
	            if (root.right != null) { 
	                suc = root.right; 
	                while (suc.left != null) 
	                    suc = suc.left; 
	            } 
	            // the maximum value in left subtree is successor. 
	            if (root.left != null) { 
	                pre = root.left; 
	                while (pre.right != null) 
	                    pre = pre.right; 
	            } 
	            return; 
	        } else if (root.key < key) { 
	            pre = root; 
	            root = root.right; 
	        } else { 
	            suc = root; 
	            root = root.left; 
	        } 
	    } 
	} */
	  


	static Node pre = new Node(), suc = new Node(); 

	static void findPreSuc(Node root, int key) { 
		// Base case 
		if (root == null) 
			return; 
		// If key is present at root 
		if (root.key == key) { 
			// The maximum value in left subtree is predecessor 
			if (root.left != null) { 
				Node tmp = root.left; 
				while (tmp.right != null) 
					tmp = tmp.right; 
				pre = tmp; 
			} 
			// The minimum value in right subtree is successor 
			if (root.right != null) { 
				Node tmp = root.right; 
				while (tmp.left != null) 
					tmp = tmp.left; 
				suc = tmp; 
			} 
			return; 
		} 
		// If key is smaller than root's key, go to left subtree 
		if (root.key > key) { 
			suc = root; 
			findPreSuc(root.left, key); 
		} else { 
		   // Go to right subtree 
			pre = root; 
			findPreSuc(root.right, key); 
		} 
	} 

	// A utility function to insert a 
	// new node with given key in BST 
	static Node insert(Node node, int key) 
	{ 
		if (node == null) 
			return new Node(key); 
		if (key < node.key) 
			node.left = insert(node.left, key); 
		else
			node.right = insert(node.right, key); 
			
		return node; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		
		// Key to be searched in BST 
		int key = 65; 

		/* 
		* Let us create following BST 
		*		 50 
		*		 / \ 
		*	 30 70 
		*	 / \ / \ 
		*	 20 40 60 80 
		*/

		Node root = new Node(); 

		root = insert(root, 50); 
		
		insert(root, 30); 
		insert(root, 20); 
		insert(root, 40); 
		insert(root, 70); 
		insert(root, 60); 
		insert(root, 80); 

		findPreSuc(root, key); 

		if (pre != null) 
			System.out.println("Predecessor is " + pre.key); 
		else
			System.out.println("No Predecessor"); 

		if (suc != null) 
			System.out.println("Successor is " + suc.key); 
		else
			System.out.println("No Successor"); 
	} 
} 



/*
Inorder predecessor and successor for a given key in BST | Iterative Approach


Given a BST and a key. The task is to find the inorder successor and predecessor of the given key. In case, if either of predecessor or successor is not present, then print -1.

Examples:

Input:          50
               /  \
              /    \
            30     70
           / \     / \
          /   \   /   \
         20   40 60   80
            key = 65
Output: Predecessor : 60
        Successor : 70

Input:          50
               /  \
              /    \
            30     70
           / \     / \
          /   \   /   \
         20   40 60   80
            key = 100
Output: predecessor : 80
        successor : -1
Explanation: As no node in BST has key value greater 
than 100 so -1 is printed for successor.

*/