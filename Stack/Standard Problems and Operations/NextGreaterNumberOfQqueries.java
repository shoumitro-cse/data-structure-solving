// Print next greater number of Q queries

// javac -d classes NextGreaterNumberOfQqueries.java  && cd classes && java NextGreaterNumberOfQqueries && cd ..


import java.util.*; 

class NextGreaterNumberOfQqueries {

	// Time complexity: O(n)
	// Auxiliary Space: O(n)
	public static int[] query(int arr[]) {

		// this array contains the next greatest elements of all the elements 
		int ans[] = new int[arr.length];
		Stack<Integer> s = new Stack<>(); 
		// push the 0th index to the stack 
		s.push(arr[0]); 
		int j = 0; 
		//traverse rest of the array 
		for(int i = 1; i < arr.length; i++) { 
			
			int next = arr[i]; 

			if(!s.isEmpty()) { 

				int element = s.pop(); 
				while(next > element) { 

					ans[j] = next; 
					j++; 

					if(s.isEmpty()) {
						break; 
					}
					element = s.pop(); 
				} 

				if (element > next) 
					s.push(element); 
			} 
			s.push(next); 
		} 

		while(!s.isEmpty()) 
		{ 
			int element = s.pop(); 
			ans[j] = -1; 
			j++; 
		} 
		// return the next greatest array 
		return ans; 
	} 

	// Driver Code	 
	public static void main(String[] args) 
	{ 
		int arr[] = {3, 4, 2, 7, 5, 8, 10, 6}; 
		int query[] = {3, 6, 1}; // query indexes, here index=3, 6, 1

		int ans[] = query(arr); 
		System.out.println("Answer: "+Arrays.toString(ans));
		
		// getting output array 
		// with next greatest elements 
		for(int i = 0; i < query.length; i++) { 
			System.out.print(ans[query[i]] + " "); 
		} 
		System.out.print("\n"); 
	} 
} 




/*

Print next greater number of Q queries

Given an array of n elements and q queries, for each query which has an index i, 
find the next greater element and print its value. If there is no such greater element 
to its right then print -1.

Examples:

Input : arr[] = {3, 4, 2, 7, 5, 8, 10, 6} 
        query indexes = {3, 6, 1}
Output: 8 -1 7

Explanation : 
For the 1st query index is 3, element is 7 and 
the next greater element at its right is 8 

For the 2nd query index is 6, element is 10 and 
there is no element greater then 10 at right, 
so print -1.

For the 3rd query index is 1, element is 4 and
the next greater element at its right is 7.


Algorithm:

1) Push the first index to stack.
2) Pick rest of the index one by one and follow following steps in loop.
….a) Mark the current element as i.
….b) If stack is not empty, then pop an index from stack and compare a[index] with a[I].
….c) If a[I] is greater than the a[index], then a[I] is the next greater element for the a[index].
….d) Keep popping from the stack while the popped index element is smaller than a[I]. a[I] becomes the next greater element for all such popped elements
….g) If a[I] is smaller than the popped index element, then push the popped index back.

3) After the loop in step 2 is over, pop all the index from stack and print -1 as next index for them.

*/