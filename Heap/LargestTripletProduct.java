// Largest triplet product in a stream


//javac -d classes LargestTripletProduct.java  && cd classes && java LargestTripletProduct && cd ..

import java.util.Collections;
import java.util.PriorityQueue;

class LargestTripletProduct {

	// Prints the product of three largest numbers in subarray arr[0..i]
	static void LargestTripletMultiplication(int arr[], int n) {
		// call a priority queue
		PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());
		// traversing the array
		for (int i = 0; i < n; i++) {
			// pushing arr[i] in array
			q.add(arr[i]);
			// if less than three elements are present in array print -1
			if (q.size() < 3) {
				System.out.println("-1");
			} else {
				// pop three largest elements
				int x = q.poll();
				int y = q.poll();
				int z = q.poll();

				// Reinsert x, y, z in priority_queue
				int ans = x * y * z;
				System.out.println(ans);
				q.add(x);
				q.add(y);
				q.add(z);
			}
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;
		LargestTripletMultiplication(arr, n);
	}
}

/*
Largest triplet product in a stream


Given a stream of integers represented as arr[]. For each index i from 0 to n-1, 
print the multiplication of largest, second largest, third largest element of 
the subarray arr[0…i]. If i < 2 print -1. 

Examples: 

Input : arr[] = {1, 2, 3, 4, 5}
Output :-1
        -1
         6
         24
         60
Explanation : for i = 2 only three elements 
are there {1, 2, 3} so answer is 6. For i = 3
largest three elements are {2, 3, 4} their
product is 2*3*4 = 24 ....so on    



*/