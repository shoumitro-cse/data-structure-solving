// Minimum number of operation required to convert number x into y

// javac -d classes ConvertNumber.java  && cd classes && java ConvertNumber && cd ..

import java.util.HashSet; 
import java.util.LinkedList; 
import java.util.Set; 

class Pair {

	int val; 
	int steps; 

	public Pair(int val, int steps) { 
	   this.val = val; 
	   this.steps = steps; 
	} 

} 

public class ConvertNumber {


	private static int minOperations(int src, int target) { 

		Set<Pair> visited = new HashSet<>(1000); 
		LinkedList<Pair> queue = new LinkedList<Pair>(); 

		Pair node = new Pair(src, 0); 

		queue.offer(node); 
		visited.add(node); 

		while (!queue.isEmpty()) {

			Pair temp = queue.poll(); 
			visited.add(temp); 

			if (temp.val == target) { 
				return temp.steps; 
			} 

			/*
				Input : x = 4, y = 7
				Output : 2
				We can transform x into y using following two operations.
				1. 4*2  = 8
				2. 8-1  = 7
			*/
				
			int mul = temp.val * 2; 
			int sub = temp.val - 1; 

			// given constraints 
			if (mul > 0 && mul < 1000) { 
				Pair nodeMul = new Pair(mul, temp.steps + 1); 
				queue.offer(nodeMul); 
			} 

			if (sub > 0 && sub < 1000) { 
				Pair nodeSub = new Pair(sub, temp.steps + 1); 
				queue.offer(nodeSub); 
			} 
		} 

		return -1; 
	} 

	public static void main(String[] args) { 
		// int x = 2, y = 5; 
		int x = 4, y = 7; 
		// Pair src = new Pair(x, y); 
		System.out.println(minOperations(x, y)); 
	} 



} 


/*
Minimum number of operation required to convert number x into y



Given a initial number x and two operations which are given below:

Multiply number by 2.
Subtract 1 from the number.

The task is to find out minimum number of operation required to convert number x into y using 
only above two operations. We can apply these operations any number of times.

Constraints:
1 <= x, y <= 10000

Example:

Input : x = 4, y = 7
Output : 2
We can transform x into y using following two operations.
1. 4*2  = 8
2. 8-1  = 7

Input  : x = 2, y = 5
Output : 4
We can transform x into y using following four operations.
1. 2*2  = 4
2. 4-1   = 3
3. 3*2  = 6
4. 6-1   = 5
Answer = 4

Note that other sequences of two operations 
would take more operations.

*/
