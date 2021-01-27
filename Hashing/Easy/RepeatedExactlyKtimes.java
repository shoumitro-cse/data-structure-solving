// Smallest element repeated exactly ‘k’ times (not limited to small range)

//javac -d classes RepeatedExactlyKtimes.java  && cd classes && java RepeatedExactlyKtimes && cd ..

import java.util.*; 

class RepeatedExactlyKtimes { 
	
	public static int smallestKFreq(int a[], int n, int k) {

		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>(); 

		// Map is used to store the count of elements present in the array 
		for (int i = 0; i < n; i++) {
			if (m.containsKey(a[i])) {
				m.put(a[i], m.get(a[i]) + 1); 
			} else { 
		    	m.put(a[i], 1); 
	        }
	    }

		// Traverse the map and find minimum element with frequency k. 
		int res = Integer.MAX_VALUE; 
		Set<Integer> s = m.keySet(); 
		
		for (int temp : s) {
		  if (m.get(temp) == k) {
			res = Math.min(res, temp); 
		  }
	    }
	
		return (res != Integer.MAX_VALUE)? res : -1; 
	} 
	
	public static void main(String[] args) {

		int arr[] = { 2, 2, 1, 3, 1 }; 
		int k = 2; 
		
		System.out.println(smallestKFreq(arr, arr.length, k)); 
	} 
} 


/*Smallest element repeated exactly ‘k’ times (not limited to small range)


Given an array of size n, the goal is to find out the smallest number that is 
repeated exactly ‘k’ times where k > 0?
And

Examples:

Input : a[] = {2, 1, 3, 1, 2, 2}
        k = 3
Output : 2

Input : a[] = {3, 4, 3, 2, 1, 5, 5} 
        k = 2
Output : 3
Explanation: As 3 is smaller than 5. 
So 3 should be printed.*/

