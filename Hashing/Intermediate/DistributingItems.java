// Distributing items when a person cannot take more than two items of same type

//javac -d classes DistributingItems.java  && cd classes && java DistributingItems && cd ..

import java.util.HashMap;
import java.util.Map;

class DistributingItems {
	
	// Function to check hash array corresponding to the given array 
	static boolean checkCount(int arr[], int n, int k) {

		HashMap <Integer, Integer> hash = new HashMap<>(); 
	
		// Maintain a hash 
		for (int i = 0; i < n; i++) {

		  if (!hash.containsKey(arr[i])) {
			hash.put(arr[i], 0);
		  }

		  hash.put(arr[i], hash.get(arr[i]) + 1);
		}
	
		// Check for each value in hash 
		for (Map.Entry x : hash.entrySet()){
		  if ((int)x.getValue() > 2 * k) {
			 return false; 
		  }
		}
	
		return true; 
	} 

	public static void main(String []args) {
		
		int arr[] = { 1, 1, 2, 3, 1, 1, }; 
		int n = arr.length; 
		int k = 2; 

		if (checkCount(arr, n, k)) 
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}


/*
Distributing items when a person cannot take more than two items of same type


Given N sweets which can be of many different types and k customers, one customer won’t take the same type of sweet more than 2 pieces, the task is to find if it is possible to distribute all sweets then print “Yes” otherwise “No”.
Given array arr[] represents array of sweets arr[i] is type of sweet.
Examples: 
 

Input : arr[] = {1, 1, 2, 3, 1}, 
            k = 2;
Output : Yes
There are three pieces of sweet type 1,
one piece of type 2 and one piece of 
type 3. Two customers can distribute 
sweets under given constraints.

Input : arr[] = {2, 3, 3, 5, 3, 3}, 
            k = 2;
Output : Yes

Input : arr[] = {2, 3, 3, 5, 3, 3, 3}, 
            k = 2;
Output : No

*/