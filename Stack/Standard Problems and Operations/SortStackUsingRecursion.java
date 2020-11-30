//Sort a stack using recursion

//javac -d classes SortStackUsingRecursion.java  && cd classes && java SortStackUsingRecursion && cd ..


import java.util.ListIterator;
import java.util.Stack;

class SortStackUsingRecursion 
{
	// Recursive Method to insert an item x in sorted way
	static void sortedInsert(Stack<Integer> s, int x)
	{
		// Base case: Either stack is empty or newly
		// inserted item is greater than top (more than all
		// existing)
		if (s.isEmpty() || x > s.peek()) 
		{
			s.push(x);
			return;
		}
		// If top is greater, remove the top item and recur
		int temp = s.pop();
		sortedInsert(s, x);

		// Put back the top item removed earlier
		s.push(temp);
	}

	// Method to sort stack
	static void sortStack(Stack<Integer> s)
	{
		// If stack is not empty
		if (!s.isEmpty()) 
		{
			// Remove the top item
			int x = s.pop();

			// Sort remaining stack
			sortStack(s);

			// Push the top item back in sorted stack
			sortedInsert(s, x);
		}
	}

	// Utility Method to print contents of stack
	static void printStack(Stack<Integer> s)
	{
/*		ListIterator<Integer> lt = s.listIterator();

		// forwarding
		while (lt.hasNext())
			lt.next();

		// printing from top to bottom
		while (lt.hasPrevious())
			System.out.print(lt.previous() + " ");*/
			System.out.println(s);
	}

/*
Sort a stack using a temporary stack

algorithm.
1. Create a temporary stack say tmpStack.
2. While input stack is NOT empty do this:
	i. Pop an element from input stack call it temp
	ii. while temporary stack is NOT empty and top of temporary stack is greater than temp,
	    pop from temporary stack and push it to the input stack
	iii. push temp in temporary stack
3. The sorted numbers are in tmpStack*/
    public static Stack<Integer> sortstack(Stack<Integer> input) {

        Stack<Integer> tmpStack = new Stack<Integer>(); 
    
        while(!input.isEmpty()) {
            // pop out the first element 
            int tmp = input.pop(); 
            // while temporary stack is not empty and top of stack is greater than temp 
            while(!tmpStack.isEmpty() && tmpStack.peek() > tmp) { 
                // pop from temporary stack and push it to the input stack 
                input.push(tmpStack.pop()); 
            } 
            // push temp in tempory of stack 
            tmpStack.push(tmp); 
        } 
        return tmpStack; 
    } 

	// Driver code
	public static void main(String[] args)
	{
		Stack<Integer> s = new Stack<>();
		s.push(30);
		s.push(-5);
		s.push(18);
		s.push(14);
		s.push(-3);

		System.out.println("Stack elements before sorting: ");
		printStack(s);

		System.out.println(sortstack(s));

/*		sortStack(s);

		System.out.println(" \n\nStack elements after sorting:");
		printStack(s);

		System.out.println();*/
	}
}


/*Complexity Analysis: 

Algorithm 
We can use below algorithm to sort stack elements: 

sortStack(stack S)
    if stack is not empty:
        temp = pop(S);  
        sortStack(S); 
        sortedInsert(S, temp);
Below algorithm is to insert element is sorted order: 

sortedInsert(Stack S, element)
    if stack is empty OR element > top element
        push(S, elem)
    else
        temp = pop(S)
        sortedInsert(S, element)
        push(S, temp)


Time Complexity: O(n2). 
In the worst case for every sortstack(), sortedinsert() is 
called for ‘N’ times recursively for putting element to the right place

Auxiliary Space: O(N)
Use of stack data structure for storing values


Sort a stack using recursion

Given a stack, sort it using recursion. Use of any loop constructs like while, 
for..etc is not allowed. We can only use the following ADT functions on Stack S: 

is_empty(S)  : Tests whether stack is empty or not.
push(S)         : Adds new element to the stack.
pop(S)         : Removes top element from the stack.
top(S)         : Returns value of the top element. Note that this
               function does not remove element from the stack.
Example: 

Input:  -3  <--- Top
        14 
        18 
        -5 
        30 

Output: 30  <--- Top
        18 
        14 
        -3 
        -5 

Examples:

Input : [34, 3, 31, 98, 92, 23]
Output : [3, 23, 31, 34, 92, 98]

Input : [3, 5, 1, 4, 2, 8]
Output : [1, 2, 3, 4, 5, 8]

        */