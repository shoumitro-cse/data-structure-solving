// Karp’s minimum mean (or average) weight cycle algorithm

// javac -d classes  KarpCycleAlgo.java  && cd classes && java KarpCycleAlgo && cd ..

import java.io.*;
import java.util.*;

class KarpCycleAlgo {

	static int V = 4;
	// a struct to represent edges
	static class Edge {
		int from, weight;
		Edge(int from, int weight) {
			this.from = from;
			this.weight = weight;
		}
	}

	// vector to store edges
	@SuppressWarnings("unchecked")
	static Vector<Edge>[] edges = new Vector[V];

	static {
		for (int i = 0; i < V; i++) {
			edges[i] = new Vector<>();
		}
	}

	static void addedge(int u, int v, int w) {
		edges[v].add(new Edge(u, w));
	}

	// calculates the shortest path
	static void shortestpath(int[][] dp) {

		// initializing all distances as -1
		for (int i = 0; i <= V; i++)
			for (int j = 0; j < V; j++)
				dp[i][j] = -1;

		// shortest distance from first vertex
		// to in tself consisting of 0 edges
		dp[0][0] = 0;

		// filling up the dp table
		for (int i = 1; i <= V; i++)
		{
			for (int j = 0; j < V; j++) 
			{
				for (int k = 0; k < edges[j].size(); k++)
				{
					if (dp[i-1][edges[j].elementAt(k).from] != -1) {

						int curr_wt = dp[i-1][edges[j].elementAt(k).from] + 
												edges[j].elementAt(k).weight;
						if (dp[i][j] == -1)
							dp[i][j] = curr_wt;
						else
							dp[i][j] = Math.min(dp[i][j], curr_wt);
					}
				}
			}
		}
	}

	// Returns minimum value of average weight of a cycle in graph.
	static double minAvgWeight() {

		int[][] dp = new int[V + 1][V];
		shortestpath(dp);

		// array to store the avg values
		double[] avg = new double[V];

		for (int i = 0; i < V; i++) {
		  avg[i] = -1;
		}

		// Compute average values for all vertices using weights of shortest paths store in dp.
		for (int i = 0; i < V; i++) {
		  if (dp[V][i] != -1) {
			  for (int j = 0; j < V; j++) {
				if (dp[j][i] != -1) {
					avg[i] = Math.max(avg[i], ((double) dp[V][i] - dp[j][i]) / (V - j));
				}
			  }
		   }
		}

		// Find minimum value in avg[]
		double result = avg[0];
		for (int i = 0; i < V; i++) {
			if (avg[i] != -1 && avg[i] < result) {
				result = avg[i];
			}
		}

		return result;
	}


	public static void main(String[] args) {

		addedge(0, 1, 1);
		addedge(0, 2, 10);
		addedge(1, 2, 3);
		addedge(2, 3, 2);
		addedge(3, 1, 0);
		addedge(3, 0, 8);

		System.out.printf("\n\n%.5f", minAvgWeight());
		System.out.printf("\n");
	}
}



/*Karp’s minimum mean (or average) weight cycle algorithm


Given a directed and strongly connected graph with non-negative edge weights. We define the mean weight of a cycle as the summation of all the edge weights of the cycle divided by the no. of edges. Our task is to find the minimum mean weight among all the directed cycles of the graph.
Example: 
 

Input : Below Graph (pic)

from pic => 3 +2 + 0 = 5/3 = 1.66667

Output : 1.66667



Method to find the smallest mean weight value cycle efficiently 
 

Step 1: Choose first vertex as source.

Step 2: Compute the shortest path to all other vertices 
        on a path consisting of k edges 0 <= k <= V 
        where V is number of vertices.
        This is a simple dp problem which can be computed 
        by the recursive solution
        dp[k][v] = min(dp[k][v], dp[k-1][u] + weight(u,v)
        where v is the destination and the edge(u,v) should
        belong to E

Step 3: For each vertex calculate max(dp[n][v]-dp[k][v])/(n-k) 
         where 0<=k<=n-1

Step 4: The minimum of the values calculated above is the 
        required answer.*/