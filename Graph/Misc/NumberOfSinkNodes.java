// Number of sink nodes in a graph

//javac -d classes NumberOfSinkNodes.java  && cd classes && java NumberOfSinkNodes && cd ..

import java.util.*; 

class NumberOfSinkNodes { 

	// Return the number of Sink NOdes. 
	static int countSink(int n, int m, int edgeFrom[], int edgeTo[]) {

		// Array for marking the non-sink node. 
		int [] mark = new int[n + 1]; 

		// Marking the non-sink node. 
		for (int i = 0; i < m; i++) 
			mark[edgeFrom[i]] = 1; 

		// Counting the sink nodes. 
		int count = 0; 
		for (int i = 1; i <= n ; i++) 
			if (mark[i] == 0) 
				count++; 

		return count; 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
		int n = 4, m = 2; 
		int edgeFrom[] = { 2, 4 }; 
		int edgeTo[] = { 3, 3 }; 

		System.out.println(countSink(n, m, edgeFrom, edgeTo)); 
	} 
} 


/*
Number of sink nodes in a graph


Given a Directed Acyclic Graph of n nodes (numbered from 1 to n) and m edges. The task is to find the number of sink nodes. A sink node is a node such that no edge emerges out of it.

Examples:

Input : n = 4, m = 2
        Edges[] = {{2, 3}, {4, 3}} 
Output : 2

Only node 1 and node 3 are sink nodes.*/