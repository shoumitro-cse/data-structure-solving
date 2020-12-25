// Depth of the deepest odd level node in Binary Tree

//javac -d classes DeepestOddLevel.java  && cd classes && java DeepestOddLevel && cd ..

class DeepestOddLevel { 

	// A Tree node 
	static class Node 
	{ 
		int key; 
		Node left, right; 
	} 

	// Utility function to create a new node 
	static Node newNode(int key) 
	{ 
		Node temp = new Node(); 
		temp.key = key; 
		temp.left = null; 
		temp.right = null; 
		return (temp); 
	} 

	// return max odd number depth of leaf node 
	/*static int maxOddLevelDepth(Node root) 
	{ 
	    if (root == null) 
	        return 0; 
	  
	    // create a queue for level order  
	    // traversal 
	    Queue<Node> q = new LinkedList<>(); 
	    q.add(root); 
	  
	    int result = Integer.MAX_VALUE; 
	    int level = 0; 
	  
	    // traverse until the queue is empty 
	    while (!q.isEmpty())  
	    { 
	        int size = q.size(); 
	        level += 1; 
	  
	        // traverse for complete level 
	        while(size > 0) 
	        { 
	            Node temp = q.peek(); 
	            q.remove(); 
	  
	            // check if the node is leaf node and  
	            // level is odd if level is odd, 
	            // then update result 
	            if(temp.left == null &&  
	               temp.right == null && (level % 2 != 0)) 
	            { 
	                result = level; 
	            } 
	          
	            // check for left child 
	            if (temp.left != null)  
	            { 
	                q.add(temp.left); 
	            } 
	              
	            // check for right child 
	            if (temp.right != null) 
	            { 
	                q.add(temp.right); 
	            } 
	            size -= 1; 
	        }  
	    } 
	    return result; 
	} */


/*	    // A recursive function to find depth of the deepest odd level leaf 
    int depthOfOddLeafUtil(Node node, int level)  
    { 
        // Base Case 
        if (node == null) 
            return 0; 
   
        // If this node is a leaf and its level is odd, return its level 
        if (node.left == null && node.right == null && (level & 1) != 0) 
            return level; 
   
        // If not leaf, return the maximum value from left and right subtrees 
        return Math.max(depthOfOddLeafUtil(node.left, level + 1), 
                depthOfOddLeafUtil(node.right, level + 1)); 
    } 
   
    int depthOfOddLeaf(Node node)  
    { 
        int level = 1, depth = 0; 
        return depthOfOddLeafUtil(node, level); 
    } */



	// Utility function which 
	// returns whether the current node 
	// is a leaf or not 
	static boolean isleaf(Node curr_node) { 
		return (curr_node.left == null && curr_node.right == null); 
	} 

	// function to return the longest 
	// odd level depth if it exists 
	// otherwise 0 
	static int deepestOddLevelDepthUtil(Node curr_node, int curr_level) 
	{ 
		// Base case 
		// return from here 
		if ( curr_node == null) 
			return 0; 
		// increment current level 
		curr_level += 1; 
		// if curr_level is odd 
		// and its a leaf node 
		if ( curr_level % 2 != 0 && isleaf(curr_node)) 
			return curr_level; 

		return Math.max(deepestOddLevelDepthUtil(curr_node.left, curr_level), 
					deepestOddLevelDepthUtil(curr_node.right, curr_level)); 
	} 

	// A wrapper over deepestOddLevelDepth() 
	static int deepestOddLevelDepth(Node curr_node) { 
		return deepestOddLevelDepthUtil(curr_node, 0); 
	} 

	public static void main(String[] args) {
/*        10
       /     \
     28       13
            /     \
          14       15
                  /  \
                 23   24*/

		Node root = newNode(10); 
		root.left = newNode(28); 
		root.right = newNode(13); 

		root.right.left = newNode(14); 
		root.right.right = newNode(15); 

		root.right.right.left = newNode(23); 
		root.right.right.right = newNode(24); 


		System.out.println(deepestOddLevelDepth(root)); 
	} 

} 

/*
Depth of the deepest odd level node in Binary Tree


Given a Binary tree, find out depth of the deepest odd level leaf node. Take root level as depth 1.

Examples:


Input : 10
       /     \
     28       13
            /     \
          14       15
                  /  \
                 23   24
Output : 3*/
