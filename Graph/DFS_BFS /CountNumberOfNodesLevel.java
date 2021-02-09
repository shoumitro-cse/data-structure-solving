// Count the number of nodes at given level in a tree using BFS.

//javac -d classes CountNumberOfNodesLevel.java  && cd classes && java CountNumberOfNodesLevel && cd ..

import java.util.*;

// This class representsa directed graph using adjacency list representation
class Graph {
	// No. of vertices
	int V;
	// Pointer to an array containing adjacency lists
	Vector<Integer>[] adj;

	// Constructor
	@SuppressWarnings("unchecked")
	Graph(int V) {
		adj = new Vector[V];
		for (int i = 0; i < adj.length; i++) {
		  adj[i] = new Vector<>();
		}

		this.V = V;
	}

	void addEdge(int v, int w) {
		// Add w to v’s list.
		adj[v].add(w);
		// Add v to w's list.
		adj[w].add(v);
	}

	int BFS(int s, int l) {
		// Mark all the vertices as not visited
		boolean[] visited = new boolean[V];
		int[] level = new int[V];

		for (int i = 0; i < V; i++) {
			visited[i] = false;
			level[i] = 0;
		}

		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);
		level[s] = 0;

		int count = 0;
		while (!queue.isEmpty()) {

			// Dequeue a vertex from queue and print it
			s = queue.poll();

			Vector<Integer> list = adj[s];

			for (int i : list) {
				if (!visited[i]) {
					visited[i] = true;
					level[i] = level[s] + 1;
					queue.add(i);
				}
			}

			count = 0;
			for (int i = 0; i < V; i++) {
				if (level[i] == l) {
				  count++;
				}
		    }
		}

		return count;
	}
}

class CountNumberOfNodesLevel {

	public static void main(String[] args) {

		// Create a graph given in the above diagram
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);

		int level = 2;
		System.out.println(g.BFS(0, level));
	}
}

/*
Count the number of nodes at given level in a tree using BFS.


Given a tree represented as undirected graph. Count the number of nodes at given level l. 
It may be assumed that vertex 0 is root of the tree.

Examples: 

Input :   7
          0 1
          0 2
          1 3
          1 4 
          1 5
          2 6
          2
Output :  4

Input : 6
        0 1
        0 2
        1 3
        2 4
        2 5
        2
Output : 3

BFS is a traversing algorithm which start traversing from a selected node (source or starting node) 
and traverse the graph layer wise thus exploring the neighbour nodes (nodes which are directly 
connected to source node). Then, move towards the next-level neighbour nodes. 

As the name BFS suggests, traverse the graph breadth wise as follows:
1. First move horizontally and visit all the nodes of the current layer. 
2. Move to the next layer.

In this code, while visiting each node, the level of that node is set with an increment in the 
level of its parent node i.e., level[child] = level[parent] + 1. This is how the level of each 
node is determined. The root node lies at level zero in the tree.

Explanation :




     0         Level 0
   /   \ 
  1     2      Level 1
/ |\    |
3 4 5   6      Level 2

Given a tree with 7 nodes and 6 edges in which node 0 lies at 0 level. Level of 1 can be updated as : level[1] = level[0] +1 as 0 is the parent node of 1. Similarly, the level of other nodes can be updated by adding 1 to the level of their parent. 
level[2] = level[0] + 1, i.e level[2] = 0 + 1 = 1. 
level[3] = level[1] + 1, i.e level[3] = 1 + 1 = 2. 
level[4] = level[1] + 1, i.e level[4] = 1 + 1 = 2. 
level[5] = level[1] + 1, i.e level[5] = 1 + 1 = 2. 
level[6] = level[2] + 1, i.e level[6] = 1 + 1 = 2.

Then, count of number of nodes which are at level l(i.e, l=2) is 4 (node:- 3, 4, 5, 6) 

*/
