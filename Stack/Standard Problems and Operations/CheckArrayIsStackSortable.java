//Check if an array is stack sortable

//javac -d classes CheckArrayIsStackSortable.java  && cd classes && java CheckArrayIsStackSortable && cd ..

import java.util.Stack; 
import java.util.*; 


class CheckArrayIsStackSortable { 

	// Function to check if A[] is Stack Sortable or Not. 
	// Time Complexity: O(N).
	static boolean check(int A[], int N) { 

		int B[] = new int[N];
		int j=0;

		// Stack S 
		Stack<Integer> S = new Stack<Integer>(); 

		// Pointer to the end value of array B. 
		int B_end = 0; 

		// Traversing each element of A[] from starting that can be performed. 
		for (int i = 0; i < N; i++) { 
			// If the stack is not empty 
			if (!S.empty()) { 
				// Top of the Stack. 
				int top = S.peek(); 
				// If the top of the stack is 
				// Equal to B_end+1, we will pop it And increment B_end by 1. 
				while (top == B_end + 1) { 
					// if current top is equal to 
					// B_end+1, we will increment B_end to B_end+1 
					B_end = B_end + 1; 
					// Pop the top element. 
					B[j++]=S.pop(); 
					// If the stack is empty We cannot 
					// further perfom this operation. Therefore break 
					if (S.empty()) { 
						break; 
					} 
					// Current Top 
					top = S.peek(); 
				} 

				// If stack is empty push the current element 
				if (S.empty()) { 
					S.push(A[i]); 
				} else { 
					top = S.peek(); 
					// If the Current element of the array A[] 
					// if smaller than the top of the stack We can push it in the Stack. 
					if (A[i] < top) { 
						S.push(A[i]); 
					} else { 
					    // Else We cannot sort the array Using any valid operations. 
						// Not Stack Sortable 
						return false; 
					} 
				} 
			} else { 
				// If the stack is empty push the current element in the stack. 
				S.push(A[i]); 
			} 
		} 

		while(!S.empty()){
          B[j++]=S.pop(); 
		}
		// System.out.println(S);
		System.out.println("B Array: "+Arrays.toString(B));
		// Stack Sortable 
		return true; 
	} 

// Driver's Code 
	public static void main(String[] args) { 

		// int  A[] = { 2, 3, 1};
		// int A[] = {7, 1, 2, 5, 6}; 
		int A[] = {7, 1, 2, 3, 4, 6}; 
		int N = A.length; 

		if (check(A, N)) { 
			System.out.println("YES"); 
		} else { 
			System.out.println("NO"); 
		} 

	} 
} 


/*Check if an array is stack sortable

Given an array of N distinct elements where elements are between 1 and N both inclusive, 
check if it is stack-sortable or not. An array A[] is said to be stack sortable if it can be 
stored in another array B[], using a temporary stack S.

The operations that are allowed on array are:

Remove the starting element of array A[] and push it into the stack.
Remove the top element of the stack S and append it to the end of array B.
If all the element of A[] can be moved to B[] by performing these operations such that 
array B is sorted in ascending order, then array A[] is stack sortable.


Input : A[] = { 3, 2, 1 }
Output : YES

Explanation : 
Step 1: Remove the starting element of array A[] 
        and push it in the stack S. ( Operation 1)
        That makes A[] = { 2, 1 } ; Stack S = { 3 }
Step 2: Operation 1
        That makes A[] = { 1 } Stack S = { 3, 2 }
Step 3: Operation 1
        That makes A[] = {} Stack S = { 3, 2, 1 }
Step 4: Operation 2
        That makes Stack S = { 3, 2 } B[] = { 1 }
Step 5: Operation 2
        That makes Stack S = { 3 } B[] = { 1, 2 }
Step 6: Operation 2
        That makes Stack S = {} B[] = { 1, 2, 3 }
  
Input : A[] = { 2, 3, 1}
Output : NO*/