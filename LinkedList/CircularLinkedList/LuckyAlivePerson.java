// Lucky alive person in a circle | Code Solution to sword puzzle
//javac -d classes LuckyAlivePerson.java  && cd classes && java LuckyAlivePerson && cd ..

class LuckyAlivePerson 
{ 
		
	// Node structure 
	static class Node { 
		int data; 
		Node next; 
	}; 

	static Node newNode(int data) { 
		Node node = new Node(); 
		node.data = data; 
		node.next = null; 
		return node; 
	} 

	// Function to find the luckiest person 
	static int alivesol(int Num) 
	{ 
		if (Num == 1) return 1; 

		// Create a single node circular linked list. 
		Node last = newNode(1); 
		last.next = last; 
		
		for (int i = 2; i <= Num; i++) { 
			Node temp = newNode(i); 
			temp.next = last.next;	 
			last.next = temp; 
			last = temp;	 
		} 

		// Starting from first soldier. 
		Node head = last.next; 
		Node curr = head; 

		// condition for evaluating the existence of single soldier who is not killed. 
		Node ptr = new Node(); 
		while (curr.next != curr) 
		{ 
			ptr = curr; 
			curr = curr.next; 
			ptr.next = curr.next; 

			// deleting soldier from the circular list who is killed in the fight. 
			ptr = ptr.next; 
			curr = ptr; 
		} 

		// Returning the Luckiest soldier who remains alive. 
		int res = ptr.data; 
		
		return res; 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		int N = 5; 
		System.out.println( alivesol(N) ); 
	} 
} 


/*Lucky alive person in a circle | Code Solution to sword puzzle
Given n people standing in a circle where 1st is having sword, 
find the luckiest person in the circle, if from 1st soldier
who is having a sword each have to kill the next soldier and
handover the sword to next soldier, in turn the soldier will
kill the adjacent soldier and handover the sword to next soldier
such that one soldier remain in this war who is not killed by anyone.

Examples :

Input : 5
Output : 3
Explanation :
N = 5
Soldier 1 2 3 4 5 (5 soldiers)
In first go 1 3 5 (remains) as 2 and 4 killed by 1 and 3.
In second go 3 as 5 killed 1 and 3rd kill 5 soldier 3 remains alive.

Input : 100
Output : 73
Explanation :
N = 10
Soldiers 1 2 3 4 5 6 7 8 9 10 (10 soldiers)
In first 1 3 5 7 9 as 2 4 6 8 10 were killed by 1 3 5 7 and 9.
In second 1 5 9 as 9 kill 1 and in turn 5 kill 9th soldier.
In third 5 5th soldiers remain alive*/
