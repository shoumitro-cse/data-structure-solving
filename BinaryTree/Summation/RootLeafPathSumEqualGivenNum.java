// Java program to print to print root to leaf path sum equal to a given number

//javac -d classes RootLeafPathSumEqualGivenNum.java  && cd classes && java RootLeafPathSumEqualGivenNum && cd ..


class Node {
	int data;
	Node left, right;

	Node(int item)
	{
		data = item;
		left = right = null;
	}
}

class RootLeafPathSumEqualGivenNum {

	Node root;

	boolean hasPathSum(Node node, int sum){
		if (node == null)
			return sum == 0;
		return hasPathSum(node.left, sum - node.data)|| hasPathSum(node.right, sum - node.data);
	}

	// Driver Code
	public static void main(String args[])
	{
		int sum = 21;

		RootLeafPathSumEqualGivenNum tree = new RootLeafPathSumEqualGivenNum();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);

		        /* 
              10
             /  \
           8     2
          / \   /
         3   5 2
        */

		if (tree.hasPathSum(tree.root, sum))
			System.out.println("\nThere is a root to leaf path with sum "+ sum);
		else
			System.out.println("There is no root to leaf path with sum "+ sum);
	}
}


/*Root to leaf path sum equal to a given number

Given a binary tree and a number, return true if the tree has a root-to-leaf path such 
that adding up all the values along the path equals the given number. Return false if 
no such path can be found. 
 
              10
             /  \
           8     2
          / \   /
         3   5 2


For example, in the above tree root to leaf paths exist with following sums.
21 –> 10 – 8 – 3 
23 –> 10 – 8 – 5 
14 –> 10 – 2 – 2
*/