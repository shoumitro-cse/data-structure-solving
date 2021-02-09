// find number of cycles of length k in a graph with n nodes. 


// Number of loops of size k starting from a specific node

public class CyclesOfLengthk { 
	

	static int numOfways(int n, int k) {
		int p = 1; 
		if (k % 2 != 0) 
			p = -1; 
		return (int)(Math.pow(n-1, k) + p * (n-1)) / n; 
	} 
	
	// Driver code 
	public static void main(String args[]) 
	{ 
		int n = 4, k = 2; 
	
		System.out.println(numOfways(n, k)); 
	} 
} 


/*
Number of loops of size k starting from a specific node


Given two positive integer n, k. Consider an undirected complete connected graph of n nodes in a complete connected graph. The task is to calculate the number of ways in which one can start from any node and return to it by visiting K nodes.

Examples:
  (pic)
Input : n = 3, k = 3
Output : 2


Input : n = 4, k = 2
Output : 3*/