//Possible edges of a tree for given diameter, height and vertices

//javac -d classes PossibleEdges.java  && cd classes && java PossibleEdges && cd ..

class PossibleEdges { 

	// Function to construct the tree 
	static void constructTree(int n, int d, int h) 
	{ 
		if (d == 1) { 

			// Special case when d == 2, only one edge 
			if (n == 2 && h == 1) { 
				System.out.println("1 2"); 
				return; 
			} 
			System.out.println("-1"); // Tree is not possible 
			return; 
		} 

		if (d > 2 * h) { 
			System.out.println("-1"); 
			return; 
		} 

		// Satisfy the height condition by add 
		// edges up to h 
		for (int i = 1; i <= h; i++)	 
			System.out.println(i + " " + (i + 1)); 
		
		if (d > h) { 
			// Add d - h edges from 1 to 
			// satisfy diameter condition 
			System.out.println("1" + " " + (h + 2)); 
			for (int i = h + 2; i <= d; i++) { 
				System.out.println(i + " " + (i + 1)); 
			} 
		} 

		// Remaining edges at vertex 1 or 2(d == h) 
		for (int i = d + 1; i < n; i++) 
		{ 
			int k = 1; 
			if (d == h) 
				k = 2; 
			System.out.println(k + " " + (i + 1)); 
		} 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
		int n = 5, d = 3, h = 2; 
		constructTree(n, d, h); 
	} 
} 


/*Possible edges of a tree for given diameter, height and vertices

Find a tree with the given values and print the edges of the tree. 
Print “-1”, if the tree is not possible.

Given three integers n, d and h.

n -> Number of vertices. [1, n]
d -> Diameter of the tree (largest distance between two vertices).
h -> Height of the tree (longest distance between vertex 1 and another vertex)

Examples :

Input : n = 5, d = 3, h = 2 
Output : 1 2
         2 3
         1 4
         1 5
Explanation :  

       1
    /  |  \
   2   4   5
  /
 3  */