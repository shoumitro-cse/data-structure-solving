// Maximum number of edges to be added to a tree so that it stays a Bipartite graph

// javac -d classes BipartiteGraph.java  && cd classes && java BipartiteGraph && cd ..

import java.util.*; 

class BipartiteGraph { 

	// To store counts of nodes with two colors 
	static long []count_color = new long[2]; 

	static void dfs(Vector<Integer> adj[], int node, int parent, boolean color) {

		// Increment count of nodes with current color 
		count_color[color == false ? 0 : 1]++; 

		// Traversing adjacent nodes 
		for (int i = 0; i < adj[node].size(); i++) { 
			// Not recurring for the parent node 
			if (adj[node].get(i) != parent) {
				dfs(adj, adj[node].get(i), node, !color); 
			}
		} 
	} 

	// Finds maximum number of edges that can be added without violating Bipartite property. 
	static int findMaxEdges(Vector<Integer> adj[], int n) { 
		  // Do a DFS to count number of nodes of each color 
		  dfs(adj, 1, 0, false); 
		  // System.out.println(Arrays.toString(count_color));
		return (int) (count_color[0] * count_color[1] - (n-1)); 
	} 
 
    @SuppressWarnings("unchecked")
	public static void main(String[] args) {

		int n = 5; 
		Vector<Integer>[] adj = new Vector[n+1]; 

		for (int i = 0; i < n + 1; i++) {
			adj[i] = new Vector<Integer>(); 
		}
		
		adj[1].add(2); 
		adj[1].add(3); 
		adj[2].add(4); 
		adj[3].add(5); 
		System.out.println(findMaxEdges(adj, n)); 
	
	} 

} 


/*
Maximum number of edges to be added to a tree so that it stays a Bipartite graph


A tree is always a Bipartite Graph as we can always break into two disjoint sets with alternate levels. In other words we always color it with two colors such that alternate levels have same color. The task is to compute the maximum no. of edges that can be added to the tree so that it remains Bipartite Graph.

Examples:

Input : Tree edges as vertex pairs 
        1 2
        1 3
Output : 0
Explanation :
The only edge we can add is from node 2 to 3.
But edge 2, 3 will result in odd cycle, hence 
violation of Bipartite Graph property.

Input : Tree edges as vertex pairs 
        1 2
        1 3
        2 4
        3 5
Output : 2
Explanation : On colouring the graph, {1, 4, 5} 
and {2, 3} form two different sets. Since, 1 is 
connected from both 2 and 3, we are left with 
edges 4 and 5. Since, 4 is already connected to
2 and 5 to 3, only options remain {4, 3} and 
{5, 2}.
*/