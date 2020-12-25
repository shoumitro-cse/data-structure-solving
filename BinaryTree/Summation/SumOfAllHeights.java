// Java program to find sum of heights of all nodes in a binary tree 

//javac -d classes SumOfAllHeights.java  && cd classes && java SumOfAllHeights && cd ..

class SumOfAllHeights { 


	static class Node { 
		int data; 
		Node left; 
		Node right; 
	} 

	static int getHeight(Node Node) 
	{ 
		if (Node == null) 
			return 0; 
		else { 
			int lHeight = getHeight(Node.left); 
			int rHeight = getHeight(Node.right); 

			if (lHeight > rHeight) 
				return (lHeight + 1); 
			else
				return (rHeight + 1); 
		} 
	} 

	static Node newNode(int data) 
	{ 
		Node Node = new Node(); 
		Node.data = data; 
		Node.left = null; 
		Node.right = null; 

		return (Node); 
	} 


	static int getTotalHeight( Node root) 
	{ 
		if (root == null) 
			return 0; 
		return getTotalHeight(root.left) + getHeight(root) + getTotalHeight(root.right); 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		Node root = newNode(1); 

		root.left = newNode(2); 
		root.right = newNode(3); 
		root.left.left = newNode(4); 
		root.left.right = newNode(5); 
	/*		 1
			/ \
		   2   3
		  / \
		 4   5	*/
		System.out.println("Sum of heights of all Nodes = " + getTotalHeight(root)); 
	}
} 

/*Sum of heights of all individual nodes in a binary tree

Given a binary tree, find sum of heights all individual Nodes in the tree. 

Example: 

Binary Tree

For this tree:
             1
			/ \
		   2   3
		  / \
		 4   5
1). Height of Node 1 - 3
2). Height of Node 2 - 2
3). Height of Node 3 - 1
4). Height of Node 4 - 1
5). Height of Node 5 - 1

Adding all of them = 8      */








/*// Java program to find sum of heights of all 
// nodes in a binary tree 
class SumOfAllHeights 
{


	static class Node
	{
		int data;
		Node left;
		Node right;
	};
	static int sum;


	static Node newNode(int data)
	{
		Node Node = new Node();
		Node.data = data;
		Node.left = null;
		Node.right = null;

		return (Node);
	}


	static int getTotalHeightUtil(Node root) 
	{
		if (root == null) 
		{
			return 0;
		}

		int lh = getTotalHeightUtil(root.left);
		int rh = getTotalHeightUtil(root.right);
		int h = Math.max(lh, rh) + 1;

		sum = sum + h;
		return h;
	}

	static int getTotalHeight(Node root) 
	{
		sum = 0;
		getTotalHeightUtil(root);
		return sum;
	}

	// Driver code 
	public static void main(String[] args) 
	{
		Node root = newNode(1);

		root.left = newNode(2);
		root.right = newNode(3);
		root.left.left = newNode(4);
		root.left.right = newNode(5);
		System.out.printf("Sum of heights of all Nodes = %d", getTotalHeight(root));
	}
}

*/