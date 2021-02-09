// Word Ladder (Length of shortest chain to reach a target word)

// javac -d classes  WordLadder.java  && cd classes && java WordLadder && cd ..

import java.util.*;

class WordLadder {

	// Returns length of shortest chain to reach 'target' from 'start'
	// using minimum number of adjacent moves. D is dictionary
	static int shortestChainLen(String start, String target, Set<String> D) {
		// If the target String is not present in the dictionary
		if (!D.contains(target))
			return 0;
		// To store the current chain length and the length of the words
		int level = 0, wordlength = start.length();
		// Push the starting word into the queue
		Queue<String> Q = new LinkedList<>();
		Q.add(start);
		// While the queue is non-empty
		while (!Q.isEmpty()) {
			// Increment the chain length
			++level;
			// Current size of the queue
			int sizeofQ = Q.size();

			for (int i = 0; i < sizeofQ; ++i) {
				// Remove the first word from the queue
				char [] word = Q.peek().toCharArray();
				Q.remove();
				// For every character of the word
				for (int pos = 0; pos < wordlength; ++pos) {
					// Retain the original character at the current position
					char orig_char = word[pos];
					// Replace the current character with every possible lowercase alphabet
					for (char c = 'a'; c <= 'z'; ++c) {
						word[pos] = c;
						// If the new word is equal to the target word
						if (String.valueOf(word).equals(target))
							return level + 1;
						// Remove the word from the set if it is found in it
						if (!D.contains(String.valueOf(word)))
							continue;
						D.remove(String.valueOf(word));
						// And push the newly generated word which will be a part of the chain
						Q.add(String.valueOf(word));
					}

					// Restore the original character at the current position
					word[pos] = orig_char;
				}
			}
		}

		return 0;
	}

	// Driver code
	public static void main(String[] args) {

		// make dictionary
		Set<String> D = new HashSet<String>();
		D.add("poon");
		D.add("plee");
		D.add("same");
		D.add("poie");
		D.add("plie");
		D.add("poin");
		D.add("plea");

		String start = "toon";
		String target = "plea";
		System.out.println("\n\nLength of shortest chain is: "+ shortestChainLen(start, target, D));
	
	}
}


/*
Complexity Analysis: 

Time complexity: O(n²m), where m is the number of entries originally in the dictionary and n is the size of the string. 
 
Auxiliary Space: O(m*n), where m are the strings are stored in queue. 
So the space Complexity is O(m*n).
*/


/*
Word Ladder (Length of shortest chain to reach a target word)


Given a dictionary, and two words ‘start’ and ‘target’ (both of same length). 
Find length of the smallest chain from ‘start’ to ‘target’ if it exists, such that adjacent 
words in the chain only differ by one character and each word in the chain is a valid word i.e., 
it exists in the dictionary. It may be assumed that the ‘target’ word exists in dictionary and 
length of all dictionary words is same. 

Example: 

Input: Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
       start = TOON
       target = PLEA
Output: 7
TOON - POON - POIN - POIE - PLIE - PLEE - PLEA

Input: Dictionary = {ABCD, EBAD, EBCD, XYZA}
       Start = ABCV
       End = EBAD
Output: 4
ABCV - ABCD - EBCD - EBAD
*/