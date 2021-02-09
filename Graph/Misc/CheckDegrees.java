// Check whether given degrees of vertices represent a Graph or Tree

class CheckDegrees { 

	// Function returns true for tree false for graph 
	static boolean check(int degree[], int n) { 
		// Find sum of all degrees 
		int deg_sum = 0; 
		for (int i = 0; i < n; i++) { 
			deg_sum += degree[i]; 
		} 
		// Graph is tree if sum is equal to 2(n-1) 
		return (2 * (n - 1) == deg_sum); 
	} 


	public static void main(String[] args) { 
		int n = 5; 
		int degree[] = {2, 3, 1, 1, 1}; 

		if (check(degree, n)) { 
			System.out.println("Tree"); 
		} else { 
			System.out.println("Graph"); 
		} 
	} 

} 


/*
Check whether given degrees of vertices represent a Graph or Tree


Given the number of vertices and the degree of each vertex where vertex numbers are 1, 2, 3,…n. 
The task is to identify whether it is a graph or a tree. It may be assumed that the graph is 
connected.

Examples:

Input : 5
        2 3 1 1 1
Output : Tree
Explanation : The input array indicates that 
              vertex one has degree 2, vertex
              two has degree 3, vertices 3, 4 
              and 5 have degree 1.  
            1
           / \
          2   3
         / \
        4   5


Input : 3
        2 2 2
Output : Graph      
            1
           / \
          2 - 3*/