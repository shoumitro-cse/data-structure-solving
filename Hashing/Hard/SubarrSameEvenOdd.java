//Count subarrays with same even and odd elements


class SubarrSameEvenOdd { 

	static int countSubarrays(int[] arr, int n) { 
		
		// initialize difference and answer with 0 
		int difference = 0; 
		int ans = 0; 

		int[] hash_positive = new int[n + 1]; 
		int[] hash_negative = new int[n + 1]; 

		hash_positive[0] = 1; 

		for (int i = 0; i < n; i++) { 
			if ((arr[i] & 1) == 1) { 
				difference++; 
			} else { 
				difference--; 
			} 

			if (difference < 0) { 
				ans += hash_negative[-difference]; 
				hash_negative[-difference]++; 
			} else { 
			   // else use hash_positive 
				ans += hash_positive[difference]; 
				hash_positive[difference]++; 
			} 
		} 

		// return total number of even-odd subarrays 
		return ans; 
	} 

	public static void main(String[] args) { 
		int[] arr = new int[]{3, 4, 6, 8, 1, 10, 5, 7}; 
		int n = arr.length; 
		// Printing total number of even-odd subarrays 
		System.out.println("Total Number of Even-Odd"+ " subarrays are "+ countSubarrays(arr, n)); 
	}

} 

/*
Count subarrays with same even and odd elements


Given an array of N integers, count number of even-odd subarrays. An even – odd subarray 
is a subarray that contains the same number of even as well as odd integers.

Examples :

Input : arr[] = {2, 5, 7, 8} 
Output : 3
Explanation : There are total 3 even-odd subarrays.
               1) {2, 5}
               2) {7, 8}
               3) {2, 5, 7, 8}

Input : arr[] = {3, 4, 6, 8, 1, 10} 
Output : 3
Explanation : In this case, 3 even-odd subarrays are:
               1) {3, 4}
               2) {8, 1}
               3) {1, 10}
*/
