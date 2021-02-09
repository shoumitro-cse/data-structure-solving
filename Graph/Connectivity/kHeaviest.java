// find Kth node weight after sorting of nodes directly connected to a node. 

// k’th heaviest adjacent node in a graph where each vertex has weight

// javac -d classes  kHeaviest.java  && cd classes && java kHeaviest && cd ..

import java.util.*; 

class kHeaviest {

	// pair class 
	static class pair { 
		int first, second; 
		pair(int a, int b) { 
			first = a; 
			second = b; 
		} 
	} 

	// Print Kth node number for each node after sorting 
	// connected node according to their weight. 
	static void printkthnode(Vector<pair> adj[], int wt[], int n, int k) { 
		
		// Sort Adjacency List of all node on the basis of its weight. 
		for (int i = 0; i < n; i++) {
			Collections.sort(adj[i], new Comparator<pair>() { 
				public int compare(pair p1, pair p2) { 
					return p1.first - p2.first; // accending order
				} 
			}); 
		}

		// Printing Kth node for each node. 
		for (int i = 0; i < n; i++) { 
			if (adj[i].size() >= k) 
				System.out.print(adj[i].get(adj[i].size()-k).second + " "); 
			else
				System.out.print("-1"); 
		} 
	} 

	public static void main(String[] args) {

		int n = 3, k = 2; 
		int wt[] = { 2, 4, 3 }; 

		// Making adjacency list, storing the nodes along with their weight. 
		Vector<pair>[] adj = new Vector[n + 1]; 
		for (int i = 0; i < n + 1; i++) {
			adj[i] = new Vector<pair>(); 
		}

		/*       0 (weight 2)
		        / \
		       /   \
		      1-----2
		(weight 4)  (weight 3)*/

		adj[0].add(new pair(wt[2], 2)); 
		adj[2].add(new pair(wt[0], 0)); 

		adj[0].add(new pair(wt[1], 1)); 
		adj[1].add(new pair(wt[0], 0)); 

		adj[1].add(new pair(wt[2], 2)); 
		adj[2].add(new pair(wt[1], 1)); 

		printkthnode(adj, wt, n, k); 
		System.out.println();
	} 
} 


/*
k’th heaviest adjacent node in a graph where each vertex has weight


Given a positive number k and an undirected graph of N nodes, numbered from 0 to N-1, each having a weight associated with it. Note that this is different from a normal weighted graph where every edge has a weight.

For each node, if we sort the nodes (according to their weights), which are directly connected to it, in decreasing order, then what will be the number of the node at the kth position. Print kth node number(not weight) for each node and if it does not exist, print -1.

Examples:

Input : N = 3, k = 2, wt[] = { 2, 4, 3 }.
edge 1: 0 2
edge 2: 0 1
edge 3: 1 2

Output : 2 0 0
Graph:
         0 (weight 2)
        / \
       /   \
      1-----2
(weight 4)  (weight 3)

For node 0, sorted (decreasing order) nodes according to their weights are node 1(weight 4),
node 2(weight 3). The node at 2nd position for node 0 is node 2.

For node 1, sorted (decreasing order) nodes 
according to their weight are node 2(weight 3), node 0(weight 2). The node at 2nd position for 
node 1 is node 0.

For node 2, sorted (decreasing order) nodes according to their weight are node 1(weight 4),
node 0(weight 2). The node at 2nd position for node 2 is node 0.
*/