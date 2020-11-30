//The Celebrity Problem

// Java program to find celebrity using stack data structure 

//javac -d classes CelebrityProblem.java  && cd classes && java CelebrityProblem && cd ..

import java.util.Stack; 

class CelebrityProblem { 

	// Person with 2 is celebrity 
	static int MATRIX[][] = {
		                        { 0, 0, 1, 0 }, 
								{ 0, 0, 1, 0 }, 
								{ 0, 0, 0, 0 }, 
								{ 0, 0, 1, 0 }
						    }; 
/*	static int MATRIX[][] = {
		                        { 0, 0, 0, 1 }, 
								{ 0, 0, 0, 1 }, 
								{ 0, 0, 0, 1 }, 
								{ 0, 0, 0, 0 }
						    }; 
*/
	// Returns true if a knows b, false otherwise 
	static boolean knows(int a, int b) { 
		boolean res = (MATRIX[a][b] == 1) ? true : false; 
		return res; 
	} 

/*	// Returns -1 if celebrity 
	// is not present. If present, returns id (value from 0 to n-1). 
	static int findCelebrity(int n) { 

		Stack<Integer> st = new Stack<>(); 
		int c; 
		
		// Step 1 :Push everybody onto stack 
		for (int i = 0; i < n; i++) { 
			st.push(i); 
		} 

		while (st.size() > 1) { 
			// Step 2 :Pop off top two persons from the stack, discard one 
			// person based on return status of knows(A, B). 
			int a = st.pop(); 
			int b = st.pop(); 
			// Step 3 : Push the remained person onto stack. 
			if (knows(a, b)) { 
				st.push(b); 
			} else {
				st.push(a); 
			}
		} 

		// If there are only two people and there is no potential candicate 
		if(st.empty()) {
			return -1; 
		}

		c = st.pop(); 
		// Step 5 : Check if the last person is celebrity or not 
		for (int i = 0; i < n; i++) { 
			// If any person doesn't know 'c' or 'a' doesn't know any person, return -1 
			// skip celebrity person (i != c)
			if (i != c && (knows(c, i) || !knows(i, c))) 
				return -1; 
		} 
		return c; 
		// return c+1; 
	} */

	// Returns -1 if celebrity is not present. If present, returns id (value from 0 to n-1). 
	// Complexity Analysis: 
	//  1. Time Complexity: O(n). 
	// 	  Total number of comparisons 2(N-1), so the time complexity is O(n).
	//  2. Space Complexity : O(1). 
	// 	  No extra space is required.
    static int findCelebrity(int n)  { 
        // Initialize two pointers as two corners 
        int a = 0; 
        int b = n - 1; 
        // Keep moving while the two pointers don't become same. 
        while (a < b) { 
            if (knows(a, b)) {
                a++; 
            } else {
                b--; 
            }
        } 
        // Check if a is actually a celebrity or not 
        for (int i = 0; i < n; i++)  { 
            // If any person doesn't know 'a' or 'a' doesn't know any person, return -1 
            if (i != a && (knows(a, i) || !knows(i, a))) {
                return -1; 
            }
        } 
        return a; 
    } 
  
	public static void main(String[] args) { 
		int n = 4; 
		int result = findCelebrity(n); 
		if (result == -1) { 
			System.out.println("No Celebrity"); 
		} else {
			System.out.println("Celebrity ID " + result); 
		}
	} 
} 

/*
The Celebrity Problem

In a party of N people, only one person is known to everyone. 
Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. 
We can only ask questions like “does A know B? “. Find the stranger (celebrity) in the minimum 
number of questions.
We can describe the problem input as an array of numbers/characters representing persons in 
the party. We also have a hypothetical function HaveAcquaintance(A, B) which returns true 
if A knows B, false otherwise. How can we solve the problem. 
Examples: 
 

Input:
MATRIX = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 0, 0, 0},
           {0, 0, 1, 0} }
Output:id = 2
Explanation: The person with ID 2 does not 
know anyone but everyone knows him

Input:
MATRIX = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 1, 0, 0},
           {0, 0, 1, 0} }
Output: No celebrity
Explanation: There is no celebrity.*/



/*Complexity Analysis: 
Time Complexity: O(n). 
The recursive function is called n times, so the time complexity is O(n).
Space Complexity: O(1). 
As no extra space is required.

Approach: There are some observations based on elimination technique (Refer Polya’s 
How to Solve It book). 

1. If A knows B, then A can’t be a celebrity. Discard A, and B may be celebrity.
2. If A doesn’t know B, then B can’t be a celebrity. Discard B, and A may be celebrity.
3. Repeat above two steps till there is only one person.
4. Ensure the remained person is a celebrity. (What is the need of this step?)

Algorithm: 
1. Create a stack and push all the id’s in the stack.
2. Run a loop while there are more than 1 element in the stack.
3. Pop top two element from the stack (represent them as A and B)
4. Check if A knows B, then A can’t be a celebrity and push B in stack. 
   Check if A doesn’t know B, then B can’t be a celebrity push A in stack
5. Assign the remaining element in the stack as the celebrity
6. Run a loop from 0 to n-1 and find the count of persons who knows the celebrity and 
   the number of people whom the celebrity knows. if the count of persons who knows 
   the celebrity is n-1 and the count of people whom the celebrity knows is 0 then 
   return the id of celebrity else return -1.*/



/*   // C++ program to find celebrity 
#include <bits/stdc++.h> 
#include <list> 
using namespace std; 

// Max # of persons in the party 
#define N 8 

// Person with 2 is celebrity 
bool MATRIX[N][N] = {{0, 0, 1, 0}, 
					{0, 0, 1, 0}, 
					{0, 0, 0, 0}, 
					{0, 0, 1, 0}}; 

bool knows(int a, int b) 
{ 
	return MATRIX[a][b]; 
} 

// Returns -1 if celebrity 
// is not present. If present, 
// returns id (value from 0 to n-1). 
int findCelebrity(int n) 
{ 
	//the graph needs not be constructed 
	//as the edges can be found by 
	//using knows function 
	
	//degree array; 
	int indegree[n]={0},outdegree[n]={0}; 
	
	//query for all edges 
	// Complexity Analysis: 
	// Time Complexity: O(n2). 
	// A nested loop is run traversing the array, SO the time complexity is O(n2)
	// Space Complexity: O(n). 
	// Since extra space of size n is required.

	for(int i=0; i<n; i++) 
	{ 
		for(int j=0; j<n; j++) 
		{ 
			int x = knows(i,j); 
			
			//set the degrees 
			outdegree[i]+=x; 
			indegree[j]+=x; 
		} 
	} 
	
	//find a person with indegree n-1 
	//and out degree 0 
	for(int i=0; i<n; i++) 
	if(indegree[i] == n-1 && outdegree[i] == 0) 
		return i; 
	
	return -1; 
} 

// Driver code 
int main() 
{ 
	int n = 4; 
	int id = findCelebrity(n); 
	id == -1 ? cout << "No celebrity" : 
			cout << "Celebrity ID " << id; 
	return 0; 
} 
*/