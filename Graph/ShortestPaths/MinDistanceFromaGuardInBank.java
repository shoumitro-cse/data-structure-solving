// Find Shortest distance from a guard in a Bank

// javac -d classes  MinDistanceFromaGuardInBank.java  && cd classes && java MinDistanceFromaGuardInBank && cd ..


import java.util.LinkedList;
import java.util.Queue;

public class MinDistanceFromaGuardInBank{
	
	// Store dimensions of the matrix 
	int M = 5;
	int N = 5;

	class Node {
		int i, j, dist;
		Node(int i, int j, int dist) {
			this.i = i;
			this.j = j;
			this.dist = dist;
		}
	}

	// These arrays are used to get row and column numbers of 4 neighbors of a given cell 
	int row[] = { -1, 0, 1, 0 };
	int col[] = { 0, 1, 0, -1 };

	// Return true if row number and column number is in range 
	boolean isValid(int i, int j) {
		if ((i < 0 || i > M - 1) || (j < 0 || j > N - 1))
			return false;

		return true;
	}

	// Return true if current cell is 
	// an open area and its distance 
	// from guard is not calculated yet 
	boolean isSafe(int i, int j, char matrix[][], int output[][]) {
		if (matrix[i][j] != 'O' || output[i][j] != -1)
			return false;
		return true;
	}

	// Function to replace all of the O's in the matrix with their shortest distance from a guard 
	void findDistance(char matrix[][]) { //Time complexity is O(MN) 

		int output[][] = new int[M][N];
		Queue<Node> q = new LinkedList<Node>();

		// Finding Guards location and adding into queue 
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				// Initialize each cell as -1 
				output[i][j] = -1;
				if (matrix[i][j] == 'G') {
					q.add(new Node(i, j, 0));
					// Guard has 0 distance 
					output[i][j] = 0;
				}
			}
		}
		
		// Do till queue is empty 
		while (!q.isEmpty()) {
			
			// Get the front cell in the queue and update its adjacent cells 
			Node curr = q.poll();
			
			int x = curr.i;
			int y = curr.j;
			int dist = curr.dist;
			
			// Do for each adjacent cell 
			for (int i = 0; i < 4; i++) {
				// If adjacent cell is valid, has path and not visited yet,en-queue it. 
				if (isValid(x+row[i], y+col[i])) {
					if (isSafe(x + row[i], y + col[i], matrix, output)) {
						output[x + row[i]][y + col[i]] = dist + 1;
						q.add(new Node(x + row[i], y + col[i], dist + 1));
					}
				}
			}
			
		}
		
		// Print output matrix 
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {

		char matrix[][] = { 
			                 { 'O', 'O', 'O', 'O', 'G' },
							 { 'O', 'W', 'W', 'O', 'O' },
							 { 'O', 'O', 'O', 'W', 'O' },
							 { 'G', 'W', 'W', 'W', 'O' },
							 { 'O', 'O', 'O', 'O', 'G' } 
						  };
							
		MinDistanceFromaGuardInBank g = new MinDistanceFromaGuardInBank();
		
		g.findDistance(matrix);
	}
}



/*Find Shortest distance from a guard in a Bank


Given a matrix that is filled with ‘O’, ‘G’, and ‘W’ where ‘O’ represents open space, 
‘G’ represents guards and ‘W’ represents walls in a Bank. Replace all of the O’s in the 
matrix with their shortest distance from a guard, without being able to go through any walls. 
Also, replace the guards with 0 and walls with -1 in output matrix.
Expected Time complexity is O(MN) for a M x N matrix.

Examples:

O ==> Open Space
G ==> Guard
W ==> Wall

Input: 
  O  O  O  O  G
  O  W  W  O  O
  O  O  O  W  O
  G  W  W  W  O
  O  O  O  O  G

Output:  
  3  3  2  1  0
  2 -1 -1  2  1
  1  2  3 -1  2
  0 -1 -1 -1  1
  1  2  2  1  0
*/