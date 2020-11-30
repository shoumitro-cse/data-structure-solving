// Java program for bubble sort using stack 

//javac -d classes BubbleSortUsingTwoStacks.java  && cd classes && java BubbleSortUsingTwoStacks && cd ..

import java.util.Arrays; 
import java.util.Stack; 

public class BubbleSortUsingTwoStacks {

	// Method for bubble sort using Stack 
	static void bubbleSortStack(int arr[], int n) 
	{ 
		Stack<Integer> s1 = new Stack<>(); 
		
		// Push all elements of array in 1st stack 
		for (int num : arr) {
			s1.push(num);	 
		}
		
		Stack<Integer> s2 = new Stack<>(); 
		
		for (int i = 0; i < n; i++) 
		{ 
			// alternatively 
			if (i % 2 == 0) 
			{ 
				while (!s1.isEmpty()) { 

					int top = s1.pop(); 
					
					if (s2.isEmpty()) {
						s2.push(top);					 
					} else { 

						if (s2.peek() > top) { 
							// swapping 
							int temp = s2.pop(); 
							s2.push(top); 
							s2.push(temp); 
						} else { 
							s2.push(top); 
						} 
					} 
				} 
				// tricky step 
				arr[n-1-i] = s2.pop(); 

			} else {

				while(!s2.isEmpty()) {
				 
					int top = s2.pop(); 
					
					if (s1.isEmpty()) {
						s1.push(top); 
					} else {
						if (s1.peek() > top) { 
							// swapping 
							int temp = s1.pop(); 
							
							s1.push(top); 
							s1.push(temp); 
						} else {
							s1.push(top); 
						}
					} 
				} 
				
				// tricky step 
				arr[n-1-i] = s1.pop(); 
			} 
		}		 
		System.out.println(Arrays.toString(arr)); 
	} 
	
	// Driver Method 
	public static void main(String[] args) 
	{ 
		int arr[] = {15, 12, 44, 2, 5, 10};	 
		bubbleSortStack(arr, arr.length); 
	} 
} 

/*
Bubble sort using two Stacks

Algorithm:

1. Push all elements of array in 1st stack

2. Run a loop for 'n' times(n is size of array)
   having the following :
   2.a. Keep on pushing elements in the 2nd 
        stack till the top of second stack is 
        smaller than element being pushed from 
        1st stack.
   2.b. If the element being pushed is smaller 
        than top of 2nd stack  then swap them
        (as in bubble sort)
   *Do above steps alternatively

TRICKY STEP: Once a stack is empty, then the 
top of the next stack will be the largest 
number so keep it at its position in array 
i.e arr[len-1-i] and then pop it from that 
stack


Iterative code:

    void bubbleSort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] and arr[j] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
    } 
*/