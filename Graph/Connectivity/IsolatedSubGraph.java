// Count single node isolated sub-graphs in a disconnected graph

// javac -d classes  IsolatedSubGraph.java  && cd classes && java IsolatedSubGraph && cd ..

import java.util.*; 

class IsolatedSubGraph {

	// Function to compute the count 
	static int compute(int [] graph, int N) { 
		// Storing intermediate result 
		int count = 0; 
		// Traversing the Nodes 
		for (int i = 1; i < 7; i++) { 
			// Singleton component 
			if (graph[i] == 0) {
				count++;	 
			}
		} 			
		// Returning the result 
		return count; 
	} 

	public static void main(String[] args) { 
		// Number of nodes 
		int N = 6; 
		// Adjacency list for edges 1..6 
		int [] graph = new int[7]; 
		// Representing edges 
		graph[1] = 2; 
		graph[2] = 1; 
		graph[2] = 3; 
		graph[3] = 2; 
		graph[5] = 6; 
		graph[6] = 5; 
		System.out.println(compute(graph, N)); 
	} 
} 

/*Count single node isolated sub-graphs in a disconnected graph


A disconnected Graph with N vertices and K edges is given. The task is to find the count of singleton sub-graphs. A singleton graph is one with only single vertex.

Examples:

Input : 
Vertices : 6
Edges :    1 2
           1 3
           5 6
Output : 1
Explanation :  The Graph has 3 components : {1-2-3}, {5-6}, {4}
Out of these, the o*/