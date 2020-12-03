// C++ program to rot all oranges when u can move
// in all the four direction from a rotten 

//g++ Min_time_required_rot_all_oranges.cpp && ./a.out

#include <bits/stdc++.h>
using namespace std;

const int R = 3;
const int C = 5;

// Check if i, j is under the array limits of row and column
bool issafe(int i, int j)
{
	if (i >= 0 && i < R && j >= 0 && j < C)
		return true;
	return false;
}

int rotOranges(int v[R][C]) {

	bool changed = false;
	int no = 2;

	while (true) {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// Rot all other oranges present at
				// (i+1, j), (i, j-1), (i, j+1), (i-1, j)
				if (v[i][j] == no) {
					if (issafe(i + 1, j) && v[i+1][j] == 1) {
						v[i + 1][j] = v[i][j] + 1;
						changed = true;
					}
					if (issafe(i, j + 1) && v[i][j+1] == 1) {
						v[i][j + 1] = v[i][j] + 1;
						changed = true;
					}
					if (issafe(i - 1, j) && v[i-1][j] == 1) {
						v[i - 1][j] = v[i][j] + 1;
						changed = true;
					}
					if (issafe(i, j - 1) && v[i][j-1] == 1) {
						v[i][j - 1] = v[i][j] + 1;
						changed = true;
					}
				}
			}
		}

		// if no rotten orange found it means all oranges rottened now
		if (!changed){
			break;
		}

		changed = false;
		no++;
	}

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			// if any orange is found to be not rotten then ans is not possible
			if (v[i][j] == 1) {
				return -1;
			}
		}
	}
	// Because initial value for a rotten orange was 2
	return no - 2;
}

// Driver function
int main()
{

	int v[R][C] = { 
		            { 2, 1, 0, 2, 1 },
					{ 1, 0, 1, 2, 1 },
					{ 1, 0, 0, 2, 1 } 
				  };

	cout << "\n\nMax time incurred: "<< rotOranges(v)<<endl;

	return 0;
}



/*

Complexity Analysis: 
Time Complexity : O(max(R,C) * R *C). 
The matrix needs to be traversed again and again until there is no change in the matrix, that can happen max(R,C) times. So time complexity is O(max(R,C) * R *C).
Space Complexity:O(1). 
No extra space is required.


Minimum time required to rot all oranges
Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 
which has the following meaning:  

0: Empty cell
1: Cells have fresh oranges
2: Cells have rotten oranges 
Determine what is the minimum time required so that all the oranges become rotten. 
A rotten orange at index [i,j] can rot other fresh orange at 
indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). 
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


Input:  arr[][C] = { {2, 1, 0, 2, 1},
                     {0, 0, 1, 2, 1},
                     {1, 0, 0, 2, 1}};
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