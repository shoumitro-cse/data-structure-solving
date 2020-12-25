// Java code to find the sum of the nodes which are present at the maximum depth. 

//javac -d classes SumMaxDepth.java  && cd classes && java SumMaxDepth && cd ..

class SumMaxDepth 
{ 
	static int sum = 0, max_level = Integer.MIN_VALUE; 

	static class Node 
	{ 
		int d; 
		Node l; 
		Node r; 
	}; 

	// Function to return a new node 
	static Node createNode(int d) 
	{ 
		Node node; 
		node = new Node(); 
		node.d = d; 
		node.l = null; 
		node.r = null; 
		return node; 
	} 

	static void sumOfNodesAtMaxDepth(Node ro, int level) { 

		if(ro == null) 
		  return; 

		if(level > max_level) { 
			sum = ro . d; 
			max_level = level; 
		} else if(level == max_level) { 
			sum = sum + ro . d; 
		} 

		sumOfNodesAtMaxDepth(ro.l, level + 1); 
		sumOfNodesAtMaxDepth(ro.r, level + 1); 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
		Node root; 
		root = createNode(1); 
		root.l = createNode(2); 
		root.r = createNode(3); 
		root.l.l = createNode(4); 
		root.l.r = createNode(5); 
		root.r.l = createNode(6); 
		root.r.r = createNode(7); 
		sumOfNodesAtMaxDepth(root, 0); 
		System.out.println(sum); 
	} 
} 

/*Sum of nodes at maximum depth of a Binary Tree

Given a root node to a tree, find the sum of all the leaf nodes which are at 
maximum depth from root node.

Example:

      1
    /   \
   2     3
  / \   / \
 4   5 6   7

Input : root(of above tree)
Output : 22

Explanation:
Nodes at maximum depth are: 4, 5, 6, 7. 
So, sum of these nodes = 22*/