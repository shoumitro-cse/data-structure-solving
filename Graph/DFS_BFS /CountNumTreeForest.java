// Count number of trees in a forest

//javac -d classes CountNumTreeForest.java  && cd classes && java CountNumTreeForest && cd ..

import java.io.*; 
import java.util.*; 

// This class represents a directed graph using adjacency list representation 
class Graph {

	private int V; // No. of vertices 

	// Array of lists for Adjacency List Representation 
	private LinkedList<Integer> adj[]; 

	// Constructor 
	@SuppressWarnings("unchecked") 
	Graph(int v) { 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList(); 
		}
	} 

	//Function to add an edge into the graph 
	void addEdge(int v, int w) { 
		adj[v].add(w); // Add w to v's list. 
	} 

	// A function used by DFS 
	void DFSUtil(int v,boolean visited[]) { 
		// Mark the current node as visited and print it 
		visited[v] = true; 
		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> i = adj[v].listIterator(); 
		while (i.hasNext()) { 
			int n = i.next(); 
			if (!visited[n]) { 
				DFSUtil(n,visited); 
			} 
		} 
	} 

	// The function to do DFS traversal. It uses recursive DFSUtil() 
	int countTrees() { 
		// Mark all the vertices as not visited(set as false by default in java) 
		boolean visited[] = new boolean[V]; 
		int res = 0; 
		
		// Call the recursive helper function to print DFS traversal 
		// starting from all vertices one by one 
		for (int i = 0; i < V; ++i) { 
			if (visited[i] == false) { 
				DFSUtil(i, visited); 
				res ++; 
			} 
		}

		return res; 
	} 

} 


class CountNumTreeForest {

	public static void main(String args[]) {

		Graph g = new Graph(5); 

		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(3, 4); 

		System.out.println(g.countTrees()); 
	} 

}


/*
Count number of trees in a forest


Given n nodes of a forest (collection of trees), find the number of trees in the forest.

Examples :

Input :  edges[] = {0, 1}, {0, 2}, {3, 4}
Output : 2

Explanation : There are 2 trees
                   0       3
                  / \       \
                 1   2       4
*/
