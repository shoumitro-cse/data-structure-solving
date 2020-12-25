//Check if removing an edge can divide a Binary Tree in two halves

//javac -d classes CheckRemovingEdgeCrBTtwohalves.java  && cd classes && java CheckRemovingEdgeCrBTtwohalves && cd ..

class Node { 
	int key; 
	Node left, right; 
	public Node(int key) { 
		this.key = key; 
		left = right = null; 
	} 
} 

class Res { 
    boolean res = false; 
} 

class CheckRemovingEdgeCrBTtwohalves { 

	Node root; 
	// To calculate size of tree with given root 
	int count(Node node) { 
		if (node == null) 
			return 0; 	
		return count(node.left) + count(node.right) + 1; 
	} 


/*	boolean checkRec(Node node, int n) { 
		// Base cases 
		if (node == null) 
			return false; 
		// Check for root 
		int c = count(node);
		if (c == n-c) 
			return true; 
		// Check for rest of the nodes 
		return checkRec(node.left, n) || checkRec(node.right, n); 
	} 
	// This function mainly uses checkRec() 
	boolean check(Node node) { 
		// Count total nodes in given tree 
		int n = count(node); 
		// Now recursively check all nodes 
		return checkRec(node, n); 
	} */

	int checkRec(Node root, int n, Res res) { 
        // Base case 
        if (root == null) 
            return 0; 
        // Compute sizes of left and right children 
        int c = checkRec(root.left, n, res) + 1 + checkRec(root.right, n, res); 
        // If required property is true for current node set "res" as true 
        if (c == n - c)  
            res.res = true; 
        // Return size 
        return c; 
    } 

   // This function mainly uses checkRec() 
    boolean check(Node root) { 
        // Count total nodes in given tree 
        int n = count(root); 
        // Initialize result and recursively check all nodes 
        Res res = new Res(); 
        checkRec(root, n, res); 
        return res.res; 
    } 


	// Driver code 
	public static void main(String[] args) 
	{ 
		CheckRemovingEdgeCrBTtwohalves tree = new CheckRemovingEdgeCrBTtwohalves(); 
		
		tree.root = new Node(5); 

		tree.root.left = new Node(1); 
		tree.root.right = new Node(6); 
		
		tree.root.left.left = new Node(3); 
		
		tree.root.right.left = new Node(7); 
		tree.root.right.right = new Node(4); 

		/*	   5
		     /   \
		   1      6    
		  /      /  \
		 3      7    4*/

		if(tree.check(tree.root) == true) 
			System.out.println("YES"); 
		else
			System.out.println("NO"); 
	} 
} 


/*
Check if removing an edge can divide a Binary Tree in two halves

Given a Binary Tree, find if there exist edge whose removal creates two trees of equal size.

Examples:

Input : root of following tree
           5
         /   \
       1      6    
      /      /  \
     3      7    4
Output : true
Removing edge 5-6 creates two trees of equal size


Input : root of following tree
           5
         /   \
       1      6    
            /  \
           7    4
         /  \    \
        3    2    8
Output : false
There is no edge whose removal creates two trees
of equal size.*/