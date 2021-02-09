// Find the minimum cost to reach destination using a train


class shortest_path { 

	static int INF = Integer.MAX_VALUE, N = 4; 
	// A recursive function to find the shortest path from source 's' to destination 'd'. 
	static int minCostRec(int cost[][], int s, int d) { 

		// If source is same as destination or destination is next to source 
		if (s == d || s+1 == d) 
		   return cost[s][d]; 
	
		// Initialize min cost as direct ticket from source 's' to destination 'd'. 
		int min = cost[s][d]; 
	
		// Try every intermediate vertex to find minimum 
		for (int i = s+1; i < d; i++) { 
			int c = minCostRec(cost, s, i) + minCostRec(cost, i, d); 
			if (c < min) {
			  min = c; 
			}
		} 

		return min; 
	} 
	
	// This function returns the smallest possible cost to 
	// reach station N-1 from station 0. This function mainly 
	// uses minCostRec(). 
	static int minCost(int cost[][]) 
	{ 
		return minCostRec(cost, 0, N-1); 
	} 


   static int minCost_2(int cost[][]) 
    { 
        // dist[i] stores minimum cost to reach station i 
        // from station 0. 
        int dist[] = new int[N]; 
        for (int i=0; i<N; i++) 
           dist[i] = INF; 
        dist[0] = 0; 
       
        // Go through every station and check if using it 
        // as an intermediate station gives better path 
        for (int i=0; i<N; i++) 
           for (int j=i+1; j<N; j++) 
              if (dist[j] > dist[i] + cost[i][j]) 
                 dist[j] = dist[i] + cost[i][j]; 
       
        return dist[N-1]; 
    } 

	public static void main(String args[]) { 
		int cost[][] = { 
			             	{0, 15, 80, 90}, 
							{INF, 0, 40, 50}, 
							{INF, INF, 0, 70}, 
							{INF, INF, INF, 0} 
					   }; 
		System.out.println("The Minimum cost to reach station "+ N+ " is "+minCost(cost)); 
	} 

}


/*
Find the minimum cost to reach destination using a train


There are N stations on route of a train. The train goes from station 0 to N-1. The ticket cost 
for all pair of stations (i, j) is given where j is greater than i. Find the minimum cost to reach 
the destination.
Consider the following example:

Input: 
cost[N][N] = { {0, 15, 80, 90},
              {INF, 0, 40, 50},
              {INF, INF, 0, 70},
              {INF, INF, INF, 0}
             };
There are 4 stations and cost[i][j] indicates cost to reach j 
from i. The entries where j < i are meaningless.

Output:
The minimum cost is 65
The minimum cost can be obtained by first going to station 1 
from 0. Then from station 1 to station 3.
*/