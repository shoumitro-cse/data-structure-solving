//Find three element from different three arrays such that a + b + c = sum
import java.util.*; 

class ThreeEleDiffArrSum { 
	
     static boolean findTriplet(int a1[], int a2[], int a3[], int n1, int n2, int n3, int sum) { 
        
        // Store elements of first array in hash 
        HashSet<Integer> s = new HashSet<Integer>(); 
        for (int i = 0; i < n1; i++) { 
          s.add(a1[i]); 
        } 

        // sum last two arrays element one by one 
        ArrayList<Integer> al = new ArrayList<>(s); 
        for (int i = 0; i < n2; i++)  { 
           for (int j = 0; j < n3; j++) { 
              if (al.contains(sum-a2[i]-a3[j]) & al.indexOf(sum-a2[i]-a3[j])!= al.get(al.size()-1)) { 
                return true; 
              } 
           } 
        } 
        return false; 
    } 



	static boolean findTriplet2(int a1[], int a2[], int a3[], int n1, int n2, int n3, int sum) { 
		for (int i = 0; i < n1; i++) 
			for (int j = 0; j < n2; j++) 
				for (int k = 0; k < n3; k++) 
					if (a1[i] + a2[j] + a3[k] == sum) 
					  return true; 
		return false; 
	} 
	
	public static void main (String[] args) { 
		int a1[] = { 1 , 2 , 3 , 4 , 5 }; 
		int a2[] = { 2 , 3 , 6 , 1 , 2 }; 
		int a3[] = { 3 , 2 , 4 , 5 , 6 }; 
		int sum = 9; 
		
		int n1 = a1.length; 
		int n2 = a2.length; 
		int n3 = a3.length; 
		
		if(findTriplet(a1, a2, a3, n1, n2, n3, sum)) 
			System.out.print("Yes"); 
		else
			System.out.print("No"); 
	} 
} 



/*
Find three element from different three arrays such that a + b + c = sum


Given three integer arrays and a “sum”, the task is to check if there are three elements a, b, c 
such that a + b + c = sum and a, b and c belong to three different arrays.

Examples :

Input : a1[] = { 1 , 2 , 3 , 4 , 5 };
    a2[] = { 2 , 3 , 6 , 1 , 2 };
    a3[] = { 3 , 2 , 4 , 5 , 6 };  
        sum = 9
Output : Yes
1  + 2  + 6 = 9  here 1 from a1[] and 2 from
a2[] and 6 from a3[]   
    
Input : a1[] = { 1 , 2 , 3 , 4 , 5 };
    a2[] = { 2 , 3 , 6 , 1 , 2 };
    a3[] = { 3 , 2 , 4 , 5 , 6 };   
         sum = 20 
Output : No
*/

