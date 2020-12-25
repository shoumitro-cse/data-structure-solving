//Prufer Code to Tree Creation

// Java program to construct tree from given Prufer Code 

// javac -d classes PruferCodeToTreeCreation.java  && cd classes && java PruferCodeToTreeCreation && cd ..

class PruferCodeToTreeCreation { 

	// Prints edges of tree represented by give Prufer code 
	static void printTreeEdges(int prufer[], int m) { 

		int vertices = m + 2; //4+2=6
		int vertex_set[] = new int[vertices]; 
		// Initialize the array of vertices 
		for (int i = 0; i < vertices; i++) {
			vertex_set[i] = 0; 
		}
		// Number of occurrences of vertex in code 
		for (int i = 0; i < vertices-2; i++) {
			vertex_set[prufer[i]-1] += 1; 
		}
		System.out.print("\nThe edge set E(G) is :\n"); 
		// Find the smallest label not present in prufer[]. 
		int j = 0; 
		for (int i = 0; i < vertices-2; i++) { // 4 time
			for (j = 0; j < vertices; j++) { // 6 time
				// If j+1 is not present in prufer set 
				if (vertex_set[j] == 0) { 
					// Remove from Prufer set and print pair. 
					vertex_set[j] = -1; 
					System.out.print("(" + (j + 1) + ", "+ prufer[i] + ") "); 
					vertex_set[prufer[i]-1]--; 
					break; 
				} 
			} 
		} 

		j = 0; 
		// For the last element 
		for (int i = 0; i < vertices; i++) {         

			if (vertex_set[i] == 0 && j == 0) { 
				System.out.print("(" + (i + 1) + ", "); 
				j++; 
			} else if (vertex_set[i] == 0 && j == 1) {
				System.out.print((i + 1) + ")\n"); 
			}

		} 
	} 

	public static void main(String args[]) { 
		int prufer[] = { 4, 1, 3, 4 }; 
		int n = prufer.length; 
		printTreeEdges(prufer, n); 
	} 
} 


/*
Prufer Code to Tree Creation

What is Prufer Code?
Given a tree (represented as graph, not as a rooted tree) with n labeled nodes with 
labels from 1 to n, a Prufer code uniquely idetifies the tree. The sequence has n-2 values.

How to get Prufer Code of a tree?

Initialize Prufer code as empty.
Start with a leaf of lowest label say x. Find the vertex connecting it to the rest of tree say y. 
Remove x from the tree and add y to the Prufer Code
Repeat above step 2 until we are left with two nodes.
A tree with labels from 1 to n.
             5 
           /   \      
          1     4 
        /  \
       2    3

PruferCode = {}
The lowest label leaf is 2, we remove it from tree
and add the other vertex (connecting it to the tree)
to Prufer code
Tree now becomes
             5 
           /   \      
          1     4
           \
            3
Prufer Code becomes = {1}

The lowest label leaf is 3, we remove it from tree
and add the other vertex (connecting it to the tree)
to Prufer code
Tree now becomes
             5 
           /   \      
          1     4
Prufer Code becomes = {1, 1}
           
The lowest label leaf is 1, we remove it from tree
and add the other vertex (connecting it to the tree)
to Prufer code
Tree now becomes
             5 
              \      
               4     
Prufer Code becomes = {1, 1, 5}


We have only two nodes left now, so we stop.
How to construct a tree from given Prufer Code?

Input : (4, 1, 3, 4)
Output : Edges of following tree
         2----4----3----1----5
              |
              6

Input : (1, 3, 5)
Output : Edges of following tree
         2----1----3----5----4
Let the length of given Prufer code be m. The idea is to create an empty graph of m+2 vertices. We remove first element from sequence. Let first element of current sequence be x. Then we find the least value which is not present in the given sequence and not yet added to the tree. Let this value be be y. We add an edge from x to y and repeat this step.

Let us understand algorithm to construct tree with above first example:




Input : (4, 1, 3, 4)

Step 1: First we create an empty graph of 6 vertices 
        and get 4 from the sequence. 

Step 2: Out of 1 to 6, the least vertex not in 
        Prufer sequence is 2. 

Step 3: We form an edge between 2 and 4. 
             2----4    1    3    5      6

Step 4: Next in the sequence is 1 and corresponding 
        vertex with least degree is 5 (as 2 has been 
        considered). 
             2----4    1----5    3    6

Step 5: Next in the sequence is 3 and corresponding 
        vertex with least degree is 1 
        (as 1 is now not part of remaining Prufer sequence) 
             2----4    3----1----5    6

Step 6: Next in the sequence is 4 and corresponding vertex
        with least degree is 3 (as 3 has not been considered 
        as is not present further in sequence)
             2----4----3----1----5    6

Step 7: Finally two vertices are left out from 1 to 6 (4
         and 6) so we join them.
             2----4----3----1----5
                  |
                  6
This is the required tree on 6 vertices.*/