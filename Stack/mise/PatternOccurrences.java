//Pattern Occurrences : Stack Implementation Java

//javac -d classes PatternOccurrences.java  && cd classes && java PatternOccurrences && cd ..

import java.util.ArrayList; 
import java.util.Stack; 

class PatternOccurrences { 
	// custom class for returning multiple values 
	class Data {

		ArrayList<Integer> present; 
		int count; 

		public Data(ArrayList<Integer> present, int count) { 
		   this.present = present; 
		   this.count = count; 
		} 
	} 

	public Data findPatternOccurrence(char pattern[], char text[]) { 
		// stores the indices for all occurrences 
		ArrayList<Integer> list = new ArrayList<>(); 
		Stack<String> stack = new Stack<>(); 
		int p = 0; 
		int counter = 0 ; 
		int lastOccurrence = -10; 

		for (int i = 0; i < text.length; i ++) { //len=9

			if(text[i] == pattern[p]) { 
				if(text[i] == pattern[pattern.length - 1]) { 
					list.add(i); 
					counter ++; 
					lastOccurrence = i; 
					p = 0; 
				} else { 
				  p ++; 
				} 
			} else { // if characters are not same 

				if(text[i] == pattern[0]) { 
					String temp = ""; 
					for (int i1 = p; i1 < pattern.length; i1 ++) {
						temp += pattern[i1]; 
					}
					stack.push(temp); 
					p = 1; 
				} else { 

				  if (lastOccurrence == i-1) { 

					  if (stack.isEmpty()) {
					    p = 0; 
				      } else { 
						String temp = stack.pop(); 
						if (temp.charAt(0) == text[i]) { 
							lastOccurrence = i; 
							if (temp.charAt(0) == pattern[pattern.length - 1]) { 
								list.add(i); 
								counter ++; 
							} else { 
								temp = temp.substring(1, temp.length()); 
								stack.push(temp); 
							} 
						} else { 
							if (!stack.isEmpty()) {
							   stack.clear(); 
							}
							p = 0; 
						} 
					  }

				   } else { 
					  if (!stack.isEmpty()) {
					    stack.clear(); 
					  }
					  p = 0; 
				  } 
			  } 
		   } 

	    } 
		// return the result 
		return new Data(list, counter); 
	} 

	public static void main(String args[]) {

		// the simple pattern to be matched 
		char[] pattern = "ABC".toCharArray(); 
		char[] text = "ABABCABCC".toCharArray(); 

		PatternOccurrences obj = new PatternOccurrences(); 
		Data data = obj.findPatternOccurrence(pattern, text); 

		int count = data.count; 
		ArrayList<Integer> list = data.present; 

		System.out.println(count); 

		if (count > 0) { 
			System.out.println("Occurrences found at:"); 
			for (int i : list) 
				System.out.print(i + " "); 
		} 
		System.out.println(""); 
	} 
} 



/*Pattern Occurrences : Stack Implementation Java

Suppose we have two Strings :- Pattern and Text
pattern: consisting of unique characters
text: consisting of any length

We need to find the number of patterns that can be obtained from text removing each and 
every occurrence of Pattern in the Text.

Example:

Input : 
Pattern : ABC
Text : ABABCABCC

Output :
3
Occurrences found at: 
4 7 8

Explanation
Occurrences and their removal in the order
1. ABABCABCC
     --- 
2. ABABCC
     ---
3. ABC
   ---





The idea is to use stack data structure.
1. Initialize a pointer to beginning for matching the occurrences in the pattern with 0 and counter 
     to 0.
2. Check if pattern and text have same character at the present index.
3. If the pointer is to the end of pattern that means all the previous characters have been found 
    in an increasing subsequential order increment the counter by 1.
4. If not, keep incrementing the pointer by 1 if characters are same.
5. If the characters are different in both the strings, check if the character is same as the first
     character of the pattern (i.e. pointer = 0).
6. If yes, add the remaining characters from the present pointer to length of the pattern to a stack
     and check if they are present in order that the pattern can be formed from the stack. Also, 
     initialize the pointer now to 1 because we already had checked for pointer = 0 (in step 5).
7. If matches, empty the stack to null. Else, remove the first character and keep adding the rest 
   of the substring for checking for further of the steps.
8. If any added String to the Stack matches the pattern increment counter by 1 and initialize 
   pointer by 0.
9. Repeat all these steps for all the indexes of the text length.
10. Print the counter and occurrences.
11. Basic task of Stack is handling the pending operations that might be possible occurrences.


Example Explanation according to above algorithm:

TEXT: ABABCABCC
PATTERN: ABC
pointer = 0
counter = 0
A B A B C A B C C
0 1 2 3 4 5 6 7 8

at index = 0
pointer = 0
stack = []

at index = 1
pointer = 1
stack = []

at index = 2
pointer = 0
stack = ['C']

at index = 3
pointer = 1
stack = ['C']

at index = 4
pointer = 2
counter += 1
pointer = 0 
stack = ['C']

same for index 5,6,7 according to above method

at index = 8
pop from Stack
counter += 1
clear Stack 

   */







/*import java.util.ArrayList; 
import java.util.Stack; 

class PatternOccurrences 
{ 
	// custom class for returning multiple values 
	class Data 
	{ 
		ArrayList<Integer> present; 
		int count; 

		public Data(ArrayList<Integer> present, int count) 
		{ 
		this.present = present; 
		this.count = count; 
		} 
	} 
	public Data Solution(char pattern[], char text[]) 
	{ 
		// stores the indices for all occurrences 
		ArrayList<Integer> list = new ArrayList<>(); 
		Stack<String> stack = new Stack<>(); 

		// present index pointer searched for in 
		// the entire array of string characters 
		int p = 0; 

		//count of all the number of occurrences 
		int counter = 0 ; 

		// any random number less than 0 to mark 
		// the previous index where the occurrence 
		// was found 
		int lastOccurrence = -10; 

		// traversing all the indexes of the text 
		// searching for possible pattern 
		for (int i = 0; i < text.length; i ++) 
		{ 
		// if the present index and the pointer in 
		// the pattern is at same character 
		if(text[i] == pattern[p]) 
		{ 
			// and if that character is the end of 
			// the pattern to be found 
			if(text[i] == pattern[pattern.length - 1]) 
			{ 
			//index at which pattern is found 
			list.add(i); 

			// incrementing total occurrences by 1 
			counter ++; 

			// last found index to be initizalized 
			// to present index 
			lastOccurrence = i; 

			// begin the search for the next pointer 
			// again from 0th index of the pattern 
			p = 0; 
			} 
			else
			{ 
			// if present character at pattern and index 
			// is same but still not the end of pattern 
			p ++; 
			} 
		} 

		// if characters are not same 
		else
		{ 
			// if the present character is same as the 1st 
			// character of the pattern 
			// here 0 = pointer in the pattern fixed to 0 
			if(text[i] == pattern[0]) 
			{ 
			// assume a temporary string 
			String temp = ""; 

			// and add all characters to it to the pattern 
			// length from the present pointer to the end 
			for (int i1 = p; i1 < pattern.length; i1 ++) 
				temp += pattern[i1]; 

			// push the present pattern length into the stack 
			// for checking if pattern is same as subsequence 
			// of the text 
			stack.push(temp); 

			//pattern at pointer = 0 already checked so we 
			// start from 1 for the next step 
			p = 1; 
			} 
			else
			{ 
			// if the previous occurrence was just before 
			// the present index 
			if (lastOccurrence == i - 1) 
			{ 
				// if the stack is empty place the pointer = 0 
				if (stack.isEmpty()) 
				p = 0; 
				else
				{ 
				// pick up the present possible pattern 
				String temp = stack.pop(); 

				// check if it's character has the matching 
				// occurrence 
				if (temp.charAt(0) == text[i]) 
				{ 
					//increment last index by the present index 
					// so that net index is checked 
					lastOccurrence = i; 

					// check if stack character is last character 
					// in the pattern 
					if (temp.charAt(0) == pattern[pattern.length - 1]) 
					{ 
					// index found 
					list.add(i); 

					// increment occurrences by 1 
					counter ++; 
					} 
					else
					{ 
					// if present index character doesn't 
					// match the last character in the pattern 
					// remove the first character which was same 
					// and check for further occurrences of the 
					// remaining letters in the stack string 
					temp = temp.substring(1, temp.length()); 

					// add the remaining string back to stack 
					// for further review 
					stack.push(temp); 
					} 
				} 
				// if first string character in the stack doesn't 
				// match the present character in the text 
				else
				{ 
					// if stack is not empty empty it. 
					if (!stack.isEmpty()) 
					stack.clear(); 

					// reinitialize the pointer back to 0 for 
					// checking pattern from beginning 
					p = 0; 
				} 
				} 
			} 
			else
			{ 
				// empty the stack under any other circumstances 
				if (!stack.isEmpty()) 
				stack.clear(); 

				// reinitialize the pointer back to 0 for 
				// checking pattern from beginning 
				p = 0; 
			} 
			} 
		} 
		} 
		// return the result 
		return new Data(list, counter); 
	} 

	public static void main(String args[]) 
	{ 
		// the simple pattern to be matched 
		char[] pattern = "ABC".toCharArray(); 

		// the input string in which the number of 
		// occurrences can be found out after removing 
		// each occurrence. 
		char[] text = "ABABCABCC".toCharArray(); 

		PatternOccurrences obj = new PatternOccurrences(); 
		Data data = obj.Solution(pattern, text); 

		int count = data.count; 
		ArrayList<Integer> list = data.present; 
		System.out.println(count); 
		if (count > 0) 
		{ 
		System.out.println("Occurrences found at:"); 
		for (int i : list) 
			System.out.print(i + " "); 
		} 
	} 
} 
*/