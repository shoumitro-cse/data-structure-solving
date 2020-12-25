// Recursive Java program to connect nodes at same level 
// using constant extra space 

//javac -d classes ConnectSameLevel2.java  && cd classes && java ConnectSameLevel2 && cd ..

// Java program to connect nodes at same level using extended 
// pre-order traversal 

//https://www.geeksforgeeks.org/connect-nodes-at-same-level/

import java.util.*; 
import java.io.*; 

class Node { 
	int data; 
	Node left, right, nextRight; 

	Node(int item) 
	{ 
		data = item; 
		left = right = nextRight = null; 
	} 
} 

class ConnectSameLevel2 { 
	Node root; 


    void connect2(Node p) { 
        // initialize queue to hold nodes at same level  
        Queue<Node> q = new LinkedList<>(); 
        q.add(root); // adding nodes to tehe queue 
        Node temp = null; // initializing prev to null 
        while (!q.isEmpty()) { 
            int n = q.size(); 
            for (int i = 0; i < n; i++) { 
                Node prev = temp; 
                temp = q.poll(); 
                // i > 0 because when i is 0 prev points 
                // the last node of previous level, so we skip it 
                if (i > 0) 
                    prev.nextRight = temp;  
  
                if (temp.left != null) 
                    q.add(temp.left); 
  
                if (temp.right != null) 
                    q.add(temp.right); 
            } 
            // pointing last node of the nth level to null 
            temp.nextRight = null;  
        } 
    } 

	// Sets the nextRight of root and calls connectRecur() 
	// for other nodes 
	void connect(Node p) { 
		// Set the nextRight for root 
		p.nextRight = null;
		// Set the next right for rest of the nodes (other than root) 
		connectRecur(p); 
	} 


	void connectRecur(Node p) 
	{ 
		// Base case 
		if (p == null) 
			return; 
		// Set the nextRight pointer for p's left child 
		if (p.left != null) 
			p.left.nextRight = p.right; 
		// Set the nextRight pointer for p's right child 
		// p->nextRight will be NULL if p is the right most child at its level 
		if (p.right != null) 
			p.right.nextRight = (p.nextRight != null) ? p.nextRight.left : null; 
		// Set nextRight for other nodes in pre order fashion 
		connectRecur(p.left); 
		connectRecur(p.right); 
	} 

	// Driver program to test above functions 
	public static void main(String args[]) 
	{ 
		ConnectSameLevel2 tree = new ConnectSameLevel2(); 

        /* Constructed binary tree is 
             10 
            /  \ 
          8     2 
         / 
        3 
        */
		tree.root = new Node(10); 
		tree.root.left = new Node(8); 
		tree.root.right = new Node(2); 
		tree.root.left.left = new Node(3); 

		// Populates nextRight pointer in all nodes 
		tree.connect(tree.root); 

		// Let us check the values of nextRight pointers 
		System.out.println("Following are populated nextRight pointers in "
						+ "the tree"
						+ "(-1 is printed if there is no nextRight)"); 
		int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1; 
		System.out.println("nextRight of " + tree.root.data + " is "
						+ a); 
		int b = tree.root.left.nextRight != null ? tree.root.left.nextRight.data : -1; 
		System.out.println("nextRight of " + tree.root.left.data + " is "
						+ b); 
		int c = tree.root.right.nextRight != null ? tree.root.right.nextRight.data : -1; 
		System.out.println("nextRight of " + tree.root.right.data + " is "
						+ c); 
		int d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.data : -1; 
		System.out.println("nextRight of " + tree.root.left.left.data + " is "
						+ d); 
	} 
} 




/*
Connect nodes at same level using constant extra space


Write a function to connect all the adjacent nodes at the same level in a binary tree. 
Structure of the given Binary Tree node is like following.

struct node { 
  int data; 
  struct node* left; 
  struct node* right; 
  struct node* nextRight; 
} 
Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right for each node. You can use only constant extra space.

Example:

Input Tree
       A
      / \
     B   C
    / \   \
   D   E   F

Output Tree
       A--->NULL
      / \
     B-->C-->NULL
    / \   \
   D-->E-->F-->NULL

*/