// Rearrange characters in a string such that no two adjacent are same

//javac -d classes RearrangeChar.java  && cd classes && java RearrangeChar && cd ..

import java.io.*; 
import java.util.*; 

class KeyComparator implements Comparator<Key> { 
	// Overriding compare()method of Comparator 
	public int compare(Key k1, Key k2) { 
		if (k1.freq < k2.freq) 
			return 1; 
		else if (k1.freq > k2.freq) 
			return -1; 
		return 0; 
	} 
} 

class Key { 
	int freq; // store frequency of character 
	char ch; 
	Key(int val, char c) { 
		freq = val; 
		ch = c; 
	} 
} 

class RearrangeChar { 

	static int MAX_CHAR = 26; 
	
	// Function to rearrange character of a string so that no char repeat twice 
	static void rearrangeString(String str) { 

			int n = str.length(); 

			// Store frequencies of all characters in string 
			int[] count = new int[MAX_CHAR];

			for (int i = 0; i < n; i++) {
				count[str.charAt(i)-'a']++; 
			}

			// Insert all characters with their frequencies into a priority_queue 
			PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());

			for (char c = 'a'; c <= 'z'; c++) { 
				int val = c-'a'; 
				if (count[val] > 0) 
					pq.add(new Key(count[val], c)); 
			} 
			
			// 'str' that will store resultant value 
			str = "" ; 
			// work as the previous visited element 
			// initial previous element be. ( '#' and it's frequency '-1' ) 
			Key prev = new Key(-1, '#'); 
			// System.out.println(pq);
			// traverse queue 
			while (pq.size() != 0) { 
					// pop top element from queue and add it to string. 
					Key k = pq.poll(); 
					str = str + k.ch; 
					// If frequency of previous character is less 
					// than zero that means it is useless, we need not to push it 
					if (prev.freq > 0) 
						pq.add(prev); 
					// make current character as the previous 'char' decrease frequency by 'one' 
					(k.freq)--; 
					prev = k; 
			} 
			// If length of the resultant string and original 
			// string is not same then string is not valid 
			if (n != str.length()) 
				System.out.println(" Not valid String "); 
			else
				System.out.println(str); 
	} 

	public static void main(String args[]) { 
			String str = "bbbaa" ; 
			rearrangeString(str); 
	} 
} 


/*Asked In : Amazon Interview

Rearrange characters in a string such that no two adjacent are same


Given a string with repeated characters, the task is to rearrange characters 
in a string so that no two adjacent characters are same.

Note : It may be assumed that the string has only lowercase English alphabets.

Examples:

Input: aaabc 
Output: abaca 

Input: aaabb
Output: ababa 

Input: aa 
Output: Not Possible

Input: aaaabc 
Output: Not Possible*/

