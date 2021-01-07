// Java program to find minimum product of k elements in an array 


//Minimum product of k integers in an array of positive Integers

//javac -d classes MinProductOfKEle.java  && cd classes && java MinProductOfKEle && cd ..

import java.util.PriorityQueue; 

class MinProductOfKEle {

	public static int minProduct(int[] arr, int n, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			pq.add(arr[i]); 
		}

		int count = 0, ans = 1; 
		// One by one extract items 
		while(pq.isEmpty() == false && count < k) { 
			ans = ans * pq.remove(); 
			count++; 
		} 
		
	  return ans; 
	} 

	public static void main(String[] args) { 
		int arr[] = {198, 76, 544, 123, 154, 675}; 
		int k = 2; 
		int n = arr.length; 
		System.out.println("Minimum product is " + minProduct(arr, n, k)); 
	} 
} 



/*
Minimum product of k integers in an array of positive Integers


Given an array of n positive integers. We are required to write a program to print 
the minimum product of k integers of the given array.

Examples:

Input : 198 76 544 123 154 675
         k = 2
Output : 9348
We get minimum product after multiplying
76 and 123.

Input : 11 8 5 7 5 100
        k = 4
Output : 1400
*/
