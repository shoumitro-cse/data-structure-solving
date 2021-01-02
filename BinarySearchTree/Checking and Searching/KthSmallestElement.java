//Find k-th smallest element in BST (Order Statistics in BST)

//javac -d classes KthSmallestElement.java  && cd classes && java KthSmallestElement && cd ..

import java.io.*;
// A BST node
class Node {
	int data;
	Node left, right;
	Node(int x)
	{
		data = x;
		left = right = null;
	}
}

class KthSmallestElement {
	
	static int count = 0; 
	// Recursive function to insert an key into BST
	public static Node insert(Node root, int x)
	{
		if (root == null)
			return new Node(x);
		if (x < root.data)
			root.left = insert(root.left, x);
		else if (x > root.data)
			root.right = insert(root.right, x);
		return root;
	}
	
	// Function to find k'th largest element in BST
	// Here count denotes the number 
	// of nodes processed so far
	public static Node kthSmallest(Node root, int k)
	{
		// base case
		if (root == null)
			return null;
		// search in left subtree
		Node left = kthSmallest(root.left, k);
		// if k'th smallest is found in left subtree, return it
		if (left != null)
			return left;
		// if current element is k'th smallest, return it
		count++;
		if (count == k)
			return root;
		// else search in right subtree
		return kthSmallest(root.right, k);
	}	

	// Function to find k'th largest element in BST
	// Here count denotes the number 
	// of nodes processed so far
	public static Node kthLargest(Node root, int k)
	{
		// base case
		if (root == null)
			return null;
		// search in left subtree
		Node left = kthSmallest(root.right, k);
		// if k'th smallest is found in left subtree, return it
		if (left != null)
			return left;
		// if current element is k'th smallest, return it
		count++;
		if (count == k)
			return root;
		// else search in right subtree
		return kthSmallest(root.left, k);
	}
	
	// Function to find k'th largest element in BST
	public static void printKthSmallest(Node root, int k)
	{
		// maintain an index to count number of
		// nodes processed so far
		count = 0;
		
		Node res = kthSmallest(root, k);
		if (res == null)
			System.out.println("There are less "
						+ "than k nodes in the BST");
		else
			System.out.println("K-th Smallest"
					+ " Element is " + res.data);
	}
		
	public static void main (String[] args) {
		
		Node root = null;
		int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
	
		for (int x : keys)
			root = insert(root, x);
		
		int k = 3;
		printKthSmallest(root, k);
		
		
	}
}



/*K’th Largest and Smallest element in BST 

Given a binary search tree, task is to find Kth largest element in the binary search tree.
Example:

Input :  k = 3
         Root of following BST
            10
          /    \
         4      20
        /      /   \
       2     15     40
Output : 15*/


/*
Source: Microsoft Interview

Second largest element in BST

Given a Binary Search Tree(BST), find the second largest element.

Examples:

Input: Root of below BST
    10
   /
  5

Output:  5


Input: Root of below BST
        10
      /   \
    5      20
             \ 
              30 

Output:  20*/


/*
// Java code to find second largest element in BST 

// A binary tree node 
class Node { 

	int data; 
	Node left, right; 

	Node(int d) 
	{ 
		data = d; 
		left = right = null; 
	} 
} 

class BinarySearchTree { 

	// Root of BST 
	Node root; 

	// Constructor 
	BinarySearchTree() 
	{ 
		root = null; 
	} 

	// function to insert new nodes 
	public void insert(int data) 
	{ 
		this.root = this.insertRec(this.root, data); 
	} 
	
	Node insertRec(Node node, int data) 
	{ 
		if (node == null) { 
			this.root = new Node(data); 
			return this.root; 
		} 

		if (data < node.data) { 
			node.left = this.insertRec(node.left, data); 
		} else { 
			node.right = this.insertRec(node.right, data); 
		} 
		return node; 
	} 

	// class that stores the value of count 
	public class count { 
		int c = 0; 
	} 

	// Function to find 2nd largest element 
	void secondLargestUtil(Node node, count C) 
	{ 
		// Base cases, the second condition is important to 
		// avoid unnecessary recursive calls 
		if (node == null || C.c >= 2) 
			return; 
		// Follow reverse inorder traversal so that the 
		// largest element is visited first 
		secondLargestUtil(node.right, C); 
		// Increment count of visited nodes 
		C.c++; 
		// If c becomes k now, then this is the 2nd largest 
		if (C.c == 2) { 
			System.out.print("2nd largest element is "+ node.data); 
			return; 
		} 
		// Recur for left subtree 
		secondLargestUtil(node.left, C); 
	} 

	// Function to find 2nd largest element 
	void secondLargest(Node node) 
	{ 
		// object of class count 
		count C = new count(); 
		this.secondLargestUtil(this.root, C); 
	} 

	// Driver function 
	public static void main(String[] args) 
	{ 
		BinarySearchTree tree = new BinarySearchTree(); 
		
	// 	 Let us create following BST 
	// 		50 
	// 	/	 \ 
	// 	30	 70 
	// 	/ \ / \ 
	// 20 40 60 80 
		
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80); 

		tree.secondLargest(tree.root); 
	} 
} 

*/











// K’th smallest element in BST using O(1) Extra Space(Mirror Search)

/*
// Java program to find k'th largest element in BST 
import java.util.*; 
class SmallestEle { 

	// A BST node 
	static class Node 
	{ 
		int key; 
		Node left, right; 
	} 

	// A function to find 
	static int KSmallestUsingMorris(Node root, int k) 
	{ 
		// Count to iterate over elements till we 
		// get the kth smallest number 
		int count = 0; 

		int ksmall = Integer.MIN_VALUE; // store the Kth smallest 
		Node curr = root; // to store the current node 

		while (curr != null) 
		{ 

			if (curr.left == null) 
			{ 
				count++; 

				if (count==k) 
					ksmall = curr.key; 

				// go to current's right child 
				curr = curr.right; 
			} 
			else
			{ 
				// we create links to Inorder Successor and 
				// count using these links 
				Node pre = curr.left; 
				while (pre.right != null && pre.right != curr) 
					pre = pre.right; 

				// building links 
				if (pre.right== null) 
				{ 
					//link made to Inorder Successor 
					pre.right = curr; 
					curr = curr.left; 
				} 

				// While breaking the links in so made temporary 
				// threaded tree we will check for the K smallest 
				// condition 
				else
				{ 
					// Revert the changes made in if part (break link 
					// from the Inorder Successor) 
					pre.right = null; 

					count++; 

					// If count is equal to K then we found 
					// the kth smallest and so store it in ksmall 
					if (count==k) 
						ksmall = curr.key; 

					curr = curr.right; 
				} 
			} 
		} 
		return ksmall; //return the found value 
	} 

	// A utility function to create a new BST node 
	static Node newNode(int item) 
	{ 
		Node temp = new Node(); 
		temp.key = item; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	static Node insert(Node node, int key) 
	{ 
		if (node == null) return newNode(key); 

		if (key < node.key) 
			node.left = insert(node.left, key); 
		else if (key > node.key) 
			node.right = insert(node.right, key); 

		return node; 
	} 

	// Driver Program to test above functions 
	public static void main(String[] args) 
	{ 
		//  Let us create following BST 
		// 		50 
		// 	/	 \ 
		// 	30	 70 
		// 	/ \ / \ 
		// 20 40 60 80 
		Node root = null; 
		root = insert(root, 50); 
		insert(root, 30); 
		insert(root, 20); 
		insert(root, 40); 
		insert(root, 70); 
		insert(root, 60); 
		insert(root, 80); 

		for (int k=1; k<=7; k++) 
		System.out.print(KSmallestUsingMorris(root, k) + " "); 

	} 
} 
*/