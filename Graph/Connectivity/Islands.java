// Find the number of islands | Set 1 (Using DFS)

// javac -d classes  Islands.java  && cd classes && java Islands && cd ..

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class Islands { 

	// No of rows and columns 
	static final int ROW = 5, COL = 5; 

	// A function to check if a given cell (row, col) can be included in DFS 
	boolean isSafe(int M[][], int row, int col, boolean visited[][]) { 
		// row number is in range, column number is in range 
		// and value is 1 and not yet visited 
		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]); 
	} 

	// A utility function to do DFS for a 2D boolean matrix. 
	// It only considers the 8 neighbors as adjacent vertices 
	void DFS(int M[][], int row, int col, boolean visited[][]) {

		// These arrays are used to get row and column numbers of 8 neighbors of a given cell 
		int rowNbr[] = new int[] { -1, -1, -1,    0, 0,    1, 1, 1 }; 
		int colNbr[] = new int[] { -1,  0,  1,   -1, 1,   -1, 0, 1 }; 

		// Mark this cell as visited 
		visited[row][col] = true; 

		// Recur for all connected neighbours 
		for (int k = 0; k < 8; ++k) {
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
				DFS(M, row + rowNbr[k], col + colNbr[k], visited); 
			}
		}
	} 

	// The main function that returns count of islands in a given boolean 2D matrix 
	int countIslands(int M[][]) { 

		// Make a bool array to mark visited cells. Initially all cells are unvisited 
		boolean visited[][] = new boolean[ROW][COL]; 

		// Initialize count as 0 and travese through the all cells 
		// of given matrix 
		int count = 0; 
		for (int i = 0; i < ROW; ++i) 
			for (int j = 0; j < COL; ++j) 
				if (M[i][j] == 1 && !visited[i][j]) {// If a cell with 
				    // value 1 is not visited yet, then new island found, Visit all 
					// cells in this island and increment island count 
					DFS(M, i, j, visited); 
					++count; 
				} 

		return count; 
	} 

	public static void main(String[] args) throws java.lang.Exception {

		int M[][] = new int[][] { 
			                     { 1, 1, 0, 0, 0 }, 
								 { 0, 1, 0, 0, 1 }, 
								 { 1, 0, 0, 1, 1 }, 
								 { 0, 0, 0, 0, 0 }, 
								 { 1, 0, 1, 0, 1 } 
								}; 

		Islands I = new Islands(); 
		System.out.println("Number of islands is: " + I.countIslands(M)); 
	} 
}


/*
What is an island?
A group of connected 1s forms an island. For example, the below matrix contains 4 islands
(pic)*/


/*// Java program to fnd number of islands using Disjoint Set data structure. 
import java.io.*; 
import java.util.*; 

public class Main 
{ 
	public static void main(String[] args)throws IOException 
	{ 
		int[][] a = new int[][] {{1, 1, 0, 0, 0}, 
								{0, 1, 0, 0, 1}, 
								{1, 0, 0, 1, 1}, 
								{0, 0, 0, 0, 0}, 
								{1, 0, 1, 0, 1} 
								}; 
		System.out.println("Number of Islands is: " + countIslands(a)); 
	} 

	// Returns number of islands in a[][] 
	static int countIslands(int a[][]) 
	{ 
		int n = a.length; 
		int m = a[0].length; 

		DisjointUnionSets dus = new DisjointUnionSets(n*m); 

		/* The following loop checks for its neighbours 
		and unites the indexes if both are 1. */
		for (int j=0; j<n; j++) 
		{ 
			for (int k=0; k<m; k++) 
			{ 
				// If cell is 0, nothing to do 
				if (a[j][k] == 0) 
					continue; 

				// Check all 8 neighbours and do a union with neighbour's set if neighbour is also 1 
				if (j+1 < n && a[j+1][k]==1) 
					dus.union(j*(m)+k, (j+1)*(m)+k); 

				if (j-1 >= 0 && a[j-1][k]==1) 
					dus.union(j*(m)+k, (j-1)*(m)+k); 

				if (k+1 < m && a[j][k+1]==1) 
					dus.union(j*(m)+k, (j)*(m)+k+1); 

				if (k-1 >= 0 && a[j][k-1]==1) 
					dus.union(j*(m)+k, (j)*(m)+k-1); 

				if (j+1<n && k+1<m && a[j+1][k+1]==1) 
					dus.union(j*(m)+k, (j+1)*(m)+k+1); 

				if (j+1<n && k-1>=0 && a[j+1][k-1]==1) 
					dus.union(j*m+k, (j+1)*(m)+k-1); 

				if (j-1>=0 && k+1<m && a[j-1][k+1]==1) 
					dus.union(j*m+k, (j-1)*m+k+1); 
				
				if (j-1>=0 && k-1>=0 && a[j-1][k-1]==1) 
					dus.union(j*m+k, (j-1)*m+k-1); 
			} 
		} 

		// Array to note down frequency of each set 
		int[] c = new int[n*m]; 
		int numberOfIslands = 0; 
		for (int j=0; j<n; j++) 
		{ 
			for (int k=0; k<m; k++) 
			{ 
				if (a[j][k]==1) 
				{ 

					int x = dus.find(j*m+k); 

					// If frequency of set is 0, 
					// increment numberOfIslands 
					if (c[x]==0) 
					{ 
						numberOfIslands++; 
						c[x]++; 
					} 

					else
						c[x]++; 
				} 
			} 
		} 
		return numberOfIslands; 
	} 
} 

// Class to represent Disjoint Set Data structure 
class DisjointUnionSets 
{ 
	int[] rank, parent; 
	int n; 

	public DisjointUnionSets(int n) 
	{ 
		rank = new int[n]; 
		parent = new int[n]; 
		this.n = n; 
		makeSet(); 
	} 

	void makeSet() 
	{ 
		// Initially, all elements are in their 
		// own set. 
		for (int i=0; i<n; i++) 
			parent[i] = i; 
	} 

	// Finds the representative of the set that x 
	// is an element of 
	int find(int x) 
	{ 
		if (parent[x] != x) 
		{ 
			// if x is not the parent of itself, 
			// then x is not the representative of 
			// its set. 
			// so we recursively call Find on its parent 
			// and move i's node directly under the 
			// representative of this set 
			return find(parent[x]); 
		} 

		return x; 
	} 

	// Unites the set that includes x and the set 
	// that includes y 
	void union(int x, int y) 
	{ 
		// Find the representatives (or the root nodes) 
		// for x an y 
		int xRoot = find(x); 
		int yRoot = find(y); 

		// Elements are in the same set, no need 
		// to unite anything. 
		if (xRoot == yRoot) 
			return; 

		// If x's rank is less than y's rank 
		// Then move x under y so that depth of tree 
		// remains less 
		if (rank[xRoot] < rank[yRoot]) 
			parent[xRoot] = yRoot; 

		// Else if y's rank is less than x's rank 
		// Then move y under x so that depth of tree 
		// remains less 
		else if(rank[yRoot]<rank[xRoot]) 
			parent[yRoot] = xRoot; 

		else // Else if their ranks are the same 
		{ 
			// Then move y under x (doesn't matter 
			// which one goes where) 
			parent[yRoot] = xRoot; 

			// And increment the result tree's 
			// rank by 1 
			rank[xRoot] = rank[xRoot] + 1; 
		} 
	} 
} 
*/