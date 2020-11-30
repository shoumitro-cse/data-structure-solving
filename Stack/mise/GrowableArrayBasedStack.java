// Java Program to implement growable array based stack using tight strategy 

//javac -d classes GrowableArrayBasedStack.java  && cd classes && java GrowableArrayBasedStack && cd ..

class GrowableArrayBasedStack { 
	// constant amount at which stack is increased 
	static final int BOUND = 4; 
	// top of the stack 
	static int top = -1; 
	// length of stack 
	static int length = 0; 
	// function to create new stack 
	static int[] create_new(int[] a) { 
		// allocate memory for new stack 
		int[] new_a = new int[length + BOUND]; 
		// copying the content of old stack 
		for (int i = 0; i < length; i++) {
			new_a[i] = a[i]; 
		}
		// re-sizing the length 
		length += BOUND; 
		return new_a; 
	} 
	// function to push new element 
	static int[] push(int[] a, int element) { 
		// if stack is full, create new one 
		if (top == length - 1) {
			a = create_new(a); 
		}
		// insert element at top of the stack 
		a[++top] = element; 
		return a; 
	} 

	// function to pop an element 
	static void pop(int[] a) { 
		top--; 
	} 

	// function to display 
	static void display(int[] a) { 
		// if top is -1, that means stack is empty 
		if (top == -1) {
			System.out.println("Stack is Empty"); 
		} else { 
			System.out.print("Stack: "); 
			for (int i = 0; i <= top; i++) { 
				System.out.print(a[i] + " ");
			} 
			System.out.println(); 
		} 
	} 

	// Driver Code 
	public static void main(String args[]) { 
		// creating initial stack 
		int []a = create_new(new int[length + BOUND]); 
		// pushing element to top of stack 
		a = push(a, 1); 
		a = push(a, 2); 
		a = push(a, 3); 
		a = push(a, 4); 
		display(a); 

		// pushing more element when stack is full 
		a = push(a, 5); 
		a = push(a, 6); 
		display(a); 

		a = push(a, 7); 
		a = push(a, 8); 
		display(a); 

		// pushing more element so that stack can grow 
		a = push(a, 9); 
		display(a); 
	} 
} 

