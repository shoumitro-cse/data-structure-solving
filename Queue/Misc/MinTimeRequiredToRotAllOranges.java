//Minimum time required to rot all oranges

//javac -d classes MinTimeRequiredToRotAllOranges.java  && cd classes && java MinTimeRequiredToRotAllOranges && cd ..


import java.util.LinkedList;
import java.util.Queue;

public class MinTimeRequiredToRotAllOranges {

	public final static int R = 3;
	public final static int C = 5;
	
	// structure for storing coordinates of the cell
	static class Element {
		int x = 0;
		int y = 0;
		Element(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// function to check whether a cell is valid / invalid
	static boolean isValid(int i, int j) {
		return (i >= 0 && j >= 0 && i < R && j < C);
	}
	

	// Function to check whether the cell is delimiter
	// which is (-1, -1)
	static boolean isDelim(Element temp) {
		return (temp.x == -1 && temp.y == -1);
	}
	
	// Function to check whether there is still a fresh orange remaining
	static boolean checkAll(int arr[][]) {
		for (int i=0; i<R; i++)
			for (int j=0; j<C; j++)
				if (arr[i][j] == 1)
					return true;
		return false;
	}
	
	// This function finds if it is possible to rot all oranges or not.
	// If possible, then it returns minimum time required to rot all,
	// otherwise returns -1
	static int rotOranges(int arr[][]) {
		// Create a queue of cells
		Queue<Element> Q = new LinkedList<>();
		Element temp; 
		int ans = 0;
		// Store all the cells having rotten orange in first time frame
		for (int i=0; i < R; i++)
		  for (int j=0; j < C; j++)
			if (arr[i][j] == 2)
				Q.add(new Element(i,j));
				
		// Separate these rotten oranges from the oranges which will rotten
		// due the oranges in first time frame using delimiter which is (-1, -1)
		Q.add(new Element(-1,-1));
		
		// Process the grid while there are rotten oranges in the Queue
		while(!Q.isEmpty()) {
			// This flag is used to determine whether even a single fresh
			// orange gets rotten due to rotten oranges in the current time
			// frame so we can increase the count of the required time.
			boolean flag = false;
			// Process all the rotten oranges in current time frame.
			while(!isDelim(Q.peek())) {
				temp = Q.peek();
				
				// Rot all other oranges present at
				// (i+1, j), (i, j-1), (i, j+1), (i-1, j)

				// Check right adjacent cell that if it can be rotten
				if(isValid(temp.x+1, temp.y) && arr[temp.x+1][temp.y] == 1) {
					if(!flag) {
						// if this is the first orange to get rotten, increase count and set the flag.
						ans++;
						flag = true;
					}
					// Make the orange rotten
					arr[temp.x+1][temp.y] = 2;
					// push the adjacent orange to Queue
					temp.x++;
					Q.add(new Element(temp.x, temp.y));
					// Move back to current cell
					temp.x--;
				}
				
				// Check left adjacent cell that if it can be rotten
				if (isValid(temp.x-1, temp.y) && arr[temp.x-1][temp.y] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x-1][temp.y] = 2;
					temp.x--;
					Q.add(new Element(temp.x,temp.y)); // push this cell to Queue
					temp.x++;
				}
				
				// Check top adjacent cell that if it can be rotten
				if (isValid(temp.x, temp.y+1) && arr[temp.x][temp.y+1] == 1) {
					if(!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x][temp.y+1] = 2;
					temp.y++;
					Q.add(new Element(temp.x,temp.y)); // Push this cell to Queue
					temp.y--;
				}
				
				// Check bottom adjacent cell if it can be rotten
				if (isValid(temp.x, temp.y-1) && arr[temp.x][temp.y-1] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x][temp.y-1] = 2;
					temp.y--;
					Q.add(new Element(temp.x,temp.y)); // push this cell to Queue
				}
				Q.remove();
				
			}
			// Pop the delimiter
			Q.remove();
			// If oranges were rotten in current frame than separate the
			// rotten oranges using delimiter for the next frame for processing.
			if (!Q.isEmpty()) {
				Q.add(new Element(-1,-1));
			}
			// If Queue was empty than no rotten oranges left to process so exit
		}
		// Return -1 if all arranges could not rot, otherwise -1.s
		return (checkAll(arr))? -1: ans;
		
	}
	
	// Driver program
	public static void main(String[] args) {

		int arr[][] = { 
			            {2, 1, 0, 2, 1},
						{1, 0, 1, 2, 1},
						{1, 0, 0, 2, 1}
					  };
		int ans = rotOranges(arr);

		if(ans == -1)
			System.out.println("\nAll oranges cannot rot");
		else
			System.out.println("\nTime required for all oranges to rot = " + ans);
	}

}


/*
Minimum time required to rot all oranges

Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 
which has the following meaning:  

0: Empty cell
1: Cells have fresh oranges
2: Cells have rotten or damage oranges 

Determine what is the minimum time required so that all the oranges become rotten.
A rotten orange at index [i,j] can rot other fresh orange 
at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). 
If it is impossible to rot every orange then simply return -1.

Examples: 

Input:  arr[][C] = { {2, 1, 0, 2, 1},
                     {1, 0, 1, 2, 1},
                     {1, 0, 0, 2, 1}};

Output:
All oranges can become rotten in 2-time frames.

Explanation: 
At 0th time frame:
 {2, 1, 0, 2, 1}
 {1, 0, 1, 2, 1}
 {1, 0, 0, 2, 1}

At 1st time frame:
 {2, 2, 0, 2, 2}
 {2, 0, 2, 2, 2}
 {1, 0, 0, 2, 2}

At 2nd time frame:
 {2, 2, 0, 2, 2}
 {2, 0, 2, 2, 2}
 {2, 0, 0, 2, 2}


Input:  arr[][C] = { 
                     {2, 1, 0, 2, 1},
                     {0, 0, 1, 2, 1},
                     {1, 0, 0, 2, 1}
                   };
Output:
All oranges cannot be rotten.
Explanation: 
At 0th time frame:
{2, 1, 0, 2, 1}
{0, 0, 1, 2, 1}
{1, 0, 0, 2, 1}

At 1st time frame:
{2, 2, 0, 2, 2}
{0, 0, 2, 2, 2}
{1, 0, 0, 2, 2}

At 2nd time frame:
{2, 2, 0, 2, 2}
{0, 0, 2, 2, 2}
{1, 0, 0, 2, 2}
...
The 1 at the bottom left corner of the matrix is never rotten.*/