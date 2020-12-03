// Java program to implement sorting a queue data structure 

//javac -d classes SortQueue.java  && cd classes && java SortQueue && cd ..

import java.util.LinkedList; 
import java.util.Queue; 

class SortQueue {

	// Queue elements after sortIndex are 
	// already sorted. This function returns 
	// index of minimum element from front to 
	// sortIndex 
    public static int minIndex(Queue<Integer> list, int sortIndex) {

		int min_index = -1; 
		int min_value = Integer.MAX_VALUE; 
		int s = list.size(); 

		for (int i = 0; i < s; i++) { 
			int current = list.poll(); 
			if (current <= min_value && i <= sortIndex) { 
				min_index = i; 
				min_value = current; 
			} 
			list.add(current); 
		} 
		return min_index; 
	} 
	
	// Moves given minimum element 
	// to rear of queue 
	public static void insertMinToRear(Queue<Integer> list, int min_index) { 
		int min_value = 0; 
		int s = list.size(); 
		for (int i = 0; i < s; i++) { 
			int current = list.poll(); 
			if (i != min_index) {
				list.add(current); 
			} else {
				min_value = current; 
			}
		} 
		list.add(min_value); 
	} 
	

	// Time complexity of this algorithm is O(n^2).
    // Extra space needed is O(1).
	public static void sortQueue(Queue<Integer> list) { 
		for(int i = 1; i <= list.size(); i++) { 
			int min_index = minIndex(list, list.size()-i); 
			insertMinToRear(list, min_index); 
		} 
	} 

	//Driver function 
	public static void main (String[] args) {

		Queue<Integer> list = new LinkedList<Integer>(); 
		list.add(30); 
		list.add(11); 
		list.add(15); 
		list.add(4); 
		
		System.out.println(list); 
		//Sort Queue 
		sortQueue(list); 
		//print sorted Queue 
		System.out.println(list); 
	} 



} 




/*Sorting a Queue without extra space

Given a queue with random elements, we need to sort it. We are not allowed to use extra space. The operations allowed on queue are :

enqueue() : Adds an item to rear of queue. In C++ STL queue, this function is called push().
dequeue() : Removes an item from front of queue. In C++ STL queue, this function is called pop().
isEmpty() : Checks if a queue is empty. In C++ STL queue, this function is called empty().
Examples :

Input : A queue with elements 
        11  5  4  21 
Output : Modified queue with 
         following elements
        4 5 11 21

Input : A queue with elements 
        3  2  1  2
Output : Modified queue with 
         following elements
        1 2 2 3*/