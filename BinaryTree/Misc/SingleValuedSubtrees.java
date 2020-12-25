//Find Count of Single Valued Subtrees

//javac -d classes SingleValuedSubtrees.java  && cd classes && java SingleValuedSubtrees && cd ..

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int item) { 
        data = item; 
        left = right = null; 
    } 
} 
   
class Count { 
    int count = 0; 
} 
   
class SingleValuedSubtrees  
{ 
    Node root;   
    Count ct = new Count(); 
       
    // This function increments count by number of single  
    // valued subtrees under root. It returns true if subtree  
    // under root is Singly, else false. 
    boolean countSingleRec(Node node, Count c)  { 
        // Return false to indicate NULL 
        if (node == null) 
            return true; 
        // Recursively count in left and right subtrees also 
        boolean left = countSingleRec(node.left, c); 
        boolean right = countSingleRec(node.right, c); 
        // If any of the subtrees is not singly, then this cannot be singly. 
        if (left == false || right == false) 
            return false; 
        // If left subtree is singly and non-empty, but data doesn't match 
        if (node.left != null && node.data != node.left.data) 
            return false; 
        // Same for right subtree 
        if (node.right != null && node.data != node.right.data) 
            return false;
        // If none of the above conditions is true, then 
        // tree rooted under root is single valued, increment count and return true. 
        c.count++; 
        return true; 
    } 
   
    // This function mainly calls countSingleRec() 
    // after initializing count as 0 
    int countSingle()  
    { 
        return countSingle(root); 
    } 
   
    int countSingle(Node node)  
    { 
        // Recursive function to count 
        // System.out.println(countSingleRec(node, ct)); 
        countSingleRec(node, ct); 
        return ct.count; 
    } 
   
    public static void main(String args[])  {
     
        SingleValuedSubtrees tree = new SingleValuedSubtrees(); 
        tree.root = new Node(5); 
        tree.root.left = new Node(4); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(4); 
        tree.root.right.right = new Node(5); 
   
           /* 
                5 
              /   \ 
            4      5 
          /  \      \ 
         4    4      5 */

        System.out.println("\n\nThe count of single valued sub trees is : " + tree.countSingle()); 
    } 
} 

/*
Find Count of Single Valued Subtrees

Given a binary tree, write a program to count the number of Single Valued Subtrees. 
A Single Valued Subtree is one in which all the nodes have same value. 
Expected time complexity is O(n).

Example:

Input: root of below tree
              5
             / \
            1   5
           / \   \
          5   5   5
Output: 4
There are 4 subtrees with single values.


Input: root of below tree
              5
             / \
            4   5
           / \   \
          4   4   5                
Output: 5
There are five subtrees with single values.*/