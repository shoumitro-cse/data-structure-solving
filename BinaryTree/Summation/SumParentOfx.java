// Sum of all the parent nodes having child node x

//javac -d classes SumParentOfx.java  && cd classes && java SumParentOfx && cd ..

class SumParentOfx { 
	// sum 
	static int sum = 0; 
	// Node of a binary tree 
	static class Node { 
		int data; 
		Node left, right; 
	}; 

	// function to get a new node 
	static Node getNode(int data) { 
		// allocate memory for the node 
		Node newNode = new Node(); 
		// put in the data	 
		newNode.data = data; 
		newNode.left = newNode.right = null; 
		return newNode;	 
	} 

	static void sumOfParentOfX(Node root, int x) { 
		// if root == NULL 
		if (root == null) 
			return; 
		if ((root.left != null && root.left.data == x) || (root.right != null && root.right.data == x)) {
			sum += root.data; 
		} 
		sumOfParentOfX(root.left, x); 
		sumOfParentOfX(root.right, x); 
		
	} 

	static int sumOfParentOfXUtil(Node root, int x) { 
		sum = 0; 
		sumOfParentOfX(root, x); 
		// required sum of parent nodes 
		return sum; 
	} 

	public static void main(String args[]) { 

		Node root = getNode(4);		  
		root.left = getNode(2);		 
		root.right = getNode(5);		 
		root.left.left = getNode(7);	
		root.left.right = getNode(2); 
		root.right.left = getNode(2); 
		root.right.right = getNode(3); 

		/*		4        
		       / \       
		      2   5      
		     / \ / \     
		    7  2 2  3    */
		
		int x = 2; 
		
		System.out.println( "Sum = " + sumOfParentOfXUtil(root, x)); 
	} 
} 


/*
Sum of all the parent nodes having child node x


Given a binary tree containing n nodes. The problem is to find the sum of all 
the parent node’s which have a child node with value x.

Examples:

Input : Binary tree with x = 2:
        4        
       / \       
      2   5      
     / \ / \     
    7  2 2  3    

Output : 11

        4        
       / \       
      2   5      
     / \ / \     
    7  2 2  3    

The highlighted nodes (4, 2, 5) above
are the nodes having 2 as a child node.


Algorithm:

sumOfParentOfX(root,sum,x)
    if root == NULL
        return

    if (root->left && root->left->data == x) ||
       (root->right && root->right->data == x)
        sum += root->data
    
    sumOfParentOfX(root->left, sum, x)
    sumOfParentOfX(root->right, sum, x)
    
sumOfParentOfXUtil(root,x)
    Declare sum = 0
    sumOfParentOfX(root, sum, x)
    return sum

*/