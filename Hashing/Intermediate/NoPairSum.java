// Java Program to find the subarray with no pair sum divisible by K 

//javac -d classes NoPairSum.java  && cd classes && java NoPairSum && cd ..

import java.io.*; 
import java.util.*; 

public class NoPairSum { 
	
	// function to find the subarray with no pair sum divisible by k 
	static void subarrayDivisibleByK(int []arr, int n, int k) { 

		// hash table to store the remainders obtained on dividing by K 
		int [] mp = new int[1000]; 
		int s = 0, e = 0, maxs = 0, maxe = 0; 
		// insert the first element in the set 
		mp[arr[0] % k]++; 
	
		for (int i = 1; i < n; i++) { 
			int mod = arr[i] % k; 
			while (mp[k-mod] != 0 || (mod == 0 && mp[mod] != 0)) { 
				mp[arr[s] % k]--; 
				s++; 
			} 
			mp[mod]++; 
			e++; 
			if ((e-s) > (maxe-maxs)) { 
				maxe = e; 
				maxs = s; 
			} 
	
		} 
	
		System.out.print("The maximum size is "+(maxe-maxs + 1)+" and the subarray is as follows\n"); 
	
		for (int i = maxs; i <= maxe; i++) {
			System.out.print(arr[i] + " "); 
		}

	} 
	
	public static void main(String args[]) { 
		int k = 3; 
		int []arr = {5, 10, 15, 20, 25}; 
		int n = arr.length; 
		subarrayDivisibleByK(arr, n, k); 
		System.out.println();
	} 
} 

/*
Subarray with no pair sum divisible by K


Given an array of N non-negative integers, task is to find the maximum size of a subarray 
such that the pairwise sum of the elements of this subarray is not divisible by a given integer, K. 
Also, print this subarray as well. If there are two or more subarrays which follow the above 
stated condition, then print the first one from the left.

Prerequisite : Subset with no pair sum divisible by K

Examples :

Input : arr[] = [3, 7, 1, 9, 2]        
        K = 3
Output : 3
         [3, 7, 1]
3 + 7 = 10, 3 + 1 = 4, 7 + 1 = 8, all are 
not divisible by 3. 
It is not possible to get a subarray of size bigger
than 3 with the above-mentioned property.
[7, 1, 9] is also of the same size but [3, 7, 1] comes first.

Input : arr[] = [2, 4, 4, 3]        
        K = 4
Output : 2
         [2, 4]
2 + 4 = 6 is not divisible by 4. 
It is not possible to get a subarray of size bigger 
than 2 with the above-mentioned property.
[4, 3] is also of the same size but [2, 4] comes first.

*/