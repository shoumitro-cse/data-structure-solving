// Write a program to Calculate Size of a tree | Recursion

//javac -d classes CalculateSize.java  && cd classes && java CalculateSize && cd ..

import java.util.LinkedList; 
import java.util.Queue; 

class Node 
{ 
	int data; 
	Node left, right; 

	public Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

/* Class to find size of Binary Tree */
class CalculateSize 
{ 
	Node root; 

    public int sizeItr() { 
        if (root == null) 
            return 0; 
        // Using level order Traversal. 
        Queue<Node> q = new LinkedList<Node>(); 
        q.offer(root); 
          
        int count = 1;  
        while (!q.isEmpty()) { 
            Node tmp = q.poll(); 
            // when the queue is empty: the poll() method returns null. 
            if (tmp != null) { 
                if (tmp.left != null)  { 
                    // Increment count 
                    count++; 
                    // Enqueue left child  
                    q.offer(tmp.left); 
                } 
                if (tmp.right != null) { 
                    // Increment count 
                    count++; 
                    // Enqueue left child  
                    q.offer(tmp.right); 
                } 
            } 
        } 
          
        return count; 
    } 

	int size() 
	{ 
		return size(root); 
	} 

	/* computes number of nodes in tree */
	int size(Node node) 
	{ 
		if (node == null) 
			return 0; 
		else
			return(size(node.left) + 1 + size(node.right)); 
	} 

	public static void main(String args[]) 
	{ 
		/* creating a binary tree and entering the nodes */
		CalculateSize tree = new CalculateSize(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 

		System.out.println("The size of binary tree is : "+ tree.size()); 
	} 
} 


/*Write a program to Calculate Size of a tree | Recursion

Size of a tree is the number of elements present in the tree. Size of the below tree is 5.
Example Tree
Example Tree

Size() function recursively calculates the size of a tree. It works as follows:

Size of a tree = Size of left subtree + 1 + Size of right subtree.*/