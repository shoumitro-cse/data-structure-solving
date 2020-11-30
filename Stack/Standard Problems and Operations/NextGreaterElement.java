// Simple Java program to print next greater elements in a given array 

//javac -d classes NextGreaterElement.java  && cd classes && java NextGreaterElement && cd ..
import java.util.*; 

class NextGreaterElement 
{ 
	 // prints element and NGE pair for all elements of arr[] of size n 
	//Time Complexity: O(n^2).
/*	static void printNGE(int arr[], int n) 
	{ 
		System.out.println("\n\nElement  Greater"); 
		int next, i, j; 
		for (i=0; i<n; i++) 
		{ 
			next = -1; 
			for (j = i+1; j<n; j++) 
			{ 
				if (arr[i] < arr[j]) 
				{ 
					next = arr[j]; 
					break; 
				} 
			} 
			System.out.println("  "+arr[i]+"----> "+next); 
		} 
	} */


   // Time Complexity: O(n).
	static void printNGE(int arr[], int n) {
        int i = 0; 
        Stack<Integer> stack = new Stack<Integer>(); 
        int element, next; 
         // push the first element to stack 
        stack.push(arr[0]); 
        // iterate for rest of the elements 
        for (i = 1; i < n; i++) { 
            next = arr[i]; 
            if (stack.isEmpty() == false) { 
                // if stack is not empty, then pop an element from stack 
                element = stack.pop(); 
                 // If the popped element is smaller than next, then a) print the pair b) keep  
                 //   popping while elements are smaller and stack is not empty 
                while (element < next) { 
                    System.out.println(element + " --> " + next); 
                    if (stack.isEmpty() == true) {
                        break; 
                    }
                    element = stack.pop(); 
                } 
                 // If element is greater than next, then push the element back 
                if (element > next) {
                    stack.push(element); 
                }
            } 
             // push next to stack so that we can find next greater for it 
            stack.push(next); 
        } 
  
        //  After iterating over the loop, the remaining  elements in stack 
        // do not have the next greater element, so print -1 for them 
        while (stack.isEmpty() == false) { 
            element = stack.pop(); 
            next = -1; 
            System.out.println(element + " -- " + next); 
        } 
    }
	
	public static void main(String args[]) 
	{ 
		int arr[]= {11, 13, 21, 3, 30}; 
		int n = arr.length; 
		printNGE(arr, n); 
	} 
} 



/*
Problem: Next Greater Element


Given an array, print the Next Greater Element (NGE) for every element. 
The Next greater Element for an element x is the first greater element on the 
right side of x in array. Elements for which no greater element exist, consider 
next greater element as -1.

Examples:

For any array, rightmost element always has next greater element as -1.
For an array which is sorted in decreasing order, all elements have next greater element as -1.
For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1*/