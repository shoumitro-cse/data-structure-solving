//print all root to leaf paths 
//Given a binary tree, print out all of its root-to-leaf paths one per line.
 
 //javac -d classes PrintRootToLeafPaths.java  && cd classes && java PrintRootToLeafPaths && cd ..  

class Node  
{ 
    int data; 
    Node left, right; 
   
    Node(int item)  
    { 
        data = item; 
        left = right = null; 
    } 
} 
   
class PrintRootToLeafPaths  
{ 
     Node root; 
       
     // Given a binary tree, print out all of its root-to-leaf 
       // paths, one per line. Uses a recursive helper to do the work.
    void printPaths(Node node)  { 
        int path[] = new int[1000]; 
        printPathsRecur(node, path, 0); 
    } 
   
   // Time Complexity: O(n2) where n is number of nodes.
    void printPathsRecur(Node node, int path[], int pathLen)  { 
        if (node == null) 
            return; 
         // append this node to the path array 
        path[pathLen] = node.data; 
        pathLen++; 
         // it's a leaf, so print the path that led to here 
        if (node.left == null && node.right == null) {
            printArray(path, pathLen); 
        } else {  
             // otherwise try both subtrees 
            printPathsRecur(node.left, path, pathLen); 
            printPathsRecur(node.right, path, pathLen); 
        } 
    } 
   
     // Utility that prints out an array on a line 
    void printArray(int ints[], int len) { 
        int i; 
        for (i = 0; i < len; i++)  {
            System.out.print(ints[i] + " "); 
        }
        System.out.println(""); 
    } 
   
    public static void main(String[] args)  {

        PrintRootToLeafPaths tree = new PrintRootToLeafPaths(); 
   
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 

        /*       1
                / \
               2   3
              / \ 
             4   5  */
   
         // Print all root-to-leaf paths of the input tree 
        tree.printPaths(tree.root); 
   
    } 
} 

/*
output:
     1 2 4 
     1 2 5 
     1 3 
*/


/*
Algorithm:

initialize: pathlen = 0, path[1000] 
// 1000 is some max limit for paths, it can change

// printPathsRecur traverses nodes of tree in preorder 
printPathsRecur(tree, path[], pathlen)
   1) If node is not NULL then 
         a) push data to path array: 
                path[pathlen] = node->data.
         b) increment pathlen 
                pathlen++
   2) If node is a leaf node then print the path array.
   3) Else
        a) Call printPathsRecur for left subtree
                 printPathsRecur(node->left, path, pathLen)
        b) Call printPathsRecur for right subtree.
                printPathsRecur(node->right, path, pathLen)*/