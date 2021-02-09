// Hypercube Graph


class HypercubeGraph { 

	// Function to find power of 2 
	static int power(int n) { 
		if (n == 1) 
			return 2; 
		return 2 * power(n - 1); 
	} 
	

	// Driver program 
	public static void main(String []args) { 
		// n is the order of the graph 
		int n = 4; 
		System.out.println(power(n)); 
	} 
} 


/*
Hypercube Graph


You are given input as order of graph n (highest number of edges connected to a node), 
you have to find the number of vertices in a Hypercube graph of order n.

Examples:

Input : n = 3
Output : 8

Input : n = 2
Output : 4*/