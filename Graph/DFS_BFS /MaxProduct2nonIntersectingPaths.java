// Maximum product of two non-intersecting paths in a tree

// javac -d classes MaxProduct2nonIntersectingPaths.java  && cd classes && java MaxProduct2nonIntersectingPaths && cd ..

import java.util.*;

class MaxProduct2nonIntersectingPaths {

	static int curMax;

	// Returns maximum length path in subtree rooted at u after removing edge connecting u and v 
	static int dfs(Vector<Integer> g[], int u, int v) {
		// To find lengths of first and second maximum in subtrees. 
		// currMax is to store overall maximum.
		int max1 = 0, max2 = 0, total = 0;

		// Loop through all neighbors of u
		for(int i = 0; i < g[u].size(); i++) {

			// If neighbor is v, then skip it
			if (g[u].get(i) == v)
				continue;

			// Call recursively with current neighbor as root
			total = Math.max(total, dfs(g, g[u].get(i), u));

			// Get max from one side and update
			if (curMax > max1) {
				max2 = max1;
				max1 = curMax;
			} else {
				max2 = Math.max(max2, curMax);
			}
		}

		// Store total length by adding max and second max
		total = Math.max(total, max1 + max2);

		// Update current max by adding 1, i.e. current node is included
		curMax = max1 + 1;
		return total;
	}

	// Method returns maximum product of length of two non-intersecting paths
	static int maxProductOfTwoPaths(Vector<Integer> g[], int N) {

		int res = Integer.MIN_VALUE;
		int path1, path2;

		// One by one removing all edges and calling dfs on both subtrees
		for(int i = 1; i < N + 2; i++) {
			for(int j = 0; j < g[i].size(); j++) {	
				// Calling dfs on subtree rooted at g[i][j], excluding edge from g[i][j] to i.
				curMax = 0;
				path1 = dfs(g, g[i].get(j), i);

				// Calling dfs on subtree rooted at i, edge from i to g[i][j]
				curMax = 0;
				path2 = dfs(g, i, g[i].get(j));

				res = Math.max(res, path1 * path2);
			}
		}
		return res;
	}

	// Utility function to add an undirected edge (u,v)
	static void addEdge(Vector<Integer> g[], int u, int v) {
		g[u].add(v);
		g[v].add(u);
	}


	public static void main(String[] args) {

		int edges[][] = { 
			              { 1, 8 }, 
			              { 2, 6 }, 
						  { 3, 1 }, 
						  { 5, 3 },
						  { 7, 8 }, 
						  { 8, 4 },
						  { 8, 6 } 
						};
						
		int N = edges.length;

		// There are N edges, so +1 for nodes and +1 for 1-based indexing
		
		@SuppressWarnings("unchecked")
		Vector<Integer> []g = new Vector[N + 2];
		for(int i = 0; i < g.length; i++) {
			g[i] = new Vector<Integer>();
		}
			
		for(int i = 0; i < N; i++) {
			addEdge(g, edges[i][0], edges[i][1]);
		}

		System.out.print(maxProductOfTwoPaths(g, N) + "\n");
	}
}


/*
Maximum product of two non-intersecting paths in a tree


Given an undirected connected tree with N nodes (and N-1 edges), we need to find two paths in this tree such that they are non-intersecting and the product of their length is maximum. 

Examples: (pic)

In first tree two paths which are non-intersecting
and have highest product are, 1-2 and 3-4, so answer
is 1*1 = 1
In second tree two paths which are non-intersecting 
and has highest product are, 1-3-5  and  7-8-6-2 
(or 4-8-6-2), so answer is 3*2 = 6
*/