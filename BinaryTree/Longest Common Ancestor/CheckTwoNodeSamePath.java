// Check if two nodes are on same path in a tree | Set 2

//javac -d classes CheckTwoNodeSamePath.java  && cd classes && java CheckTwoNodeSamePath && cd ..

class CheckTwoNodeSamePath { 

	// Function to filter 
	// the return Values 
	static int filter(int x, int y, int z) 
	{ 
		if (x != -1 && y != -1) 
		{ 
			return z; 
		} 
		return x == -1 ? y : x; 
	} 

	// Utility function to check if nodes 
	// are on same path or not 
	static int samePathUtil(int mtrx[][], int vrtx, int v1, int v2, int i) { 
		int ans = -1; 

		// Condition to check 
		// if any vertex 
		// is equal to given two 
		// vertex or not 
		if (i == v1 || i == v2) 
			return i; 

		for(int j = 0; j < vrtx; j++) { 
			// Check if the current position has 1 
			if (mtrx[i][j] == 1) { 
				// Recursive call 
				ans = filter(ans, samePathUtil( mtrx, vrtx, v1, v2, j), i); 
			} 
		} 

		// Return LCA 
		return ans; 
	} 

	// Function to check if nodes 
	// lies on same path or not 
	static boolean isVertexAtSamePath(int mtrx[][], int vrtx, int v1, int v2, int i) { 

		int lca = samePathUtil(mtrx, vrtx, v1 - 1, v2 - 1, i); 
											
		if (lca == v1 - 1 || lca == v2 - 1) 
			return true; 

		return false; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		int vrtx = 7; 
		int mtrx[][] = { { 0, 1, 1, 1, 0, 0, 0 }, 
						{ 0, 0, 0, 0, 1, 0, 0 }, 
						{ 0, 0, 0, 0, 0, 1, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 1 }, 
						{ 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 0 } }; 

		int v1 = 1, v2 = 5; 

		if (isVertexAtSamePath(mtrx, vrtx, 
							v1, v2, 0)) 
			System.out.print("Yes"); 
		else
			System.out.print("No"); 
	} 
} 

/*Check if two nodes are on same path in a tree | Set 2


Given two nodes of a binary tree v1 and v2, the task is to check if two nodes 
are on the same path in a tree. 
Example: 

Input:  v1 = 1, v2 = 5
       1
    /  |  \
   2   3   4
  /    |    \
 5     6     7
 
Output: Yes
Explanation:
Both nodes 1 and 5
lie in the path 1 -> 2 -> 5.

Input: v1 = 2, v2 = 6
       1
    /  |  \
   2   3   4
  /    |    \
 5     6     7

Output: NO*/