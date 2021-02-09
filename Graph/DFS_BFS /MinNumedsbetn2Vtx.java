// Minimum number of edges between two vertices of a Graph

// javac -d classes MinNumedsbetn2Vtx.java  && cd classes && java MinNumedsbetn2Vtx && cd ..

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

class MinNumedsbetn2Vtx {

	// Method for finding minimum no. of edge using BFS
	static int minEdgeBFS(Vector <Integer> edges[], int u, int v, int n) {
	
		// visited[n] for keeping track of visited node in BFS
		Vector<Boolean> visited = new Vector<Boolean>(n);
		
		for (int i = 0; i < n; i++) {
			visited.addElement(false);
		}
	
		// Initialize distances as 0
		Vector<Integer> distance = new Vector<Integer>(n);
		
		for (int i = 0; i < n; i++) {
			distance.addElement(0);
		}
	
		// queue to do BFS.
		Queue<Integer> Q = new LinkedList<>();
		distance.setElementAt(0, u);
	
		Q.add(u);
		visited.setElementAt(true, u);
		
		while (!Q.isEmpty()) {

			int x = Q.poll();
	
			for (int i=0; i<edges[x].size(); i++) {

				if (visited.elementAt(edges[x].get(i))) {
					continue;
				}
				// update distance for i
				distance.setElementAt(distance.get(x) + 1, edges[x].get(i));
				  Q.add(edges[x].get(i));
				visited.setElementAt(true, edges[x].get(i));
			}
		}

		return distance.get(v);
	}
	
	// method for addition of edge
	static void addEdge(Vector <Integer> edges[], int u, int v) {
	   edges[u].add(v);
	   edges[v].add(u);
	}


	@SuppressWarnings("unchecked")
	public static void main(String args[]) {

		// To store adjacency list of graph
		int n = 9;
		Vector <Integer> edges[] = new Vector[9];
		
		for (int i = 0; i < edges.length; i++) {
		  edges[i] = new Vector<>();
		}
		
		addEdge(edges, 0, 1);
		addEdge(edges, 0, 2);
		addEdge(edges, 0, 4);
		addEdge(edges, 2, 5);
		addEdge(edges, 2, 1);
		addEdge(edges, 4, 3);
		addEdge(edges, 4, 5);
		addEdge(edges, 4, 6);
		
		int u = 1;
		int v = 5;
		
		System.out.println(minEdgeBFS(edges, u, v, n));

	}
}


/*
Minimum number of edges between two vertices of a Graph

You are given a undirected graph G(V, E) with N vertices and M edges. We need to find the 
minimum number of edges between a given pair of vertices (u, v).

Examples:(pic) 

Input : For given graph G. Find minimum number
        of edges between (1, 5).


Output : 2
Explanation: (1, 2) and (2, 5) are the only
edges resulting into shortest path between 1
and 5.

*/