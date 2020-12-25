// Check if there is a root to leaf path with given sequence

 //javac -d classes CheckLeafPath.java  && cd classes && java CheckLeafPath && cd ..

import java.io.*; 

class Node { 

	int data; 
	Node left; 
	Node right; 
	
	Node(int data) { 
		this.data = data; 
		this.left = null; 
		this.right = null; 
	} 
} 


class CheckLeafPath { 
	
	// Util function 
	static boolean existPathUtil(Node root, int arr[], int n, int index) { 
		// If root is NULL or  reached end of the array 
		if(root == null || index == n) 
				return false; 
		// If current node is leaf 
		if (root.left == null && root.right == null) { 
			if((root.data == arr[index]) && (index == n-1)) {
				return true; 
			}
		  return false; 
		} 
	
	 return ((index < n) && (root.data == arr[index]) 
	   && (existPathUtil(root.left, arr, n, index+1) || existPathUtil(root.right, arr, n, index+1) )); 
	} 
	
	// Time complexity : O(n)
	static boolean existPath(Node root, int arr[], int n, int index) { 
		if(root == null) 
			return (n==0); 
		return existPathUtil(root, arr, n, 0); 
	} 

	
	public static void main (String[] args) { 
		
		// arr[] : sequence of root to leaf path 
		int arr[] = {5, 8, 6, 7}; 
		int n = arr.length; 

		Node root = new Node(5); 
		root.left = new Node(3); 
		root.right = new Node(8); 
		root.left.left = new Node(2); 
		root.left.right = new Node(4); 
		root.left.left.left = new Node(1); 
		root.right.left = new Node(6); 
		root.right.left.right = new Node(7); 

		/*           5
		          /    \ 
		         3      8
		        / \    /
		       2   4  6
		      /        \
		     1          7*/

		if(existPath(root, arr, n, 0)) 
			System.out.println("Path Exists"); 
		else
			System.out.println("Path does not Exist"); 
		
	} 
} 

/*
             5
          /    \ 
         3      8
        / \    /
       2   4  6
      /        \
     1          7

Examples :

Input : arr[] = {5, 2, 4, 8} for above tree
Output: "Path Exist"

Input :  arr[] = {5, 3, 4, 9} for above tree
Output: "Path does not Exist"*/