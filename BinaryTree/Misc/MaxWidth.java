// Java program to calculate maximum width of a binary tree using queue 

//javac -d classes MaxWidth.java  && cd classes && java MaxWidth && cd ..

import java.util.LinkedList; 
import java.util.Queue; 

public class MaxWidth 
{ 
	/* A binary tree node has data, pointer to 
	left child and a pointer to right child */
	static class node 
	{ 
		int data; 
		node left, right; 

		public node(int data) { this.data = data; } 
	} 

/*    int getMaxWidth(Node node) { 
        int maxWidth = 0; 
        int width; 
        int h = height(node); 
        int i; 
  
        for (i = 1; i <= h; i++) { 
            width = getWidth(node, i); 
            if (width > maxWidth) {
                maxWidth = width; 
            }
        } 
  
        return maxWidth; 
    } 
  
    int getWidth(Node node, int level) { 
        if (node == null) 
            return 0; 
        if (level == 1) 
            return 1; 
        else if (level > 1) 
            return getWidth(node.left, level - 1) + getWidth(node.right, level - 1); 
        return 0; 
    } 
  
    int height(Node node) 
    { 
        if (node == null) 
            return 0; 
        else { 
            int lHeight = height(node.left); 
            int rHeight = height(node.right); 
            return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1); 
        } 
    }
*/


	// Function to find the maximum width of the tree using level order traversal 
	static int maxwidth(node root) { 
		// Base case 
		if (root == null) 
			return 0; 
		// Initialize result 
		int maxwidth = 0; 
		// Do Level order traversal keeping track of number of nodes at every level 
		Queue<node> q = new LinkedList<>(); 
		q.add(root); 
		while (!q.isEmpty()) { 
			// Get the size of queue when the level order traversal for one level finishes 
			int count = q.size(); 
			// Update the maximum node count value 
			maxwidth = Math.max(maxwidth, count); 
			// Iterate for all the nodes in  the queue currently 
			while (count-- > 0) { 
				// Dequeue an node from queue 
				node temp = q.remove(); 
				// Enqueue left and right children of dequeued node 
				if (temp.left != null) { 
					q.add(temp.left); 
				} 
				if (temp.right != null) { 
					q.add(temp.right); 
				} 
			} 
		} 
		return maxwidth; 
	} 
	
	
	// Function call 
	public static void main(String[] args) 
	{ 
		node root = new node(1); 
		root.left = new node(2); 
		root.right = new node(3); 
		root.left.left = new node(4); 
		root.left.right = new node(5); 
		root.right.right = new node(8); 
		root.right.right.left = new node(6); 
		root.right.right.right = new node(7); 

		        /*   
		        1 
		      /   \ 
		    2      3 
		  /  \      \ 
		 4    5      8 
		           /   \ 
		          6     7    */
		// Function call 
		System.out.println("Maximum width = "+ maxwidth(root)); 
	} 
} 


/*
Maximum width of a binary tree

Given a binary tree, write a function to get the maximum width of the given tree. 
Width of a tree is maximum of widths of all levels. 

Let us consider the below example tree.  

         1
        /  \
       2    3
     /  \     \
    4    5     8 
              /  \
             6    7

For the above tree, 
width of level 1 is 1, 
width of level 2 is 2, 
width of level 3 is 3 
width of level 4 is 2. 
So the maximum width of the tree is 3.*/