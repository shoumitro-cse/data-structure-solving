// Java program of Next Greater Frequency Element

// javac -d classes NextGreaterFrequency.java  && cd classes && java NextGreaterFrequency && cd ..

import java.util.*;

class NextGreaterFrequency {

	// NFG function to find the next greater frequency element for each element in the array
	//Time complexity: O(n).
	static void NFG(int arr[], int n, int freq[]) {

		// stack data structure to store the position of array element
		Stack<Integer> stack = new Stack<Integer>();

		stack.push(0);

		// res to store the value of next greater frequency element for each element
		int res[] = new int[n];

		for (int i = 0; i < n; i++) {
			res[i] = 0;
		}

		for (int i = 1; i < n; i++) {

			if (freq[arr[stack.peek()]] > freq[arr[i]]) {
				stack.push(i);
			} else {
					while (freq[arr[stack.peek()]] < freq[arr[i]] && !stack.isEmpty()) {
						res[stack.peek()] = arr[i];
						stack.pop();
					    if (stack.isEmpty() == true) {
					    	break;
		                }
					}
				// now push the current element
				stack.push(i);
			}
		}

		while (!stack.isEmpty()) {
			res[stack.peek()] = -1;
			stack.pop();
		}

/*		for (int i = 0; i < n; i++) {
			// Print the res list containing next greater frequency element
			System.out.print(res[i] + " ");
		}*/
		System.out.println("next greater frequency: "+Arrays.toString(res));
	}

	// Driver code
	public static void main(String args[]) {

		// int arr[] = { 1, 1, 2, 3, 4, 2, 1 };
		int arr[] = {1, 1, 1, 2, 2, 2, 2, 11, 3, 3};
		int len = arr.length;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < len; i++) {

			// Getting the max element of the array
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		int freq[] = new int[max + 1];//max=4

		for (int i = 0; i < max + 1; i++) {
			freq[i] = 0;
		}

		// Calculating frequency of each element
		for (int i = 0; i < len; i++) {
			freq[arr[i]]++;
		}

		System.out.println("\nOriginal arr"+Arrays.toString(arr));
		System.out.println("Frequency arr"+Arrays.toString(freq));

		// Function call
		NFG(arr, len, freq);
		System.out.println("");
	}
}



/*Next Greater Frequency Element

Given an array, for each element find the value of the nearest element to 
the right which is having a frequency greater than as that of the current element. 
If there does not exist an answer for a position, then make the value ‘-1’.

Examples: 

Input : a[] = [1, 1, 2, 3, 4, 2, 1] 
Output : [-1, -1, 1, 2, 2, 1, -1]
Explanation:
Given array a[] = [1, 1, 2, 3, 4, 2, 1] 
Frequency of each element is: 3, 3, 2, 1, 1, 2, 3
Lets calls Next Greater Frequency element as NGF
1. For element a[0] = 1 which has a frequency = 3,
   As it has frequency of 3 and no other next element 
   has frequency more than 3 so  '-1'
2. For element a[1] = 1 it will be -1 same logic 
   like a[0]
3. For element a[2] = 2 which has frequency = 2,
   NGF element is 1 at position = 6  with frequency 
   of 3 > 2
4. For element a[3] = 3 which has frequency = 1,
   NGF element is 2 at position = 5 with frequency 
   of 2 > 1
5. For element a[4] = 4 which has frequency = 1,
   NGF element is 2 at position = 5 with frequency 
   of 2 > 1
6. For element a[5] = 2 which has frequency = 2,
   NGF element is 1 at position = 6 with frequency
   of 3 > 2
7. For element a[6] = 1 there is no element to its 
   right, hence -1 

Input : a[] = [1, 1, 1, 2, 2, 2, 2, 11, 3, 3]
Output : [2, 2, 2, -1, -1, -1, -1, 3, -1, -1]

Algorithm:

1) Create a list to use values as index to store frequency of each element. 
2) Push the position of first element to stack. 
3) Pick rest of the position of elements one by one and follow following steps in loop. 
    a) Mark the position of current element as ‘i’ . 
    b) If the frequency of the element which is pointed by the top of stack is greater than
      frequency of the current element, push the current position i to the stack 
    c) If the frequency of the element which is pointed by the top of stack is less than 
       frequency of the current element and the stack is not empty then follow these steps: 
    i) continue popping the stack 
    ii) if the condition in step c fails then push the current position i to the stack 
4) After the loop in step 3 is over, pop all the elements from stack and print -1 as next
   greater frequency element for them does not exist.


*/
