// Minimum edges to reverse to make path from a source to a destination


// javac -d classes  Graph.java  && cd classes && java Graph && cd ..

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Pair {
	int first, second;
	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}


// This class represents a directed Graph using adjacency list representation
class Graph {

	final int INF = (int)0x3f3f3f3f;
	// No. of vertices
	int V; 
	// In a weighted Graph, we need to store vertex
	// and weight pair for every edge
	List<Pair>[] adj;
	// Allocates memory for adjacency list
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		adj = new ArrayList[V];

		for(int i = 0; i < V; i++) {
			adj[i] = new ArrayList();
		}
	}

	// Fucntion adds a directed edge from
	// u to v with weight w
	void addEdge(int u, int v, int w) {
		adj[u].add(new Pair(v, w));
	}

	// Prints shortest paths from 
	// src to all other vertices
	int[] shortestPath(int src) {
		// Create a set to store vertices
		// that are being prerocessed
		Set setds = new HashSet();
		// Create a vector for distances and 
		// initialize all distances as infinite(INF)
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		// Insert source itself in Set and initialize
		// its distance as 0.
		setds.add(new Pair(0, src));
		dist[src] = 0;
		// Looping till all shortest distance are 
		// finalized then setds will become empty
		while (!setds.isEmpty()) {
			// The first vertex in Set is the minimum distance vertex, extract it from set.
			Iterator itr = setds.iterator();
			Pair tmp = (Pair) itr.next();
			itr.remove();
			// Vertex label is stored in second of pair (it
			// has to be done this way to keep the vertices
			// sorted distance (distance must be first item
			// in pair)
			int u = tmp.second;
			// 'i' is used to get all adjacent 
			// vertices of a vertex
			for(Pair p : adj[u]) {
				// Get vertex label and weight of
				// current adjacent of u.
				int v = p.first;
				int weight = p.second;

				// If there is shorter path to v through u.
				if (dist[v] > dist[u] + weight) {
					
					if (dist[v] != INF) {
						setds.remove(new Pair(dist[v], v));
					}
					// setds.erase(setds.find(new Pair(dist[v], v)));
					// Updating distance of v
					dist[v] = dist[u] + weight;
					setds.add(new Pair(dist[v], v));
				}
			}
		}
		return dist;
	}
	}

class MinEdgeReversalStoD {

	static final int INF = (int)0x3f3f3f3f;

	static Graph modelGraphWithEdgeWeight(int edge[][], int E, int V) {

		Graph g = new Graph(V);
		for(int i = 0; i < E; i++) {
			// Original edge : weight 0
			g.addEdge(edge[i][0], edge[i][1], 0);
			// Reverse edge : weight 1
			g.addEdge(edge[i][1], edge[i][0], 1);
		}
		return g;
	}

	// Function returns minimum number of edges to be
	// reversed to reach from src to dest
	static int getMinEdgeReversal(int edge[][], int E, int V, int src, int dest) {
		// Get modified Graph with edge weight
		Graph g = modelGraphWithEdgeWeight(edge, E, V);
		// Get shortes path vector
		int[] dist = g.shortestPath(src);
		// If distance of destination is still INF,
		// not possible
		if (dist[dest] == INF)
			return -1;
		else
			return dist[dest];
	}

	// Driver code 
	public static void main(String[] args) {

		int V = 7;
		int edge[][] = { 
			             { 0, 1 }, 
			             { 2, 1 },
						 { 2, 3 }, 
						 { 5, 1 }, 
						 { 4, 5 }, 
						 { 6, 4 }, 
						 { 6, 3 } 
					   };
		int E = edge.length;

		int minEdgeToReverse = getMinEdgeReversal(edge, E, V, 0, 6);
		
		if (minEdgeToReverse != -1)
			System.out.println(minEdgeToReverse);
		else
			System.out.println("Not possible");
	}
}

/*

Minimum edges to reverse to make path from a source to a destination

Given a directed graph and a source node and destination node, we need to find how many edges we need to reverse in order to make at least 1 path from source node to destination node.

Examples:  

(pic)

In above graph there were two paths from node 0 to node 6,
0 -> 1 -> 2 -> 3 -> 6
0 -> 1 -> 5 -> 4 -> 6
But for first path only*/