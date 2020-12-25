// print all nodes at a distance k from leaf
// javac -d classes PrintNodeDistKFromLeaf.java  && cd classes && java PrintNodeDistKFromLeaf && cd .. 

class Node {
	int data;
	Node left, right;

	Node(int item)
	{
		data = item;
		left = right = null;
	}
}

class PrintNodeDistKFromLeaf {

	Node root;

	int printKDistantfromLeaf(Node node, int k) {//k=2
        
        if (node == null)
            return -1;

        int left_k = printKDistantfromLeaf(node.left, k);
        int right_k = printKDistantfromLeaf(node.right, k);

        boolean isLeaf = (left_k == -1) && (left_k == right_k);

        if (left_k == 0 || right_k == 0 || (isLeaf && k == 0))
            System.out.print(" " + node.data);

        if (isLeaf && k > 0)
            return k-1; // leaf node

        if (left_k > 0 && left_k < k)
            return left_k-1; // parent of left leaf

        if (right_k > 0 && right_k < k)
            return right_k-1; // parent of right leaf
 
        return -2;
    }


/*	void kDistantFromLeafUtil(Node node, int path[], boolean visited[], int pathLen, int k) {//k=2
		// Base case
		if (node == null)
			return;
		 // append this Node to the path array 
		path[pathLen] = node.data;
		visited[pathLen] = false;
		pathLen++;
		// System.out.println(pathLen);

		if (node.left==null && node.right==null && pathLen-k-1 >= 0 && visited[pathLen-k-1] == false) {
			System.out.print(path[pathLen-k-1] + " ");
			visited[pathLen-k-1] = true;
			return;
		}
		 // If not leaf node, recur for left and right subtrees 
		kDistantFromLeafUtil(node.left, path, visited, pathLen, k);
		kDistantFromLeafUtil(node.right, path, visited, pathLen, k);
	}


	void printKDistantfromLeaf(Node node, int k) {
		int path[] = new int[1000];
		boolean visited[] = new boolean[1000];
		kDistantFromLeafUtil(node, path, visited, 0, k);
	}*/

	// Driver program to test the above functions
	public static void main(String args[]) {

		PrintNodeDistKFromLeaf tree = new PrintNodeDistKFromLeaf();

		 // Let us construct the tree shown in above diagram 
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);

		/*		  1
				/   \
			   2     3
			  / \   / \
			 4   5 6   7
			        \
			         8 */

		System.out.println("\n\nNodes at distance 2 are :");
		tree.printKDistantfromLeaf(tree.root, 2);// return -2
		System.out.println();
	}
}

/*Print all nodes that are at distance k from a leaf node

Given a Binary Tree and a positive integer k, print all nodes that are distance k from a leaf node. 
Here the meaning of distance is different from previous post. Here k distance from a leaf 
means k levels higher than a leaf node. For example if k is more than height of Binary Tree, 
then nothing should be printed. 

Expected time complexity is O(n) where n is the number nodes in the given Binary Tree.*/