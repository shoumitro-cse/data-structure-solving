// find number of persons under every employee 

//javac -d classes UnderEmployee.java  && cd classes && java UnderEmployee && cd ..

import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 

public class UnderEmployee 
{ 
	// A hashmap to store result. It stores count of employees 
	// under every employee, the count may by 0 also 
	static Map<String,Integer> result = new HashMap<String, Integer>(); 

	// Driver function 
	public static void main(String[] args) { 

		Map<String, String> dataSet = new HashMap<String, String>(); 
		dataSet.put("A", "C"); 
		dataSet.put("B", "C"); 
		dataSet.put("C", "F"); 
		dataSet.put("D", "E"); 
		dataSet.put("E", "F"); 
		dataSet.put("F", "F"); 

		populateResult(dataSet); 
		System.out.println("result = " + result); 
	} 

	// This function populates 'result' for given input 'dataset' 
	private static void populateResult(Map<String, String> dataSet) {

		// To store reverse of original map, each key will have 0 to multiple values 
		Map<String, List<String>> mngrEmpMap = new HashMap<String, List<String>>(); 

		// To fill mngrEmpMap, iterate through the given map 
		for (Map.Entry<String,String> entry: dataSet.entrySet()) { 
			String emp = entry.getKey(); 
			String mngr = entry.getValue(); 
			if (!emp.equals(mngr)) { // excluding emp-emp entry  
				// Get the previous list of direct reports under 
				// current 'mgr' and add the current 'emp' to the list 
				List<String> directReportList = mngrEmpMap.get(mngr); 
				// If 'emp' is the first employee under 'mgr' 
				if (directReportList == null) { 
					directReportList = new ArrayList<String>(); 
					// add a new entry for the mngr with empty directReportList 
					mngrEmpMap.put(mngr, directReportList); 
				} 
				directReportList.add(emp); 
			} 
		} 

		// Now use manager-Emp map built above to populate result 
		// with use of populateResultUtil() 

		// note- we are iterating over original emp-manager map and 
		// will use mngr-emp map in helper to get the count 
		for (String mngr: dataSet.keySet()) {
			populateResultUtil(mngr, mngrEmpMap); 
			// System.out.println(mngr+"=>"+mngrEmpMap.get(mngr));
		}

	} 

	// This is a recursive function to fill count for 'mgr' using 
	// mngrEmpMap. This function uses memoization to avoid re-computations of subproblems. 
	private static int populateResultUtil(String mngr, Map<String, List<String>> mngrEmpMap) { 
		int count = 0; 
		// means employee is not a manager of any other employee 
		if (!mngrEmpMap.containsKey(mngr)) { 
			result.put(mngr, 0); 
			return 0; 
		} else if (result.containsKey(mngr)) {
		  // this employee count has already been done by this method, so avoid re-computation 
			count = result.get(mngr); 
		} else { 
			List<String> directReportEmpList = mngrEmpMap.get(mngr); 
			count = directReportEmpList.size(); 
			
			for (String directReportEmp: directReportEmpList) {
			  count += populateResultUtil(directReportEmp, mngrEmpMap); 
            }

			result.put(mngr, count); 
		} 
		return count; 
	} 
} 

/*
Source: Microsoft Interview

Find number of Employees Under every Employee

Given a dictionary that contains mapping of employee and his manager as a 
number of (employee, manager) pairs like below.
{ "A", "C" },
{ "B", "C" },
{ "C", "F" },
{ "D", "E" },
{ "E", "F" },
{ "F", "F" } 

In this example C is manager of A, 
C is also manager of B, F is manager 
of C and so on.


Write a function to get no of employees under each manager in the hierarchy not just their direct reports. It may be assumed that an employee directly reports to only one manager. In the above dictionary the root node/ceo is listed as reporting to himself.

Output should be a Dictionary that contains following.

A - 0  
B - 0
C - 2
D - 0
E - 1
F - 5 


This question might be solved differently but i followed this and found interesting, so sharing:

 1. Create a reverse map with Manager->DirectReportingEmployee 
    combination. Off-course employee will be multiple so Value 
    in Map is List of Strings.
        "C" --> "A", "B",
        "E" --> "D" 
        "F" --> "C", "E", "F"

 
2. Now use the given employee-manager map to iterate  and at 
   the same time use newly reverse map to find the count of 
   employees under manager.
   
   Let the map created in step 2 be 'mngrEmpMap' 
   Do following for every employee 'emp'.
     a) If 'emp' is not present in 'mngrEmpMap' 
          Count under 'emp' is 0 [Nobody reports to 'emp']
     b) If 'emp' is present in 'mngrEmpMap' 
          Use the list of direct reports from map 'mngrEmpMap'
          and recursively calculate number of total employees
          under 'emp'. 
A trick in step 2.b is to use memorization(Dynamic programming) while finding number of 
employees under a manager so that we don’t need to find number of employees again for 
any of the employees. In the below code populateResultUtil() is the recursive function 
that uses memoization to avoid re-computation of same results.


*/
