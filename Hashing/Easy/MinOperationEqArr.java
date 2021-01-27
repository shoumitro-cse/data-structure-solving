// Minimum operation to make all elements equal in array

//javac -d classes MinOperationEqArr.java  && cd classes && java MinOperationEqArr && cd ..

import java.util.*; 

class MinOperationEqArr { 
	
	// function for min operation 
	public static int minOperation (int arr[], int n) { 

		// Insert all elements in hash. 
	    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>(); 
		
		for (int i=0; i<n; i++) {

			if(hash.containsKey(arr[i])) {
				hash.put(arr[i], hash.get(arr[i])+1); 
			} else {
				hash.put(arr[i], 1); 
			}
		}

		// find the max frequency 
		int max_count = 0; 
		Set<Integer> s = hash.keySet(); 

		for (int i : s) {
		  // System.out.println(hash.get(i));
		  if (max_count < hash.get(i)) { 
			max_count = hash.get(i); 
		  }

		}

		// System.out.println(max_count);
		// System.out.println(n);

		System.out.println();

		// return result 
		return (n - max_count); 
	} 
	
	public static void main(String[] args) {

		// int arr[] = {1, 5, 2, 1, 3, 2, 1}; 
		int arr[] = {1, 2, 3, 4}; 
		int n = arr.length; 
		System.out.println(minOperation(arr, n)); 
	
	    // int a=5;		
		// System.out.println(a++ +" "+ --a +" "+ --a+" "+a);	
	} 
} 
	

/*
Minimum operation to make all elements equal in array

Given an array with n positive integers. We need to find the minimum number of operation 
to make all elements equal. We can perform addition, multiplication, subtraction or division 
with any element on an array element.

Examples:

Input : arr[] = {1, 2, 3, 4}
Output : 3

Since all elements are different, we need to perform at least three
operations to make them same. For example, we can make them all 1
by doing three subtractions. Or make them all 3 by doing three additions.

Input : arr[] = {1, 1, 1, 1}
Output : 0
*/