// Multistage Graph (Shortest Path)

// javac -d classes  MultistageGraph.java  && cd classes && java MultistageGraph && cd ..


class MultistageGraph {

	static int N = 8; 
	static int INF = Integer.MAX_VALUE; 

	// Returns shortest distance from 0 to N-1. 
	public static int shortestDist(int [][] graph) { 
		// dist[i] is going to store shortest distance from node i to node N-1. 
		int[] dist = new int[N]; 
		dist[N-1] = 0; 
		// Calculating shortest path for rest of the nodes 
		for (int i = N - 2; i >= 0; i--) { 
			// Initialize distance from i to destination (N-1) 
			dist[i] = INF; 
			// Check all nodes of next stages to find shortest distance from i to N-1. 
			for (int j = i; j < N; j++) { 
				// Reject if no edge exists 
				if (graph[i][j] == INF) { 
					continue; 
				} 
				// We apply recursive equation to  distance to target through j. 
				// and compare with minimum distance so far. 
				dist[i] = Math.min(dist[i], graph[i][j] + dist[j]); 
			} 
		} 

		return dist[0]; 
	} 

	public static void main(String[] args) { 

	  // Graph stored in the form of an adjacency Matrix 
	  int[][] graph = new int[][] {
	 								{INF, 1, 2, 5, INF, INF, INF, INF}, 
									{INF, INF, INF, INF, 4, 11, INF, INF}, 
									{INF, INF, INF, INF, 9, 5, 16, INF}, 
									{INF, INF, INF, INF, INF, INF, 2, INF}, 
									{INF, INF, INF, INF, INF, INF, INF, 18}, 
									{INF, INF, INF, INF, INF, INF, INF, 13}, 
									{INF, INF, INF, INF, INF, INF, INF, 2}
								}; 

		System.out.println(shortestDist(graph)); 
	} 

} 

/*
Multistage Graph (Shortest Path)


A Multistage graph is a directed graph in which the nodes can be divided into a set of stages 
such that all edges are from a stage to next stage only (In other words there is no edge between 
vertices of same stage and from a vertex of current stage to previous stage).

We are give a multistage graph, a source and a destination, we need to find shortest path from 
source to destination. By convention, we consider source at stage 1 and destination as last stage.

Following is an example graph we will consider in this article :- (pic)







Shortest distance from stage 1, node 0 to 
destination, i.e., 7 is M(1, 0).

// From 0, we can go to 1 or 2 or 3 to
// reach 7.              
M(1, 0) = min(1 + M(2, 1),
              2 + M(2, 2),
              5 + M(2, 3))
This means that our problem of 0 —> 7 is now sub-divided into 3 sub-problems :-

So if we have total 'n' stages and target
as T, then the stopping condition  will be :-
M(n-1, i) = i ---> T + M(n, T) = i ---> T
Recursion Tree and Overlapping Sub-Problems:-
So, the hierarchy of M(x, y) evaluations will look something like this :-

In M(i, j), i is stage number and
j is node number

                   M(1, 0)
           /          |         \                             
          /           |          \                            
       M(2, 1)      M(2, 2)        M(2, 3)
    /      \        /     \         /    \
M(3, 4)  M(3, 5)  M(3, 4)  M(3, 5) M(3, 6)  M(3, 6)
 .         .       .       .          .        .
 .         .       .       .          .        .
 .         .       .       .          .        .
So, here we have drawn a very small part of the Recursion Tree and we can already see Overlapping Sub-Problems. We can largely reduce the number of M(x, y) evaluations using Dynamic Programming.

*/