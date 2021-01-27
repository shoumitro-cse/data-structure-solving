// Maximum consecutive numbers present in an array

import java.util.*; 

class MaxConsecutiveNum { 
	
	static int findLongestConseqSubseq(int arr[], int n) {

		 // We insert all the array elements into unordered set. 
		HashSet<Integer> S = new HashSet<Integer>(); 
		for (int i = 0; i < n; i++) { 
			S.add(arr[i]); 
		}

		// check each possible sequence from the start then update optimal length 
		int ans = 0; 
		for (int i = 0; i < n; i++) { 
			// if current element is the starting element of a sequence 
			if(S.contains(arr[i])) { 
				// Then check for next elements in the sequence 
				int j = arr[i]; 
				// increment the value of array element and repeat search in the set 
				while (S.contains(j)) {
					j++; 
				}
				// Update optimal length if this length is more. To get the length as it is 
				// incremented one by one 
				ans = Math.max(ans, j - arr[i]); 
			} 
		} 
		return ans; 
	} 

	public static void main(String[] args) 
	{ 
		int arr[] = {1, 94, 93, 1000, 5, 92, 78}; 
		int n = arr.length; 
			System.out.println(findLongestConseqSubseq(arr, n)); 
	} 
} 


/*
Maximum consecutive numbers present in an array


Find the length of maximum number of consecutive numbers jumbled up in an array.

Examples:

Input : arr[] = {1, 94, 93, 1000, 5, 92, 78};
Output : 3 
The largest set of consecutive elements is
92, 93, 94 

Input  : arr[] = {1, 5, 92, 4, 78, 6, 7};
Output : 4 
The largest set of consecutive elements is
4, 5, 6, 7

*/