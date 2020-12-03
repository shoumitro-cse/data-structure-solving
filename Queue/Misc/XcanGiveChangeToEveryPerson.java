// Java program to check whether X can give change to every person in the Queue 

//javac -d classes XcanGiveChangeToEveryPerson.java  && cd classes && java XcanGiveChangeToEveryPerson && cd ..

import java.io.*; 

class XcanGiveChangeToEveryPerson { 
	
	// Function to check if every person will get the change from X 
	static int isChangeable(int notes[], int n) { 
		// To count the 5$ and 10& notes 
		int fiveCount = 0; 
		int tenCount = 0; 
		// Serve the customer in order 
		for (int i = 0; i < n; i++) { 
			// Increase the number of 5$ note by one 
			if (notes[i] == 5) {
				fiveCount++; 
			} else if (notes[i] == 10) { 
				// decrease the number of note 5$ and increase 10$ note by one 
				if (fiveCount > 0) { 
					fiveCount--; 
					tenCount++; 
				} else {
					return 0; 
				}
			} else { 
				// decrease 5$ and 10$ note by one 
				if (fiveCount > 0 && tenCount > 0) { 
					fiveCount--; 
					tenCount--; 
				} else if (fiveCount >= 3) { 
				   // decrease 5$ note by three 
					fiveCount -= 3; 
				} else {
					return 0; 
				}
			} 
		} 
		return 1; 
	} 

	public static void main (String[] args) { 
		
		// queue of customers with available notes. 
		int notes[] = {5, 5, 5, 10, 20}; 
		int len = notes.length; 
		
		// Calling function 
		if (isChangeable(notes, len) > 0) {
			System.out.println("\nYES"); 
		} else {
			System.out.println("\nNO"); 
		}

	} 
} 



/*
Check if X can give change to every person in the Queue

Given an array of N integers where Ai denotes the currency of note that the i-th person has. 
The possible currencies are 5, 10 and 20. All the N people are standing in a queue waiting to buy 
an ice-cream from X which costs Rs 5. Initially, X has an initial balance of 0. 
Check if X will be able to provide change to every people who are waiting to buy an ice-cream.

Examples:

Input:a[] = {5, 5, 5, 10, 20}
Output: YES
When the fourth person chance comes to buy an ice-cream, X has three Rs 5
change, hence X gives him 1, and now when the fifth person
comes to buy the ice-cream, X has two Rs 5 and one Rs 10 note, hence he
gives him one Rs 10 and one Rs 5 note.

Input: a[] = {5, 10, 10, 20}
Output: NO


The approach is to keep a track of the number of Rs 5 and Rs 10 currencies. 
Rs 20 currencies will not be used since it is the highest currency that a person can 
give and thus it cannot be given as a change. Initialize two variables to 
count Rs 5(fiveCount) and Rs 10(tenCount). If the person has a Rs 10 currency and 
fiveCount > 0, then decrease fiveCount and increase tenCount. If X does not have Rs 5, 
then X cannot give the person the required change. If the person has 5$ note, increase 
fiveCount by one. If the person has a Rs 20, then three conditions will be:


1. If fiveCount > 0 and tencount > 0, decrease both.
2. else if, fiveCount >= 3, decrease fivecount by three.
3. else, return false.*/