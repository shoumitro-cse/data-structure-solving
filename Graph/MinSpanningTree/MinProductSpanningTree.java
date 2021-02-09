// Minimum Product Spanning Tree

// javac -d classes  MinProductSpanningTree.java  && cd classes && java MinProductSpanningTree && cd ..


import java.util.*;

class MinProductSpanningTree {
	// Number of vertices in the graph
	static int V = 5;
	// A utility function to find the vertex with minimum
	// key value, from the set of vertices not yet included in MST
	static int minKey(int key[], boolean[] mstSet) {
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = 0;
		for (int v = 0; v < V; v++) {
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		}
		return min_index;
	}

	// A utility function to print the constructed MST
	// stored in parent[] and print Minimum Obtaiable product
	static void printMST(int parent[], int n, int graph[][]) {

		System.out.printf("Edge Weight\n");
		int minProduct = 1;
		
		for (int i = 1; i < V; i++) {
			System.out.printf("%d - %d %d \n", parent[i], i, graph[i][parent[i]]);
			minProduct *= graph[i][parent[i]];
		}

		System.out.printf("Minimum Obtainable product is %d\n", minProduct);
	}


	static void primMST(int inputGraph[][], double logGraph[][]) {

		int[] parent = new int[V]; // Array to store constructed MST
		int[] key = new int[V]; // Key values used to pick minimum
		
		// weight edge in cut
		boolean[] mstSet = new boolean[V]; // To represent set of vertices not
		// yet included in MST

		// Initialize all keys as INFINITE
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		// Always include first 1st vertex in MST.
		key[0] = 0; // Make key 0 so that this vertex is
		
		// picked as first vertex
		parent[0] = -1; // First node is always root of MST

		// The MST will have V vertices
		for (int count = 0; count < V - 1; count++) {
			// Pick the minimum key vertex from the set of vertices not yet included in MST
			int u = minKey(key, mstSet);
			// Add the picked vertex to the MST Set
			mstSet[u] = true;

			for (int v = 0; v < V; v++) { 
			  if (logGraph[u][v] > 0 && mstSet[v] == false && logGraph[u][v] < key[v]) {
				 parent[v] = u;
				 key[v] = (int)logGraph[u][v];
			   }
			}
		}

		// print the constructed MST
		printMST(parent, V, inputGraph);
	}

	// Method to get minimum product spanning tree
	static void minimumProductMST(int graph[][]) {

		double[][] logGraph = new double[V][V];

		// Constructing logGraph from original graph
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (graph[i][j] > 0) {
					logGraph[i][j] = Math.log(graph[i][j]);
				} else {
					logGraph[i][j] = 0;
				}
			}
		}

		// Applyting standard Prim's MST algorithm on Log graph.
		primMST(graph, logGraph);
	}

	// Driver code
	public static void main(String[] args) {

		int graph[][] = {

			{ 0, 2, 0, 6, 0 },
			{ 2, 0, 3, 8, 5 },
			{ 0, 3, 0, 0, 7 },
			{ 6, 8, 0, 0, 9 },
			{ 0, 5, 7, 9, 0 },
		};

		// Print the solution
		minimumProductMST(graph);
	}
}

/*
Minimum Product Spanning Tree

Given a connected and undirected graph, a spanning tree of that graph is a subgraph that is a tree and connects all the vertices together. A single graph can have many different spanning trees. A minimum product spanning tree for a weighted, connected and undirected graph is a spanning tree with weight product less than or equal to the weight product of every other spanning tree. The weight product of a spanning tree is the product of weights corresponding to each edge of the spanning tree. All weights of the given graph will be positive for simplicity.

Examples: (pic)


Minimum Product that we can obtain is 
180 for above graph by choosing edges 
0-1, 1-2, 0-3 and 1-4*/