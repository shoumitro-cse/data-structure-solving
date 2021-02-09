// Minimum edge reversals to make a root

// javac -d classes MinEdgeReversalsMakRoot.java  && cd classes && java MinEdgeReversalsMakRoot && cd ..

import java.util.*;

class MinEdgeReversalsMakRoot {

		// pair class
		static class pair {
			int first, second;
			pair(int a ,int b) {
				first = a;
				second = b;
			}
		}

	// method to dfs in tree and populates disRev values 
	static int dfs(Vector<Vector< pair >> g, pair disRev[], boolean visit[], int u) { 

		// visit current node 
		visit[u] = true; 
		int totalRev = 0; 

		// looping over all neighbors 
		for (int i = 0; i < g.get(u).size(); i++) {

			int v = g.get(u).get(i).first; 

			if (!visit[v]) { 
				
				// distance of v will be one more than distance of u 
				disRev[v].first = disRev[u].first + 1; 
				
				// initialize back edge count same as parent node's count 
				disRev[v].second = disRev[u].second; 
				
				// if there is a reverse edge from u to i, then only update 
				if (g.get(u).get(i).second != 0) { 
					disRev[v].second = disRev[u].second + 1; 
					totalRev++; 
				} 

				totalRev += dfs(g, disRev, visit, v); 
			} 
		} 

		// return total reversal in subtree rooted at u 
		return totalRev; 
	} 

	// method prints root and minimum number of edge reversal 
	static void printMinEdgeReverseForRootNode(int edges[][], int e) {

		// number of nodes are one more than number of edges 
		int V = e + 1; 

		// data structure to store directed tree 
		Vector<Vector<pair>> g = new Vector<Vector<pair>>();
		
		for(int i = 0; i < V + 1; i++) {
		   g.add(new Vector<pair>());
		}

		// disRev stores two values - distance and back edge count from root node 
		pair disRev[] = new pair[V]; 

		for(int i = 0; i < V; i++) {
		  disRev[i] = new pair(0, 0);
		}
		
		boolean visit[] = new boolean[V]; 

		int u, v; 
		for (int i = 0; i < e; i++) {

			u = edges[i][0]; 
			v = edges[i][1]; 

			// add 0 weight in direction of u to v 
			g.get(u).add(new pair(v, 0)); 

			// add 1 weight in reverse direction 
			g.get(v).add(new pair(u, 1)); 
		} 

		// initialize all variables 
		for (int i = 0; i < V; i++) { 
			visit[i] = false; 
			disRev[i].first = disRev[i].second = 0; 
		} 

		int root = 0; 

		// dfs populates disRev data structure and store total reverse edge counts 
		int totalRev = dfs(g, disRev, visit, root); 

		// UnComment below lines to print each node's 
		// distance and edge reversal count from root node 
		/* 
		for (int i = 0; i < V; i++) 
		{ 
			cout << i << " : " << disRev[i].first 
				<< " " << disRev[i].second << endl; 
		} 
		*/

		int res = Integer.MAX_VALUE; 

		// loop over all nodes to choose minimum edge reversal 
		for (int i = 0; i < V; i++) { 
			// (reversal in path to i) + (reversal in all other tree parts) 
			int edgesToRev = (totalRev - disRev[i].second) + (disRev[i].first - disRev[i].second); 
			// choose minimum among all values 
			if (edgesToRev < res) { 
				res = edgesToRev; 
				root = i; 
			} 
		} 

		// print the designated root and total edge reversal made 
		System.out.println("\n\nprint the designated root and total edge reversal made: "); 
		System.out.println("root: "+root + "\nedge reversal: " + res ); 
	} 


	public static void main(String args[]) {

		int edges[][] = 
		{ 
			{0, 1}, 
			{2, 1}, 
			{3, 2}, 
			{3, 4}, 
			{5, 4}, 
			{5, 6}, 
			{7, 6} 
		}; 

		int e = edges.length; //7

		printMinEdgeReverseForRootNode(edges, e); 
	}
} 


/*
Minimum edge reversals to make a root


Given a directed tree with V vertices and V-1 edges, we need to choose such a root 
(from given nodes from where we can reach to every other node) with a minimum number of edge reversal. 

Examples:  (pic)



In above tree, if we choose node 3 as our 
root then we need to reverse minimum number
of 3 edges to reach every other node, 
changed tree is shown on the right side.
 
*/