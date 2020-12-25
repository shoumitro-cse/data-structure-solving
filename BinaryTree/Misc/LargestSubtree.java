// Find largest subtree having identical left and right subtrees

//javac -d classes LargestSubtree.java  && cd classes && java LargestSubtree && cd ..

class LargestSubtree
{
		
	/* A binary tree node has data, pointer to left
	child and a pointer to right child */
	static class Node {
		int data;
		Node left, right;
	};

	/* Helper function that allocates a new node with
	the given data and null left and right pointers. */
	static Node newNode(int data)
	{
		Node node = new Node();
		node.data = data;
		node.left = node.right = null;
		return (node);
	}

	static class string {
		String str;
	}

	static int maxSize;
	static Node maxNode;

	static class pair
	{
		int first;
		String second;
		pair(int a, String b){
			first = a;
			second = b;
		}
	}

	static pair largestSubtreeUtil(Node root, String str)
	{
		if (root == null)
			return new pair(0, str);
		// string to store structure of left and right subtrees
		String left ="", right="";
		// traverse left subtree and finds its size
		pair ls1 = largestSubtreeUtil(root.left, left);
		left = ls1.second;
		int ls = ls1.first;
		
		// traverse right subtree and finds its size
		pair rs1 = largestSubtreeUtil(root.right, right);
		right = rs1.second;
		int rs = rs1.first;
		
		int size = ls + rs + 1;
		if (left.equals(right)) {
			if (size > maxSize) {
					maxSize = size;
					maxNode = root;
			}
		}

		// append left subtree data
		str += "|"+left+"|";
		// append current node data
		str += "|"+root.data+"|";
		// append right subtree data
		str += "|"+right+"|";

        // for debug
        System.out.println(str);
		
		return new pair(size, str);
	}

	static int largestSubtree(Node node) {
		maxSize = 0;
		largestSubtreeUtil(node, "");
	   return maxSize;
	}

	public static void main(String args[]) {

	/*            50
	         /      \
	        10       60
	       /  \     /   \
	      5   20   70    70
	               / \   / \
	             65  80 65  80*/

		Node root = newNode(50);
		root.left = newNode(10);
		root.right = newNode(60);
		root.left.left = newNode(5);
		root.left.right = newNode(20);
		root.right.left = newNode(70);
		root.right.left.left = newNode(65);
		root.right.left.right = newNode(80);
		root.right.right = newNode(70);
		root.right.right.left = newNode(65);
		root.right.right.right = newNode(80);

		maxNode = null;
		maxSize = largestSubtree(root);

		System.out.println( "Largest Subtree is rooted at node "
			+ maxNode.data + "\nand its size is "+ maxSize);
	}
}


/*

Find largest subtree having identical left and right subtrees

Given a binary tree, find the largest subtree having identical left and right subtree. Expected complexity is O(n).

For example, 

Input: 
            50
         /      \
        10       60
       /  \     /   \
      5   20   70    70
               / \   / \
             65  80 65  80
Output: 
 Largest subtree is rooted at node 60*/