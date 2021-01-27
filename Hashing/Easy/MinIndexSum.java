//Minimum Index Sum for Common Elements of Two Lists

//javac -d classes MinIndexSum.java  && cd classes && java MinIndexSum && cd ..

// Hashing based Java program to find common elements
// with minimum index sum.
import java.util.*;

class MinIndexSum
{

	// Function to print common Strings with minimum index sum
	static void find(Vector<String> list1, Vector<String> list2) {

		// mapping Strings to their indices
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < list1.size(); i++) {
			map.put(list1.get(i), i);
		}

		Vector<String> res = new Vector<String>(); // resultant list

		int minsum = Integer.MAX_VALUE;// Max
		for (int j = 0; j < list2.size(); j++) {
			if (map.containsKey(list2.get(j))) {
				// If current sum is smaller than minsum
				int sum = j + map.get(list2.get(j));
				if (sum < minsum) {
					minsum = sum;
					res.clear();
					res.add(list2.get(j));
				} else if (sum == minsum) {
				   // if index sum is same then put this String in resultant list as well
					res.add(list2.get(j));
				}
			}
		}

		// Print result
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}
	}

	// Driver code
	public static void main(String[] args) 
	{
		// Creating list1
		Vector<String> list1 = new Vector<String>();
		list1.add("w3school");
		list1.add("Udemy");
		list1.add("Coursera");
		list1.add("edX");

		// Creating list2
		Vector<String> list2 = new Vector<String>();
		list2.add("Codecademy");
		list2.add("Khan Academy");
		list2.add("w3school");

		find(list1, list2);
		System.out.println();
	}
}

/*
Minimum Index Sum for Common Elements of Two Lists


Ram and Shyam want to choose a website to learn programming and they both have 
a list of favorite websites represented by strings.
You need to help them find out their common interest with the least index sum. 
If there is a choice tie between answers, print all of them with no order requirement. 
Assume there always exists an answer.

Examples:

Input : ["GeeksforGeeks", "Udemy", "Coursera", "edX"]
        ["Codecademy", "Khan Academy", "GeeksforGeeks"]
Output : "GeeksforGeeks"
Explanation : GeeksforGeeks is the only common website in two lists

Input : ["Udemy", "GeeksforGeeks", "Coursera", "edX"]
        ["GeeksforGeeks", "Udemy", "Khan Academy", "Udacity"]
Output : "GeeksforGeeks" "Udemy"
Explanation : There are two common websites and index sum of both is same.
*/



/*import java.util.*;

class MinIndexSum 
{


	// Time Complexity : O((l1+l2)2 *x), where l1 and l2 are the lengths of list1 and list2 
	// respectively and x refers to string length.
	// Auxiliary Space : O(l*x), where x refers to length of resultant list and l is length 
	// of maximum size word.
 
	// Function to print common Strings with minimum index sum
	static void find(Vector<String> list1, Vector<String> list2) {

		Vector<String> res = new Vector<>(); // resultant list
		int max_possible_sum = list1.size() + list2.size() - 2;

		// iterating over sum in ascending order 
		for (int sum = 0; sum <= max_possible_sum ; sum++) {
		  // iterating over one list and check index (Corresponding to given sum) in other list
		  for (int i = 0; i <= sum; i++) {
				// put common Strings in resultant list 
			if (i < list1.size() && (sum-i) < list2.size() && list1.get(i) == list2.get(sum-i)) {
			  res.add(list1.get(i));
			}		 
		  }
		  
		  // if common String found then break as we are considering index sums in increasing order.
		  if (res.size() > 0) {
			break;
		  }

		}

		// print the resultant list
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i)+" ");
		}
	}

	public static void main(String[] args) {

		// Creating list1
		Vector<String> list1 = new Vector<>();
		list1.add("w3school");
		list1.add("Udemy");
		list1.add("Coursera");
		list1.add("edX");

		// Creating list2
		Vector<String> list2= new Vector<>();
		list2.add("Codecademy");
		list2.add("Khan Academy");
		list2.add("w3school");

		find(list1, list2);
        System.out.println();
	}
}

*/

