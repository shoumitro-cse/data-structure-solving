// Convert an arbitrary Binary Tree to a tree that holds Children Sum Property

//javac -d classes ArbitraryTreeToBinaryTree.java  && cd classes && java ArbitraryTreeToBinaryTree && cd ..

class Node { 
	int data; 
	Node left, right; 
	Node(int item) { 
		data = item; 
		left = right = null; 
	} 
} 

class ArbitraryTreeToBinaryTree {

	Node root; 
	 // This function changes a tree to hold children sum property 
	void convertTree(Node node) { 
		int left_data = 0, right_data = 0, diff; 
		 // If tree is empty or it's a leaf node then return true 
		if (node == null || (node.left == null && node.right == null)) { 
			return; 
		} else { 
			 // convert left and right subtrees 
			convertTree(node.left); 
			convertTree(node.right); 
			 // If left child is not present then 0 is used as data of left child 
			if (node.left != null) {
				left_data = node.left.data; 
			}
			 // If right child is not present then 0 is used as data of right child 
			if (node.right != null) {
				right_data = node.right.data;
			} 
			 // get the diff of node's data and children sum 
			diff = left_data + right_data - node.data; 
			 // If node's children sum is greater than the node's data 
			if (diff > 0) { 
				node.data = node.data + diff;
			} 
			 // THIS IS TRICKY --> If node's data is greater than children sum, then increment subtree by diff 
			if (diff < 0) {
				// -diff is used to make diff positive 
				increment(node, -diff);
			} 
		} 
	} 

	 // This function is used to increment subtree by diff 
	void increment(Node node, int diff) { 
		 // IF left child is not NULL then increment it 
		if (node.left != null) { 
			node.left.data = node.left.data + diff; 
			increment(node.left, diff); 
		} else if (node.right != null) {// Else increment right child 
			node.right.data = node.right.data + diff; 
			increment(node.right, diff); 
		} 
	} 

	 // Given a binary tree, printInorder() prints out its inorder traversal
	void printInorder(Node node) 
	{ 
		if (node == null) 
			return; 
		 // first recur on left child 
		printInorder(node.left); 
		 // then print the data of node 
		System.out.print(node.data + " "); 
		 // now recur on right child 
		printInorder(node.right); 
	} 

	// Driver program to test above functions 
	public static void main(String args[]) {

		ArbitraryTreeToBinaryTree tree = new ArbitraryTreeToBinaryTree(); 
		tree.root = new Node(50); 
		tree.root.left = new Node(7); 
		tree.root.right = new Node(2); 
		tree.root.left.left = new Node(3); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(1); 
		tree.root.right.right = new Node(30); 

/*		      50
             /  \     
	       7      2
	      / \     /\
	    3   5    1  0*/

		System.out.println("Inorder traversal before conversion is :"); 
		tree.printInorder(tree.root); 

		tree.convertTree(tree.root); 
		System.out.println(""); 

		System.out.println("Inorder traversal after conversion is :"); 
		tree.printInorder(tree.root); 
		System.out.println(""); 

	} 
} 



/*Convert an arbitrary Binary Tree to a tree that holds Children Sum Property
Last Updated: 10-02-2020
Question: Given an arbitrary binary tree, convert it to a binary tree that holds 
Children Sum Property. You can only increment data values in any node 
(You cannot change the structure of the tree and cannot decrement the value of any node).

For example, the below tree doesn’t hold the children sum property, convert it to a 
tree that holds the property.

             50
           /     \     
         /         \
       7             2
     / \             /\
   /     \          /   \
  3        5      1      30


Algorithm:
Traverse the given tree in post order to convert it, i.e., first change left and right 
children to hold the children sum property then change the parent node.

Let difference between node’s data and children sum be diff.

     diff = node’s children sum - node’s data  
If diff is 0 then nothing needs to be done.




If diff > 0 ( node’s data is smaller than node’s children sum) increment the node’s data by diff.

If diff < 0 (node’s data is greater than the node's children sum) then increment one child’s data.
We can choose to increment either left or right child if they both are not NULL. 
Let us always first increment the left child. Incrementing a child changes the subtree’s 
children sum property so we need to change left subtree also. So we recursively increment the 
left child. If left child is empty then we recursively call increment() for right child.

Let us run the algorithm for the given example.

First convert the left subtree (increment 7 to 8).

             50
           /     \     
         /         \
       8             2
     / \             /\
   /     \          /   \
  3        5      1      30
Then convert the right subtree (increment 2 to 31)

          50
        /    \     
      /        \
    8            31
   / \           / \
 /     \       /     \
3       5    1       30
Now convert the root, we have to increment left subtree for converting the root.

          50
        /    \     
      /        \
    19           31
   / \           /  \
 /     \       /      \
14      5     1       30
Please note the last step – we have incremented 8 to 19, 
and to fix the subtree we have incremented 3 to 14.
*/