// Shortest path in an unweighted graph

// javac -d classes  ShortestPathUnweightedGraph.java  && cd classes && java ShortestPathUnweightedGraph && cd ..


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ShortestPathUnweightedGraph {

	public static void main(String args[]) {
		// No of vertices
		int v = 8;
		// Adjacency list for storing which vertices are connected
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}

		// Creating graph given in the above diagram.
		// add_edge function takes adjacency list, source
		// and destination vertex as argument and forms
		// an edge between them.
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 3);
		addEdge(adj, 1, 2);
		addEdge(adj, 3, 4);
		addEdge(adj, 3, 7);
		addEdge(adj, 4, 5);
		addEdge(adj, 4, 6);
		addEdge(adj, 4, 7);
		addEdge(adj, 5, 6);
		addEdge(adj, 6, 7);

		int source = 0, dest = 7;
		printShortestDistance(adj, source, dest, v);
		System.out.println();

	}

	// function to form edge between two vertices source and dest
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
		adj.get(i).add(j);
		adj.get(j).add(i);
	}

	// function to print the shortest distance and path
	// between source vertex and destination vertex
	private static void printShortestDistance(ArrayList<ArrayList<Integer>> adj,
							int s, int dest, int v) {
		// predecessor[i] array stores predecessor of
		// i and distance array stores distance of i from s
		int pred[] = new int[v];
		int dist[] = new int[v];

		if (BFS(adj, s, dest, v, pred, dist) == false) {
			System.out.println("Given source and destination are not connected");
			return;
		}

		// LinkedList to store path
		LinkedList<Integer> path = new LinkedList<Integer>();
		int crawl = dest;
		
		path.add(crawl);

		while (pred[crawl] != -1) {
			path.add(pred[crawl]);
			crawl = pred[crawl];
		}

		// Print distance
		System.out.println("Shortest path length is: " + dist[dest]);

		// Print path
		System.out.print("Path is :: ");
		for (int i = path.size() - 1; i >= 0; i--) {
			System.out.print(path.get(i) + " ");
		}
	}


	private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src,
								int dest, int v, int pred[], int dist[]) {

		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[v];
		for (int i = 0; i < v; i++) {
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}

		// now source is first to be visited and distance from source to itself should be 0
		visited[src] = true;
		dist[src] = 0;
		queue.add(src);

		// bfs Algorithm
		while (!queue.isEmpty()) {
			
			int u = queue.remove();

			for (int i = 0; i < adj.get(u).size(); i++) {
			
				if (visited[adj.get(u).get(i)] == false) {

					visited[adj.get(u).get(i)] = true;
					dist[adj.get(u).get(i)] = dist[u] + 1;
					pred[adj.get(u).get(i)] = u;
					
					queue.add(adj.get(u).get(i));

					// stopping condition (when we find our destination)
					if (adj.get(u).get(i) == dest) {
						return true;
					}
				}
			}
		}
		return false;
	}
}


/*
Shortest path in an unweighted graph

Given an unweighted graph, a source, and a destination, we need to find the shortest path 
from source to destination in the graph in the most optimal way.

(pic) 

unweighted graph
unweighted graph of 8 vertices 

Input: source vertex = 0 and destination vertex is = 7.
Output: Shortest path length is:2
        Path is::
        0 3 7

Input: source vertex is = 2 and destination vertex is = 6.
Output: Shortest path length is:5
        Path is::
        2 1 0 3 4 6
*/