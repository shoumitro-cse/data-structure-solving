//Check if all leaves are at same level

//javac -d classes CheckLeavesSameLevel.java  && cd classes && java CheckLeavesSameLevel && cd ..

class Node { 
	int data; 
	Node left, right; 
	Node(int item) { 
		data = item; 
		left = right = null; 
	} 
} 

class Leaf { 
	int leaflevel=0; 
} 

class CheckLeavesSameLevel {

	Node root; 
	Leaf mylevel = new Leaf(); 
	
	 // Recursive function which checks whether all leaves are at same level 
	boolean checkUtil(Node node, int level, Leaf leafLevel) { 
		// Base case 
		if (node == null) 
			return true; 
		// If a leaf node is encountered 
		if (node.left == null && node.right == null) { 
			// When a leaf node is found first time 
			if (leafLevel.leaflevel == 0) { 
				// Set first found leaf's level 
				leafLevel.leaflevel = level; 
				return true; 
			} 
			// If this is not first leaf node, compare its level with first leaf's level 
		    // System.out.println("\n\n Not Entry"); 
			return (level == leafLevel.leaflevel); 
		} 
		// If this node is not leaf, recursively check left and right subtrees 
	  return checkUtil(node.left, level+1, leafLevel) && checkUtil(node.right, level+1, leafLevel); 
	} 

	 // The main function to check if all leafs are at same level. It mainly uses checkUtil() 
	boolean check(Node node) { 
		int level = 0; 
		return checkUtil(node, level, mylevel); 
	} 

	public static void main(String args[]) { 

		// Let us create the tree as shown in the example 
		CheckLeavesSameLevel tree = new CheckLeavesSameLevel(); 

		tree.root = new Node(12); 

		tree.root.left = new Node(5); 

		tree.root.left.left = new Node(3); 
		tree.root.left.right = new Node(9); 

		tree.root.left.left.left = new Node(1); 

		// tree.root.left.right.left = new Node(1);

		/*		 12
				/  \
		       5
		      / \
		     3   9
		    /    /
		   1	1      */

		if (tree.check(tree.root)) 
				System.out.println("\n\nLeaves are at same level"); 
			else
				System.out.println("\n\nLeaves are not at same level"); 
		} 
} 


/*
Check if all leaves are at same level

Given a Binary Tree, check if all leaves are at same level or not.
          12
        /    \
      5       7       
    /          \ 
   3            1
  Leaves are at same level

          12
        /    \
      5       7       
    /          
   3          
   Leaves are Not at same level


          12
        /    
      5             
    /   \        
   3     9
  /      /
 1      2
 Leaves are at same level*/





/*

// Method 1 (Iterative)


       // return true if all leaf nodes are  
  // at same level, else false  
   static boolean checkLevelLeafNode(Node root) { 
     if (root == null) 
         return true; 
     // create a queue for level order traversal 
     Queue<Node> q = new LinkedList<>(); 
     q.add(root); 
   
     int result = Integer.MAX_VALUE; 
     int level = 0; 
     // traverse until the queue is empty 
     while (q.size() != 0) { 
            int size = q.size(); 
            level++; 
            // traverse for complete level 
            while (size > 0) { 
                 Node temp = q.remove(); 
                 // check for left child 
                 if (temp.left != null) { 
                     q.add(temp.left); 
                      // if its leaf node 
                      if (temp.left.left == null && temp.left.right == null) { 
                          // if it's first leaf node, then update result 
                          if (result == Integer.MAX_VALUE) 
                              result = level; 
                          // if it's not first leaf node, then compare   
                          // the level with level of previous leaf node. 
                          else if (result != level) 
                               return false;  
                      } 
                 } 
                  // check for right child  
                  if (temp.right != null) { 
                     q.add(temp.right); 
                      // if its leaf node 
                     if (temp.right.left == null && temp.right.right == null) { 
                          // if it's first leaf node, then update result 
                          if (result == Integer.MAX_VALUE) 
                              result = level; 
                          // if it's not first leaf node, then compare   
                          // the level with level of previous leaf node. 
                          else if (result != level) 
                               return false;  
                      } 
                 } 
                 size--; 
            } 

     } 
     return true; 
   }
*/