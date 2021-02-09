// Count all possible paths between two vertices

//javac -d classes AllPathsBetn2Vertices.java  && cd classes && java AllPathsBetn2Vertices && cd ..

import java.util.Arrays; 
import java.util.Iterator; 
import java.util.LinkedList; 

// This class represents a directed graph using 
// adjacency list representation 
class Graph { 
	// No. of vertices 
	private int V; 
	// Array of lists for Adjacency List Representation 
	private LinkedList<Integer> adj[]; 

	@SuppressWarnings("unchecked") 
	Graph(int v) { 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<>(); 
		}
	} 

	// Method to add an edge into the graph 
	void addEdge(int v, int w) { 
		// Add w to v's list. 
		adj[v].add(w); 
	} 

	// A recursive method to count all paths from 'u' to 'd'. 
	int countPathsUtil(int u, int d, int pathCount) { 
		// If current vertex is same as destination, then increment count 
		if (u == d) { 
			pathCount++; 
		} else { 
		  // Recur for all the vertices adjacent to this vertex 
			Iterator<Integer> i = adj[u].listIterator(); // [1,2,3]
			while (i.hasNext()) { 
				int n = i.next(); 
				pathCount = countPathsUtil(n, d, pathCount); 
			} 
		} 
		return pathCount; 
	} 

	// Returns count of paths from 's' to 'd' 
	int countPaths(int s, int d) { 
		// Call the recursive method to count all paths 
		int pathCount = 0; 
		pathCount = countPathsUtil(s, d, pathCount); 
		return pathCount; 
	} 

} 


class AllPathsBetn2Vertices {

	public static void main(String args[]) { 

		Graph g = new Graph(5); 
		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(0, 3); 
		g.addEdge(1, 3); 
		g.addEdge(2, 3); 
		g.addEdge(1, 4); 
		g.addEdge(2, 4); 

		int s = 0, d = 3; 
		System.out.println(g.countPaths(s, d)); 
	} 

}


/*
Count all possible paths between two vertices

Count the total number of ways or paths that exist between two vertices in a directed graph. These paths don’t contain a cycle, the simple enough reason is that a cycle contains an infinite number of paths and hence they create a problem.

Examples:

For the following Graph: (pic is available in computer)

  
Input: Count paths between A and E
Output : Total paths between A and E are 4
Explanation: The 4 paths between A and E are:
                      A -> E
                      A -> B -> E
                      A -> C -> E
                      A -> B -> D -> C -> E 

Input : Count paths between A and C
Output : Total paths between A and C are 2
Explanation: The 2 paths between A and C are:
                      A -> C
                      A -> B -> D -> C*/