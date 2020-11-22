 // Java program to arrange consonants and vowels nodes in a linked list 
// javac -d classes ArrangeConsonantsAndVowels.java  && cd classes && java ArrangeConsonantsAndVowels && cd ..

class ArrangeConsonantsAndVowels 
{ 
	 // A linked list node 
	static class Node 
	{ 
		char data; 
		Node next; 
	} 

	 // Function to add new node to the List 
	static Node newNode(char key) 
	{ 
		Node temp = new Node(); 
		temp.data = key; 
		temp.next = null; 
		return temp; 
	} 

	// utility function to print linked list 
	static void printlist(Node head) 
	{ 
		if (head == null) 
		{ 
			System.out.println("Empty List"); 
			return; 
		} 
		while (head != null) 
		{ 
			System.out.print(head.data +" "); 
			if (head.next != null) 
			System.out.print("-> "); 
			head = head.next; 
		} 
		System.out.println(); 
	} 

	// utility function for checking vowel 
	static boolean isVowel(char x) { 
		return (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u'); 
	} 

	/* function to arrange consonants and 
	vowels nodes */
	static Node arrange(Node head) { 

		Node newHead = head; 
		// for keep track of vowel 
		Node latestVowel; 

		Node curr = head; 

		// list is empty 
		if (head == null) 
			return null; 

		if (isVowel(head.data) == true) {
			latestVowel = head; 
		}else { // when latestVowel not head node

			while (curr.next != null && !isVowel(curr.next.data)) {
				curr = curr.next; 
			}
			// This is an edge case where there are only consonants in the list. 
			if (curr.next == null) 
				return head; 

			latestVowel = newHead = curr.next; 
			curr.next = curr.next.next; 
			latestVowel.next = head; 
		} 

		while (curr != null && curr.next != null) { 

			if (isVowel(curr.next.data) == true) { 
				// The next discovered item is a vowel 
				if (curr == latestVowel) { 
					latestVowel = curr = curr.next; 
				} else { 

					Node temp = latestVowel.next; 
					// Chain in new vowel 
					latestVowel.next = curr.next; 
					// Advance latestVowel 
					latestVowel = latestVowel.next; 
					// Remove found vowel from previous place 
					curr.next = curr.next.next; 
					// Re-link chain of consonants after latestVowel 
					latestVowel.next = temp; 
				} 
			} else { 
				// No vowel in the next element, advance curr. 
				curr = curr.next; 
			} 
		} 
		return newHead; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		Node head = newNode('a'); 
		head.next = newNode('b'); 
		head.next.next = newNode('c'); 
		head.next.next.next = newNode('e'); 
		head.next.next.next.next = newNode('d'); 
		head.next.next.next.next.next = newNode('o'); 
		head.next.next.next.next.next.next = newNode('x'); 
		head.next.next.next.next.next.next.next = newNode('i'); 

		System.out.println("Linked list before : "); 
		printlist(head); 

		head = arrange(head); 

		System.out.println("Linked list after :"); 
		printlist(head); 
		System.out.println(); 
	} 
} 

/*
Arrange consonants and vowels nodes in a linked list
Last Updated: 04-02-2019
Given a singly linked list, we need to arrange the consonants and vowel nodes 
of it in such a way that all the vowels nodes come before the consonants 
while maintaining the order of their arrival.

Examples:

Input : a -> b -> c -> e -> d -> o -> x -> i->null
Output : a -> e -> o -> i -> b -> c -> d -> x ->null*/