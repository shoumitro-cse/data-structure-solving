// Check if there is a cycle with odd weight sum in an undirected graph

// javac -d classes CycleOddWeightSum.java  && cd classes && java CycleOddWeightSum && cd ..

import java.io.*; 
import java.util.*; 

class CycleOddWeightSum { 

	// This function returns true if the current subpart of the forest is two colorable, else false. 
	static boolean twoColorUtil(Vector<Integer>[] G, int src, int N, int[] colorArr) { 

		// Assign first color to source 
		colorArr[src] = 1; 
		
		// Create a queue (FIFO) of vertex numbers and enqueue source vertex for BFS traversal 
		Queue<Integer> q = new LinkedList<>(); 
		q.add(src); 
		
		// Run while there are vertices in queue (Similar to BFS) 
		while (!q.isEmpty()) {
			int u = q.peek(); 
			q.poll(); 
			
			// Find all non-colored adjacent vertices 
			for (int v = 0; v < G[u].size(); ++v) { 
			
				// An edge from u to v exists and destination v is not colored 
				if (colorArr[G[u].elementAt(v)] == -1) {
					// Assign alternate color to this adjacent v of u 
					colorArr[G[u].elementAt(v)] = 1 - colorArr[u]; 
					q.add(G[u].elementAt(v)); 
				} else if (colorArr[G[u].elementAt(v)] == colorArr[u]) {
				    // An edge from u to v exists and destination v is colored with same color as u 
					return false; 
				}
			} 
		} 

		return true; 
	} 

	// This function returns true if graph G[V][V] is two colorable, else false 
	static boolean twoColor(Vector<Integer>[] G, int N) { 
 
		int[] colorArr = new int[N + 1];

		for (int i = 1; i <= N; ++i) {
			colorArr[i] = -1; 
		}

		for (int i = 1; i <= N; i++) {
			if (colorArr[i] == -1) {
				if (twoColorUtil(G, i, N, colorArr) == false) {
					return false; 
				}
			}
		}

		return true; 
	} 


	static boolean isOddSum(int[][] info, int n, int m) { 

		@SuppressWarnings("unchecked") 
		Vector<Integer>[] G = new Vector[2*n]; 

		for (int i = 0; i < 2*n; i++) {
			G[i] = new Vector<>(); 
		}

		int pseudo = n + 1; 
		int pseudo_count = 0; 

		for (int i = 0; i < m; i++) { 
			// For odd weight edges, we directly add it in our graph 
			if (info[i][2] % 2 == 1) { 
				int u = info[i][0]; 
				int v = info[i][1]; 
				G[u].add(v); 
				G[v].add(u); 
			} else { 
			    // For even weight edges, we break it 
				int u = info[i][0]; 
				int v = info[i][1]; 

				// Entering a pseudo node between u---v 
				G[u].add(pseudo); 
				G[pseudo].add(u); 
				G[v].add(pseudo); 
				G[pseudo].add(v); 

				// Keeping a record of number of pseudo nodes inserted 
				pseudo_count++; 
				// Making a new pseudo node for next time 
				pseudo++; 
			} 
		} 

		return twoColor(G, n + pseudo_count); 
	} 


	public static void main(String[] args) { 
		
		int n = 4, m = 3;

		int[][] info = { 
			             { 1, 2, 12 }, 
			             { 2, 3, 1 }, 
						 { 4, 3, 1 }, 
						 { 4, 1, 20 } 
					   }; 

		if (isOddSum(info, n, m) == true) {
			System.out.println("No"); 
		} else {
			System.out.println("Yes"); 
		}

	} 

} 


/*
Check if there is a cycle with odd weight sum in an undirected graph


Given a weighted and undirected graph, we need to find if a cycle exist in this graph such that the sum of weights of all the edges in that cycle comes out to be odd.

Examples: (pic)

Input : Number of vertices, n = 4, 
        Number of edges, m = 4
        Weighted Edges = 
        1 2 12
        2 3 1
        4 3 1
        4 1 20
Output : No! There is no odd weight 
         cycle in the given graph


Input : Number of vertices, n = 5, 
        Number of edges, m = 3
        Weighted Edges = 
        1 2 1
        3 2 1
        3 1 1
Output : Yes! There is an odd weight 
         cycle in the given graph*/
