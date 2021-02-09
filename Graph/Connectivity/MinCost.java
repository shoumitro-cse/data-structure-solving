// Minimum cost to connect weighted nodes represented as array

// javac -d classes  MinCost.java  && cd classes && java MinCost && cd ..

import java.io.*; 

class MinCost { 
	
	static int minimum_cost(int a[], int n) 
	{ 
		
		int mn = Integer.MAX_VALUE; 
		int sum = 0; 
		
		for (int i = 0; i < n; i++) { 

			// To find the minimum element 
			mn = Math.min(a[i], mn); 

			// sum of all the elements 
			sum += a[i]; 
		} 

		return mn * (sum - mn); 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		int a[] = { 4, 3, 2, 5 }; 
		int n = a.length; 
		
		System.out.println(minimum_cost(a, n)); 
	} 
} 

/*
Minimum cost to connect weighted nodes represented as array


Given an array of N elements(nodes), where every element is weight of that node.Connecting two nodes will take a cost of product of their weights.You have to connect every node with every other node(directly or indirectly).Output the minimum cost required.

Examples:

Input : a[] = {6, 2, 1, 5}
Output :  13
Explanation : 
Here, we connect the nodes as follows:
connect a[0] and a[2], cost = 6*1 = 6,
connect a[2] and a[1], cost = 1*2 = 2,
connect a[2] and a[3], cost = 1*5 = 5.
every node is reachable from every other node:
Total cost = 6+2+5 = 13.

Input  : a[] = {5, 10}
Output : 50
Explanation : connections:
connect a[0] and a[1], cost = 5*10 = 50,
Minimum cost = 50. */