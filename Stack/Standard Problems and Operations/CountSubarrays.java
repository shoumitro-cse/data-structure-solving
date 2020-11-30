// count number of distinct instance where second highest number lie before highest number in all //subarrays. 

//javac -d classes CountSubarrays.java  && cd classes && java CountSubarrays && cd ..

import java.util.*; 

class CountSubarrays { 
	
	static int MAXN = 100005; 

	static class pair {

		int first, second; 
	
		public pair(int first, int second) { 
			this.first = first; 
			this.second = second; 
		} 
	} 
	
	// Finding the next greater element of the array. 
	static void findNextBigIndexes(int arr[], int n, int nextBigIndex[]) { 
		//n=4 
		Stack<pair> s = new Stack<>(); 

		for (int i = n-1; i >= 0; i--) {

			nextBigIndex[i] = i; 

			while (!s.empty() && s.peek().first < arr[i]) {
				s.pop(); 
			}

			if (!s.empty()) {
				nextBigIndex[i] = s.peek().second; 
			}

			s.push(new pair(arr[i], i)); 
		} 
	} 
	
	// Finding the previous greater element of the array. 
	static void findPreviousBigIndexes(int arr[], int n, int prevBigIndex[]) 
	{ 
		Stack<pair> s = new Stack<>(); 

		for (int i = 0; i < n; i++) {

			prevBigIndex[i] = -1; 

			while (!s.empty() && s.peek().first < arr[i]) {
				s.pop(); 
			}

			if (!s.empty()) {
				prevBigIndex[i] = s.peek().second; 
			}

			s.push(new pair(arr[i], i)); 
		} 
	} 

	// Wrapper Function 
	//Time Complexity: O(n)
	static int wrapper(int arr[], int n) {

		int []nextBigIndex = new int[n]; 
		int []prevBigIndex = new int[n]; 
		int []max_arr = new int[n]; 
		int ans = 0; 

		// Finding previous largest element 
		findPreviousBigIndexes(arr, n, prevBigIndex); 
		// Finding next largest element 
		findNextBigIndexes(arr, n, nextBigIndex); 

        System.out.println("arr: "+Arrays.toString(arr));

        System.out.println("nextBigIndex: "+Arrays.toString(nextBigIndex));
        System.out.println("prevBigIndex: "+Arrays.toString(prevBigIndex));

        System.out.println("max_arr: "+Arrays.toString(max_arr));
		//n=4
		for (int index = 0; index < n; index++) { 

			if (nextBigIndex[index] != index) {
				
				int nextIndex = nextBigIndex[index] - index;
				int prevIndex = index - prevBigIndex[index];

				max_arr[nextIndex] = Math.max(max_arr[nextIndex], prevIndex); 
			}
		}

		for (int i = 0; i < n; i++) {
			ans =  ans + max_arr[i]; 
		}

        System.out.println("max_arr: "+Arrays.toString(max_arr));
		return ans; 
	} 
	// Driver code 
	public static void main(String[] args) { 

		int arr[] = { 1, 3, 2, 4 }; 
		int n = arr.length; 

		System.out.println("Output: "+wrapper(arr, n)); 
	} 
} 

/*
Count subarrays where second highest lie before highest

Given an array of N distinct element of at least size 2. A pair (a, b) in an array is 
defined as ‘a’ is the index of second highest element and ‘b’ is the index of highest 
element in the array. The task is to count all the distinct pair where a < b in all 
the subarrays.

Examples :

Input : arr[] = { 1, 3, 2, 4 }
Output : 3
Explanation :
The subarray { 1 }, { 3 }, { 2 }, { 4 } does not contain any such pair
The subarray { 1, 3 }, { 2, 4 } contain (1, 2) as pair
The subarray { 3, 2 } does not contain any such pair
The subarray { 3, 2, 4 } contain (1, 3) as a pair
The subarray { 1, 3, 2 } does not contain any such pair
The subarray { 1, 3, 2, 4 } contain (2, 4) as a pair
So, there are 3 distinct pairs, which are (1, 2), (1, 3) and (2, 4).


Method 1: (Brute Force) – Simple approach can be,
1. Find all the subarrays.
2. For each subarray, find second largest and largest element.
3. Check if second largest element lie before largest element.
4. If so, check if such index pair is already counted or not. If not store the pair 
   and increment the count by 1, else ignore.
Time Complexity: O(n2).




Method 2: (Using stack) –
For given array A, suppose for an element at index curr (A[curr]), first element greater than it 
and after it is A[next] and first element greater than it and before it A[prev]. Observe that for 
all subarray starting from any index in range [prev + 1, curr] and ending at index next, 
A[curr] is the second largest and A[next] is the largest, which generate (curr – prev + 1) pairs 
in total with difference of (next – curr + 1) in maximum and second maximum.

If we get next and prev greater element in an array, and keep track of maximum number of pairs 
possible for any difference (of largest and second largest). We will need to add all these numbers.

Now only job left is to get greater element (after and before) any element. For this, refer 
Next Greater Element.

Traverse from the starting element in an array, keeping track of all numbers in the stack in 
decreasing order. After arriving at any number, pop all elements from stack which are less 
than current element to get location of number bigger than it and push current element on it. 
This generates required value for all numbers in the array.

*/