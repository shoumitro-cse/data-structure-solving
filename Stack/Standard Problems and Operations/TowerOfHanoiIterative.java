// Iterative Tower of Hanoi

//javac -d classes TowerOfHanoiIterative.java  && cd classes && java TowerOfHanoiIterative && cd ..

//https://www.geeksforgeeks.org/iterative-tower-of-hanoi/

class TowerOfHanoiIterative {
	
	// A structure to represent a stack
	class Stack {
		int capacity;
		int top;
		int array[];
	}

	// Function to create a stack of given capacity.
	Stack createStack(int capacity) {
		Stack stack = new Stack();
		stack.capacity = capacity;
		stack.top = -1;
		stack.array = new int[capacity];
	  return stack;
	}

	// Stack is full when the top is equal to the last index
	boolean isFull(Stack stack) {
		return (stack.top == stack.capacity - 1);
	}

	// Stack is empty when top is equal to -1
	boolean isEmpty(Stack stack) {
		return (stack.top == -1);
	}

	// Function to add an item to stack.It increases top by 1
	void push(Stack stack, int item) {
		if (isFull(stack))
			return;
		stack.array[++stack.top] = item;
	}

	// Function to remove an item from stack.It decreases top by 1
	int pop(Stack stack) {
		if (isEmpty(stack))
			return Integer.MIN_VALUE;
		return stack.array[stack.top--];
	}

	// Function to implement legal movement between two poles
	void moveDisksBetweenTwoPoles(Stack src, Stack dest, char s, char d) {

		int pole1TopDisk = pop(src);
		int pole2TopDisk = pop(dest);

		if (pole1TopDisk == Integer.MIN_VALUE) { // When pole 1 is empty
			push(src, pole2TopDisk);
			moveDisk(d, s, pole2TopDisk);
		} else if (pole2TopDisk == Integer.MIN_VALUE) { // When pole2 is empty
			push(dest, pole1TopDisk);
			moveDisk(s, d, pole1TopDisk);
		} else if (pole1TopDisk > pole2TopDisk) { // When top disk of pole1 > top disk of pole2
			push(src, pole1TopDisk);
			push(src, pole2TopDisk);
			moveDisk(d, s, pole2TopDisk);
		} else { // When top disk of pole1 < top disk of pole2
			push(dest, pole2TopDisk);
			push(dest, pole1TopDisk);
			moveDisk(s, d, pole1TopDisk);
		}
	}

	// Function to show the movement of disks
	void moveDisk(char fromPeg, char toPeg, int disk) {
		System.out.println("Move the disk " + disk + " from " + fromPeg + " to " + toPeg);
	}

	// Function to implement TowerOfHanoiIterative puzzle
	void towerOfHanoiIterative(int num_of_disks, Stack src, Stack aux, Stack dest) {

		int i, total_num_of_moves;
		char s = 'S', d = 'D', a = 'A';

		// If number of disks is even, then 
		// interchange destination pole and
		// auxiliary pole
		if (num_of_disks % 2 == 0) {
			char temp = d;
			d = a;
			a = temp;
		}

		total_num_of_moves = (int) (Math.pow(2, num_of_disks) - 1);

		// Larger disks will be pushed first
		for(i = num_of_disks; i >= 1; i--) {
			push(src, i);
		}
        // src = 1 2 3
		for(i = 1; i <= total_num_of_moves; i++) {

			if (i % 3 == 1) {
			   moveDisksBetweenTwoPoles(src, dest, s, d);
			} else if (i % 3 == 2) {
			   moveDisksBetweenTwoPoles(src, aux, s, a);
			} else if (i % 3 == 0) {
			   moveDisksBetweenTwoPoles(aux, dest, a, d);
			}
		}

	}

/*	public static void main(String[] args) {
		
		// Input: number of disks
		int num_of_disks = 3;
		
		TowerOfHanoiIterative ob = new TowerOfHanoiIterative();
		Stack src, dest, aux;
		
		// Create three stacks of size 'num_of_disks' to hold the disks
		src = ob.createStack(num_of_disks);
		dest = ob.createStack(num_of_disks);
		aux = ob.createStack(num_of_disks);
		
		ob.towerOfHanoiIterative(num_of_disks, src, aux, dest);
	}*/

	    // Java recursive function to solve tower of hanoi puzzle 
	//https://www.geeksforgeeks.org/recursive-functions/
    static void towerOfHanoi(int n, char src_pole, char dest_pole, char aux_pole) 
    { 
/*        if (n == 1) { 
            System.out.println("Move disk 1 from pole " +  src_pole + " to pole " + dest_pole); 
            return; 
        }   */      

        if (n == 0) return; 

        towerOfHanoi(n-1, src_pole, aux_pole, dest_pole); 
        System.out.println("Move disk " + n + " from pole " +  src_pole + " to pole " + dest_pole); 
        towerOfHanoi(n-1, aux_pole, dest_pole, src_pole); 
    } 
      
    //  Driver method 
    public static void main(String args[]) { 
        int n = 3; // Number of disks 
        towerOfHanoi(n, 'S', 'D', 'A');  // S=src, D=destination and A=Auxiliary are names of poles 
    } 

}

/*
Iterative Tower of Hanoi

Tower of Hanoi is a mathematical puzzle. It consists of three poles and a number of 
disks of different sizes which can slide onto any poles. The puzzle starts with the 
disk in a neat stack in ascending order of size in one pole, the smallest at the top 
thus making a conical shape. The objective of the puzzle is to move all the disks from 
one pole (say ‘source pole’) to another pole 
(say ‘destination pole’) with the help of the third pole (say auxiliary pole).

The puzzle has the following two rules:
      1. You can’t place a larger disk onto smaller disk 
      2. Only one disk can be moved at a time

Iterative Algorithm: 

1. Calculate the total number of moves required i.e. "pow(2, n)- 1" here n is number of disks.
2. If number of disks (i.e. n) is even then interchange destination 
   pole and auxiliary pole.
3. for i = 1 to total number of moves:
     if i%3 == 1:
    legal movement of top disk between source pole and 
        destination pole
     if i%3 == 2:
    legal movement top disk between source pole and 
        auxiliary pole    
     if i%3 == 0:
        legal movement top disk between auxiliary pole 
        and destination pole 

*/