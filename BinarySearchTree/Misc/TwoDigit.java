// Java program to count number of nodes in BST containing two digit special number

// javac -d classes TwoDigit.java  && cd classes && java TwoDigit && cd ..

class Node
{
	int info;
	Node left, right;

	Node(int d)
	{
		info = d;
		left = right = null;
	}
}

class TwoDigit{

	static Node head;
	static int count;

	// Function to create a new node 
	Node insert(Node node, int info){
		// If the tree is empty, return a new,single node
		if (node == null) {
			return (new Node(info));
		} else {
			// Otherwise, recur down the tree 
			if (info <= node.info) {
				node.left = insert(node.left, info);
			} else {
				node.right = insert(node.right, info);
			}
			// return the (unchanged) node pointer 
			return node;
		}
	}

	// Function to find if number
	// is special or not
	static int check(int num)
	{
		int sum = 0, i = num, sum_of_digits, prod_of_digits;
		// Check if number is two digit or not
		if (num < 10 || num > 99) {
			return 0;
		} else {
			sum_of_digits = (i % 10) + (i / 10);
			prod_of_digits = (i % 10) * (i / 10);
			sum = sum_of_digits + prod_of_digits;
		}

		if (sum == num){
			//System.out.println(num);
			return 1;
		} else {
			return 0;
		}
	}

	// Function to count number of special
	// two digit number
	static void countSpecialDigit(Node rt)
	{
		int x;
		if (rt == null) {
			return;
		} else {
			x = check(rt.info);
			if (x == 1)
				count = count + 1;	
			countSpecialDigit(rt.left);
			countSpecialDigit(rt.right);
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		TwoDigit tree = new TwoDigit();
		Node root = null;
		
		root = tree.insert(root, 50);
		tree.insert(root, 29);
		tree.insert(root, 59);
		tree.insert(root, 19);
		tree.insert(root, 53);
		tree.insert(root, 556);
		tree.insert(root, 56);
		tree.insert(root, 94);
		tree.insert(root, 13);
		
		// Function call
		countSpecialDigit(root);
		System.out.println(count);
	}
}

/*
Special two digit numbers in a Binary Search Tree

Given a Binary Search Trees, the task is to count the number of nodes which are having special two-digit numbers.
Prerequisite : Special Two Digit Number | Binary Search Tree 

Examples :  

Input : 15 7 987 21
Output : 0

Input : 19 99 57 1 22
Output : 2

*/
