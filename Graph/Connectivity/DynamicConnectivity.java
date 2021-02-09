// incremental connectivity 

// Dynamic Connectivity | Set 1 (Incremental)

 // javac -d classes  DynamicConnectivity.java  && cd classes && java DynamicConnectivity && cd ..

import java.util.*; 

class DynamicConnectivity {

	// Finding the root of node i 
	static int root(int arr[], int i) { 
		while (arr[i] != i) { 
			arr[i] = arr[arr[i]]; 
			i = arr[i]; 
		} 
		return i; 
	} 

	// union of two nodes a and b 
	static void weighted_union(int arr[], int rank[], int a, int b) { 
		int root_a = root (arr, a); 
		int root_b = root (arr, b); 
		// union based on rank 
		if (rank[root_a] < rank[root_b]) { 
			arr[root_a] = arr[root_b]; 
			rank[root_b] += rank[root_a]; 
		} else { 
			arr[root_b] = arr[root_a]; 
			rank[root_a] += rank[root_b]; 
		} 
	} 

	// Returns true if two nodes have same root 
	static boolean areSame(int arr[], int a, int b) { 
		return (root(arr, a) == root(arr, b)); 
	} 

	// Performing an operation according to query type 
	static void query(int type, int x, int y, int arr[], int rank[]) { 
		// type 1 query means checking if node x and y are connected or not 
		if (type == 1) { 
			// If roots of x and y is same then yes is the answer 
			if (areSame(arr, x, y) == true) 
				System.out.println("Yes"); 
			else
				System.out.println("No"); 
		} else if (type == 2) { // type 2 query refers union of x and y 
			// If x and y have different roots then union them 
			if (areSame(arr, x, y) == false) {
				weighted_union(arr, rank, x, y); 
			}
		} 
	} 

	// Driver Code 
	public static void main(String[] args) { 
		// No.of nodes 
		int n = 7; 
		// The following two arrays are used to 
		// implement disjoint set data structure. 
		// arr[] holds the parent nodes while rank 
		// array holds the rank of subset 
		int []arr = new int[n]; 
		int []rank = new int[n]; 

		// initializing both array and rank 
		for (int i = 0; i < n; i++) { 
			arr[i] = i; 
			rank[i] = 1; 
		} 

		// number of queries 
		int q = 11;

		query(1, 0, 1, arr, rank); 
		query(2, 0, 1, arr, rank); 
		query(2, 1, 2, arr, rank); 
		query(1, 0, 2, arr, rank); 
		query(2, 0, 2, arr, rank); 
		query(2, 2, 3, arr, rank); 
		query(2, 3, 4, arr, rank); 
		query(1, 0, 5, arr, rank); 
		query(2, 4, 5, arr, rank); 
		query(2, 5, 6, arr, rank); 
		query(1, 2, 6, arr, rank); 
	} 
} 


/*
Dynamic Connectivity | Set 1 (Incremental)


Dynamic connectivity is a data structure that dynamically maintains the information about thee connected components of graph. In simple words suppose there is a graph G(V, E) in which no. of vertices V is constant but no. of edges E is variable. There are three ways in which we can change the number of edges

Incremental Connectivity : Edges are only added to the graph.
Decremental Connectivity : Edges are only deleted from the graph.
Fully Dynamic Connectivity : Edges can both be deleted and added to the graph.
In this article only Incremental connectivity is discussed. There are mainly two operations that need to be handled.

An edge is added to the graph.
Information about two nodes x and y whether they are in the same connected components or not.
Example:

Input : V = 7
        Number of operations = 11
        1 0 1
        2 0 1
        2 1 2
        1 0 2
        2 0 2
        2 2 3
        2 3 4
        1 0 5
        2 4 5
        2 5 6
        1 2 6
Note: 7 represents number of nodes, 
      11 represents number of queries. 
      There are two types of queries 
      Type 1 : 1 x y in  this if the node 
               x and y are connected print 
               Yes else No
      Type 2 : 2 x y in this add an edge 
               between node x and y
Output : No
         Yes
         No
         Yes
Explanation :
Initially there are no edges so node 0 and 1
will be disconnected so answer will be No
Node 0 and 2 will be connected through node 
1 so answer will be Yes similarly for other
queries we can find whether two nodes are 
connected or not*/