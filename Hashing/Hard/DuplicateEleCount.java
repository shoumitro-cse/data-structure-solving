// Count of index pairs with equal elements in an array

import java.util.*; 

class DuplicateEleCount { 

	public static int countPairs(int arr[], int n) { 
		//A method to return number of pairs with equal values 
		HashMap<Integer,Integer> hm = new HashMap<>(); 
		// Finding frequency of each number. 
		for(int i = 0; i < n; i++) { 
			if(hm.containsKey(arr[i])) 
				hm.put(arr[i], hm.get(arr[i]) + 1); 
			else
				hm.put(arr[i], 1); 
		} 
		
		int ans=0;
		// Calculating count of pairs with equal values 
		for(Map.Entry<Integer,Integer> it : hm.entrySet()) { 
			int count = it.getValue(); 
			ans += (count * (count - 1)) / 2; 
		} 

		return ans; 
	} 


/*	// Return the number of pairs with equal values. 
    static int countPairs(int arr[], int n) { 
        int ans = 0; 
        // for each index i and j 
        for (int i = 0; i < n; i++) 
            for (int j = i+1; j < n; j++) 
                // finding the index with same value but different index. 
                if (arr[i] == arr[j]) 
                    ans++; 
        return ans; 
    } 
*/

	
	public static void main(String[] args) { 
	   int arr[] = new int[]{1, 2, 3, 1}; 
	   System.out.println(countPairs(arr,arr.length)); 
	} 
} 

/*
Count of index pairs with equal elements in an array


Given an array of n elements. The task is to count the total number of 
indices (i, j) such that arr[i] = arr[j] and i != j

Examples :

Input : arr[] = {1, 1, 2}
Output : 1
As arr[0] = arr[1], the pair of indices is (0, 1)

Input : arr[] = {1, 1, 1}
Output : 3
As arr[0] = arr[1], the pair of indices is (0, 1), 
(0, 2) and (1, 2)

Input : arr[] = {1, 2, 3}
Output : 0
*/
