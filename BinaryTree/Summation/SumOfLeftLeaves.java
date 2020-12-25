// Find sum of all left leaves in a given Binary Tree

//javac -d classes SumOfLeftLeaves.java  && cd classes && java SumOfLeftLeaves && cd ..

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

class SumOfLeftLeaves 
{ 
	Node root; 

	// A utility function to check if a given node is leaf or not 
	boolean isLeaf(Node node) { 
		if (node == null) 
			return false; 
		if (node.left == null && node.right == null) 
			return true; 
		return false; 
	} 

/*	// utility function to calculate sum of right leaf nodes
	static int sum=0;  
	static void rightLeafSum(Node root) 
	{  
	    if(root == null)  
	        return ;  
	  
	    // check if the right child 
	    // of root is leaf node  
	    if(root.right != null)  
	        if(root.right.left == null && root.right.right == null)  
	            sum += root.right.data;  
	  
	    rightLeafSum(root.left);  
	    rightLeafSum(root.right);  
	}  */

	// Time Complexity: O(N), where n is number of nodes in Binary Tree.
	int leftLeavesSum(Node node) { 
		// Initialize result 
		int res = 0; 
		// Update result if root is not NULL 
		if (node != null) { 

/*			// sum of right left
			if (isLeaf(node.right)) 
				res += node.right.data; */

			// If left of root is NULL, then add key of left child 
			if (isLeaf(node.left)) 
				res += node.left.data; 
			// else // Else recur for left child of root 
			res += leftLeavesSum(node.left); 
			// Recur for right child of root and update res 
			res += leftLeavesSum(node.right); 
		} 
		// return result 
		return res; 
	} 

	// Driver program 
	public static void main(String args[]) 
	{ 
		SumOfLeftLeaves tree = new SumOfLeftLeaves(); 
		tree.root = new Node(4);		  
		tree.root.left = new Node(1);		 
		tree.root.right = new Node(5);		 
		tree.root.left.left = new Node(7);	
		tree.root.left.right = new Node(8); 
		// tree.root.left.right.left = new Node(9); 
		tree.root.right.left = new Node(2); 
		tree.root.right.right = new Node(3); 

		/*		4        
		       / \       
		      1   5      
		     / \ / \     
		    7  8 2  3    */
/*        tree.root = new Node(20); 
        tree.root.left = new Node(9); 
        tree.root.right = new Node(49); 
        tree.root.left.right = new Node(12); 
        tree.root.left.left = new Node(5); 
        tree.root.right.left = new Node(23); 
        tree.root.right.right = new Node(52); 
        tree.root.left.right.right = new Node(12); 
        tree.root.right.right.left = new Node(50); */
   


		System.out.println("The sum of leaves is " + tree.leftLeavesSum(tree.root)); 
	} 
} 


/*Find sum of all left leaves in a given Binary Tree

Given a Binary Tree, find the sum of all left leaves in it. 
For example, sum of all left leaves in below Binary Tree is 7+2=9.

                4        
		       / \       
		      1   5      
		     / \ / \     
		    7  8 2  3   */

/*
	class Sum  
	{ 
	    int sum = 0; 
	}
     // Pass in a sum variable as an accumulator 
    void leftLeavesSumRec(Node node, boolean isleft, Sum summ)  
    { 
        if (node == null) 
            return; 
   
        // Check whether this node is a leaf node and is left. 
        if (node.left == null && node.right == null && isleft) 
            summ.sum = summ.sum + node.data; 
   
        // Pass true for left and false for right 
        leftLeavesSumRec(node.left, true, summ); 
        leftLeavesSumRec(node.right, false, summ); 
    } 
   
    // A wrapper over above recursive function 
    int leftLeavesSum(Node node)  
    { 
        Sum suum = new Sum(); 
          
        // use the above recursive function to evaluate sum 
        leftLeavesSumRec(node, false, suum); 
   
        return suum.sum; 
    } */


// c++ method
/*
// Return the sum of left leaf nodes 
int sumOfLeftLeaves(Node* root) 
{ 
    if(root == NULL) 
        return 0; 
      
    // Using a stack_ for Depth-First  
    // Traversal of the tree 
    stack<Node*> stack_;  
    stack_.push(root); 
      
    // sum holds the sum of all the left leaves 
    int sum = 0; 
  
    while(stack_.size() > 0) 
    { 
        Node* currentNode = stack_.top(); 
        stack_.pop(); 
  
        if (currentNode->left != NULL) 
        { 
            stack_.push(currentNode->left); 
              
            // Check if currentNode's left  
            // child is a leaf node 
            if(currentNode->left->left == NULL &&  
               currentNode->left->right == NULL) 
            { 
                // if currentNode is a leaf,  
                // add its data to the sum  
                sum = sum + currentNode->left->key ; 
            } 
        } 
        if (currentNode->right != NULL) 
            stack_.push(currentNode->right); 
    } 
          
    return sum; 
} */