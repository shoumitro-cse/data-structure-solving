// The Stock Span Problem

//javac -d classes StockSpanProblem.java  && cd classes && java StockSpanProblem && cd ..

import java.util.Stack; 
import java.util.Arrays; 

public class StockSpanProblem { 

/*	1. Time Complexity: O(n). It seems more than O(n) at first look. 
	If we take a closer look, we can observe that every element of the array is added 
	and removed from the stack at most once. So there are total 2n operations at most. 
	Assuming that a stack operation takes O(1) time, we can say that the time complexity is O(n).

    2. Auxiliary Space: O(n) in worst case when all elements are sorted in decreasing order.*/

	// A stack based efficient method to calculate 
	// stock span values 
/*	static void calculateSpan(int price[], int n, int S[]) 
	{ 
		// Create a stack and push index of first element 
		// to it 
		Stack<Integer> st = new Stack<>(); 
		st.push(0); 

		// Span value of first element is always 1 
		S[0] = 1; 

		// Calculate span values for rest of the elements 
		for (int i = 1; i < n; i++) { 

			// Pop elements from stack while stack is not 
			// empty and top of stack is smaller than 
			// price[i] 
			while (!st.empty() && price[st.peek()] <= price[i]) 
				st.pop(); 

			// If stack becomes empty, then price[i] is 
			// greater than all elements on left of it, i.e., 
			// price[0], price[1], ..price[i-1]. Else price[i] 
			// is greater than elements after top of stack 
			S[i] = (st.empty()) ? (i + 1) : (i - st.peek()); 

			// Push this element to stack 
			st.push(i); 
		} 
	} */



/*	// Time Complexity is O(n^2). 
    static void calculateSpan(int price[], int n, int S[]) { 
        // Span value of first day is always 1 
        S[0] = 1; 
        // Calculate span value of remaining days by linearly checking previous days 
        for (int i = 1; i < n; i++) { 
            S[i] = 1; // Initialize span value 
            // Traverse left while the next element on left is smaller than price[i] 
            for (int j = i-1; (j >= 0) && (price[i] >= price[j]); j--) {
                // S[i]++; 
                S[i] = S[i]+1; 
            }
        } 
    } */


    // An efficient method to calculate 
    // stock span values implementing the same idea without using stack 
    static void calculateSpan(int A[],  int n, int answer[]) { 
        // Span value of first element is always 1 
        answer[0] = 1; 
        // Calculate span values for rest of the elements 
        for (int i = 1; i < n; i++) { 
            int counter = 1; 
            while ((i - counter) >= 0 && A[i] >= A[i - counter]) { 
                counter = counter + answer[i-counter]; 
            } 
            answer[i] = counter; 
        } 
    } 

	// A utility function to print elements of array 
	static void printArray(int arr[]) { 
		System.out.println(Arrays.toString(arr)); 
	} 

	// Driver method 
	public static void main(String[] args) 
	{ 
		// int price[] = { 10, 4, 5, 90, 120, 80 }; 
		int price[] = { 100, 80, 60, 70, 60, 75, 85 }; 
		int n = price.length; 
		int S[] = new int[n]; 
		// Fill the span values in array S[] 
		calculateSpan(price, n, S); 
		// print the calculated span values 
		printArray(S); 
	} 
} 

/*The Stock Span Problem

The stock span problem is a financial problem where we have a series of n daily price quotes 
for a stock and we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number of 
consecutive days just before the given day, for which the price of the stock on the 
current day is less than or equal to its price on the given day.

For example, 
if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, 
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}*/