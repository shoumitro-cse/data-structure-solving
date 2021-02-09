// find all the Stepping Number in [n, m]

class SteppingNumbers {

	// This Method checks if an integer n is a Stepping Number
	public static boolean isStepNum(int n) {
		
		// Initalize prevDigit with -1
		int prevDigit = -1;
		
		// Iterate through all digits of n and compare
		// difference between value of previous and current digits
		while (n > 0) {
			
			// Get Current digit
			int curDigit = n % 10;
			
			// Single digit is consider as a Stepping Number
			if (prevDigit != -1) {
				// Check if absolute difference between prev digit and current digit is 1
				if (Math.abs(curDigit - prevDigit) != 1) {
					return false;
				}
			}

			n = n / 10;
			prevDigit = curDigit;
		}

		return true;
	}

	// A brute force approach based function to find all stepping numbers.
	public static void displaySteppingNumbers(int n, int m) {
		// Iterate through all the numbers from [N,M] and check if it is a stepping number.
		for (int i = n; i <= m; i++) {
			if (isStepNum(i)) {
				System.out.print(i+ " ");
			}
		}
	}

	public static void main(String args[]) {
		int n = 0, m = 21;
		// Display Stepping Numbers in the range [n,m]
		displaySteppingNumbers(n, m);
	}
}


/*
Stepping Numbers


Given two integers ‘n’ and ‘m’, find all the stepping numbers in range [n, m]. 
A number is called stepping number if all adjacent digits have an absolute difference of 1. 
321 is a Stepping Number while 421 is not.

Examples : 
 

Input : n = 0, m = 21
Output : 0 1 2 3 4 5 6 7 8 9 10 12 21

Input : n = 10, m = 15
Output : 10, 12
*/