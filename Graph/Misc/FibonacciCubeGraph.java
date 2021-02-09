// Fibonacci Cube Graph


public class FibonacciCubeGraph { 
	
	// function to find fibonacci number 
	static int fib(int n) { 
		if (n <= 1) 
			return n; 
		return fib(n - 1) + fib(n - 2); 
	} 
	
	// function for finding number of vertices 
	// in fibonacci cube graph 
	static int findVertices (int n) { 
		// return fibonacci number for f(n + 2) 
		return fib(n + 2); 
	} 
		
	public static void main(String args[]) { 
		// n is the order of the graph 
		int n = 3; 
		System.out.println(findVertices(n)); 
	} 
} 


/*Fibonacci Cube Graph


You are given input as order of graph n (highest number of edges connected to a node), you have to find the number of vertices in a Fibonacci cube graph of order n.

Examples :

Input : n = 3
Output : 5
Explanation : 
Fib(n + 2) = Fib(5) = 5

Input : n = 2
Output : 3*/