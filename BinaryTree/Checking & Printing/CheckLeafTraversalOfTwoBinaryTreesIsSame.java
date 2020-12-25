//Check if leaf traversal of two Binary Trees is same?

//javac -d classes CheckLeafTraversalOfTwoBinaryTreesIsSame.java  && cd classes && java CheckLeafTraversalOfTwoBinaryTreesIsSame && cd ..


import java.util.*; 
import java.lang.*; 
import java.io.*; 

// Binary Tree node 
class Node { 
	int data; 
	Node left, right; 
	public Node(int x) { 
		data = x; 
		left = right = null; 
	} 

	public boolean isLeaf() { 
		return (left == null && right == null); 
	} 
} 

class CheckLeafTraversalOfTwoBinaryTreesIsSame {
 
	// Expected time complexity O(n). 
	// Expected auxiliary space O(h1 + h2) where h1 and h2 are heights of two Binary Trees.
	public static boolean isSame(Node root1, Node root2) { 
		// Create empty stacks. These stacks are going 
		// to be used for iterative traversals. 
		Stack<Node> s1 = new Stack<Node>(); 
		Stack<Node> s2 = new Stack<Node>(); 

		s1.push(root1); 
		s2.push(root2); 

		// Loop until either of two stacks is not empty 
		while (!s1.empty() || !s2.empty()) { 

			// If one of the stacks is empty means other stack has extra leaves so return false 
			if (s1.empty() || s2.empty()) 
				return false; 

			Node temp1 = s1.pop(); 
			while (temp1 != null && !temp1.isLeaf()) { 
		       // Push right and left children of temp1.Note that right child is inserted before left 
				if (temp1.right != null) 
					s1.push(temp1.right); 
				if (temp1.left != null) 
					s1.push(temp1.left); 
				temp1 = s1.pop(); 
			} 

			// same for tree2 
			Node temp2 = s2.pop(); 
			while (temp2 != null && !temp2.isLeaf()) 
			{ 
				if (temp2.right != null) 
					s2.push(temp2.right); 
				if (temp2.left != null) 
					s2.push(temp2.left); 
				temp2 = s2.pop(); 
			} 
			// If one is null and other is not, then return false 
			if (temp1 == null && temp2 != null) 
				return false; 
			if (temp1 != null && temp2 == null) 
				return false; 
			// If both are not null and data is not same return false 
			if (temp1 != null && temp2 != null) { 
				if (temp1.data != temp2.data) 
					return false; 
			} 

			// System.out.println(temp1.data+" "+temp2.data);
		} 
		// If control reaches this point, all leaves are matched 
		return true; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		// Let us create trees in above example 1 
		Node root1 = new Node(1); 
		root1.left = new Node(2); 
		root1.right = new Node(3); 
		root1.left.left = new Node(4); 
		root1.right.left = new Node(6); 
		root1.right.right = new Node(7); 

		/*		 1            
		        / \
		       2   3      
		      /   / \          
		     4   6   7*/

		Node root2 = new Node(0); 
		root2.left = new Node(1); 
		root2.right = new Node(5); 
		root2.left.right = new Node(4); 
		root2.right.left = new Node(6); 
		root2.right.right = new Node(7); 

		/*		  0
		        /   \
		       5     8      
		        \   / \        
		        4   6  7*/

		if (isSame(root1, root2)) 
			System.out.println("Same"); 
		else
			System.out.println("Not Same"); 
	} 
}


/*
Check if leaf traversal of two Binary Trees is same?

Leaf traversal is sequence of leaves traversed from left to right. The problem is to check 
if leaf traversals of two given Binary Trees are same or not.
Expected time complexity O(n). Expected auxiliary space O(h1 + h2) where h1 and h2 are heights 
of two Binary Trees.

Examples: 

Input: Roots of below Binary Trees
         1            
        / \
       2   3      
      /   / \          
     4   6   7

          0
        /   \
       5     8      
        \   / \        
        4   6  7
Output: same
Leaf order traversal of both trees is 4 6 7     

Input: Roots of below Binary Trees
         0            
        / \
       1   2       
      / \       
     8   9   

         1
        / \
       4   3     
        \ / \        
        8 2  9

Output: Not Same
Leaf traversals of two trees are different.
For first, it is 8 9 2 and for second it is 8 2 9


Algorithm:

1. Create empty stacks stack1 and stack2 
   for iterative traversals of tree1 and tree2

2. insert (root of tree1) in stack1
   insert (root of tree2) in stack2

3. Stores current leaf nodes of tree1 and tree2
temp1 = (root of tree1) 
temp2 = (root of tree2)  

4. Traverse both trees using stacks
while (stack1 and stack2 parent empty) 
{
    // Means excess leaves in one tree
    if (if one of the stacks are empty)   
    return false

   // get next leaf node in tree1 
   temp1 = stack1.pop()
   while (temp1 is not leaf node) 
   {
        push right child to stack1     
    push left child to stack1
   }

   // get next leaf node in tree2     
   temp2 = stack2.pop()
   while (temp2 is not leaf node) 
   {
        push right child to stack2      
    push left child to stack2
   }

   // If leaves do not match return false
   if (temp1 != temp2)                  
       return false
}

5. If all leaves matched, return true


*/