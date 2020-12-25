// Java program to find minimum number of 
// iterations to pass information from 
// root to all nodes in an n-ary tree 

// javac -d classes MinItr.java  && cd classes && java MinItr && cd ..

import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.Collections; 
import java.util.Iterator; 
import java.util.List; 

class MinItr 
{ 
	// No. of nodes 
	private static int N; 
	// Adjacency list containing list of children 
	private static List<List<Integer>> adj; 

	MinItr(int N) { 
		this.N = N; 
		adj = new ArrayList<>(N); 

		for (int i = 0; i < N; i++) 
			adj.add(new ArrayList<>()); 
	} 

	// function to add a child w to v 
	void addChild(int v, int w) { 
		adj.get(v).add(w); 
	} 

	// Main function to find the minimum iterations 
	private int getMinIteration() { 
		// Base case : if height = 0 or 1; 
		if (N == 0 || N == 1) 
			return 0; 
		int[] mintItr = new int[N]; 
		// Start Post Order Traversal from Root 
		getMinIterUtil(0, mintItr); 
		return mintItr[0]; 
	} 

	private void getMinIterUtil(int u, int[] minItr) { 
		// Base case : Leaf node 
		if (adj.get(u).size() == 0) 
			return; 

		minItr[u] = adj.get(u).size(); 

		Integer[] minItrTemp = new Integer[minItr[u]]; 

		int k = 0; 

		Iterator itr = adj.get(u).iterator(); 

		while (itr.hasNext()) { 
			int currentChild = (int) itr.next(); 
			getMinIterUtil(currentChild, minItr); 
			minItrTemp[k++] = minItr[currentChild]; 
		} 

		Arrays.sort(minItrTemp, Collections.reverseOrder()); 

		for (k = 0; k < adj.get(u).size(); k++) { 
			int temp = minItrTemp[k] + k + 1; 
			minItr[u] = Math.max(minItr[u], temp); 
		} 
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		// TestCase1 
		MinItr testCase1 = new MinItr(17); 
		testCase1.addChild(0, 1); 
		testCase1.addChild(0, 2); 
		testCase1.addChild(0, 3); 
		testCase1.addChild(0, 4); 
		testCase1.addChild(0, 5); 
		testCase1.addChild(0, 6); 
		testCase1.addChild(1, 7); 
		testCase1.addChild(1, 8); 
		testCase1.addChild(1, 9); 
		testCase1.addChild(4, 10); 
		testCase1.addChild(4, 11); 
		testCase1.addChild(6, 12); 
		testCase1.addChild(7, 13); 
		testCase1.addChild(7, 14); 
		testCase1.addChild(10, 15); 
		testCase1.addChild(11, 16); 

		System.out.println("TestCase 1 - Minimum Iteration: " + testCase1.getMinIteration()); 

/*		// TestCase2 
		MinItr testCase2 = new MinItr(3); 

		testCase2.addChild(0, 1); 
		testCase2.addChild(0, 2); 

		System.out.println("TestCase 2 - Minimum Iteration: " + 
								testCase2.getMinIteration()); 

		// TestCase3 
		MinItr testCase3 = new MinItr(1); 
		System.out.println("TestCase 3 - Minimum Iteration: " + 
								testCase3.getMinIteration()); 

		// TestCase4 
		MinItr testCase4 = new MinItr(6); 
		testCase4.addChild(0, 1); 
		testCase4.addChild(1, 2); 
		testCase4.addChild(2, 3); 
		testCase4.addChild(3, 4); 
		testCase4.addChild(4, 5); 

		System.out.println("TestCase 4 - Minimum Iteration: " + 
								testCase4.getMinIteration()); 

		// TestCase 5 
		MinItr testCase5 = new MinItr(6); 
		testCase5.addChild(0, 1); 
		testCase5.addChild(0, 2); 
		testCase5.addChild(2, 3); 
		testCase5.addChild(2, 4); 
		testCase5.addChild(2, 5); 

		System.out.println("TestCase 5 - Minimum Iteration: " + 
								testCase5.getMinIteration()); 

		// TestCase 6 
		MinItr testCase6 = new MinItr(6); 
		testCase6.addChild(0, 1); 
		testCase6.addChild(0, 2); 
		testCase6.addChild(2, 3); 
		testCase6.addChild(2, 4); 
		testCase6.addChild(3, 5); 

		System.out.println("TestCase 6 - Minimum Iteration: " + 
								testCase6.getMinIteration()); 

		// TestCase 7 
		MinItr testCase7 = new MinItr(14); 
		testCase7.addChild(0, 1); 
		testCase7.addChild(0, 2); 
		testCase7.addChild(0, 3); 
		testCase7.addChild(1, 4); 
		testCase7.addChild(2, 5); 
		testCase7.addChild(2, 6); 
		testCase7.addChild(4, 7); 
		testCase7.addChild(5, 8); 
		testCase7.addChild(5, 9); 
		testCase7.addChild(7, 10); 
		testCase7.addChild(8, 11); 
		testCase7.addChild(8, 12); 
		testCase7.addChild(10, 13); 

		System.out.println("TestCase 7 - Minimum Iteration: " +	 
								testCase7.getMinIteration()); 

		// TestCase 8 
		MinItr testCase8 = new MinItr(14); 
		testCase8.addChild(0, 1); 
		testCase8.addChild(0, 2); 
		testCase8.addChild(0, 3); 
		testCase8.addChild(0, 4); 
		testCase8.addChild(0, 5); 
		testCase8.addChild(1, 6); 
		testCase8.addChild(2, 7); 
		testCase8.addChild(3, 8); 
		testCase8.addChild(4, 9); 
		testCase8.addChild(6, 10); 
		testCase8.addChild(7, 11); 
		testCase8.addChild(8, 12); 
		testCase8.addChild(9, 13); 

		System.out.println("TestCase 8 - Minimum Iteration: " + 
								testCase8.getMinIteration()); 

		// TestCase 9 
		MinItr testCase9 = new MinItr(25); 
		testCase9.addChild(0, 1); 
		testCase9.addChild(0, 2); 
		testCase9.addChild(0, 3); 
		testCase9.addChild(0, 4); 
		testCase9.addChild(0, 5); 
		testCase9.addChild(0, 6); 
		testCase9.addChild(1, 7); 
		testCase9.addChild(2, 8); 
		testCase9.addChild(3, 9); 
		testCase9.addChild(4, 10); 
		testCase9.addChild(5, 11); 
		testCase9.addChild(6, 12); 
		testCase9.addChild(7, 13); 
		testCase9.addChild(8, 14); 
		testCase9.addChild(9, 15); 
		testCase9.addChild(10, 16); 
		testCase9.addChild(11, 17); 
		testCase9.addChild(12, 18); 
		testCase9.addChild(13, 19); 
		testCase9.addChild(14, 20); 
		testCase9.addChild(15, 21); 
		testCase9.addChild(16, 22); 
		testCase9.addChild(17, 23); 
		testCase9.addChild(19, 24); 

		System.out.println("TestCase 9 - Minimum Iteration: " + 
								testCase9.getMinIteration()); */
	} 
} 

