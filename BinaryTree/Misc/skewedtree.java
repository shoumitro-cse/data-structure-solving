// Ways to color a skewed tree such that parent and child have different colors

import java.io.*; 

class GFG { 
	// fast_way is recursive 
	// method to calculate power 
	static int fastPow(int N, int K) 
	{ 
		if (K == 0) 
			return 1; 
		int temp = fastPow(N, K / 2); 
		if (K % 2 == 0) 
			return temp * temp; 
		else
			return N * temp * temp; 
	} 

	static int countWays(int N, int K) 
	{ 
		return K * fastPow(K - 1, N - 1); 
	} 

	// Driver program 
	public static void main(String[] args) 
	{ 
		int N = 3, K = 3; 
		System.out.println(countWays(N, K)); 
	} 
} 


/*Ways to color a skewed tree such that parent and child have different colors

Given a skewed tree (Every node has at most one child) with N nodes and K colors. You have to assign a color from 1 to K to each node such that parent and child has different colors. Find the maximum number of ways of coloring the nodes.

Examples –

Input : N = 2, K = 2.
Output :  
Let A1 and A2 be the two nodes.
Let A1 is parent of A2.
Colors are Red and Blue.
Case 1: A1 is colored Red 
       and A2 is colored Blue.
Case 2: A1 is colored Blue 
       and A2 is colored Red.
No. of ways : 2      

Input : N = 3, K = 3.
Output : 
A1, A2, A3 are the nodes. 
A1 is parent of A2 
and A2 is parent of A3.
Let colors be R, B, G.
A1 can choose any three colors 
and A2 can choose 
any other two colors
and A3 can choose 
any other two colors 
than its parents.
No. of ways: 12*/