// Last seen array element (last appearance is earliest)

//javac -d classes LastSeenArray.java  && cd classes && java LastSeenArray && cd ..

import java.util.*; 

class LastSeenArray { 

	// Returns last seen element in arr[] 
	static int lastSeenElement(int a[], int n) { 

		// Store last occurrence index of every element 
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>(); 
		
		for (int i = 0; i < n; i++) { 
			hash.put(a[i], i); 
		} 

		// Find an element in hash with minimum index value 
		int res_ind = Integer.MAX_VALUE, res = 0; 
		for (Map.Entry<Integer, Integer> x : hash.entrySet()) { 
			if (x.getValue() < res_ind) { 
				res_ind = x.getValue(); 
				res = x.getKey(); 
			} 
		} 
		return res; 
	} 


	public static void main(String[] args) { 
		int a[] = { 2, 1, 2, 2, 4, 1 }; 
		int n = a.length; 
		System.out.println(lastSeenElement(a, n)); 
	} 
} 


/*
Last seen array element (last appearance is earliest)


Given an array that might contain duplicates, find the element whose last appearance is latest.

Examples:

Input :  arr[] = {10, 30, 20, 10, 20}
Output : 30
Explanation: Below are indexes of last
appearances of all elements (0 based indexes)
10 last occurs at index 3
30 last occurs at index 1
20 last occurs at index 2
The element whose last appearance earliest
is 30.

Input : arr[] = {20, 10, 20, 20, 40, 10}
Output : 20
Explanation: 
Explanation: Below are indexes of last
appearances of all elements (0 based indexes)
20 last occurs at index 2
10 last occurs at index 5
40 last occurs at index 4
The element whose last appearance earliest
is 20.
*/
