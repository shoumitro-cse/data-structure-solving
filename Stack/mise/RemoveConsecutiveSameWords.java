// Delete consecutive same words in a sequence

//javac -d classes RemoveConsecutiveSameWords.java  && cd classes && java RemoveConsecutiveSameWords && cd ..

import java.util.*; 

class RemoveConsecutiveSameWords {

/*	// Method to find the size of manipulated sequence 
	static int removeConsecutiveSame(Vector <String > v) {
		int n = v.size(); 
		// Start traversing the sequence 
		int i=0;
		while( i<n-1)  { 
			// Compare the current string with next one Erase both if equal 
			if (v.get(i).equals(v.get(i+1))) { 
				// delete both element 
				v.remove(i); 
				v.remove(i); 
				// Update i, as to check from previous element again 
				if (i > 0) 
					i--; 
				// Reduce sequence size 
				// n = n-2; 
				n = v.size();
				// System.out.println("size: "+n);
			} else {
			// Increment i, if not equal 
				i++; 
			}
		} 
		// Return modified size 
		return v.size(); 
	} */

	    // Method to find the size of manipulated sequence 
    static int removeConsecutiveSame(Vector <String> v) 
    { 
        Stack<String> st = new Stack<>(); 
        // Start traversing the sequence 
        for (int i=0; i<v.size(); i++) 
        { 
            // Push the current string if the stack is empty 
            if (st.empty()) {
                st.push(v.get(i)); 
            } else { 
                String str = st.peek(); 
                // compare the current string with stack top if equal, pop the top 
                if (str.equals(v.get(i)))     
                    st.pop(); 
                // Otherwise push the current string 
                else
                    st.push(v.get(i)); 
            } 
        } 
       
        // Return stack size 
        return st.size(); 
    }

	
	// Driver method 
	public static void main(String[] args) 
	{ 
		Vector<String> v = new Vector<>(); 

		v.addElement("tom"); 
		v.addElement("jerry"); 
		v.addElement("jerry");
		v.addElement("tom"); 

		System.out.println(removeConsecutiveSame(v)); 
	} 
} 



/*Delete consecutive same words in a sequence

Given a sequence of n strings, the task is to check if any two similar words come together 
then they destroy each other then print the number of words left in the sequence after this 
pairwise destruction.

Examples:

Input : ab aa aa bcd ab
Output : 3
As aa, aa destroys each other so, ab bcd ab is the
new sequence.

Input :  tom jerry jerry tom
Output : 0

As first both jerry will destroy each other.
Then sequence will be tom, tom they will also destroy
each other. So, the final sequence doesn't contain any word.


Algorithm:

Method 1:(Using Vector)

1- Start traversing the sequence by storing it in vector.
  a) Check if the current string is equal to next string
     if yes, erase both from the vector.
  b) And check the same till last.
2- Return vector size.


Method 2:(Using Stack)

1- Start traversing the strings and push into stack.
    a) Check if the current string is same as the string
       at the top of the stack
        i) If yes, pop the string from top.
        ii) Else push the current string.
2- Return stack size if the whole sequence is traversed.

*/