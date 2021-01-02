// Java program to Check given array can represent BST or not 

//javac -d classes CheckArrayBST.java  && cd classes && java CheckArrayBST && cd ..

//https://www.geeksforgeeks.org/check-given-array-of-size-n-can-represent-bst-of-n-levels-or-not/

class CheckArrayBST 
{ 

	// structure for Binary Node 
	static class Node 
	{ 
		int key; 
		Node right, left; 
	}; 

	static Node newNode(int num) 
	{ 
		Node temp = new Node(); 
		temp.key = num; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	// To create a Tree with n levels. We always 
	// insert new node to left if it is less than 
	// previous value. 
	static Node createNLevelTree(int arr[], int n) 
	{ 
		Node root = newNode(arr[0]); 
		Node temp = root; 
		for (int i = 1; i < n; i++) { 
			if (temp.key > arr[i]) { 
				temp.left = newNode(arr[i]); 
				temp = temp.left; 
			} else { 
				temp.right = newNode(arr[i]); 
				temp = temp.right; 
			} 
		} 
		return root; 
	} 


	static boolean isBST(Node root, int min, int max) 
	{ 
		if (root == null) { 
			return true; 
		} 

		if (root.key < min || root.key > max) { 
			// System.out.println(max+1);//200
			// System.out.println(root.key);//250
			return false; 
		} 
		// Allow only distinct values 
		return (isBST(root.left, min, (root.key)-1) && isBST(root.right, (root.key)+1, max)); 
	} 

	// Returns tree if given array of size n can 
	// represent a BST of n levels. 
	static boolean canRepresentNLevelBST(int arr[], int n) { 
		Node root = createNLevelTree(arr, n); 
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
	} 

	// Driver code 
	public static void main(String[] args) {

		// int arr[] = { 500, 200, 90, 250, 100}; 
		int arr[] = { 5123, 3300, 783, 1111, 890 }; 
		int n = arr.length; 

		if (canRepresentNLevelBST(arr, n)) { 
			System.out.println("Yes"); 
		} else { 
			System.out.println("No"); 
		} 
	} 
} 

/*
Check given array of size n can represent BST of n levels or not
Last Updated: 31-01-2020
Given an array of size n, the task is to find whether array can represent a BST with n levels.

Since levels are n, we construct a tree in the following manner.
Assuming a number X,

Number higher than X is on the right side
Number lower than X is on the left side.
Note: during the insertion, we never go beyond a number already visited.

Examples:

Input : 500, 200, 90, 250, 100
Output : No

Input : 5123, 3300, 783, 1111, 890
Output : Yes
*/