// A union by rank and path compression based program to detect cycle in a graph

// javac -d classes DetectCycleUnionRank.java  && cd classes && java DetectCycleUnionRank && cd ..

class DetectCycleUnionRank {

	int V, E;
	Edge[] edge;

	DetectCycleUnionRank(int nV, int nE) {
		V = nV;
		E = nE;
		edge = new Edge[E];
		for (int i = 0; i < E; i++) {
		  edge[i] = new Edge();
		}
	}

	// class to represent edge
	class Edge {
		int src, dest;
	}

	// class to represent Subset
	class subset {
		int parent;
		int rank;
	}

	// A utility function to find set of an element i (uses path compression technique)
	int find(subset[] subsets, int i) {
		if (subsets[i].parent != i) {
			subsets[i].parent = find(subsets, subsets[i].parent);
		}
		return subsets[i].parent;
	}

	// A function that does union
	// of two sets of x and y
	// (uses union by rank)
	void Union(subset[] subsets, int x, int y)
	{
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[yroot].rank < subsets[xroot].rank)
			subsets[yroot].parent = xroot;
		else {
			subsets[xroot].parent = yroot;
			subsets[yroot].rank++;
		}
	}

	// The main function to check whether a given graph contains cycle or not
	int isCycle(DetectCycleUnionRank graph) {

		int V = graph.V;
		int E = graph.E;

		subset[] subsets = new subset[V];
		for (int v = 0; v < V; v++) {

			subsets[v] = new subset();
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}

		for (int e = 0; e < E; e++) {
			int x = find(subsets, graph.edge[e].src);
			int y = find(subsets, graph.edge[e].dest);
			if (x == y)
				return 1;
			Union(subsets, x, y);
		}
		return 0;
	}


	public static void main(String[] args) {

		/* Let us create the following graph
			0
			| \
			| \
			1-----2 */

		int V = 3, E = 3;
		DetectCycleUnionRank graph = new DetectCycleUnionRank(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		// add edge 1-2
		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;

		// add edge 0-2
		graph.edge[2].src = 0;
		graph.edge[2].dest = 2;

		if (graph.isCycle(graph) == 1)
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");
	}
}


/*
Union-Find Algorithm | Set 2 (Union By Rank and Path Compression)


In the previous post, we introduced union find algorithm and used it to detect cycle in a graph. 
We used following union() and find() operations for subsets.


// Naive implementation of find
static int find(int parent[], int i)
{
    if (parent[i] == -1)
        return i;
    return find(parent, parent[i]);
}
   
// Naive implementation of union()
static void Union(int parent[], int x, int y)
{
    int xset = find(parent, x);
    int yset = find(parent, y);
    parent[xset] = yset;
}
 
// This code is contributed by divyesh072019
The above union() and find() are naive and the worst case time complexity is linear. 
The trees created to represent subsets can be skewed and can become like a linked list. 
Following is an example worst case scenario. 

Let there be 4 elements 0, 1, 2, 3

Initially, all elements are single element subsets.
0 1 2 3 

Do Union(0, 1)
   1   2   3  
  /
 0

Do Union(1, 2)
     2   3   
    /
   1
 /
0

Do Union(2, 3)
         3    
        /
      2
     /
   1
 /
0
The above operations can be optimized to O(Log n) in worst case. The idea is to always 
attach smaller depth tree under the root of the deeper tree. This technique is called union 
by rank. The term rank is preferred instead of height because if path compression technique 
(we have discussed it below) is used, then rank is not always equal to height. Also, size 
(in place of height) of trees can also be used as rank. Using size as rank also yields 
worst case time complexity as O(Logn) (See this for proof)

Let us see the above example with union by rank
Initially, all elements are single element subsets.
0 1 2 3 

Do Union(0, 1)
   1   2   3  
  /
 0

Do Union(1, 2)
   1    3
 /  \
0    2

Do Union(2, 3)
    1    
 /  |  \
0   2   3
The second optimization to naive method is Path Compression. The idea is to flatten the 
tree when find() is called. When find() is called for an element x, root of the tree is returned. 
The find() operation traverses up from x to find root. The idea of path compression is to make the 
found root as parent of x so that we don’t have to traverse all intermediate nodes again. 
If x is root of a subtree, then path (to root) from all nodes under x also compresses.

Let the subset {0, 1, .. 9} be represented as below and find() is called
for element 3.
              9
         /    |    \  
        4     5      6
     /     \        /  \
    0        3     7    8
            /  \
           1    2  

When find() is called for 3, we traverse up and find 9 as representative
of this subset. With path compression, we also make 3 as the child of 9 so 
that when find() is called next time for 1, 2 or 3, the path to root is reduced.

               9
         /    /  \    \
        4    5    6     3 
     /           /  \   /  \
    0           7    8  1   2
The two techniques complement each other. The time complexity of each operation becomes even smaller than O(Logn). In fact, amortized time complexity effectively becomes small constant
*/