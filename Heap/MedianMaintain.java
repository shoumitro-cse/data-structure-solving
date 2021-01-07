// Median of Stream of Running Integers using STL

//javac -d classes MedianMaintain.java  && cd classes && java MedianMaintain && cd ..

import java.util.Collections; 
import java.util.PriorityQueue; 

public class MedianMaintain { 
	// method to calculate med of stream 
	public static void printMedian(int[] a) { 
		double med = a[0]; 
		// max heap to store the smaller half elements 
		PriorityQueue<Integer> smaller = new PriorityQueue<> (Collections.reverseOrder()); 
		// min-heap to store the greater half elements 
		PriorityQueue<Integer> greater = new PriorityQueue<>(); 
		
		smaller.add(a[0]); 
		System.out.println(med); 
		
		for(int i = 1; i < a.length; i++) { 
			int x = a[i]; 
			// case1(left side heap has more elements) 
			if(smaller.size() > greater.size()) { 
				
				if(x < med) { 
					greater.add(smaller.remove()); 
					smaller.add(x); 
				} else {
					greater.add(x); 
				}

				med = (double)(smaller.peek() + greater.peek())/2; 
			} else if(smaller.size() == greater.size()) { 
			// case2(both heaps are balanced) 
				if(x < med) { 
					smaller.add(x); 
					med = (double)smaller.peek(); 
				} else { 
					greater.add(x); 
					med = (double)greater.peek(); 
				} 
			} else { 
		    	// case3(right side heap has more elements) 
				if(x > med) { 
					smaller.add(greater.remove()); 
					greater.add(x); 
				} else {
					smaller.add(x); 
				}
				med = (double)(smaller.peek() + greater.peek())/2; 
			} 

			System.out.println(med); 
		} 
	} 
	
	public static void main(String []args) { 
		// stream of integers 
		int[] arr = new int[] {5, 15, 10, 20, 3}; 
		printMedian(arr); 
	} 
} 


/*
Median of Stream of Running Integers using STL


Given that integers are being read from a data stream. Find the median of all the elements read so far starting from the first integer till the last integer. This is also called the Median of Running Integers. The data stream can be any source of data, for example, a file, an array of integers, input stream etc.

What is Median?

Median can be defined as the element in the data set which separates the higher half of the data sample from the lower half. In other words, we can get the median element as, when the input size is odd, we take the middle element of sorted data. If the input size is even, we pick an average of middle two elements in the sorted stream.

Examples:

Input: 5 10 15
Output: 5, 7.5, 10
Explanation: Given the input stream as an array of integers [5,10,15]. Read integers one by one and print the median correspondingly. So, after reading first element 5,median is 5. After reading 10,median is 7.5 After reading 15 ,median is 10.




Input: 1, 2, 3, 4
Output: 1, 1.5, 2, 2.5
Explanation: Given the input stream as an array of integers [1, 2, 3, 4]. Read integers one by one and print the median correspondingly. So, after reading first element 1,median is 1. After reading 2,median is 1.5 After reading 3 ,median is 2.After reading 4 ,median is 2.5.

*/

