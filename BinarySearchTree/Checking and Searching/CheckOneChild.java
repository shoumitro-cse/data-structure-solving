// Check if each internal node of BST has only one child 

class CheckOneChild { 

	boolean hasOnlyOneChild(int pre[], int size) { 
		int nextDiff, lastDiff; 

		for (int i = 0; i < size - 1; i++) { 
			nextDiff = pre[i] - pre[i + 1]; 
			lastDiff = pre[i] - pre[size - 1]; 
			if (nextDiff * lastDiff < 0) { 
				return false; 
			}; 
		} 
		return true; 
	} 

	public static void main(String[] args) { 
		CheckOneChild tree = new CheckOneChild(); 
		int pre[] = new int[]{8, 3, 5, 7, 6}; 
		int size = pre.length; 
		if (tree.hasOnlyOneChild(pre, size) == true) { 
			System.out.println("Yes"); 
		} else { 
			System.out.println("No"); 
		} 
	} 
} 


/*
Check if each internal node of a BST has exactly one child

Given Preorder traversal of a BST, check if each non-leaf node has only one child. Assume that the BST contains unique entries.
Examples

Input: pre[] = {20, 10, 11, 13, 12}
Output: Yes
The give array represents following BST. In the following BST, every internal
node has exactly 1 child. Therefor, the output is true.
        20
       /
      10
       \
        11
          \
           13
           /
         12*/