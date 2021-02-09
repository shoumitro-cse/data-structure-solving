// Prim’s Minimum Spanning Tree (PrimMinSpanningTree) | Greedy Algo-5

// javac -d classes PrimMinSpanningTree.java  && cd classes && java PrimMinSpanningTree && cd ..
  
import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class PrimMinSpanningTree { 

    // Number of vertices in the graph 
    private static final int V = 5; 
  
    // A utility function to find the vertex with minimum key 
    // value, from the set of vertices not yet included in PrimMinSpanningTree 
    int minKey(int key[], Boolean visited[]) {

        // Initialize min value 
        int min = Integer.MAX_VALUE, 
            min_index = -1; 
  
        for (int v = 0; v < V; v++) {
          if (visited[v] == false && key[v] < min) { 
            min = key[v]; 
            min_index = v; 
          } 
        }
  
        return min_index; 
    } 
  
    // A utility function to print the constructed PrimMinSpanningTree stored in parent[] 
    void printPrimMinSpanningTree(int parent[], int graph[][]) { 

        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < V; i++) {
          System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]); 
        }
    } 
  
    // Function to construct and print PrimMinSpanningTree for a graph represented 
    // using adjacency matrix representation 
    void primPrimMinSpanningTree(int graph[][]) {

        // Array to store constructed PrimMinSpanningTree 
        int parent[] = new int[V]; 
        
        // Key values used to pick minimum weight edge in cut 
        int key[] = new int[V]; 
        
        // To represent set of vertices included in PrimMinSpanningTree 
        Boolean visited [] = new Boolean[V]; 
        
        // Initialize all keys as INFINITE 
        for (int i = 0; i < V; i++) { 
            key[i] = Integer.MAX_VALUE; 
            visited[i] = false; 
        } 
  
        // Always include first 1st vertex in PrimMinSpanningTree. 
        key[0] = 0; // Make key 0 so that this vertex is 
        
        // picked as first vertex 
        parent[0] = -1; // First node is always root of PrimMinSpanningTree 
  
        // The PrimMinSpanningTree will have V vertices 
        for (int count = 0; count < V-1; count++) { 
            
            int u = minKey(key, visited); 
            
            // Add the picked vertex to the PrimMinSpanningTree Set 
            visited[u] = true; 

            for (int v = 0; v < V; v++) {
               if (graph[u][v] != 0 && visited[v] == false && graph[u][v] < key[v]) { 
                 parent[v] = u; 
                 key[v] = graph[u][v]; 
               } 
            }

        } 
  
        // print the constructed PrimMinSpanningTree 
        printPrimMinSpanningTree(parent, graph); 
    } 
  
    public static void main(String[] args) {

       /* input graph 
                                 3
                        2 / 1----------2
                         /  |  \5      |
                        0   |8    \    |7
                         \  |       \  |
                         6\ 3----------4          
                                9
      */    


        /* output graph 

                        3
                   1----------2
                2 / \
                 /   \5      
                0     \    
                 \     \  
                 6\     4          
                   3

      */
        
        PrimMinSpanningTree t = new PrimMinSpanningTree();

        int graph[][] = new int[][] { 
                                      { 0, 2, 0, 6, 0 }, 
                                      { 2, 0, 3, 8, 5 }, 
                                      { 0, 3, 0, 0, 7 }, 
                                      { 6, 8, 0, 0, 9 }, 
                                      { 0, 5, 7, 9, 0 } 
                                    }; 
  
        // Print the solution 
        t.primPrimMinSpanningTree(graph); 
    } 
} 


// Time Complexity of the above program is O(V^2).

/*Output: 

Edge   Weight
0 - 1    2
1 - 2    3
0 - 3    6
1 - 4    5
*/