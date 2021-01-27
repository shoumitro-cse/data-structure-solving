// Maximize elements using another array

//javac -d classes Maximize.java  && cd classes && java Maximize && cd ..

import java.util.*; 

class Maximize { 

	// Function to maximize array elements 
	static void maximizeArray(int[] arr1, int[] arr2) { 

		// auxiliary array arr3 to store elements of arr1 & arr2 
		int arr3[] = new int[10]; 
		for(int i = 0; i < arr3.length; i++) { 
			//arr2 has high priority 
			arr3[i] = 0; 
		} 
		
		// Arraylist to store n largest unique elements 
		ArrayList<Integer> al = new ArrayList<Integer>(); 
		
		for(int i = 0; i < arr2.length; i++) { 
			if(arr3[arr2[i]] == 0) { 
				// to avoid repetition of digits of arr2 in arr3 
				arr3[arr2[i]] = 2; 
				// simultaneously setting arraylist to preserve order of arr2 and arr3 
				al.add(arr2[i]); 
			} 
		} 
		
		for(int i = 0; i < arr1.length; i++) { 
			if(arr3[arr1[i]] == 0) { 
				// if digit is already present in arr2 then priority is arr2 
				arr3[arr1[i]] = 1; 
				// simultaneously setting arraylist to preserve order of arr1 
				al.add(arr1[i]); 
			} 
		} 

		// to get only highest n elements(arr2+arr1) and remove others from arraylist 
		int count = 0; 
		for(int j = 9; j >= 0; j--) { 
			if(count < arr1.length & (arr3[j] == 2 || arr3[j] == 1)) { 
				// to not allow those elements which are absent in both arrays 
				count++; 
			} else { 
				al.remove(Integer.valueOf(j)); 
			} 
		} 

		int i = 0; 
		for(int x : al) { 
			arr1[i++] = x; 
		}

	} 

	// Function to print array elements 
	static void printArray(int[] arr) { 
		for(int x : arr) { 
			System.out.print(x + " "); 
		} 
	} 

	public static void main(String args[]) { 
		int arr1[] = {7, 4, 8, 0, 1}; 
		int arr2[] = {9, 7, 2, 3, 6}; 
		maximizeArray(arr1,arr2); 
		printArray(arr1); 
		System.out.println();
	} 


} 

/*
Maximize elements using another array


Given two arrays with size n, maximize the first array by using the elements from the second array such that the new array formed contains n greatest but unique elements of both the arrays giving the second array priority (All elements of second array appear before first array). The order of appearance of elements is kept same in output as in input.
Examples:

Input : arr1[] = {2, 4, 3} 
arr2[] = {5, 6, 1} 
Output : 5 6 4 
As 5, 6 and 4 are maximum elements from two arrays giving second array higher priority. Order of elements is same in output as in input.

Input : arr1[] = {7, 4, 8, 0, 1} 
arr2[] = {9, 7, 2, 3, 6} 
Output : 9 7 6 4 8
*/