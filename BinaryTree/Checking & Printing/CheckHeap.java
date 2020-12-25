//Given level order traversal of a Binary Tree, check if the Tree is a Min-Heap


// javac -d classes CheckHeap.java  && cd classes && java CheckHeap && cd ..

import java.io.*; 
import java.util.*; 

public class CheckHeap 
{ 
	// Returns true if given level order traversal is Min Heap. 
	//These algorithms run with worse case O(n) complexity
	static boolean isMinHeap(int [] level) { 

		int n = level.length-1; 
		// First non leaf node is at index (n/2-1). 
		// Check whether each parent is greater than child 
		for (int i=(n/2-1) ; i>=0 ; i--) { 
			// Left child will be at index 2*i+1 
			// Right child will be at index 2*i+2 
			if (level[i] > level[2*i+1]) 
				return false; 

			if (2*i+2 < n) { 
				// If parent is greater than right child 
				if (level[i] > level[2*i+2]) 
				return false; 
			} 
		} 
		return true; 
	} 

	// Driver code 
	public static void main(String[] args) throws IOException {

		// Level order traversal 
		int[] level = new int[]{10, 15, 14, 25, 30}; 

		/*		 10
		        /  \
		       15   14
		      /  \
		     25   30*/

		if (isMinHeap(level)) 
			System.out.println("\n\nTrue"); 
		else
			System.out.println("\n\nFalse"); 
	} 
}


/*
Given level order traversal of a Binary Tree, check if the Tree is a Min-Heap

Given the level order traversal of a Complete Binary Tree, determine whether the Binary Tree 
is a valid Min-Heap

Examples:

Input : level = [10, 15, 14, 25, 30]
Output : True
The tree of the given level order traversal is
                     10
                    /  \
                   15   14
                  /  \
                 25   30
We see that each parent has a value less than
its child, and hence satisfies the min-heap 
property
 
Input : level = [30, 56, 22, 49, 30, 51, 2, 67]
Output : False
The tree of the given level order traversal is
                         30
                      /      \
                    56         22
                 /      \     /   \
               49        30  51    2
              /
             67
We observe that at level 0, 30 > 22, and hence
min-heap property is not satisfied*/