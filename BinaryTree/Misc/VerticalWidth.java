// Java program to print vertical width of a tree 

//javac -d classes VerticalWidth.java  && cd classes && java VerticalWidth && cd ..

import java.util.*; 
import java.io.*; 

class VerticalWidth { 
	// A Binary Tree Node 
	static class Node { 
		int data; 
		Node left, right; 
	}; 


/*
    void fillSet(Node root, Set<Integer> set, int hd) 
    { 
        if(root == null) 
          return; 
          
        fillSet(root.left, set, hd - 1); 
        set.add(hd); 
        fillSet(root.right, set, hd + 1); 
    } 
  
    int verticalWidth(Node root) 
    { 
        Set<Integer> set = new HashSet<Integer>();  
        // Third parameter is horizontal distance  
        fillSet(root, set, 0); 
        return set.size(); 
    } */
      



	static int maximum = 0, minimum = 0; 

	// get vertical width 
	static void lengthUtil(Node root, int curr) { 
		if (root == null) 
			return; 
		// traverse left 
		lengthUtil(root.left, curr - 1); 
		// if curr is decrease then get value in minimum 
		if (minimum > curr) 
			minimum = curr; 
		// if curr is increase then get value in maximum 
		if (maximum < curr) 
			maximum = curr; 
		// traverse right 
		lengthUtil(root.right, curr + 1); 
	} 

	static int getLength(Node root) { 
		maximum = 0; minimum = 0; 
		lengthUtil(root, 0); 
		// 1 is added to include root in the width 
	  return (Math.abs(minimum) + maximum) + 1; 
	} 

	// Utility function to create a new tree node 
	static Node newNode(int data) { 
		Node curr = new Node(); 
		curr.data = data; 
		curr.left = curr.right = null; 
		return curr; 
	} 

	public static void main(String[] args) 
	{ 
		Node root = newNode(7); 
		root.left = newNode(6); 
		root.right = newNode(5); 
		root.left.left = newNode(4); 
		root.left.right = newNode(3); 
		root.right.left = newNode(2); 
		root.right.right = newNode(1); 

		System.out.println(getLength(root)); 
	} 
} 

/*
Vertical width of Binary tree | Set 1

Given a binary tree, find the vertical width of the binary tree. The width of a 
inary tree is the number of vertical paths.

In this image, the tree contains 6 vertical lines which are the required width of the tree.

Examples :

Input : 
             7
           /  \
          6    5
         / \  / \
        4   3 2  1 
Output :
5

Input :
           1
         /    \
        2       3
       / \     / \
      4   5   6   7
               \   \ 
                8   9 
Output :
6*/