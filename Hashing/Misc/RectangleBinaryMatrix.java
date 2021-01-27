// Find if there is a rectangle in binary matrix with corners as 1


// javac -d classes RectangleBinaryMatrix.java  && cd classes && java RectangleBinaryMatrix && cd ..

public class RectangleBinaryMatrix { 


    static boolean isRectangle(int matrix[][]) {
        
        // finding row and column size 
        int rows = matrix.length; 
        if (rows == 0) {
          return false; 
        }

        int columns = matrix[0].length; 

        // map for storing the index of combination of 2 1's 
        HashMap<Integer, HashSet<Integer>> table = new HashMap<>(); 
  
        // scanning from top to bottom line by line 
        for (int i = 0; i < rows; i++) { 
            for (int j = 0; j < columns - 1; j++) { 
                for (int k = j + 1; k < columns; k++) { 
                    // if found two 1's in a column 
                    if (matrix[i][j] == 1 && matrix[i][k] == 1) { 

                        // check if there exists 1's in same row previously then return true 
                        if (table.containsKey(j) && table.get(j).contains(k)) { 
                          return true; 
                        } 

                        if (table.containsKey(k) && table.get(k).contains(j)) { 
                           return true; 
                        } 
  
                        // store the indexes in hashset 
                        if (!table.containsKey(j)) { 
                            HashSet<Integer> x = new HashSet<>(); 
                            x.add(k); 
                            table.put(j, x); 
                        } else { 
                            table.get(j).add(k); 
                        } 

                        if (!table.containsKey(k)) { 
                            HashSet<Integer> x = new HashSet<>(); 
                            x.add(j); 
                            table.put(k, x); 
                        } else { 
                            table.get(k).add(j); 
                        }

                    } 
                } 
            } 
        } 
        return false; 
    } 


/*	// Returns true if there is a rectangle with 1 as corners. 
	//Time Complexity: O(n*m^2) 
	static boolean isRectangle(int m[][]) {

		// finding row and column size 
		int rows = m.length; 
		if (rows == 0) {
			return false; 
		}

		int columns = m[0].length; 

		// scanning the matrix 
		for (int y1 = 0; y1 < rows; y1++) 
		  for (int x1 = 0; x1 < columns; x1++) 
			// if any index found 1 then try for all rectangles 
			 if (m[y1][x1] == 1) 
			   for (int y2 = y1 + 1; y2 < rows; y2++) 
			     for (int x2 = x1 + 1; x2 < columns; x2++) 
				   if (m[y1][x2] == 1 && m[y2][x1] == 1 && m[y2][x2] == 1) 
				 	 return true; 

		return false; 
	} */

	public static void main(String args[]) {

		int mat[][] = { 
			            { 1, 0, 0, 1, 0 }, 
						{ 0, 0, 1, 0, 1 }, 
						{ 0, 0, 0, 1, 0 }, 
						{ 1, 0, 1, 0, 1 } 
					  }; 
		if (isRectangle(mat)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
} 


/*
Find if there is a rectangle in binary matrix with corners as 1


There is a given binary matrix, we need to find if there exists any rectangle or square 
in the given matrix whose all four corners are equal to 1.

Examples:  

Input :
mat[][] = { 1 0 0 1 0
            0 0 1 0 1
            0 0 0 1 0
            1 0 1 0 1}
Output : Yes
as there exists-
1 0 1
0 1 0
1 0 1
*/

