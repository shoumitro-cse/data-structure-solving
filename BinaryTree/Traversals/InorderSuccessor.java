// Java program to find inorder successor of a node 

// javac -d classes InorderSuccessor.java  && cd classes && java InorderSuccessor && cd ..

class InorderSuccessor {

	// A Binary Tree Node 
	static class Node { 
		int data; 
		Node left, right; 
	} 

	// Temporary node for case 2 
	static Node temp = new Node(); 

	// Utility function to create a new tree node 
	static Node newNode(int data) { 
		Node temp = new Node(); 
		temp.data = data; 
		temp.left = temp.right = null; 
		return temp; 
	} 

/*	// function to find left most node in a tree 
	static Node leftMostNode(Node node) { 
		while (node != null && node.left != null) 
			node = node.left; 
		return node; 
	} 

	// function to find right most node in a tree 
	static Node rightMostNode(Node node) { 
		while (node != null && node.right != null) 
			node = node.right; 
		return node; 
	} 

	// recursive function to find the Inorder Scuccessor when the right child of node x is null 
	static Node findInorderRecursive(Node root, Node x ) 
	{ 
		if (root==null) 
			return null; 

		if (root == x || 
		   (temp = findInorderRecursive(root.left, x)) != null || 
			(temp = findInorderRecursive(root.right, x)) != null) { 

			if (temp != null) { 
				if (root.left == temp) { 
					System.out.print( "Inorder Successor of "+x.data); 
					System.out.print( " is "+ root.data + "\n"); 
					return null; 
				} 
			} 
			return root; 
		} 

		return null; 
	} 

	// function to find inorder successor of a node 
	static void inorderSuccesor(Node root, Node x) { 
		// Case1: If right child is not null 
		if (x.right != null) { 
			Node inorderSucc = leftMostNode(x.right); 
			System.out.print("Inorder Successor of "+x.data+" is "); 
			System.out.print(inorderSucc.data+"\n"); 
		} 
		// Case2: If right child is null 
		if (x.right == null) {	 
			int f = 0; 
			Node rightMost = rightMostNode(root); 
			// case3: If x is the right most node 
			if (rightMost == x) {
				System.out.print(x.data+" is no inorder successor! Right most node.\n"); 
			} else {
				// System.out.print(x.data+"\n"+root.data+"\n"); 
				findInorderRecursive(root, x); 
			}
		} 
	} 
*/

     static Node pre;
     // Time Complexity: O( n ),
	 static void inOrderSuccessorOfBinaryTree(Node root, int searchNode) { 
        // Case1: If right child is not NULL  
        if(root.right != null) {
           inOrderSuccessorOfBinaryTree(root.right, searchNode); 
        }
          
        // Case2: If root data is equal to search node 
        if(root.data == searchNode)  {
            System.out.println("inorder successor of " + searchNode + " is: "
                            + (pre != null ? pre.data : "null")); 
        }

        pre = root;  

        if(root.left != null) {  
           inOrderSuccessorOfBinaryTree(root.left, searchNode); 
        }

    } 

	// Driver program to test above functions 
	public static void main(String args[]) { 

		Node root = newNode(1); 
		root.left = newNode(2); 
		root.right = newNode(3); 
		root.left.left = newNode(4); 
		root.left.right = newNode(5); 
		root.right.right = newNode(6); 

		/*		1
		       / \
			  2   3
			 / \   \
			4   5  	6*/

/*		// Case 1 
		inorderSuccesor(root, root.right);//3 
		// case 2 
		inorderSuccesor(root, root.left.left);//4 
		// case 3 
		inorderSuccesor(root, root.right.right); //6
		*/
		// inorderSuccesor(root, root.left.right); //5
		inOrderSuccessorOfBinaryTree(root, 4); //5

	} 
} 

