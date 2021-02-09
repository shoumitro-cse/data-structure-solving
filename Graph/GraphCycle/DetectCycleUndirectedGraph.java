// A Java Program to detect cycle in an undirected graph 

// javac -d classes DetectCycleUndirectedGraph.java  && cd classes && java DetectCycleUndirectedGraph && cd ..

import java.io.*; 
import java.util.*; 

// This class represents a directed graph using adjacency list representation 

class DetectCycleUndirectedGraph { 
	// No. of vertices 
	private int V; 
	// Adjacency List Represntation 
	private LinkedList<Integer> adj[]; 

	// Constructor 
	DetectCycleUndirectedGraph(int v) { 
		V = v; 
		adj = new LinkedList[v]; 
		for(int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	// Function to add an edge into the graph 
	void addEdge(int v,int w) { 
		adj[v].add(w); 
		adj[w].add(v); 
	} 

 
	Boolean isCyclicUtil(int v, Boolean visited[], int parent) { 
		// Mark the current node as visited 
		visited[v] = true; 
		Integer i; 
		Iterator<Integer> it = adj[v].iterator(); 
		while (it.hasNext()) { 
			i = it.next(); 
			if (!visited[i]) { 
				if (isCyclicUtil(i, visited, v)) 
					return true; 
			} else if (i != parent) {
				return true; 
			}
		} 
		return false; 
	} 

	// Returns true if the graph contains a cycle, else false. 
	Boolean isCyclic() { 

		Boolean visited[] = new Boolean[V]; 
		
		for (int i = 0; i < V; i++) 
			visited[i] = false; 

		for (int u = 0; u < V; u++) { 
			// Don't recur for u if already visited 
			if (!visited[u]) 
				if (isCyclicUtil(u, visited, -1)) 
					return true; 
		} 

		return false; 
	} 


	public static void main(String args[]) {

		// Create a graph given in the above diagram 
		DetectCycleUndirectedGraph g1 = new DetectCycleUndirectedGraph(5); 
		g1.addEdge(1, 0); 
		g1.addEdge(0, 2); 
		g1.addEdge(2, 1); 
		g1.addEdge(0, 3); 
		g1.addEdge(3, 4); 

		if (g1.isCyclic()) 
			System.out.println("Graph contains cycle"); 
		else
			System.out.println("Graph doesn't contains cycle"); 

		DetectCycleUndirectedGraph g2 = new DetectCycleUndirectedGraph(3); 
		g2.addEdge(0, 1); 
		g2.addEdge(1, 2); 
		if (g2.isCyclic()) 
			System.out.println("Graph contains cycle"); 
		else
			System.out.println("Graph doesn't contains cycle"); 
	} 
} 
