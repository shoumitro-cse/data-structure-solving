// Sum of dependencies in a graph

// javac -d classes SumOfDependencies.java  && cd classes && java SumOfDependencies && cd ..

import java.util.Vector; 

class SumOfDependencies {

	// To add an edge 
	static void addEdge(Vector <Integer> adj[], int u, int v) { 
		adj[u].addElement((v)); 
	} 
	
	// find the sum of all dependencies 
	// Time complexity: O(V) where V is number of vertices in graph.
	static int findSum(Vector<Integer> adj[], int V) { 
		int sum = 0; 
		// just find the size at each vector's index 
		for (int u = 0; u < V; u++) 
			sum += adj[u].size(); 
		return sum; 
	} 
	
	// Driver method 
	public static void main(String[] args) {

		int V = 4; 
		@SuppressWarnings("unchecked") 
		Vector<Integer> adj[] = new Vector[V]; 
		
		for (int i = 0; i < adj.length; i++) { 
			adj[i] = new Vector<>(); 
		} 
		
		addEdge(adj, 0, 2); 
		addEdge(adj, 0, 3); 
		addEdge(adj, 1, 3); 
		addEdge(adj, 2, 3); 
	
		System.out.println("Sum of dependencies is " + findSum(adj, V)); 
	} 
} 


/*
Asked in : Flipkart Interview

Sum of dependencies in a graph


Given a directed and connected graph with n nodes. If there is an edge from u to v then u 
depends on v. Our task was to find out the sum of dependencies for every node.
 

(pic)

Example: 
For the graph in diagram, 
A depends on C and D i.e. 2 
B depends on C i.e. 1 
D depends on C i.e. 1 
And C depends on none. 
Hence answer -> 0 + 1 + 1 + 2 = 4
*/