// Java program to print postorder 
// traversal from pre_orderorder and 
// inorder traversals 

//javac -d classes PostorderFromInorderPreorder.java  && cd classes && java PostorderFromInorderPreorder && cd ..

import java.util.Arrays; 

class PostorderFromInorderPreorder { 

   static int search(int[] in, int startIn, int endIn, int data) { 
        int i = 0; 
        for (i = startIn; i < endIn; i++)  
            if (in[i] == data)  
                return i;             
        return i; 
    } 

// Time complexity: O(n)
	static int preIndex = 0; 
    static void printPost(int[] in, int[] pre, int start, int end) {
    
        // System.out.println("\npreIndex: "+preIndex); 
        if (start > end)  
            return;         
        // Find index of next item in preorder traversal in inorder. 
        int index = search(in, start, end, pre[preIndex++]); 
        // traverse left tree 
        printPost(in, pre, start, index-1); 
        // traverse right tree 
        printPost(in, pre, index + 1, end); 
        // print root node at the end of traversal 
        System.out.print(in[index] + " "); 
    } 



	// Driver code 
	public static void main(String args[]) { 
		int in_order[] = { 4, 2, 5, 1, 3, 6 }; 
		int pre_order[] = { 1, 2, 4, 5, 3, 6 }; 
		//post_order=  4 5 2 6 3 1
		int len = in_order.length; 
		System.out.println("Postorder traversal " ); 
		printPost(in_order, pre_order, 0, len-1); 
		System.out.println(); 

		/*	    1
		      /    \    
		     2       3
		   /   \      \
		  4     5      6*/

	} 
} 


/*
Print Postorder traversal from given Inorder and pre_orderorder traversals

Given Inorder and pre_orderorder traversals of a binary tree, print Postorder traversal.

Example:

Input:
Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
pre_orderorder traversal pre_order[] = {1, 2, 4, 5, 3, 6}

Output:
Postorder traversal is {4, 5, 2, 6, 3, 1}
Trversals in the above example repre_ordersents following tree

         1
      /    \    
     2       3
   /   \      \
  4     5      6*/