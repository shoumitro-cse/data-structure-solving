// Find duplicates in a given array when elements are not limited to a range

//javac -d classes FindDuplicatesGivenArray.java  && cd classes && java FindDuplicatesGivenArray && cd ..

import java.util.ArrayList;

public class FindDuplicatesGivenArray {

	static void findDuplicates(int arr[], int len) {

		// initialize ifPresent as false
		boolean ifPresent = false;

		// ArrayList to store the output
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < len-1; i++) {
		  for (int j = i+1; j < len; j++) {
			 if (arr[i] == arr[j]) {
				if (al.contains(arr[i])) {
				   break;
				} else {
				   al.add(arr[i]);
				   ifPresent = true;
				}
			 }
		  }
		}

		// if duplicates is present then print ArrayList
		if (ifPresent == true) {
			System.out.print(al + " ");
		} else {
			System.out.print("No duplicates present in arrays");
		}

	}

	public static void main(String[] args) {
		int arr[] = { 12, 11, 40, 12, 5, 6, 5, 12, 11 };
		int n = arr.length;
		findDuplicates(arr, n);
		System.out.println();
	}
}



/*
Find duplicates in a given array when elements are not limited to a range

Given an array of n integers. The task is to print the duplicates in the given array. 
If there are no duplicates then print -1. 

Examples: 

Input: {2, 10, 10, 100, 2, 10, 11, 2, 11, 2}
Output: 2 10 11

Input: {5, 40, 1, 40, 100000, 1, 5, 1}
Output: 5 40 1
*/

