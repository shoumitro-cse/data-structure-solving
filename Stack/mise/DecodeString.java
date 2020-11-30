//Decode a string recursively encoded as count followed by substring

//javac -d classes DecodeString.java  && cd classes && java DecodeString && cd ..

import java.util.Stack; 

class DecodeString {

	// Returns decoded string for 'str' 
	// Time complexity: O(n)
	// Space Complexity: O(n) 
	static String decode(String str) {

		Stack<Integer> integerStack = new Stack<>(); 
		Stack<Character> stringStack = new Stack<>(); 

		String temp = "", result = ""; 
	
		// Traversing the string 
		for (int i = 0; i < str.length(); i++) { 

			int count = 0; 
			// If number, convert it into number and push it into integerStack. 
			if (Character.isDigit(str.charAt(i))) {

				while (Character.isDigit(str.charAt(i))) { 
					//count= count * 10 + str.charAt(i) - '0'; 
					count = Integer.parseInt(str.charAt(i)+""); 
					// System.out.println("count: "+count);
					i++; 
				} 
	
				i--; 
				integerStack.push(count); 

			} else if (str.charAt(i) == ']') {

				temp = ""; 
				count = 0; 
	
				if (!integerStack.isEmpty()) { 
					count = integerStack.pop(); 
				} 
	
				while (!stringStack.isEmpty() && stringStack.peek()!='[' ) { 
					temp = stringStack.pop() + temp; 
				} 
	
				if (!stringStack.empty() && stringStack.peek() == '[') {
					stringStack.pop(); 
				}
				// Repeating the popped string 'temo' count number of times. 
				for (int j = 0; j < count; j++) {
					result = result + temp; 
				}
				// Push it in the character stack. 
				for (int j = 0; j < result.length(); j++) { 
					stringStack.push(result.charAt(j)); 
				}
				result = ""; 

			} else if (str.charAt(i) == '[') {
			   // If '[' opening bracket, push it into character stack. 
				if (Character.isDigit(str.charAt(i-1))) { 
					stringStack.push(str.charAt(i)); 
				} else { 
					stringStack.push(str.charAt(i)); 
					integerStack.push(1); 
				} 
			} else {
				stringStack.push(str.charAt(i)); 
			}
		} 
	
	    // System.out.println(stringStack);
	    // System.out.println(integerStack);

		// Pop all the elmenet, make a string and return. 
		while (!stringStack.isEmpty()) { 
			result = stringStack.pop() + result; 
		} 
	
		return result; 
	} 

	// Driver method 
	public static void main(String args[]) 
	{ 
		String str = "3[b2[ca]]"; // bcaca bcaca bcaca
		System.out.println(decode(str)); 
	} 
} 



/*Decode a string recursively encoded as count followed by substring

An encoded string (s) is given, the task is to decode it. The pattern in which the strings 
are encoded is as follows.

<count>[sub_str] ==> The substring 'sub_str' appears count times.

Examples:

Input : str[] = "1[b]"
Output : b

Input : str[] = "2[ab]"
Output : abab

Input : str[] = "2[a2[b]]"
Output : abbabb

Input : str[] = "3[b2[ca]]"
Output : bcacabcacabcaca*/